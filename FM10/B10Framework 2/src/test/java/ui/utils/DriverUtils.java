package ui.utils;

import com.intuit.karate.driver.DriverOptions;
import com.intuit.karate.driver.microsoft.IeWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.exceptions.InvalidBrowserException;

public class DriverUtils {
  public static WebDriver createDriver(String browser) {
    switch (browser) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();

      case "edge":
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();

      default:
        throw new InvalidBrowserException("Invalid browser was specified");
    }
  }
}
