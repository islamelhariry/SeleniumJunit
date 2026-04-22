package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementTests extends BaseTest{
    @Test
    public void moveToElementTest(){
        driver.get("https://demoqa.com/menu/");

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        WebElement menu2 = driver.findElement(By.xpath(".//a[contains(text(),'Main Item 2')]"));

        actions.moveToElement(menu2).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

        WebElement subMenuOption = driver.findElement(By.xpath(".//a[contains(text(),'Sub Item')]"));
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on first 'Sub Item' from 'Main Item 2'");

        subMenuOption.click();
        System.out.println("Selected first 'Sub Item' from 'Main Item 2'");
    }

    @Test
    public void moveSliderTest(){
        driver.get("https://demoqa.com/slider/");

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.cssSelector("input[id='slider']"));

        actions.moveToElement(slider,50,0).perform();
        slider.click();
        System.out.println("Moved slider in horizontal directions");
    }
}
