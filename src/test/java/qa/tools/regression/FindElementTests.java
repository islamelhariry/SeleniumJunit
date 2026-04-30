package qa.tools.regression;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.tools.BaseTest;

import java.util.List;

public class FindElementTests extends BaseTest {
    public static final String TextBoxURL = "https://demoqa.com/text-box/";
    public static final String FormURL = "https://demoqa.com/automation-practice-form";
    public static final String LinksURL = "https://demoqa.com/links";

    @Test
    public void FindElementsTest() {
        driver.get(TextBoxURL);

        // Find elements using tag name
        List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

        if(!allInputElements.isEmpty())
        {
            System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

            for(WebElement inputElement : allInputElements)
            {
                System.out.println(inputElement.getAttribute("placeholder"));
            }
        }
    }

    @Test
    public void FindElementByIdTest() {
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

        WebElement parentElement = driver.findElement (By.className("btn-primary"));

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

    @Test
    public void FindElementTest() {
        driver.get(FormURL);

        // URL - https://demoqa.com/automation-practice-form

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName"));

        /*
           Locate by Name attribute
           URL - https://demoqa.com/automation-practice-form
         */

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.name("gender"));

        /*
           Locate by className attribute
           URL - https://demoqa.com/automation-practice-form
         */

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.className("practice-form-wrapper"));

        /*
           Locate by linkText and ParticalLinkText attribute
           URL - https://demoqa.com/links
         */

        driver.get("https://demoqa.com/links");
        //linkText
        driver.findElement(By.linkText("Home"));
        //partialLinkText
        driver.findElement(By.partialLinkText("Ho"));

        /*
           Locate by tagName attribute
           URL - https://demoqa.com/links
         */

        driver.get("https://demoqa.com/links");
        List <WebElement> list = driver.findElements(By.tagName("a"));


        /*
           Locate by cssSelector attribute
           URL - https://demoqa.com/text-box
         */

        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.cssSelector("input[id='userName']"));


        /*
           Locate by xpath attribute
           URL - https://demoqa.com/text-box
         */

        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//input[@id='userName']"));

    }
}
