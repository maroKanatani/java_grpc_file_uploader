package gRPC_Sample.sample;

import static gRPC_Sample.sample.CommonConst.*;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class FileServiceMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(PORT)
//				.maxInboundMessageSize(FILE_SPLIT_UNIT)
//				.maxInboundMetadataSize(Integer.MAX_VALUE)
				.addService(new FileService())
				.build();

		server.start();
		System.out.println("start server on port:" + PORT);
		server.awaitTermination();
	}
}
