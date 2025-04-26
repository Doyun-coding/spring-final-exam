package com.nhnacademy.exam.exception;

public class NotFoundDepartmentIdException extends RuntimeException {
    public NotFoundDepartmentIdException(String message) {
        super(message);
    }
}
