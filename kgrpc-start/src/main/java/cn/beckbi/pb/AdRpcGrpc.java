package cn.beckbi.pb;

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
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: ad.proto")
public final class AdRpcGrpc {

  private AdRpcGrpc() {}

  public static final String SERVICE_NAME = "AdRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.Ad,
      cn.beckbi.pb.AdInfo.AdId> getAddAdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addAd",
      requestType = cn.beckbi.pb.AdInfo.Ad.class,
      responseType = cn.beckbi.pb.AdInfo.AdId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.Ad,
      cn.beckbi.pb.AdInfo.AdId> getAddAdMethod() {
    io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.Ad, cn.beckbi.pb.AdInfo.AdId> getAddAdMethod;
    if ((getAddAdMethod = AdRpcGrpc.getAddAdMethod) == null) {
      synchronized (AdRpcGrpc.class) {
        if ((getAddAdMethod = AdRpcGrpc.getAddAdMethod) == null) {
          AdRpcGrpc.getAddAdMethod = getAddAdMethod = 
              io.grpc.MethodDescriptor.<cn.beckbi.pb.AdInfo.Ad, cn.beckbi.pb.AdInfo.AdId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AdRpc", "addAd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.Ad.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdId.getDefaultInstance()))
                  .setSchemaDescriptor(new AdRpcMethodDescriptorSupplier("addAd"))
                  .build();
          }
        }
     }
     return getAddAdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdId,
      cn.beckbi.pb.AdInfo.Ad> getGetAdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAd",
      requestType = cn.beckbi.pb.AdInfo.AdId.class,
      responseType = cn.beckbi.pb.AdInfo.Ad.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdId,
      cn.beckbi.pb.AdInfo.Ad> getGetAdMethod() {
    io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdId, cn.beckbi.pb.AdInfo.Ad> getGetAdMethod;
    if ((getGetAdMethod = AdRpcGrpc.getGetAdMethod) == null) {
      synchronized (AdRpcGrpc.class) {
        if ((getGetAdMethod = AdRpcGrpc.getGetAdMethod) == null) {
          AdRpcGrpc.getGetAdMethod = getGetAdMethod = 
              io.grpc.MethodDescriptor.<cn.beckbi.pb.AdInfo.AdId, cn.beckbi.pb.AdInfo.Ad>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AdRpc", "getAd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.Ad.getDefaultInstance()))
                  .setSchemaDescriptor(new AdRpcMethodDescriptorSupplier("getAd"))
                  .build();
          }
        }
     }
     return getGetAdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdRpcStub newStub(io.grpc.Channel channel) {
    return new AdRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class AdRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void addAd(cn.beckbi.pb.AdInfo.Ad request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdId> responseObserver) {
      asyncUnimplementedUnaryCall(getAddAdMethod(), responseObserver);
    }

    /**
     */
    public void getAd(cn.beckbi.pb.AdInfo.AdId request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.Ad> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddAdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.beckbi.pb.AdInfo.Ad,
                cn.beckbi.pb.AdInfo.AdId>(
                  this, METHODID_ADD_AD)))
          .addMethod(
            getGetAdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.beckbi.pb.AdInfo.AdId,
                cn.beckbi.pb.AdInfo.Ad>(
                  this, METHODID_GET_AD)))
          .build();
    }
  }

  /**
   */
  public static final class AdRpcStub extends io.grpc.stub.AbstractStub<AdRpcStub> {
    private AdRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdRpcStub(channel, callOptions);
    }

    /**
     */
    public void addAd(cn.beckbi.pb.AdInfo.Ad request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddAdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAd(cn.beckbi.pb.AdInfo.AdId request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.Ad> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdRpcBlockingStub extends io.grpc.stub.AbstractStub<AdRpcBlockingStub> {
    private AdRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.beckbi.pb.AdInfo.AdId addAd(cn.beckbi.pb.AdInfo.Ad request) {
      return blockingUnaryCall(
          getChannel(), getAddAdMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.beckbi.pb.AdInfo.Ad getAd(cn.beckbi.pb.AdInfo.AdId request) {
      return blockingUnaryCall(
          getChannel(), getGetAdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdRpcFutureStub extends io.grpc.stub.AbstractStub<AdRpcFutureStub> {
    private AdRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.beckbi.pb.AdInfo.AdId> addAd(
        cn.beckbi.pb.AdInfo.Ad request) {
      return futureUnaryCall(
          getChannel().newCall(getAddAdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.beckbi.pb.AdInfo.Ad> getAd(
        cn.beckbi.pb.AdInfo.AdId request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_AD = 0;
  private static final int METHODID_GET_AD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_AD:
          serviceImpl.addAd((cn.beckbi.pb.AdInfo.Ad) request,
              (io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdId>) responseObserver);
          break;
        case METHODID_GET_AD:
          serviceImpl.getAd((cn.beckbi.pb.AdInfo.AdId) request,
              (io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.Ad>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AdRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.beckbi.pb.AdInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdRpc");
    }
  }

  private static final class AdRpcFileDescriptorSupplier
      extends AdRpcBaseDescriptorSupplier {
    AdRpcFileDescriptorSupplier() {}
  }

  private static final class AdRpcMethodDescriptorSupplier
      extends AdRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdRpcMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdRpcFileDescriptorSupplier())
              .addMethod(getAddAdMethod())
              .addMethod(getGetAdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
