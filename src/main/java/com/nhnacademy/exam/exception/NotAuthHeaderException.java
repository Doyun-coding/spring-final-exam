package com.nhnacademy.exam.exception;

public class NotAuthHeaderException extends RuntimeException {
    public NotAuthHeaderException(String message) {
        super(message);
    }
}
