package ui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
  public static void setupDriverSession() {
    String browser = Constants.envObject.getString("browser"); // chrome
    WebDriver driver = DriverUtils.createDriver(browser);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_TIME_IN_SEC));
    driver.manage().window().maximize();
    Constants.driver = driver;
  }

  public static void destroyBrowserSession() {
    Constants.driver.quit();
    Constants.driver = null;
  }
}
