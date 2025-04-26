package com.nhnacademy.exam.exception;

public class AlreadyExistsDepartmentException extends RuntimeException {
    public AlreadyExistsDepartmentException(String message) {
        super(message);
    }
}
