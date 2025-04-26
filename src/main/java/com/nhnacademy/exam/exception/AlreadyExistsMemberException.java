package com.nhnacademy.exam.exception;

public class AlreadyExistsMemberException extends RuntimeException {
    public AlreadyExistsMemberException(String message) {
        super(message);
    }
}
