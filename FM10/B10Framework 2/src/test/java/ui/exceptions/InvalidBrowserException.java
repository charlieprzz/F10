package ui.exceptions;

public class InvalidBrowserException extends RuntimeException {
  public InvalidBrowserException() {

  }
  public InvalidBrowserException(String message) {
    super(message);
  }
}
