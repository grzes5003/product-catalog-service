package database;

import proto.Demo;

import java.sql.SQLException;

public interface DatabaseCommunicatorInterface {
    Demo.Product getSearchProduct(Demo.SearchProductsRequest searchProductsRequest) throws SQLException;
    Demo.Product getProductByID(int ID) throws SQLException;

    void markItemAsReserved(int ID, int incrementNum) throws SQLException;
    void markItemAsAvailable(int ID, int incrementNum);

    int getNumOfReservedItems(int ID) throws SQLException;
    int getNumOfAvailavleItems(int ID);

    void closeConnection() throws SQLException;
}
