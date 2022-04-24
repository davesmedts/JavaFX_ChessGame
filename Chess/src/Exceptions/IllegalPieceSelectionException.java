package exceptions;


public class IllegalPieceSelectionException extends Exception {
    public IllegalPieceSelectionException() {
    }

    public IllegalPieceSelectionException(String message) {
        super(message);
    }

    public IllegalPieceSelectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPieceSelectionException(Throwable cause) {
        super(cause);
    }
}
