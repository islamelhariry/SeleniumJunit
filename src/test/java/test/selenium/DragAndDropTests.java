package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTests extends BaseTest{
    @Test
    public void dragAndDropTest(){
        driver.get("http://demoqa.com/droppable/");

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
    }

    @Test
    public void dragAndDropByOffsetsTest(){
        driver.get("http://demoqa.com/droppable/");

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDropBy(from,
                to.getLocation().x - from.getLocation().x +20,
                to.getLocation().y - from.getLocation().y +50)
                .perform();

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
    }

    @Test
    public void dragAndDropByTest(){
        driver.get("https://demoqa.com/dragabble");

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement dragBox = driver.findElement(By.id("dragBox"));

        //Perform drag and drop
        builder.dragAndDropBy(dragBox,100,300).perform();

        System.out.println("Dropped");
    }
}
