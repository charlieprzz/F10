package ui.pages;

import org.openqa.selenium.WebElement;
import ui.utils.LocatorUtils;

public class DashboardPage extends LocatorUtils {

  public String getDashboardTitle() {
    WebElement title = findElement("dashboard", "dashboardHeader");
    return title.getText().trim();
  }

  public void clickTimesheetsIcon() {
    findElement("dashboard", "timesheetsIcon").click();
  }
}
