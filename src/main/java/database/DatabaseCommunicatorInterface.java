package database;

import data.ProductOperationOutOfRange;
import proto.Demo;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseCommunicatorInterface {
    List<Demo.Product> getSearchProduct(Demo.SearchProductsRequest searchProductsRequest) throws SQLException;
    Demo.Product getProductByID(int ID) throws SQLException;
    List<Demo.Product> listProducts() throws SQLException;

    void markItemAsReserved(int ID, int incrementNum) throws SQLException;

    void markItemAsAvailable(int ID, int incrementNum) throws SQLException;
    int getNumOfReservedItems(int ID) throws SQLException;

    int getNumOfAvailavleItems(int ID) throws SQLException;

    void addUnitsOfProduct(int ID, int quantity) throws SQLException, ProductOperationOutOfRange;

    void closeConnection() throws SQLException;
}
