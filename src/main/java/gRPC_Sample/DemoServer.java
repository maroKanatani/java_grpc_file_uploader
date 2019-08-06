package gRPC_Sample;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc.GreeterImplBase;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class DemoServer {

	public static void main(String[] args) throws InterruptedException, IOException {

		Server server = ServerBuilder.forPort(6565)
				.addService(new GreeterImpl())
				.build();

		server.start();
		server.awaitTermination();
	}

	static class GreeterImpl extends GreeterImplBase {
		@Override
		public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {

			System.out.println("Start Service");
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
			System.out.println("End Service");

		}
	}

}
