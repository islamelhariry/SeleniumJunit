package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class StaleElementTests extends BaseTest{
    @Test
    public void StaleElementTest(){
        driver.get("https://google.com");
        // Inject the consent cookie so the popup never appears
        InjectGoogleCookieAndRefresh();
        //Locate the search text box
        WebElement ele = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        //Refresh the web page
        driver.navigate().refresh();
        //Pass string using sendkeys to the web element
        ele.sendKeys("Testing String");
    }

    @Test
    public void AvoidStaleElementTest(){
        driver.get("https://google.com");
        InjectGoogleCookieAndRefresh();
        //Locate the search text box
        WebElement ele = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        //Refresh the web page
        driver.navigate().refresh();

        try {
            //Pass string using sendkeys to the web element
            ele.sendKeys("Testing String");
        }
        catch(StaleElementReferenceException e) {
            WebElement elem = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
            elem.sendKeys("Testing String from catch block");
            //Fetching the string entered in the search text box
            String str = elem.getAttribute("value");
            System.out.println("The string entered from catch block is - " +str);
        }
    }

    private void InjectGoogleCookieAndRefresh() {
        // Inject the consent cookie so the popup never appears
        driver.manage().addCookie(new Cookie.Builder("SOCS", "CAESEwgDEgk0OTI5NzM5MjgaAmVuIAEaBgiAo_CmBg")
                .domain(".google.com")
                .path("/")
                .build());

        driver.navigate().refresh(); // Reload with the cookie applied
    }
}
