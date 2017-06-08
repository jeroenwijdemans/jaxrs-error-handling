package com.wijdemans.error;

/**
 * <p>
 * throw new WebApplicationException(status, new Errors(  ))
 * </p>
 */
public class Error {

    public static final int UNKNOWN = 100;

    private final int code;
    private final String message;
    private final String description;

    private Error(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
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

    public static Error create(Exception e) {
        return new Error(UNKNOWN, e.getMessage(), "");
    }

    public static Error create(int code, String message) {
        return new Error(code, message, "");
    }

    public static Error create(int code, String message, String description) {
        return new Error(code, message, description);
    }


}
