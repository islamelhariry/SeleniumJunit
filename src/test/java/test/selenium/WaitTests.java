package test.selenium;

import com.google.common.base.Function;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Objects;

public class WaitTests extends BaseTest{

    @Test
    public void WaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement visibleAfter5Sec = driver.findElement(By.id("visibleAfter"));
        System.out.println(visibleAfter5Sec.getText());
    }

    @Test
    public void CustomBooleanWaitFunctionTest(){
        driver.get("https://demoqa.com/dynamic-properties");

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .pollingEvery(Duration.ofMillis(250))
            .withTimeout(Duration.ofSeconds(2));

        Function<WebDriver, Boolean> function = arg0 -> {
            WebElement element;
            element = Objects.requireNonNull(arg0).findElement(By.id("colorChange"));
            String text = element.getText();
            System.out.println("The text of the button is " + text);
            return text.equals("Color Change");
        };

        wait.until(function);
    }

    @Test
    public void CustomElementWaitFunctionTest(){
        driver.get("https://demoqa.com/dynamic-properties");

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .pollingEvery(Duration.ofMillis(250))
            .withTimeout(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class); //make sure that this exception is ignored

        Function<WebDriver, WebElement> function = arg0 -> {
            System.out.println("Checking for the element!!");
            WebElement element = Objects.requireNonNull(arg0).findElement(By.id("visibleAfter"));
            System.out.println("Target element found");
            return element;
        };

        wait.until(function);
    }
}
