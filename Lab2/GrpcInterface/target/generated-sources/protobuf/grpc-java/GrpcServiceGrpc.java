import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: GrpcInterface.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpcServiceGrpc {

  private GrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "GrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GrpcRequest,
      GrpcResponse> getGrpcStoreDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "grpcStoreData",
      requestType = GrpcRequest.class,
      responseType = GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GrpcRequest,
      GrpcResponse> getGrpcStoreDataMethod() {
    io.grpc.MethodDescriptor<GrpcRequest, GrpcResponse> getGrpcStoreDataMethod;
    if ((getGrpcStoreDataMethod = GrpcServiceGrpc.getGrpcStoreDataMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGrpcStoreDataMethod = GrpcServiceGrpc.getGrpcStoreDataMethod) == null) {
          GrpcServiceGrpc.getGrpcStoreDataMethod = getGrpcStoreDataMethod =
              io.grpc.MethodDescriptor.<GrpcRequest, GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "grpcStoreData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("grpcStoreData"))
              .build();
        }
      }
    }
    return getGrpcStoreDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GrpcRequestFibo,
      GrpcResponseFibo> getGrpcFiboMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "grpcFibo",
      requestType = GrpcRequestFibo.class,
      responseType = GrpcResponseFibo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<GrpcRequestFibo,
      GrpcResponseFibo> getGrpcFiboMethod() {
    io.grpc.MethodDescriptor<GrpcRequestFibo, GrpcResponseFibo> getGrpcFiboMethod;
    if ((getGrpcFiboMethod = GrpcServiceGrpc.getGrpcFiboMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGrpcFiboMethod = GrpcServiceGrpc.getGrpcFiboMethod) == null) {
          GrpcServiceGrpc.getGrpcFiboMethod = getGrpcFiboMethod =
              io.grpc.MethodDescriptor.<GrpcRequestFibo, GrpcResponseFibo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "grpcFibo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GrpcRequestFibo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GrpcResponseFibo.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("grpcFibo"))
              .build();
        }
      }
    }
    return getGrpcFiboMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DownloadFileRequest,
      DataChunk> getGrpcDownloadPicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "grpcDownloadPic",
      requestType = DownloadFileRequest.class,
      responseType = DataChunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<DownloadFileRequest,
      DataChunk> getGrpcDownloadPicMethod() {
    io.grpc.MethodDescriptor<DownloadFileRequest, DataChunk> getGrpcDownloadPicMethod;
    if ((getGrpcDownloadPicMethod = GrpcServiceGrpc.getGrpcDownloadPicMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGrpcDownloadPicMethod = GrpcServiceGrpc.getGrpcDownloadPicMethod) == null) {
          GrpcServiceGrpc.getGrpcDownloadPicMethod = getGrpcDownloadPicMethod =
              io.grpc.MethodDescriptor.<DownloadFileRequest, DataChunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "grpcDownloadPic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DownloadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DataChunk.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("grpcDownloadPic"))
              .build();
        }
      }
    }
    return getGrpcDownloadPicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReadInfoRequest,
      ReadInfoResponse> getGrpcReadInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "grpcReadInfo",
      requestType = ReadInfoRequest.class,
      responseType = ReadInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ReadInfoRequest,
      ReadInfoResponse> getGrpcReadInfoMethod() {
    io.grpc.MethodDescriptor<ReadInfoRequest, ReadInfoResponse> getGrpcReadInfoMethod;
    if ((getGrpcReadInfoMethod = GrpcServiceGrpc.getGrpcReadInfoMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGrpcReadInfoMethod = GrpcServiceGrpc.getGrpcReadInfoMethod) == null) {
          GrpcServiceGrpc.getGrpcReadInfoMethod = getGrpcReadInfoMethod =
              io.grpc.MethodDescriptor.<ReadInfoRequest, ReadInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "grpcReadInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReadInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReadInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("grpcReadInfo"))
              .build();
        }
      }
    }
    return getGrpcReadInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SumRequest,
      SumResponse> getGrpcSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "grpcSum",
      requestType = SumRequest.class,
      responseType = SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<SumRequest,
      SumResponse> getGrpcSumMethod() {
    io.grpc.MethodDescriptor<SumRequest, SumResponse> getGrpcSumMethod;
    if ((getGrpcSumMethod = GrpcServiceGrpc.getGrpcSumMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGrpcSumMethod = GrpcServiceGrpc.getGrpcSumMethod) == null) {
          GrpcServiceGrpc.getGrpcSumMethod = getGrpcSumMethod =
              io.grpc.MethodDescriptor.<SumRequest, SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "grpcSum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("grpcSum"))
              .build();
        }
      }
    }
    return getGrpcSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceStub>() {
        @java.lang.Override
        public GrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceStub(channel, callOptions);
        }
      };
    return GrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceBlockingStub>() {
        @java.lang.Override
        public GrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceFutureStub>() {
        @java.lang.Override
        public GrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void grpcStoreData(GrpcRequest request,
        io.grpc.stub.StreamObserver<GrpcResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGrpcStoreDataMethod(), responseObserver);
    }

    /**
     */
    public void grpcFibo(GrpcRequestFibo request,
        io.grpc.stub.StreamObserver<GrpcResponseFibo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGrpcFiboMethod(), responseObserver);
    }

    /**
     */
    public void grpcDownloadPic(DownloadFileRequest request,
        io.grpc.stub.StreamObserver<DataChunk> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGrpcDownloadPicMethod(), responseObserver);
    }

    /**
     */
    public void grpcReadInfo(ReadInfoRequest request,
        io.grpc.stub.StreamObserver<ReadInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGrpcReadInfoMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SumRequest> grpcSum(
        io.grpc.stub.StreamObserver<SumResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGrpcSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGrpcStoreDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GrpcRequest,
                GrpcResponse>(
                  this, METHODID_GRPC_STORE_DATA)))
          .addMethod(
            getGrpcFiboMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                GrpcRequestFibo,
                GrpcResponseFibo>(
                  this, METHODID_GRPC_FIBO)))
          .addMethod(
            getGrpcDownloadPicMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                DownloadFileRequest,
                DataChunk>(
                  this, METHODID_GRPC_DOWNLOAD_PIC)))
          .addMethod(
            getGrpcReadInfoMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ReadInfoRequest,
                ReadInfoResponse>(
                  this, METHODID_GRPC_READ_INFO)))
          .addMethod(
            getGrpcSumMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                SumRequest,
                SumResponse>(
                  this, METHODID_GRPC_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcServiceStub> {
    private GrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void grpcStoreData(GrpcRequest request,
        io.grpc.stub.StreamObserver<GrpcResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGrpcStoreDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void grpcFibo(GrpcRequestFibo request,
        io.grpc.stub.StreamObserver<GrpcResponseFibo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGrpcFiboMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void grpcDownloadPic(DownloadFileRequest request,
        io.grpc.stub.StreamObserver<DataChunk> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGrpcDownloadPicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void grpcReadInfo(ReadInfoRequest request,
        io.grpc.stub.StreamObserver<ReadInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGrpcReadInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<SumRequest> grpcSum(
        io.grpc.stub.StreamObserver<SumResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGrpcSumMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcServiceBlockingStub> {
    private GrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GrpcResponse grpcStoreData(GrpcRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGrpcStoreDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<GrpcResponseFibo> grpcFibo(
        GrpcRequestFibo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGrpcFiboMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<DataChunk> grpcDownloadPic(
        DownloadFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGrpcDownloadPicMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ReadInfoResponse> grpcReadInfo(
        ReadInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGrpcReadInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcServiceFutureStub> {
    private GrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GrpcResponse> grpcStoreData(
        GrpcRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGrpcStoreDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GRPC_STORE_DATA = 0;
  private static final int METHODID_GRPC_FIBO = 1;
  private static final int METHODID_GRPC_DOWNLOAD_PIC = 2;
  private static final int METHODID_GRPC_READ_INFO = 3;
  private static final int METHODID_GRPC_SUM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GRPC_STORE_DATA:
          serviceImpl.grpcStoreData((GrpcRequest) request,
              (io.grpc.stub.StreamObserver<GrpcResponse>) responseObserver);
          break;
        case METHODID_GRPC_FIBO:
          serviceImpl.grpcFibo((GrpcRequestFibo) request,
              (io.grpc.stub.StreamObserver<GrpcResponseFibo>) responseObserver);
          break;
        case METHODID_GRPC_DOWNLOAD_PIC:
          serviceImpl.grpcDownloadPic((DownloadFileRequest) request,
              (io.grpc.stub.StreamObserver<DataChunk>) responseObserver);
          break;
        case METHODID_GRPC_READ_INFO:
          serviceImpl.grpcReadInfo((ReadInfoRequest) request,
              (io.grpc.stub.StreamObserver<ReadInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GRPC_SUM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.grpcSum(
              (io.grpc.stub.StreamObserver<SumResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GrpcAppProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcService");
    }
  }

  private static final class GrpcServiceFileDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier {
    GrpcServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcServiceMethodDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcServiceFileDescriptorSupplier())
              .addMethod(getGrpcStoreDataMethod())
              .addMethod(getGrpcFiboMethod())
              .addMethod(getGrpcDownloadPicMethod())
              .addMethod(getGrpcReadInfoMethod())
              .addMethod(getGrpcSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
