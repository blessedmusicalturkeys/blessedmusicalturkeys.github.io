package com.freightwise.software.test.exception;

import lombok.Getter;

@Getter
public class BadZipProvidedException extends RuntimeException {
  private String message;

  public BadZipProvidedException(String message) {
    this.message = message;
  }
}
