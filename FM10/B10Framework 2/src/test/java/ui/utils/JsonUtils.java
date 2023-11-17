package ui.utils;

import org.json.JSONObject;
import ui.exceptions.InvalidFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JsonUtils {
  public static void main(String[] args) {
    JSONObject json = parseFileIntoJSON("src/test/resources/locators.json");
    System.out.println(json);
  }
  public static JSONObject parseFileIntoJSON(String filePath) {
    try {
      File file = new File(filePath);
      Scanner sc = new Scanner(file);
      String fileContent = "";
      while (sc.hasNextLine()) {
        fileContent = fileContent + sc.nextLine() + "\n";
      }
      sc.close();
      JSONObject json = new JSONObject(fileContent);
      return json;
    } catch (Exception e) {
      throw new InvalidFileException(e.getMessage());
    }
  }
}
