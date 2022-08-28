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
    comments = "Source: proto/ad.proto")
public final class AdStreamGrpc {

  private AdStreamGrpc() {}

  public static final String SERVICE_NAME = "AdStream";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdList,
      cn.beckbi.pb.AdInfo.AdIdList> getAddAdListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addAdList",
      requestType = cn.beckbi.pb.AdInfo.AdList.class,
      responseType = cn.beckbi.pb.AdInfo.AdIdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdList,
      cn.beckbi.pb.AdInfo.AdIdList> getAddAdListMethod() {
    io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdList, cn.beckbi.pb.AdInfo.AdIdList> getAddAdListMethod;
    if ((getAddAdListMethod = AdStreamGrpc.getAddAdListMethod) == null) {
      synchronized (AdStreamGrpc.class) {
        if ((getAddAdListMethod = AdStreamGrpc.getAddAdListMethod) == null) {
          AdStreamGrpc.getAddAdListMethod = getAddAdListMethod = 
              io.grpc.MethodDescriptor.<cn.beckbi.pb.AdInfo.AdList, cn.beckbi.pb.AdInfo.AdIdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AdStream", "addAdList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdIdList.getDefaultInstance()))
                  .setSchemaDescriptor(new AdStreamMethodDescriptorSupplier("addAdList"))
                  .build();
          }
        }
     }
     return getAddAdListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdIdList,
      cn.beckbi.pb.AdInfo.AdList> getGetAdListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAdList",
      requestType = cn.beckbi.pb.AdInfo.AdIdList.class,
      responseType = cn.beckbi.pb.AdInfo.AdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdIdList,
      cn.beckbi.pb.AdInfo.AdList> getGetAdListMethod() {
    io.grpc.MethodDescriptor<cn.beckbi.pb.AdInfo.AdIdList, cn.beckbi.pb.AdInfo.AdList> getGetAdListMethod;
    if ((getGetAdListMethod = AdStreamGrpc.getGetAdListMethod) == null) {
      synchronized (AdStreamGrpc.class) {
        if ((getGetAdListMethod = AdStreamGrpc.getGetAdListMethod) == null) {
          AdStreamGrpc.getGetAdListMethod = getGetAdListMethod = 
              io.grpc.MethodDescriptor.<cn.beckbi.pb.AdInfo.AdIdList, cn.beckbi.pb.AdInfo.AdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AdStream", "getAdList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdIdList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.beckbi.pb.AdInfo.AdList.getDefaultInstance()))
                  .setSchemaDescriptor(new AdStreamMethodDescriptorSupplier("getAdList"))
                  .build();
          }
        }
     }
     return getGetAdListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdStreamStub newStub(io.grpc.Channel channel) {
    return new AdStreamStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdStreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdStreamBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdStreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdStreamFutureStub(channel);
  }

  /**
   */
  public static abstract class AdStreamImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdList> addAdList(
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdIdList> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddAdListMethod(), responseObserver);
    }

    /**
     */
    public void getAdList(cn.beckbi.pb.AdInfo.AdIdList request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAdListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddAdListMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cn.beckbi.pb.AdInfo.AdList,
                cn.beckbi.pb.AdInfo.AdIdList>(
                  this, METHODID_ADD_AD_LIST)))
          .addMethod(
            getGetAdListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.beckbi.pb.AdInfo.AdIdList,
                cn.beckbi.pb.AdInfo.AdList>(
                  this, METHODID_GET_AD_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class AdStreamStub extends io.grpc.stub.AbstractStub<AdStreamStub> {
    private AdStreamStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdStreamStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdStreamStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdStreamStub(channel, callOptions);
    }

    /**
     * <pre>
     *stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdList> addAdList(
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdIdList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAddAdListMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getAdList(cn.beckbi.pb.AdInfo.AdIdList request,
        io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdList> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAdListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdStreamBlockingStub extends io.grpc.stub.AbstractStub<AdStreamBlockingStub> {
    private AdStreamBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdStreamBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdStreamBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdStreamBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<cn.beckbi.pb.AdInfo.AdList> getAdList(
        cn.beckbi.pb.AdInfo.AdIdList request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAdListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdStreamFutureStub extends io.grpc.stub.AbstractStub<AdStreamFutureStub> {
    private AdStreamFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdStreamFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdStreamFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdStreamFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_AD_LIST = 0;
  private static final int METHODID_ADD_AD_LIST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdStreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdStreamImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AD_LIST:
          serviceImpl.getAdList((cn.beckbi.pb.AdInfo.AdIdList) request,
              (io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdList>) responseObserver);
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
        case METHODID_ADD_AD_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addAdList(
              (io.grpc.stub.StreamObserver<cn.beckbi.pb.AdInfo.AdIdList>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AdStreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdStreamBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.beckbi.pb.AdInfo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdStream");
    }
  }

  private static final class AdStreamFileDescriptorSupplier
      extends AdStreamBaseDescriptorSupplier {
    AdStreamFileDescriptorSupplier() {}
  }

  private static final class AdStreamMethodDescriptorSupplier
      extends AdStreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdStreamMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdStreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdStreamFileDescriptorSupplier())
              .addMethod(getAddAdListMethod())
              .addMethod(getGetAdListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
