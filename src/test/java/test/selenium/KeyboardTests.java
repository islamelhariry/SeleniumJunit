package test.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardTests extends BaseTest{
    @Test
    public void testKeyboard(){
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.Peter Haynes");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("PeterHaynes@toolsqa.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("43 School Lane London EC71 9GO");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .keyDown("A")
                .keyDown("C")
                .keyUp(Keys.CONTROL)
                .perform();

        currentAddress.sendKeys(Keys.TAB);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        actions.keyDown(Keys.CONTROL)
                .keyDown("V")
                .keyUp(Keys.CONTROL)
                .perform();

        Assertions.assertEquals(currentAddress.getAttribute("value"),
                permanentAddress.getAttribute("value"));
    }
}
