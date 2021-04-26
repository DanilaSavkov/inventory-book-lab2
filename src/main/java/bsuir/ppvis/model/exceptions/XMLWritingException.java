package bsuir.ppvis.model.exceptions;

public class XMLWritingException extends Exception {
    public XMLWritingException() {
    }

    public XMLWritingException(String message) {
        super(message);
    }

    public XMLWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLWritingException(Throwable cause) {
        super(cause);
    }

    public XMLWritingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
