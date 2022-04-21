package exceptions;

/**
 * @author Dave Smedts
 * @version 1.0 27/02/2022 22:06
 */
public class IllegalMoveException extends Exception{
    public IllegalMoveException() {
    }

    public IllegalMoveException(String message) {
        super(message);
    }

    public IllegalMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMoveException(Throwable cause) {
        super(cause);
    }

}
