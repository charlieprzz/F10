package ui.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.utils.Constants;
import ui.utils.Hooks;

import java.util.List;

public class TestPim extends Constants {
  @BeforeMethod
  public void before() {
    Hooks.setupDriverSession();
  }

  @AfterMethod
  public void after() {
    Hooks.destroyBrowserSession();
  }

  @Test
  public void listPIMEmployees() {
    driver.get("https://ntkhr.noortecktraining.com/");

    loginPage.enterUsername("ntk-admin");
    loginPage.enterPassword("Ntk-orange!admin.123");
    loginPage.clickLoginButton();

    sideMenuPage.switchToPIMPage();

    List<WebElement> rows = pimPage.getRows();

    for (WebElement row: rows) {
      String id = pimPage.getIdFromRow(row);
      String name = pimPage.getFirstNameFromRow(row);
      String lastName = pimPage.getLastNameFromRow(row);

      System.out.println(id);
      System.out.println(name);
      System.out.println(lastName);
      System.out.println("*".repeat(20));
    }
  }
}
