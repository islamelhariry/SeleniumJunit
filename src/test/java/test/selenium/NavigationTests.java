package test.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationTests {
    public static final String HomeURL = "https://demoqa.com/";
    public static final String TrainingURL = "https://www.toolsqa.com/selenium-training/";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CurrentURLTest() {
        OpenHomePage();
        AssertHomeURL();
        String parent = driver.getWindowHandle();

        var registrationBtn = driver.findElement(By.className("banner-image"));
        registrationBtn.click();

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

        driver.navigate().to(TrainingURL);
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
        Assertions.assertEquals(HomeURL, currentURL);
    }

    private void AssertTrainingURL() {
        var currentURL = driver.getCurrentUrl();
        System.out.println("The current URL is : " +currentURL);
        Assertions.assertEquals(TrainingURL, currentURL);
    }

    private void OpenHomePage() {
        driver.get(HomeURL);
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
