package ru.shefer.exception;

public class UserIsNotLoggedException extends RuntimeException {
    public UserIsNotLoggedException() {
    }

    public UserIsNotLoggedException(String message) {
        super(message);
    }

    public UserIsNotLoggedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotLoggedException(Throwable cause) {
        super(cause);
    }

    public UserIsNotLoggedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
