package com.wijdemans.error;

public abstract class ErrorsException extends RuntimeException {

    private final Errors errors;

    public ErrorsException(Error error) {
        this(new Errors(error));
    }

    public ErrorsException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
