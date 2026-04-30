package qa.tools;

import execution.core.DriverConfig;
import execution.core.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // key annotation
@Tag("regression")
public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    void setupClass() {
        DriverConfig config = DriverConfig.fromSystemProperties();
        DriverManager.init(config);
    }

    @BeforeEach
    void setupTest() {
        driver = DriverManager.get();
    }

    @AfterAll
    public void tearDown() {
        DriverManager.quit();
    }
}
