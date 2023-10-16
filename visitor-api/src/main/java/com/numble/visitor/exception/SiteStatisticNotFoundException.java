package com.numble.visitor.exception;

public class SiteStatisticNotFoundException extends RuntimeException {
    public SiteStatisticNotFoundException(String message) {
        super(message);
    }

    public SiteStatisticNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
