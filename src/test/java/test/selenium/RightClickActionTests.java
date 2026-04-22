package test.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightClickActionTests extends BaseTest{
    @Test
    public void rightClickActionTest(){
        // Launch the URL
        driver.get("https://demoqa.com/buttons");
        System.out.println("demoqa webpage displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform right click
        WebElement btnElement = driver.findElement(By.id("rightClickBtn"));

        //Right Click the button to display Context Menu&nbsp;
        actions.contextClick(btnElement)
                .perform();
        System.out.println("Right click Context Menu displayed");

        //Following code is to select item from context menu which gets open up on right click, this differs
        //depending upon your application specific test case:
        //Select and click 'Copy me' i.e. 2nd option in Context menu
        WebElement elementOpen = driver.findElement(By.xpath("//*[@id=\"rightClickMessage\"]"));
        Assertions.assertEquals("You have done a right click", elementOpen.getText());
    }

    @Test
    public void doubleClickActionTest(){
        // Launch the URL
        driver.get("https://demoqa.com/buttons");
        System.out.println("demoqa webpage displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform double click WebElement
        WebElement btnElement = driver.findElement(By.id("doubleClickBtn"));

        //Double Click the button
        actions.doubleClick(btnElement)
                .perform();
        System.out.println("Right click Context Menu displayed");

        //Following code is to select item from context menu which gets open up on right click, this differs
        //depending upon your application specific test case:
        //Select and click 'Copy me' i.e. 2nd option in Context menu
        WebElement elementOpen = driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]"));
        Assertions.assertEquals("You have done a double click", elementOpen.getText());
    }
}
