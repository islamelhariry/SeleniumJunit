package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTests extends BaseTest{

    @Test
    public void simpleAlert(){
        driver.get("https://demoqa.com/alerts");
        // This step will result in an alert on screen
        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Test
    public void promptAlert(){
        driver.get("https://demoqa.com/alerts");
        // This step will result in an alert on screen
        driver.findElement(By.id("promtButton")).click();
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
        driver.get("https://demoqa.com/alerts");
        // This step will result in an alert on screen
        driver.findElement(By.id("confirmButton")).click();
        /*WebElement element = driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);*/
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();
    }

    @Test
    public void UnexpectedAlert(){
        driver.get("https://demoqa.com/alerts");

        try {
            driver.findElement(By.id("timerAlertButton")).click();
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
