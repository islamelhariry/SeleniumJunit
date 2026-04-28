package qa.tools.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPOM {
    public static final String WEB_TABLES_URL = "https://demoqa.com/webtables";

    private final WebDriver driver;

    public WebTablesPOM(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@class='web-tables-wrapper']/table/tbody/tr[1]/td[2]")
    public WebElement sCellValue;

    @FindBy(xpath = ".//*[@class='web-tables-wrapper']/table/tbody/tr[1]/td[7]")
    public WebElement lastColumn;

    // Dynamic cell accessor — replaces raw By.xpath in tests
    public WebElement cell(String row, String col) {
        return driver.findElement(
                By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[" + row + "]/td[" + col + "]")
        );
    }

    // Finds all cells in a named row by matching first-column value
    public void printRowByFirstColumnValue(String targetValue, int totalRows, int totalCols) {
        for (int i = 1; i <= totalRows; i++) {
            String firstColValue = cell(String.valueOf(i), "1").getText();
            if (firstColValue.equalsIgnoreCase(targetValue)) {
                for (int j = 1; j <= totalCols; j++) {
                    System.out.println(cell(String.valueOf(i), String.valueOf(j)).getText());
                }
                break;
            }
        }
    }
}
