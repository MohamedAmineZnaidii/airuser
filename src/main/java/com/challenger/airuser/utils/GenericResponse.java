package com.challenger.airuser.utils;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By ZNAIDI :)
 */

public class GenericResponse {
    private String message;
    private String error;

    public GenericResponse(String message) {
        super();
        this.message = message;
    }

    public GenericResponse(String message,String error) {
        super();
        this.message = message;
        this.error = error;
    }

    /**
     * get a generic list of errors
     * @param allErrors list of error messages
     * @param error error
     */
    public GenericResponse(List<ObjectError> allErrors, String error) {
        this.error = error;
        String temp = allErrors.stream().map(e -> {
            if (e instanceof FieldError) {
                return "{field: " + ((FieldError) e).getField() + ",Message: " + e.getDefaultMessage() + "} ";
            } else {
                return "{object:" + e.getObjectName() + ",Message:" + e.getDefaultMessage() + "}";
            }
        }).collect(Collectors.joining(","));
        this.message = "[" + temp + "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

}
