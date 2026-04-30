package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.WebTablesPOM;

import static qa.tools.pom.WebTablesPOM.WEB_TABLES_URL;
@Tag("regression")
public class TableTests extends BaseTest {
    private WebTablesPOM pageObject;

    @BeforeEach
    public void navigateToPage() {
        pageObject = PageFactory.initElements(driver, WebTablesPOM.class);
        // Navigation resets per test — this DOES change between tests
        driver.get(WEB_TABLES_URL);
    }
    @Test
    public void PracticeTables() {
        //Here we are storing the value from the cell in to the string variable
        String sCellValue = pageObject.sCellValue.getText();
        System.out.println(sCellValue);

        // Here we are clicking on the link of first row and the last column
        pageObject.lastColumn.click();
        System.out.println("Link has been clicked otherwise an exception would have thrown");
    }

    @Test
    public void PracticeTable_2() {
        // Dynamic cell lookup via POM method
        String sCellValue = pageObject.cell("1", "2").getText();
        System.out.println(sCellValue);

        // Row search encapsulated in POM
        pageObject.printRowByFirstColumnValue("Cierra", 3, 7);
    }
}
