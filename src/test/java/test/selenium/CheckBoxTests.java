package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxTests extends BaseTest{
    public static final String FormURL = "https://demoqa.com/automation-practice-form";

    @Test
    public void CheckBoxOperationsTest() {
        driver.get(FormURL);

        // Validate isSelected and click

        WebElement checkBoxSelected = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isSelected = checkBoxSelected.isSelected();

        // performing click operation if element is not selected
        if(!isSelected) {
            checkBoxSelected.click();
        }

        // Validate isDisplayed and click
        WebElement checkBoxDisplayed = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isDisplayed = checkBoxDisplayed.isDisplayed();

        // performing click operation if element is displayed
        if (isDisplayed) {
            checkBoxDisplayed.click();
        }

        // Validate isEnabled and click
        WebElement checkBoxEnabled = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        boolean isEnabled = checkBoxEnabled.isEnabled();

        // performing click operation if element is enabled
        if (isEnabled) {
            checkBoxEnabled.click();
        }
    }
}
