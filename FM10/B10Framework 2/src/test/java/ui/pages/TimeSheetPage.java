package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.utils.LocatorUtils;

import java.util.List;

public class TimeSheetPage extends LocatorUtils {
  public List<WebElement> getRows() {
    return findElements("time", "getRows");
  }

  public String getNameFromRow(WebElement row) {
    return row.findElement(By.xpath("./div[1]")).getText().trim();
  }

  public String getTimeSheetPeriodFromRow(WebElement row) {
    return row.findElement(By.xpath("./div[2]")).getText().trim();
  }
}
