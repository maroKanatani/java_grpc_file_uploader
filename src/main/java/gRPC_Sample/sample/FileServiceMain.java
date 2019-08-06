package gRPC_Sample.sample;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class FileServiceMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		final int portNumber = 50051;
		Server server = ServerBuilder.forPort(portNumber)
				.maxInboundMessageSize(Integer.MAX_VALUE)
				.maxInboundMetadataSize(Integer.MAX_VALUE)
				.addService(new FileService())
				.build();

		server.start();
		System.out.println("start server on port:" + portNumber);
		server.awaitTermination();
	}
}
