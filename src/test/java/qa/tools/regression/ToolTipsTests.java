package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.tools.BaseTest;
import qa.tools.pom.ToolTipsPOM;

import java.time.Duration;
import java.util.Objects;

import static qa.tools.pom.AlertsPOM.ALERTS_URL;
import static qa.tools.pom.ToolTipsPOM.TOOL_TIPS_URL;

public class ToolTipsTests extends BaseTest {

    private ToolTipsPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, ToolTipsPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(ALERTS_URL);
    }

    @Test
    public void ToolTipsTest(){
        //CASE 1: Using getAttribute
        // Launch the URL
        driver.get(TOOL_TIPS_URL);
        System.out.println("Tooltip web Page Displayed");

        // Instantiate Action Class
        Actions actions = new Actions(driver);


        // Hover first
        actions.moveToElement(pageObject.toolTipButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(pageObject.toolTipButton, "aria-describedby"));

        // Grab the ID Bootstrap assigned  e.g. "tooltip123"
        String tooltipId = pageObject.toolTipButton.getAttribute("aria-describedby");

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
        driver.get(TOOL_TIPS_URL);
        System.out.println("demoqa webpage Displayed");

        // Instantiate Action Class
        Actions actions = new Actions(driver);

        // Retrieve WebElement
        // Hover first
        actions.moveToElement(pageObject.toolTipButton).perform();

        // Wait for Bootstrap tooltip to appear in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toolTip = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ToolTipsPOM.TOOLTIP_INNER));


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
