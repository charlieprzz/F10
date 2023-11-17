package ui.pages;

import org.openqa.selenium.WebElement;
import ui.utils.LocatorUtils;

public class LoginPage extends LocatorUtils {
  public void enterUsername(String username) {
    WebElement usernameInput = findElement("login", "username");
    usernameInput.sendKeys(username);
  }

  public void enterPassword(String password) {
    WebElement passwordInput = findElement("login", "password");
    passwordInput.sendKeys(password);
  }

  public void clickLoginButton() {
    WebElement button = findElement("login", "loginButton");
    button.click();
  }

  public String getErrorMessage() {
    return findElement("login", "errorMessage").getText().trim();
  }

  public String getRequiredMessageForUsername() {
    return findElement("login", "requiredMessageForUsername").getText().trim();
  }

  public String getRequiredMessageForPassword() {
    return findElement("login", "requiredMessageForPassword").getText().trim();
  }
}
