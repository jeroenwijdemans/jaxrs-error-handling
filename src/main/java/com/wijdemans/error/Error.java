package com.wijdemans.error;

/**
 * <p>
 * throw new WebApplicationException(status, new Errors(  ))
 * </p>
 */
public class Error {

    public static final int UNKNOWN = 100;

    private int code;
    private String message;
    private String description;

    public Error(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public Error(Exception e) {
        this.code = UNKNOWN;
        this.message = e.getMessage();
        this.description = e.getMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
