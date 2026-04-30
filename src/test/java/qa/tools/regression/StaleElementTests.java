package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.GooglePOM;

import static qa.tools.pom.GooglePOM.GOOGLE_COOKIE;
import static qa.tools.pom.GooglePOM.GOOGLE_URL;
@Tag("regression")
public class StaleElementTests extends BaseTest {

    private GooglePOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, GooglePOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(GOOGLE_URL);
    }

    @Test
    public void StaleElementTest(){
        // Inject the consent cookie so the popup never appears
        InjectGoogleCookieAndRefresh();
        //Locate the search text box
        //Refresh the web page
        driver.navigate().refresh();
        //Pass string using sendkeys to the web element
        pageObject.searchBox.sendKeys("Testing String");
    }

    @Test
    public void AvoidStaleElementTest(){
        InjectGoogleCookieAndRefresh();
        //Locate the search text box
        //Refresh the web page
        driver.navigate().refresh();

        try {
            //Pass string using sendkeys to the web element
            pageObject.searchBox.sendKeys("Testing String");
        }
        catch(StaleElementReferenceException e) {
            pageObject.searchBox.sendKeys("Testing String from catch block");
            //Fetching the string entered in the search text box
            String str = pageObject.searchBox.getAttribute("value");
            System.out.println("The string entered from catch block is - " +str);
        }
    }

    private void InjectGoogleCookieAndRefresh() {
        // Inject the consent cookie so the popup never appears
        driver.manage().addCookie(new Cookie.Builder("SOCS", GOOGLE_COOKIE)
                .domain(".google.com")
                .path("/")
                .build());

        driver.navigate().refresh(); // Reload with the cookie applied
    }
}
