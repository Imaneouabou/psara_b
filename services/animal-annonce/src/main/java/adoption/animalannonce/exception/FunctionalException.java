package adoption.animalannonce.exception;

public class FunctionalException extends RuntimeException {
    public FunctionalException(String message) {
        super(message);
    }
    public FunctionalException(String message, Throwable cause) {
        super(message, cause);
    }
}
