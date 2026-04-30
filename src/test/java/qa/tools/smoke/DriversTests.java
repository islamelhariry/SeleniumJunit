package qa.tools.smoke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import qa.tools.pom.LogInPOM;

import static qa.tools.pom.LogInPOM.*;

public class DriversTests {
    private WebDriver driver;
    private LogInPOM pageObject;

    private void initDriver(WebDriver webDriver) {
        this.driver = webDriver;
        this.pageObject = PageFactory.initElements(driver, LogInPOM.class);
    }

    @Test
    public void firefoxDriverTest() {
        initDriver(new FirefoxDriver());
        openLogInPage();
        logIn();
        logOut();
    }

    @Test
    public void chromeDriverTest() {
        initDriver(new ChromeDriver());
        openLogInPage();
        logIn();
        logOut();
    }

    @Test
    public void edgeDriverTest() {
        initDriver(new EdgeDriver());
        openLogInPage();
        logIn();
        logOut();
    }

    private void openLogInPage() {
        driver.get(LOG_IN_URL);
        driver.manage().window().maximize();
        System.out.println("Page title: " + driver.getTitle());
    }

    private void logIn() {
        pageObject.userName.sendKeys(USERNAME);
        pageObject.password.sendKeys(PASSWORD);
        pageObject.login.click();
    }

    private void logOut() {
        try {
            if (pageObject.logoutBtn.isDisplayed()) {
                pageObject.logoutBtn.click();
                System.out.println("LogOut Successful!");
            }
        } catch (Exception e) {
            System.out.println("Incorrect login....");
        }
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();  // quit, not close
        }
    }
}