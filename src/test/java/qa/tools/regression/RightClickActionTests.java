package qa.tools.regression;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.ButtonsPOM;

import static qa.tools.pom.ButtonsPOM.BUTTONS_URL;

public class RightClickActionTests extends BaseTest {

    private ButtonsPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, ButtonsPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(BUTTONS_URL);
    }

    @Test
    public void rightClickActionTest(){
        // Launch the URL
        System.out.println("demoqa webpage displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform right click
        WebElement btnElement = pageObject.rightClickBtn;

        //Right Click the button to display Context Menu&nbsp;
        actions.contextClick(btnElement)
                .perform();
        System.out.println("Right click Context Menu displayed");

        //Following code is to select item from context menu which gets open up on right click, this differs
        //depending upon your application specific test case:
        //Select and click 'Copy me' i.e. 2nd option in Context menu
        WebElement elementOpen = pageObject.rightClickMessage;
        Assertions.assertEquals("You have done a right click", elementOpen.getText());
    }

    @Test
    public void doubleClickActionTest(){
        // Launch the URL
        System.out.println("demoqa webpage displayed");

        //Maximise browser window
        driver.manage().window().maximize();

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        //Retrieve WebElement to perform double click WebElement
        WebElement btnElement = pageObject.doubleClickBtn;

        //Double Click the button
        actions.doubleClick(btnElement)
                .perform();
        System.out.println("Right click Context Menu displayed");

        //Following code is to select item from context menu which gets open up on right click, this differs
        //depending upon your application specific test case:
        //Select and click 'Copy me' i.e. 2nd option in Context menu
        WebElement elementOpen = pageObject.doubleClickMessage;
        Assertions.assertEquals("You have done a double click", elementOpen.getText());
    }
}
