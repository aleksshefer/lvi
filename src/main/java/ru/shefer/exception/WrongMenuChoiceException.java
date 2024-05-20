package ru.shefer.exception;

public class WrongMenuChoiceException extends RuntimeException {
    public WrongMenuChoiceException() {
    }

    public WrongMenuChoiceException(String message) {
        super(message);
    }

    public WrongMenuChoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongMenuChoiceException(Throwable cause) {
        super(cause);
    }

    public WrongMenuChoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
