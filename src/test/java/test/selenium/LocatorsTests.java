package test.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsTests {

    public static final String LogInURL = "https://demoqa.com/login";
    public static final String BrowsersURL = "https://demoqa.com/browser-windows/";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CurrentURLTest() {
        OpenLogInPage();
        AssertCurrentURL();
    }

    @Test
    public void PageSourceTest() {
        OpenLogInPage();
        GetAndPrintPageSource();
    }

    @Test
    public void NewBrowserTest() {
        OpenWindowsPage();
        ClickNewWindowButton();
    }

    private void ClickNewWindowButton() {
        driver.findElement(By.id("windowButton")).click();
    }

    private void GetAndPrintPageSource() {
        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);
    }

    private void OpenLogInPage() {
        driver.get(LogInURL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    private void OpenWindowsPage() {
        driver.get(BrowsersURL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    private void AssertCurrentURL() {
        var currentURL = driver.getCurrentUrl();
        System.out.println("The current URL is : " +currentURL);
        Assertions.assertEquals(LogInURL, currentURL);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
