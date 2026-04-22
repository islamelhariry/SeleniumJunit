package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ToolTipsTests extends BaseTest{
    @Test
    public void ToolTipsTest(){
        //CASE 1: Using getAttribute
        // Launch the URL
        driver.get("https://demoqa.com/tool-tips/");
        System.out.println("Tooltip web Page Displayed");

        // Instantiate Action Class
        Actions actions = new Actions(driver);

        // Retrieve WebElement
        WebElement element = driver.findElement(By.id("toolTipButton"));
        // Hover first
        actions.moveToElement(element).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "aria-describedby"));

        // Grab the ID Bootstrap assigned  e.g. "tooltip123"
        String tooltipId = element.getAttribute("aria-describedby");

        // Find the injected tooltip div by that ID
        WebElement toolTip = driver.findElement(By.id(Objects.requireNonNull(tooltipId)));

        String toolTipText = toolTip.getText();
        System.out.println("toolTipText --> " + toolTipText);
        //Verification if tooltip text is matching expected value
        if(toolTipText.equalsIgnoreCase("You hovered over the Button")){
            System.out.println("Pass : Tooltip matching expected value");
        }
        else{
            System.out.println("Fail : Tooltip NOT matching expected value");
        }
    }

    @Test
    public void ToolTipsTest5() {

        // CASE 2 : Using Actions class method
        driver.get("https://demoqa.com/tool-tips");
        System.out.println("demoqa webpage Displayed");

        // Maximise browser window
        driver.manage().window().maximize();

        // Instantiate Action Class
        Actions actions = new Actions(driver);

        // Retrieve WebElement
        WebElement element = driver.findElement(By.id("toolTipButton"));

        // Use action class to mouse hover
        actions.moveToElement(element).perform();

        // Wait for Bootstrap tooltip to appear in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toolTip = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner"))
        );

        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText --> " + toolTipText);

        // Correct expected text for this button
        if (toolTipText.equalsIgnoreCase("You hovered over the Button")) {
            System.out.println("Pass* : Tooltip matching expected value");
        } else {
            System.out.println("Fail : Tooltip NOT matching expected value -- Got: " + toolTipText);
        }
    }
}
