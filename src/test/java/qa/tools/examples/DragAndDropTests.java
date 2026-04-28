package qa.tools.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.DroppablePOM;

import static qa.tools.pom.DroppablePOM.DRAGABLE_URL;
import static qa.tools.pom.DroppablePOM.DROPPABLE_URL;

@Tag("smoke")
public class DragAndDropTests extends BaseTest {

    private DroppablePOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, DroppablePOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(DROPPABLE_URL);
    }
    @Test
    public void dragAndDropTest(){
        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement from = pageObject.draggable;
        WebElement to = pageObject.droppable;
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
        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement from = pageObject.draggable;
        WebElement to = pageObject.droppable;
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
        driver.get(DRAGABLE_URL);

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);
        WebElement dragBox = pageObject.dragBox;
        //Perform drag and drop
        builder.dragAndDropBy(dragBox,100,300).perform();

        System.out.println("Dropped");
    }
}
