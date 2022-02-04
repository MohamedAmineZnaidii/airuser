package com.challenger.airuser.exceptions;

/**
 * Created By ZNAIDI :)
 */

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
