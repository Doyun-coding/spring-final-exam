package com.nhnacademy.exam.exception;

public class NotFoundMemberIdException extends RuntimeException {
    public NotFoundMemberIdException(String message) {
        super(message);
    }
}
