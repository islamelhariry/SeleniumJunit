package qa.tools;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // key annotation
@Tag("regression")
public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public void initDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
