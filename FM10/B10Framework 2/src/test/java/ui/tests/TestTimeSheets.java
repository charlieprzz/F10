package ui.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.utils.Constants;
import ui.utils.Hooks;

import java.util.List;

public class TestTimeSheets extends Constants {
  @BeforeMethod
  public void setup() {
    Hooks.setupDriverSession();
  }

  @AfterMethod
  public void destroy() {
    Hooks.destroyBrowserSession();
  }

  @Test
  public void listTimeSheets() throws InterruptedException {
    driver.get("https://ntkhr.noortecktraining.com/");

    loginPage.enterUsername("ntk-admin");
    loginPage.enterPassword("Ntk-orange!admin.123");
    loginPage.clickLoginButton();

    dashboardPage.clickTimesheetsIcon();

    List<WebElement> rows = timeSheetPage.getRows();

    for (WebElement row: rows) {
      String name = timeSheetPage.getNameFromRow(row);
      String period = timeSheetPage.getTimeSheetPeriodFromRow(row);

      System.out.println(name);
      System.out.println(period);
      System.out.println("*".repeat(20));
    }
  }
}
