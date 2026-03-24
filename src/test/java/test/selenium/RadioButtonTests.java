package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtonTests extends BaseTest{
    public static final String RadioButtonURL = "https://demoqa.com/radio-button";

    @Test
    public void RadioButtonOperationsTest() {
        driver.get(RadioButtonURL);

        // Find radio button using ID, Validate isSelected and then click to select
        WebElement radioYes = driver.findElement(By.id("yesRadio"));
        boolean yesSelected = radioYes.isSelected();
        System.out.print(yesSelected);
        // performing click operation if element is not already selected
        if (!yesSelected) {
            radioYes.click();
        }

        // Find radio button using Xpath, Validate isDisplayed and click to select
        WebElement radioImpressive = driver.findElement(By.xpath("//div/input[@id='impressiveRadio']"));
        boolean impressiveSelected = radioYes.isDisplayed();

        // performing click operation if element is displayed
        if (impressiveSelected) {
            radioImpressive.click();
        }

        // Find radio button using CSS Selector, Validate isEnabled and click to select
        WebElement radioNo = driver.findElement(By.cssSelector("input[id='noRadio']"));
        boolean noSelected = radioNo.isEnabled();

        // performing click operation if element is enabled
        if (noSelected) {
            radioNo.click();
        }
    }
}
