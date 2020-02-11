import data.Constants;

import java.io.IOException;
import java.sql.SQLException;

public class ProductCatalogServerFactory {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InterruptedException {
        ProductCatalogServer productCatalogServer = new ProductCatalogServer(Constants.PORT);
        productCatalogServer.start();
        productCatalogServer.blockUntilShutdown();
    }
}
