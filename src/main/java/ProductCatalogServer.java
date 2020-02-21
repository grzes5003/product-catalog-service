import database.DatabaseCommunicator;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import proto.Demo;
import proto.ProductCatalogServiceGrpc;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/*

protoc --proto_path=src --plugin=protoc-gen-grpc-java=src/main/resources/protoc-gen-grpc-java-1.27.0-windows-x86_64.exe --grpc-java_out=src/
main/java --java_out=src/main/java main/proto/demo.proto

* */

public class ProductCatalogServer {

    private static final Logger logger = Logger.getLogger(ProductCatalogServer.class.getName());

    private final int port;
    private final Server server;
    private DatabaseCommunicator databaseCommunicator;

    public ProductCatalogServer(int port) throws IOException, SQLException, ClassNotFoundException {
        this(ServerBuilder.forPort(port), port);
        databaseCommunicator = new DatabaseCommunicator();
    }

    public ProductCatalogServer(ServerBuilder<?> serverBuilder, int port) throws IOException {
        this.port = port;
        this.server = serverBuilder.addService(new ProductCatalogService()).
                build();
    }

    public void start() throws IOException {
        this.server.start();
        logger.info("Server has started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    ProductCatalogServer.this.stop();
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() throws SQLException {
        this.databaseCommunicator.closeConnection();
    }

    private static class ProductCatalogService extends ProductCatalogServiceGrpc.ProductCatalogServiceImplBase {

        private static DatabaseCommunicator databaseCommunicator;

        static {
            try {
                databaseCommunicator = new DatabaseCommunicator();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void listProducts(Demo.Empty request, StreamObserver<Demo.ListProductsResponse> responseObserver) {
            //super.listProducts(request, responseObserver);
            try {
                List<Demo.Product> productList = databaseCommunicator.listProducts();
                Demo.ListProductsResponse listProductsResponse = Demo.ListProductsResponse
                        .newBuilder()
                        .addAllProducts(productList)
                        .build();
                responseObserver.onNext(listProductsResponse);
                responseObserver.onCompleted();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void getProduct(Demo.GetProductRequest request, StreamObserver<Demo.GetProductResponse> responseObserver) {
            //super.getProduct(request, responseObserver);
            try {
                Demo.Product product = databaseCommunicator.getProductByID(Integer.parseInt(request.getId()));
                Demo.GetProductResponse getProductResponse = Demo.GetProductResponse
                        .newBuilder().setProduct(product).build();
                responseObserver.onNext(getProductResponse);
                responseObserver.onCompleted();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void searchProducts(Demo.SearchProductsRequest request, StreamObserver<Demo.SearchProductsResponse> responseObserver) {
            //super.searchProducts(request, responseObserver);
            try {
                List<Demo.Product> productList = databaseCommunicator.getSearchProduct(request);
                Demo.SearchProductsResponse searchProductsResponse = Demo.SearchProductsResponse
                        .newBuilder()
                        .addAllResults(productList)
                        .build();
                responseObserver.onNext(searchProductsResponse);
                responseObserver.onCompleted();
            } catch (SQLException e) {
                logger.info(e.toString());
            }
        }
    }
}
