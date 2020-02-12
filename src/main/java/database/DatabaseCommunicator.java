package database;

import data.Constants;
import data.ProductOperationOutOfRange;
import proto.Demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    public List<Demo.Product> getSearchProduct(Demo.SearchProductsRequest searchProductsRequest) throws SQLException {
        // SELECT * FROM products WHERE CONCAT(name,desctription) LIKE '%para%'
        List<Demo.Product> listOfProducts = new ArrayList<>();
        Demo.Product product;
        resultSet = connection
                .prepareStatement("SELECT * FROM products WHERE CONCAT(name,desctription) LIKE '%" + searchProductsRequest.getQuery() + "%'")
                .executeQuery();
        do {
            product = set2product(resultSet);
            listOfProducts.add(product);
        } while (product != null);
        return listOfProducts;
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
            int availableItems = resultSet.getInt("num_of_available_items");
            int reservedItems = resultSet.getInt("num_of_reserved_items");
            return Demo.Product.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setDescription(desctription)
                    .setPicture(picture)
                    .setPrice(price)
                    .setAvailableItems(availableItems)
                    .setReservedItems(reservedItems)
                    .build();
        }
        logger.info("product not found");
        return null;
    }


    //UPDATE products SET products.num_of_available_items = products.num_of_available_items + 5 WHERE id = 123456;

    // TODO not checking if product does exist

    @Override
    public void markItemAsReserved(int ID, int decrementNum) throws SQLException {
        try {
            if (getNumOfAvailavleItems(ID) < decrementNum || decrementNum < 0) {
                logger.warning("Cannot reserve more products than available");
                throw new ProductOperationOutOfRange("Products reserve number out of range");
            }
            connection
                    .prepareStatement("UPDATE products SET products.num_of_reserved_items = products.num_of_reserved_items + "
                            + decrementNum + " WHERE id = " + ID + ";")
                    .execute();
            connection
                    .prepareStatement("UPDATE products SET products.num_of_available_items = products.num_of_available_items - "
                            + decrementNum + " WHERE id = " + ID + ";")
                    .execute();
        } catch (ProductOperationOutOfRange e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    public void markItemAsAvailable(int ID, int incrementNum) throws SQLException {
        // TODO fix me
        connection
                .prepareStatement("UPDATE products SET products.num_of_available_items = products.num_of_available_items + "
                        + incrementNum + " WHERE id = " + ID + ";")
                .execute();
        connection
                .prepareStatement("UPDATE products SET products.num_of_reserved_items = products.num_of_reserved_items - "
                        + incrementNum + " WHERE id = " + ID + ";")
                .execute();
    }

    @Override
    public void addUnitsOfProduct(int ID, int quantity) throws SQLException, ProductOperationOutOfRange {
        if (quantity < 0) {
            throw new ProductOperationOutOfRange("Cannot 'add' negative number of products");
        }
        connection
                .prepareStatement("UPDATE products SET products.num_of_available_items = products.num_of_available_items + "
                        + quantity + " WHERE id = " + ID + ";")
                .execute();
    }

    @Override
    public int getNumOfReservedItems(int ID) throws SQLException {
        return getProductByID(ID).getReservedItems();
    }

    @Override
    public int getNumOfAvailavleItems(int ID) throws SQLException {
        return getProductByID(ID).getAvailableItems();
    }
}
