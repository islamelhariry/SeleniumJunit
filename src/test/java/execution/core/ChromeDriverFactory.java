package execution.core;

import org.openqa.selenium.WebDriver;

/**
 * Concrete factory for Chrome.
 * It simply validates the config targets Chrome, then delegates
 * to the appropriate Strategy (local or remote).
 */
public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createDriver(DriverConfig config) {
        return resolveStrategy(config).createDriver(config);
    }
}
