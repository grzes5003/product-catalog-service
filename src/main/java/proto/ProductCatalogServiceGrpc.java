package proto;

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
    value = "by gRPC proto compiler (version 1.27.0)",
    comments = "Source: main/proto/demo.proto")
public final class ProductCatalogServiceGrpc {

  private ProductCatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductCatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Demo.Empty,
      proto.Demo.ListProductsResponse> getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = proto.Demo.Empty.class,
      responseType = proto.Demo.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Demo.Empty,
      proto.Demo.ListProductsResponse> getListProductsMethod() {
    io.grpc.MethodDescriptor<proto.Demo.Empty, proto.Demo.ListProductsResponse> getListProductsMethod;
    if ((getListProductsMethod = ProductCatalogServiceGrpc.getListProductsMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getListProductsMethod = ProductCatalogServiceGrpc.getListProductsMethod) == null) {
          ProductCatalogServiceGrpc.getListProductsMethod = getListProductsMethod =
              io.grpc.MethodDescriptor.<proto.Demo.Empty, proto.Demo.ListProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.ListProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("ListProducts"))
              .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Demo.GetProductRequest,
      proto.Demo.GetProductResponse> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = proto.Demo.GetProductRequest.class,
      responseType = proto.Demo.GetProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Demo.GetProductRequest,
      proto.Demo.GetProductResponse> getGetProductMethod() {
    io.grpc.MethodDescriptor<proto.Demo.GetProductRequest, proto.Demo.GetProductResponse> getGetProductMethod;
    if ((getGetProductMethod = ProductCatalogServiceGrpc.getGetProductMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getGetProductMethod = ProductCatalogServiceGrpc.getGetProductMethod) == null) {
          ProductCatalogServiceGrpc.getGetProductMethod = getGetProductMethod =
              io.grpc.MethodDescriptor.<proto.Demo.GetProductRequest, proto.Demo.GetProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.GetProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.GetProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("GetProduct"))
              .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Demo.SearchProductsRequest,
      proto.Demo.SearchProductsResponse> getSearchProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchProducts",
      requestType = proto.Demo.SearchProductsRequest.class,
      responseType = proto.Demo.SearchProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Demo.SearchProductsRequest,
      proto.Demo.SearchProductsResponse> getSearchProductsMethod() {
    io.grpc.MethodDescriptor<proto.Demo.SearchProductsRequest, proto.Demo.SearchProductsResponse> getSearchProductsMethod;
    if ((getSearchProductsMethod = ProductCatalogServiceGrpc.getSearchProductsMethod) == null) {
      synchronized (ProductCatalogServiceGrpc.class) {
        if ((getSearchProductsMethod = ProductCatalogServiceGrpc.getSearchProductsMethod) == null) {
          ProductCatalogServiceGrpc.getSearchProductsMethod = getSearchProductsMethod =
              io.grpc.MethodDescriptor.<proto.Demo.SearchProductsRequest, proto.Demo.SearchProductsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.SearchProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Demo.SearchProductsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductCatalogServiceMethodDescriptorSupplier("SearchProducts"))
              .build();
        }
      }
    }
    return getSearchProductsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductCatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceStub>() {
        @java.lang.Override
        public ProductCatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductCatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceBlockingStub>() {
        @java.lang.Override
        public ProductCatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductCatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductCatalogServiceFutureStub>() {
        @java.lang.Override
        public ProductCatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductCatalogServiceFutureStub(channel, callOptions);
        }
      };
    return ProductCatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductCatalogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void listProducts(proto.Demo.Empty request,
        io.grpc.stub.StreamObserver<proto.Demo.ListProductsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListProductsMethod(), responseObserver);
    }

    /**
     */
    public void getProduct(proto.Demo.GetProductRequest request,
        io.grpc.stub.StreamObserver<proto.Demo.GetProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     */
    public void searchProducts(proto.Demo.SearchProductsRequest request,
        io.grpc.stub.StreamObserver<proto.Demo.SearchProductsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchProductsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListProductsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Demo.Empty,
                proto.Demo.ListProductsResponse>(
                  this, METHODID_LIST_PRODUCTS)))
          .addMethod(
            getGetProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Demo.GetProductRequest,
                proto.Demo.GetProductResponse>(
                  this, METHODID_GET_PRODUCT)))
          .addMethod(
            getSearchProductsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Demo.SearchProductsRequest,
                proto.Demo.SearchProductsResponse>(
                  this, METHODID_SEARCH_PRODUCTS)))
          .build();
    }
  }

  /**
   */
  public static final class ProductCatalogServiceStub extends io.grpc.stub.AbstractAsyncStub<ProductCatalogServiceStub> {
    private ProductCatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceStub(channel, callOptions);
    }

    /**
     */
    public void listProducts(proto.Demo.Empty request,
        io.grpc.stub.StreamObserver<proto.Demo.ListProductsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProduct(proto.Demo.GetProductRequest request,
        io.grpc.stub.StreamObserver<proto.Demo.GetProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchProducts(proto.Demo.SearchProductsRequest request,
        io.grpc.stub.StreamObserver<proto.Demo.SearchProductsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchProductsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductCatalogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductCatalogServiceBlockingStub> {
    private ProductCatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Demo.ListProductsResponse listProducts(proto.Demo.Empty request) {
      return blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Demo.GetProductResponse getProduct(proto.Demo.GetProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Demo.SearchProductsResponse searchProducts(proto.Demo.SearchProductsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductCatalogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProductCatalogServiceFutureStub> {
    private ProductCatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductCatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductCatalogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Demo.ListProductsResponse> listProducts(
        proto.Demo.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Demo.GetProductResponse> getProduct(
        proto.Demo.GetProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Demo.SearchProductsResponse> searchProducts(
        proto.Demo.SearchProductsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PRODUCTS = 0;
  private static final int METHODID_GET_PRODUCT = 1;
  private static final int METHODID_SEARCH_PRODUCTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductCatalogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductCatalogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts((proto.Demo.Empty) request,
              (io.grpc.stub.StreamObserver<proto.Demo.ListProductsResponse>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((proto.Demo.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<proto.Demo.GetProductResponse>) responseObserver);
          break;
        case METHODID_SEARCH_PRODUCTS:
          serviceImpl.searchProducts((proto.Demo.SearchProductsRequest) request,
              (io.grpc.stub.StreamObserver<proto.Demo.SearchProductsResponse>) responseObserver);
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

  private static abstract class ProductCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductCatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Demo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductCatalogService");
    }
  }

  private static final class ProductCatalogServiceFileDescriptorSupplier
      extends ProductCatalogServiceBaseDescriptorSupplier {
    ProductCatalogServiceFileDescriptorSupplier() {}
  }

  private static final class ProductCatalogServiceMethodDescriptorSupplier
      extends ProductCatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductCatalogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductCatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductCatalogServiceFileDescriptorSupplier())
              .addMethod(getListProductsMethod())
              .addMethod(getGetProductMethod())
              .addMethod(getSearchProductsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
