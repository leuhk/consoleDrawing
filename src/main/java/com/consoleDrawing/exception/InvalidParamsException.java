package com.consoleDrawing.exception;

public class InvalidParamsException extends RuntimeException {

  public InvalidParamsException(String message) {
    super(message);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
