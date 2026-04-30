package qa.tools.regression;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.BrowserWindowsPOM;

import static qa.tools.pom.BrowserWindowsPOM.BROWSER_WINDOWS_URL;
import static qa.tools.pom.LogInPOM.LOG_IN_URL;
@Tag("regression")
public class LocatorsTests extends BaseTest {
    private BrowserWindowsPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, BrowserWindowsPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(BROWSER_WINDOWS_URL);
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
        pageObject.windowButton.click();
    }

    private void GetAndPrintPageSource() {
        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource != null ? pageSource.length() : 0;
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);
    }

    private void OpenLogInPage() {
        driver.get(LOG_IN_URL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    private void OpenWindowsPage() {
        driver.get(BROWSER_WINDOWS_URL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    private void AssertCurrentURL() {
        var currentURL = driver.getCurrentUrl();
        System.out.println("The current URL is : " +currentURL);
        Assertions.assertEquals(LOG_IN_URL, currentURL);
    }
}
