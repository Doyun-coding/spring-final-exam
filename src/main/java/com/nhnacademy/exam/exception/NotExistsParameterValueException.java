package com.nhnacademy.exam.exception;

public class NotExistsParameterValueException extends RuntimeException {
  public NotExistsParameterValueException(String message) {
    super(message);
  }
}
