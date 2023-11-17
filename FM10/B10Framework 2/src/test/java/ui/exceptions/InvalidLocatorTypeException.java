package ui.exceptions;

public class InvalidLocatorTypeException extends RuntimeException {
  public InvalidLocatorTypeException(String message) {
    super(message);
  }
  public InvalidLocatorTypeException() {
    super();
  }
}
