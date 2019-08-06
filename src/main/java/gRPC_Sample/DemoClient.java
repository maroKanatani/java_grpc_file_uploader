package gRPC_Sample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.GreeterGrpc.GreeterBlockingStub;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

public class DemoClient {

	public static void main(String[] args) {

		System.out.println("Start Client");

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
				.usePlaintext()
				.build();

		GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

		HelloRequest request = HelloRequest.newBuilder()
				.setName("Tom")
				.build();

		HelloReply reply = stub.sayHello(request);

		System.out.println("Reply: " + reply);
	}

}
