package database;

import data.Constants;
import proto.Demo;

import java.sql.*;
import java.util.logging.Logger;

public class DatabaseCommunicator implements DatabaseCommunicatorInterface {

    private static final Logger logger = Logger.getLogger(DatabaseCommunicator.class.getName());
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DatabaseCommunicator() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/" + Constants.DB_NAME + "?serverTimezone=UTC", Constants.BD_USER, Constants.DB_PASSWD);
        } catch (SQLException sqlerr) {
            logger.warning("sql conn error " + sqlerr.toString());
        } catch (ClassNotFoundException classerr) {
            logger.warning("class not found error " + classerr.toString());
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Override
    public Demo.Product getSearchProduct(Demo.SearchProductsRequest searchProductsRequest) throws SQLException {
        // SELECT * FROM products WHERE CONCAT(name,desctription) LIKE '%para%'
        resultSet = connection
                .prepareStatement("SELECT * FROM products WHERE CONCAT(name,desctription) LIKE '%" + searchProductsRequest.getQuery() + "%'")
                .executeQuery();
        return set2product(resultSet);
    }

    @Override
    public Demo.Product getProductByID(int ID) throws SQLException {
        resultSet = connection
                .prepareStatement("SELECT * FROM products WHERE id = " + ID + ";")
                .executeQuery();
        return set2product(resultSet);
    }

    public Demo.Product set2product(ResultSet resultSet) throws SQLException {
        Demo.Product product = null;
        if (resultSet.next()) {
            String id = Integer.toString(resultSet.getInt("id"));
            String name = resultSet.getString("name");
            String desctription = resultSet.getString("desctription");
            String picture = resultSet.getString("picture");
            int price = (int) resultSet.getFloat("price");
            return Demo.Product.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setDescription(desctription)
                    .setPicture(picture)
                    .setPrice(price)
                    .build();
        }
        logger.info("product not found");
        return null;
    }


    //UPDATE products SET products.num_of_available_items = products.num_of_available_items + 5 WHERE id = 123456;


    @Override
    public void markItemAsReserved(int ID, int incrementNum) throws SQLException {
        resultSet = connection
                .prepareStatement("UPDATE products SET products.num_of_available_items = products.num_of_available_items " + ID + ";")
                .executeQuery();
    }

    @Override
    public void markItemAsAvailable(int ID, int incrementNum) {

    }

    @Override
    public int getNumOfReservedItems(int ID) throws SQLException {
        return 0;
    }

    @Override
    public int getNumOfAvailavleItems(int ID) {
        return 0;
    }
}
