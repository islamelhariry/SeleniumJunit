package execution.core;

import org.openqa.selenium.WebDriver;

/**
 * Concrete factory for Microsoft Edge.
 */
public class EdgeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createDriver(DriverConfig config) {
        return resolveStrategy(config).createDriver(config);
    }
}
