package data;

public class ProductOperationOutOfRange extends RuntimeException {
    public ProductOperationOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductOperationOutOfRange(String message) {
        super(message);
    }
}
