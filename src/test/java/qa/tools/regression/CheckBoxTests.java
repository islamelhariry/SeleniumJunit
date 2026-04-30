package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.FormPOM;

import static qa.tools.pom.FormPOM.FORM_URL;

public class CheckBoxTests extends BaseTest {
    private FormPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, FormPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(FORM_URL);
    }

    @Test
    public void CheckBoxOperationsTest() {
        // Validate isSelected and click

        boolean isSelected = pageObject.checkBox.isSelected();

        // performing click operation if element is not selected
        if(!isSelected) {
            pageObject.checkBox.click();
        }

        // Validate isDisplayed and click
        boolean isDisplayed = pageObject.checkBox.isDisplayed();

        // performing click operation if element is displayed
        if (isDisplayed) {
            pageObject.checkBox.click();
        }

        // Validate isEnabled and click
        boolean isEnabled = pageObject.checkBox.isEnabled();

        // performing click operation if element is enabled
        if (isEnabled) {
            pageObject.checkBox.click();
        }
    }
}
