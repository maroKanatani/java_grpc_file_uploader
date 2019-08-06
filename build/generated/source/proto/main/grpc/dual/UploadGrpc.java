package dual;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: upload.proto")
public final class UploadGrpc {

  private UploadGrpc() {}

  public static final String SERVICE_NAME = "Upload";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dual.Tdata,
      dual.Tdata> getFileupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Fileup",
      requestType = dual.Tdata.class,
      responseType = dual.Tdata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<dual.Tdata,
      dual.Tdata> getFileupMethod() {
    io.grpc.MethodDescriptor<dual.Tdata, dual.Tdata> getFileupMethod;
    if ((getFileupMethod = UploadGrpc.getFileupMethod) == null) {
      synchronized (UploadGrpc.class) {
        if ((getFileupMethod = UploadGrpc.getFileupMethod) == null) {
          UploadGrpc.getFileupMethod = getFileupMethod = 
              io.grpc.MethodDescriptor.<dual.Tdata, dual.Tdata>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Upload", "Fileup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dual.Tdata.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dual.Tdata.getDefaultInstance()))
                  .setSchemaDescriptor(new UploadMethodDescriptorSupplier("Fileup"))
                  .build();
          }
        }
     }
     return getFileupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UploadStub newStub(io.grpc.Channel channel) {
    return new UploadStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UploadBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UploadBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UploadFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UploadFutureStub(channel);
  }

  /**
   */
  public static abstract class UploadImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<dual.Tdata> fileup(
        io.grpc.stub.StreamObserver<dual.Tdata> responseObserver) {
      return asyncUnimplementedStreamingCall(getFileupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFileupMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                dual.Tdata,
                dual.Tdata>(
                  this, METHODID_FILEUP)))
          .build();
    }
  }

  /**
   */
  public static final class UploadStub extends io.grpc.stub.AbstractStub<UploadStub> {
    private UploadStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UploadStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UploadStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UploadStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<dual.Tdata> fileup(
        io.grpc.stub.StreamObserver<dual.Tdata> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFileupMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class UploadBlockingStub extends io.grpc.stub.AbstractStub<UploadBlockingStub> {
    private UploadBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UploadBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UploadBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UploadBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class UploadFutureStub extends io.grpc.stub.AbstractStub<UploadFutureStub> {
    private UploadFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UploadFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UploadFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UploadFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FILEUP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UploadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UploadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FILEUP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fileup(
              (io.grpc.stub.StreamObserver<dual.Tdata>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UploadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dual.UploadOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Upload");
    }
  }

  private static final class UploadFileDescriptorSupplier
      extends UploadBaseDescriptorSupplier {
    UploadFileDescriptorSupplier() {}
  }

  private static final class UploadMethodDescriptorSupplier
      extends UploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UploadMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UploadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UploadFileDescriptorSupplier())
              .addMethod(getFileupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
