package com.ExceptionsdemoHW.Exceptions;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException(String message) {
        super(message);
    }
}
