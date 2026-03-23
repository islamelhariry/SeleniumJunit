package dev.selenium.interactions;

import dev.selenium.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

public class PrintsPageTest extends BaseTest{

    @BeforeEach
    public void setup() {
        ChromeOptions options = getDefaultChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver(options);
    }

    @Test
    public void PrintWithPrintsPageTest() 
    {
        driver.get("https://www.selenium.dev/");
        PrintsPage printer = (PrintsPage) driver;
        PrintOptions printOptions = new PrintOptions();
        Pdf printedPage = printer.print(printOptions);
        Assertions.assertNotNull(printedPage);
    }

    @Test
    public void PrintWithBrowsingContextTest() 
    {
        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
        PrintOptions printOptions = new PrintOptions();
        String printPage = browsingContext.print(printOptions);
        Assertions.assertTrue(printPage.length() > 0);
    }
}
