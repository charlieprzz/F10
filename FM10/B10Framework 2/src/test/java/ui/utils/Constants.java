package ui.utils;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import ui.pages.*;

public class Constants {
  public static WebDriver driver;
  public static final int WAIT_TIME_IN_SEC = 10;
  public static JSONObject locatorObject = JsonUtils.parseFileIntoJSON("src/test/resources/locators.json");
  public static JSONObject envObject = JsonUtils.parseFileIntoJSON("src/test/resources/env.json");

  // Pages
  public static LoginPage loginPage = new LoginPage();
  public static DashboardPage dashboardPage = new DashboardPage();
  public static SideMenuPage sideMenuPage = new SideMenuPage();
  public static PimPage pimPage = new PimPage();
  public static TimeSheetPage timeSheetPage = new TimeSheetPage();
}
