package com.raise.live.core.exception;

public class LiveException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public LiveException(String message, Throwable cause) {
    super(message, cause);
  }

  public LiveException(String message) {
    super(message);
  }
}
