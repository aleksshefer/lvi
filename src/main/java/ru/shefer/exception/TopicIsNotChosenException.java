package ru.shefer.exception;

public class TopicIsNotChosenException extends RuntimeException {
    public TopicIsNotChosenException() {
    }

    public TopicIsNotChosenException(String message) {
        super(message);
    }

    public TopicIsNotChosenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TopicIsNotChosenException(Throwable cause) {
        super(cause);
    }

    public TopicIsNotChosenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
