package test.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LocatorsTests extends BaseTest{

    public static final String LogInURL = "https://demoqa.com/login";
    public static final String BrowsersURL = "https://demoqa.com/browser-windows/";

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
        int pageSourceLength = pageSource != null ? pageSource.length() : 0;
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
}
