package lab6.exceptions;


public class DuplicateProductException extends Exception {
    public DuplicateProductException(String message, Throwable cause) {super(message);}

    public DuplicateProductException(String message) {
        super(message);
    }
}
