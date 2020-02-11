package database;

import org.junit.jupiter.api.*;
import proto.Demo;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseCommunicatorTest {

    private static DatabaseCommunicator databaseCommunicator;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        databaseCommunicator = new DatabaseCommunicator();
    }

    @DisplayName("getProductByIDtest")
    @Test
    void getProductByIDtest() throws SQLException {
        assertNotNull(databaseCommunicator.getProductByID(123456));
        assertNull(databaseCommunicator.getProductByID(5234545));
    }

    @DisplayName("getSearchProductTest")
    @Test
    void getSearchProductTest() throws SQLException {
        Demo.SearchProductsRequest searchProductsRequest1 = Demo.SearchProductsRequest
                .newBuilder()
                .setQuery("para")
                .build();
        Demo.SearchProductsRequest searchProductsRequest2 = Demo.SearchProductsRequest
                .newBuilder()
                .setQuery("costam")
                .build();
        assertEquals(databaseCommunicator.getSearchProduct(searchProductsRequest1).getId(), "123456");
        assertNull(databaseCommunicator.getSearchProduct(searchProductsRequest2));

    }
}