package gRPC_Sample.dual;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DualClient {

	public static void main(String[] args) {

		final int port = 50051;

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
				.usePlaintext(false)
				.build();




	}

}
