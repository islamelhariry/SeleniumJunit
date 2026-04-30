package execution.core;

import org.openqa.selenium.WebDriver;


/**
 * Abstract Factory — declares the contract for creating WebDriver instances.
 *
 * Each concrete factory knows about one browser family (Chrome, Firefox, Edge).
 * The strategy is chosen at runtime from the DriverConfig, so local vs. remote
 * is orthogonal to the browser choice.
 *
 * Usage:
 *   DriverConfig cfg   = DriverConfig.fromSystemProperties();
 *   WebDriverFactory f = WebDriverFactory.forConfig(cfg);   // picks subclass
 *   WebDriver driver   = f.createDriver(cfg);
 */
public abstract class WebDriverFactory {

    /**
     * The single entry point — reads DriverConfig.browser and returns the
     * matching concrete factory.  Add new browsers here without touching
     * any test code.
     */
    public static WebDriverFactory forConfig(DriverConfig config) {
        return switch (config.getBrowser()) {
            case CHROME  -> new ChromeDriverFactory();
            case FIREFOX -> new FirefoxDriverFactory();
            case EDGE    -> new EdgeDriverFactory();
        };
    }

    /**
     * Builds the WebDriver.  Each subclass picks the right Options type,
     * then delegates execution environment to the Strategy.
     */
    public abstract WebDriver createDriver(DriverConfig config);

    /** Selects local vs. remote strategy from the config. */
    protected DriverCreationStrategy resolveStrategy(DriverConfig config) {
        return config.isRemote() ? new RemoteStrategy() : new LocalStrategy();
    }
}
