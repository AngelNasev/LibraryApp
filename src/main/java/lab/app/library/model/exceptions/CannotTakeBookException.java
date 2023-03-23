package lab.app.library.model.exceptions;

public class CannotTakeBookException extends RuntimeException {
    public CannotTakeBookException() {
        super("Cannot take book because the number of copies is less than 1");
    }
}
