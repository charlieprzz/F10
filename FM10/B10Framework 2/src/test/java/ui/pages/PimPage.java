package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utils.LocatorUtils;

import java.util.List;

public class PimPage extends LocatorUtils {
  public List<WebElement> getRows() {
    return findElements("pim", "getRows");
  }

  public String getIdFromRow(WebElement row) {
    return row.findElement(By.xpath("./div[2]")).getText().trim();
  }

  public String getFirstNameFromRow(WebElement row) {
    return row.findElement(By.xpath("./div[3]")).getText().trim();
  }

  public String getLastNameFromRow(WebElement row) {
    return row.findElement(By.xpath("./div[4]")).getText().trim();
  }
}
