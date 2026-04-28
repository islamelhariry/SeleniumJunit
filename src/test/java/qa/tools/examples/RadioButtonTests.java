package qa.tools.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.RadioButtonPOM;

import static qa.tools.pom.RadioButtonPOM.RADIO_BUTTON_URL;

@Tag("smoke")
public class RadioButtonTests extends BaseTest {
    private RadioButtonPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, RadioButtonPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(RADIO_BUTTON_URL);
    }

    @Test
    public void RadioButtonOperationsTest() {
        // Find radio button using ID, Validate isSelected and then click to select
        WebElement radioYes = pageObject.yesRadio;
        boolean yesSelected = radioYes.isSelected();
        System.out.print(yesSelected);
        // performing click operation if element is not already selected
        if (!yesSelected) {
            radioYes.click();
        }

        // Find radio button using Xpath, Validate isDisplayed and click to select
        WebElement radioImpressive = pageObject.impressiveRadio;
        boolean impressiveSelected = radioYes.isDisplayed();

        // performing click operation if element is displayed
        if (impressiveSelected) {
            radioImpressive.click();
        }

        // Find radio button using CSS Selector, Validate isEnabled and click to select
        WebElement radioNo = pageObject.noRadio;
        boolean noSelected = radioNo.isEnabled();

        // performing click operation if element is enabled
        if (noSelected) {
            radioNo.click();
        }
    }
}
