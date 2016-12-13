package com.ddup.java.exception;

public class MessageException extends Exception {

    /** */
    private static final long serialVersionUID = 1L;
    
    public MessageException() {
        super();
    }

    public MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }
}
