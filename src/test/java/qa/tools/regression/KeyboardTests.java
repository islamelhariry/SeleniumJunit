package qa.tools.regression;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.TextBoxPOM;

import static qa.tools.pom.TextBoxPOM.TEXT_BOX_URL;
@Tag("regression")
public class KeyboardTests extends BaseTest {
    private TextBoxPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, TextBoxPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(TEXT_BOX_URL);
    }

    @Test
    public void testKeyboard(){
        WebElement fullName = pageObject.userName;
        fullName.sendKeys("Mr.Peter Haynes");

        WebElement email = pageObject.userEmail;
        email.sendKeys("PeterHaynes@toolsqa.com");

        WebElement currentAddress = pageObject.currentAddress;
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
