package ui.pages;

import ui.utils.LocatorUtils;

public class SideMenuPage extends LocatorUtils {
  public void switchToPIMPage() {
    findElement("sideMenu", "pim").click();
  }
}
