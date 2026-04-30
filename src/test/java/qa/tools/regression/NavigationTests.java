package qa.tools.regression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.tools.BaseTest;
import qa.tools.pom.MainPOM;

import java.time.Duration;

import static qa.tools.pom.MainPOM.MAIN_PAGE_URL;
import static qa.tools.pom.TrainingPOM.TRAINING_URL;
@Tag("regression")
public class NavigationTests extends BaseTest {

    private MainPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, MainPOM.class);
    }

    @Test
    public void CurrentURLTest() {
        OpenHomePage();
        AssertHomeURL();
        String parent = driver.getWindowHandle();

        pageObject.registrationBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // wait for the new tab
        wait.until(d -> d.getWindowHandles().size() == 2);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
            }
        }
        wait.until(ExpectedConditions.urlContains("toolsqa"));

        AssertTrainingURL();
    }

    @Test
    public void NavigateToTest() {
        OpenHomePage();
        AssertHomeURL();

        driver.navigate().to(TRAINING_URL);
        AssertTrainingURL();

        driver.navigate().back();
        AssertHomeURL();

        driver.navigate().forward();
        AssertTrainingURL();

        driver.navigate().refresh();
        AssertTrainingURL();
    }

    private void AssertHomeURL() {
        var currentURL = driver.getCurrentUrl();
        System.out.println("The current URL is : " +currentURL);
        Assertions.assertEquals(MAIN_PAGE_URL, currentURL);
    }

    private void AssertTrainingURL() {
        var currentURL = driver.getCurrentUrl();
        System.out.println("The current URL is : " +currentURL);
        Assertions.assertEquals(TRAINING_URL, currentURL);
    }

    private void OpenHomePage() {
        driver.get(MAIN_PAGE_URL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }
}
