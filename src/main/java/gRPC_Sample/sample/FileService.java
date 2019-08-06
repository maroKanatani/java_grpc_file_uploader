package gRPC_Sample.sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString;

import io.grpc.stub.StreamObserver;
import uploader.FileServiceGrpc.FileServiceImplBase;
import uploader.Uploader.FileRequest;
import uploader.Uploader.FileResponse;

public class FileService extends FileServiceImplBase  {

	private String outDir = "C:\\Users\\kanatani\\Desktop\\";

	@Override
	public StreamObserver<FileRequest> upload(StreamObserver<FileResponse> responseObserver) {
		List<ByteString> blob = new ArrayList<>();

		return new StreamObserver<FileRequest>() {

			long threadId = Thread.currentThread().getId();
			String fileName = "";

			@Override
			public void onNext(FileRequest value) {
				System.out.println("FileService onNext start" + " ThreadId : " + threadId);
				blob.add(value.getData());
				fileName = value.getName();
				System.out.println("FileService onNext end" + " ThreadId : " + threadId);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("FileService onError start" + " ThreadId : " + threadId);
				t.printStackTrace();
				System.out.println("FileService onError end" + " ThreadId : " + threadId);
			}

			@Override
			public void onCompleted() {

				System.out.println("FileService onComplete start" + " ThreadId : " + threadId);

				try(FileOutputStream out = new FileOutputStream(outDir + fileName)) {

					int size = blob.stream().mapToInt(ByteString::size).sum();
					ByteString by = blob.stream().reduce((a, b) -> {
						return a.concat(b);
					}).get();

					by.writeTo(out);
//					ByteString.newOutput().writeTo(out);
					responseObserver.onNext(FileResponse.newBuilder().setSize(size).build());
					responseObserver.onCompleted();
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}



				System.out.println("FileService onComplete end" + " ThreadId : " + threadId);
			}

		};
	}


}
