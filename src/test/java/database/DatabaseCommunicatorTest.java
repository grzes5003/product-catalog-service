package database;

import data.ProductOperationOutOfRange;
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
        assertEquals(databaseCommunicator.getProductByID(5234545).getId(), "-1");
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
        assertEquals(databaseCommunicator.getSearchProduct(searchProductsRequest1).get(0).getId(), "123456");
        assertEquals(databaseCommunicator.getSearchProduct(searchProductsRequest2).get(0).getId(), "-1");

    }

    @DisplayName("getNumOfAvailavleItemsTest")
    @Test
    void getNumOfAvailavleItemsTest() throws SQLException {
        int id = 123456;
        int availavleItems =  databaseCommunicator.getNumOfAvailavleItems(id);
        int reservedItems = databaseCommunicator.getNumOfReservedItems(id);
        databaseCommunicator.markItemAsReserved(id, 1);
        assertEquals(availavleItems-1, databaseCommunicator.getNumOfAvailavleItems(id));
        assertEquals(reservedItems+1, databaseCommunicator.getNumOfReservedItems(id));
        databaseCommunicator.markItemAsAvailable(id, 1);
        assertEquals(availavleItems, databaseCommunicator.getNumOfAvailavleItems(id));
    }

    @DisplayName("addUnitsOfProductTest")
    @Test
    void addUnitsOfProductTest() throws SQLException {
        int availavleItems =  databaseCommunicator.getNumOfAvailavleItems(123456);
        assertThrows(ProductOperationOutOfRange.class, () -> databaseCommunicator.addUnitsOfProduct(123456, -1));
        assertEquals(availavleItems, databaseCommunicator.getNumOfAvailavleItems(123456));
    }
}