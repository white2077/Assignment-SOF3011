package com.sof3011.assignment.exception;

public class EntityNotFoundGeneralException extends RuntimeException{
    public EntityNotFoundGeneralException() {
        super();
    }

    public EntityNotFoundGeneralException(String message) {
        super(message);
    }

    public EntityNotFoundGeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundGeneralException(Throwable cause) {
        super(cause);
    }

    protected EntityNotFoundGeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
