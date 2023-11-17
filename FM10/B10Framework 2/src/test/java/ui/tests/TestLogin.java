package ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.utils.Constants;
import ui.utils.Hooks;

public class TestLogin extends Constants {
  @BeforeMethod
  public void setup() {
    Hooks.setupDriverSession();
  }

  @AfterMethod
  public void destroy() {
    Hooks.destroyBrowserSession();
  }

  @DataProvider(name = "valid_credentials")
  public Object[][] credentialsProvider() {
    Object[][] provider = {
      {"ntk-admin", "Ntk-orange!admin.123"},
    };
    return provider;
  }

  @DataProvider(name = "invalid_credentials")
  public Object[][] invalidCredentailsProvider() {
    Object[][] provider = {
      {"abc", "def"},
      {"", "awdas"},
      {"ntk-admin", ""},
      {"", ""}
    };
    return provider;
  }

  @Test(dataProvider = "valid_credentials")
  public void testLoginWithValidCredentials(String username, String password) {
    driver.get("https://ntkhr.noortecktraining.com/");

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();

    Assert.assertEquals(dashboardPage.getDashboardTitle(), "Dashboard");
  }

  @Test(dataProvider = "invalid_credentials")
  public void testLoginWithInvalidCredentials(String username, String password) {
    driver.get("https://ntkhr.noortecktraining.com/");

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();

    if (!username.isEmpty() && !password.isEmpty()) {
      String errorMessage = loginPage.getErrorMessage();
      Assert.assertEquals(errorMessage, "Invalid credentials");
    }

    if (username.isEmpty()) {
      String message = loginPage.getRequiredMessageForUsername();
      Assert.assertEquals(message, "Required");
    }

    if (password.isEmpty()) {
      String message = loginPage.getRequiredMessageForPassword();
      Assert.assertEquals(message, "Required");
    }
  }
}
