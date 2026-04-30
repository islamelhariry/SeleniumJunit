package qa.tools.regression;

import com.google.common.base.Function;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import qa.tools.BaseTest;
import qa.tools.pom.DynamicPropertiesPOM;

import java.time.Duration;

import static qa.tools.pom.DynamicPropertiesPOM.DYNAMIC_PROPERTIES_URL;
@Tag("regression")
public class WaitTests extends BaseTest {

    private DynamicPropertiesPOM pageObject;

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        pageObject = PageFactory.initElements(driver, DynamicPropertiesPOM.class);

        driver.get(DYNAMIC_PROPERTIES_URL);
    }

    @Test
    public void WaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement visibleAfter5Sec = pageObject.visibleAfter;
        System.out.println(visibleAfter5Sec.getText());
    }

    @Test
    public void CustomBooleanWaitFunctionTest(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .pollingEvery(Duration.ofMillis(250))
            .withTimeout(Duration.ofSeconds(2));

        Function<WebDriver, Boolean> function = driver -> {
            WebElement element;
            element = pageObject.colorChange;
            String text = element.getText();
            System.out.println("The text of the button is " + text);
            return text.equals("Color Change");
        };

        wait.until(function);
    }

    @Test
    public void CustomElementWaitFunctionTest(){
        driver.get(DYNAMIC_PROPERTIES_URL);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .pollingEvery(Duration.ofMillis(250))
            .withTimeout(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class); //make sure that this exception is ignored

        Function<WebDriver, WebElement> function = driver -> {
            System.out.println("Checking for the element!!");
            WebElement element = pageObject.visibleAfter;
            System.out.println("Target element found");
            return element;
        };

        wait.until(function);
    }
}
