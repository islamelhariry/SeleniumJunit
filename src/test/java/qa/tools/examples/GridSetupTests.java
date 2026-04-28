package qa.tools.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridSetupTests {
    private WebDriver driver;

    private static final String URL  = "https://demoqa.com";
    private static final String NODE = "http://localhost:4444";   // Selenium 4: no /wd/hub

    @BeforeEach
    void setUp() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();          // replaces DesiredCapabilities
        driver = new RemoteWebDriver(new URL(NODE), options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    void GridSetupTest() {
        driver.navigate().to(URL);

        String title = driver.getTitle();
        Assertions.assertNotNull(title, "Page title should not be null");
        Assertions.assertFalse(title.isEmpty(), "Page title should not be empty");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
