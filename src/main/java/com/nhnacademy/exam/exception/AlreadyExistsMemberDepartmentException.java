package com.nhnacademy.exam.exception;

public class AlreadyExistsMemberDepartmentException extends RuntimeException {
    public AlreadyExistsMemberDepartmentException(String message) {
        super(message);
    }
}
