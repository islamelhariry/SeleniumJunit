package test.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CheckBoxTests {
    public static final String FormURL = "https://demoqa.com/automation-practice-form";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CheckBoxOperationsTest() {
        driver.get(FormURL);

        /**
         * Validate isSelected and click
         */

        WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected = checkBoxSelected.isSelected();

        // performing click operation if element is not selected
        if(isSelected == false) {
            checkBoxSelected.click();
        }

        /**
         * Validate isDisplayed and click
         */
        WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isDisplayed = checkBoxDisplayed.isDisplayed();

        // performing click operation if element is displayed
        if (isDisplayed == true) {
            checkBoxDisplayed.click();
        }

        /**
         * Validate isEnabled and click
         */
        WebElement checkBoxEnabled = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isEnabled = checkBoxEnabled.isEnabled();

        // performing click operation if element is enabled
        if (isEnabled == true) {
            checkBoxEnabled.click();
        }
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
