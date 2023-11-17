package ui.utils;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.exceptions.InvalidLocatorTypeException;

import java.time.Duration;
import java.util.List;

public class LocatorUtils {
  public static By buildLocator(String type, String locatorValue) {

    switch (type) {
      case "id":
        return By.id(locatorValue);

      case "name":
        return By.name(locatorValue);

      case "xpath":
        return By.xpath(locatorValue);

      case "css":
        return By.cssSelector(locatorValue);

      case "className":
        return By.className(locatorValue);

      case "linkText":
        return By.linkText(locatorValue);

      case "partialLinkText":
        return By.partialLinkText(locatorValue);

      case "tagName":
        return By.tagName(locatorValue);

      default:
        // Throw an exception
        throw new InvalidLocatorTypeException("Locator type is not valid");
    }
  }
  public static WebElement findElement(String page, String locatorKey) {
    JSONObject locatorObject = Constants.locatorObject;
    JSONObject locatorInfo = locatorObject.getJSONObject(page).getJSONObject(locatorKey);
    String type = locatorInfo.getString("type");
    String value = locatorInfo.getString("value");
    By by = buildLocator(type, value);

    WebDriverWait wait = new WebDriverWait(Constants.driver, Duration.ofSeconds(Constants.WAIT_TIME_IN_SEC));
    WebElement locatedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    return locatedElement;
  }
  public static List<WebElement> findElements(String page, String locatorKey) {
    JSONObject locatorObject = Constants.locatorObject;
    JSONObject locatorInfo = locatorObject.getJSONObject(page).getJSONObject(locatorKey);
    String type = locatorInfo.getString("type");
    String value = locatorInfo.getString("value");
    By by = buildLocator(type, value);

    WebDriverWait wait = new WebDriverWait(Constants.driver, Duration.ofSeconds(Constants.WAIT_TIME_IN_SEC));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    return Constants.driver.findElements(by);
  }

}
