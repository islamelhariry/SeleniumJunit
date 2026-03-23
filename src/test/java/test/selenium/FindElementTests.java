package test.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FindElementTests {
    public static final String TextBoxURL = "https://demoqa.com/text-box/";
    public static final String FormURL = "https://demoqa.com/automation-practice-form";
    public static final String LinksURL = "https://demoqa.com/links";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void FindElementsTest() {
        driver.get(TextBoxURL);

        // Find elements using tag name
        List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

        if(allInputElements.size() != 0)
        {
            System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

            for(WebElement inputElement : allInputElements)
            {
                System.out.println(inputElement.getAttribute("placeholder"));
            }
        }
    }

    @Test
    public void FindElementTest() {
        driver.get(TextBoxURL);

        WebElement element = driver.findElement(By.id("submit"));

        if(element != null) {
            System.out.println("Element found by ID");
        }
    }

    @Test
    public void FindElementByNameTest() {
        driver.get(FormURL);

        WebElement element = driver.findElement (By.name("gender"));
        if(element != null) {
            System.out.println("Element found by Name");
        }
    }

    @Test
    public void FindElementByClassNameTest() {
        driver.get(FormURL);

        WebElement parentElement = driver.findElement (By.className("button"));

        if(parentElement != null) {
            System.out.println("Element found by ClassName");
        }
    }

    @Test
    public void FindElementByTagNameTest() {
        driver.get(FormURL);

        WebElement element = driver.findElement (By.tagName("input"));
        if(element != null) {
            System.out.println("Element found by tagName");
        }
    }

    @Test
    public void FindElementByCssSelectorTest() {
        driver.get(FormURL);

        WebElement element = driver.findElement (By.cssSelector("input[placeholder = 'First Name']"));
        if(element != null) {
            System.out.println("Element found by cssSelector");
        }
    }

    @Test
    public void FindElementByXpathTest() {
        driver.get(FormURL);

        WebElement buttonSubmit = driver.findElement( By.xpath("//button[@id = 'submit']"));
        if(buttonSubmit != null) {
            System.out.println("Element found by xpath");
        }
    }

    @Test
    public void FindElementByLinkTextAndPartialLinkTextTest() {
        driver.get(LinksURL);

        WebElement element = driver.findElement (By.linkText("Home"));

        if(element != null) {
            System.out.println("Element found by LinkText");
        }

        element= driver.findElement (By.partialLinkText("Home"));

        if(element!= null) {
            System.out.println("Element found by PartialLinkText");
        }
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
