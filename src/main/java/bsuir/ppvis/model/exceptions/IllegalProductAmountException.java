package bsuir.ppvis.model.exceptions;

public class IllegalProductAmountException extends Exception {
    public IllegalProductAmountException() {
    }

    public IllegalProductAmountException(String message) {
        super(message);
    }

    public IllegalProductAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalProductAmountException(Throwable cause) {
        super(cause);
    }

    public IllegalProductAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
