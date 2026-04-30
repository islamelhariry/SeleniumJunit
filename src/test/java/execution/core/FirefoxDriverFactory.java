package execution.core;

import org.openqa.selenium.WebDriver;

/**
 * Concrete factory for Firefox.
 */
public class FirefoxDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createDriver(DriverConfig config) {
        return resolveStrategy(config).createDriver(config);
    }
}
