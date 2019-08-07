package gRPC_Sample.sample;

import static gRPC_Sample.sample.CommonConst.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import uploader.FileServiceGrpc;
import uploader.FileServiceGrpc.FileServiceStub;
import uploader.Uploader.FileRequest;
import uploader.Uploader.FileResponse;

public class ClientThread implements Runnable {

	private ManagedChannel channel;
	private final String filePath = "C:\\Users\\kanatani\\Desktop\\work\\python_http2_test_tool\\test_data\\";
	private String fileName = "";
//	private final int splitUnit = 4194304; // 4MB
////	private final int splitUnit = 2097152; // 2MB
	private long threadId;

	public ClientThread(String fileName, long id) {
		super();
		this.channel = ManagedChannelBuilder.forAddress(HOST, PORT)
//				.maxInboundMessageSize(Integer.MAX_VALUE)
//				.maxInboundMetadataSize(Integer.MAX_VALUE)
		        .usePlaintext()
		        .build();
		this.fileName = fileName;
		this.threadId = id;
	}



	@Override
	public void run() {
		long threadStart = System.currentTimeMillis();
		System.out.println("Thread start : " + threadStart + " ThreadId : " + threadId);

		FileServiceStub stub = FileServiceGrpc.newStub(channel);
		CountDownLatch client = new CountDownLatch(1);

		StreamObserver<FileRequest> requestSender = stub.upload(new StreamObserver<FileResponse>() {

			@Override
			public void onNext(FileResponse value) {
				System.out.println("【ThreadId : " + threadId + "】" + "response message: " + value.getSize());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("【ThreadId : " + threadId + "】" + "Client onError start");
				t.printStackTrace();
				System.out.println("【ThreadId : " + threadId + "】" + "Client onError end");
			}

			@Override
			public void onCompleted() {
				System.out.println("【ThreadId : " + threadId + "】" + "Client onCompleted start");
				client.countDown();
				System.out.println("【ThreadId : " + threadId + "】" + "Client onCompleted end");
			}
		});

		File file = new File(filePath + fileName);
		try(FileInputStream input = new FileInputStream(file)) {
			long fileSize = Files.size(Paths.get(filePath + fileName));
			int data = 0;
			int count = 0;

			long loopCount = fileSize / FILE_SPLIT_UNIT;
			int remain = (int) (fileSize % FILE_SPLIT_UNIT);
			boolean hasRem = remain > 0;
			if(hasRem) {
				loopCount++;
			}

			long beforeAllRequest = System.currentTimeMillis();
			System.out.println("【ThreadId : " + threadId + "】" + "Send request start all : " + beforeAllRequest);
			for(int i = 0; i < loopCount; i++) {
				int byteLength = (i + 1 != loopCount) ? FILE_SPLIT_UNIT : remain;

				byte[] bytes = new byte[byteLength];
				data = input.read(bytes);
//				System.out.println(new String(bytes, "UTF-8"));

				long beforeRequest = System.currentTimeMillis();
				System.out.println("【ThreadId : " + threadId + "】" + "Send request start : " + beforeRequest);
				requestSender.onNext(FileRequest.newBuilder().setName(fileName).setData(ByteString.copyFrom(bytes)).setId(threadId).build());
				long afterRequest = System.currentTimeMillis();
				System.out.println("【ThreadId : " + threadId + "】" + "Send request end : " + afterRequest);
				double elapsedRequest = afterRequest - beforeRequest;
				System.out.println("【ThreadId : " + threadId + "】" + "Send request elapsed :" + elapsedRequest / 1000);
//				count += byteLength;
			}
			long afterAllRequest = System.currentTimeMillis();
			System.out.println("【ThreadId : " + threadId + "】" + "Send request end all : " + afterAllRequest);

//
//			long beforeAllRequest = System.currentTimeMillis();
//			System.out.println("Send request start all : " + beforeAllRequest + " ThreadId : " + threadId);
//			while(data != -1) {
//				byte[] bytes = new byte[splitUnit];
//				data = input.read(bytes, count, count + splitUnit);
//				long beforeRequest = System.currentTimeMillis();
//				System.out.println("Send request start : " + beforeRequest + " ThreadId : " + threadId);
//				requestSender.onNext(FileRequest.newBuilder().setName(fileName).setData(ByteString.copyFrom(bytes)).build());
//				long afterRequest = System.currentTimeMillis();
//				System.out.println("Send request end : " + afterRequest + " ThreadId : " + threadId);
//				double elapsedRequest = afterRequest - beforeRequest;
//				System.out.println("Send request elapsed :" + elapsedRequest / 1000 + " ThreadId : " + threadId);
//			}
//			long afterAllRequest = System.currentTimeMillis();
//			System.out.println("Send request end all : " + afterAllRequest + " ThreadId : " + threadId);


		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		requestSender.onCompleted();

		try {
			client.await();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		long threadEnd = System.currentTimeMillis();
		System.out.println("【ThreadId : " + threadId + "】" + "Thread end : " + threadEnd);
		System.out.println("【ThreadId : " + threadId + "】" + "All process elapsed : " + ((double)(threadEnd - threadStart)) / 1000);

	}

}
