package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.tools.BaseTest;
import qa.tools.pom.AlertsPOM;

import java.time.Duration;

import static qa.tools.pom.AlertsPOM.ALERTS_URL;
@Tag("regression")
public class AlertTests extends BaseTest {
    private AlertsPOM pageObject;

    @BeforeEach
    public void navigateToPage() {
        pageObject = PageFactory.initElements(driver, AlertsPOM.class);
        // Navigation resets per test — this DOES change between tests
        driver.get(ALERTS_URL);
    }

    @Test
    public void simpleAlert(){
        // This step will result in an alert on screen
        pageObject.alertButton.click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Test
    public void promptAlert(){
        // This step will result in an alert on screen
        pageObject.promtButton.click();
        /*WebElement element = driver.findElement(By.id("promtButton");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);*/
        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert.sendKeys("Test User");
        promptAlert.accept();
    }

    @Test
    public void confirmationAlert(){
        // This step will result in an alert on screen
        pageObject.confirmButton.click();
        /*WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);*/
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }

    @Test
    public void UnexpectedAlert(){
        try {
            pageObject.timerAlertButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
    }
}
