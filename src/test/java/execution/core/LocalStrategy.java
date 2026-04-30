package execution.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Strategy: local execution — the driver binary runs on this machine.
 * Selenium Manager (bundled since Selenium 4.6) auto-downloads the right
 * driver binary, so no WebDriverManager dependency is needed.
 */
public class LocalStrategy implements DriverCreationStrategy {

    @Override
    public WebDriver createDriver(DriverConfig config) {
        return switch (config.getBrowser()) {
            case CHROME  -> buildChrome(config);
            case FIREFOX -> buildFirefox(config);
            case EDGE    -> buildEdge(config);
        };
    }

    private WebDriver buildChrome(DriverConfig config) {
        ChromeOptions opts = new ChromeOptions();
        if (config.isHeadless()) {
            opts.addArguments("--headless=new");   // Chromium headless v2
            opts.addArguments("--disable-gpu");
            opts.addArguments("--window-size=1920,1080");
        }
        return new ChromeDriver(opts);
    }

    private WebDriver buildFirefox(DriverConfig config) {
        FirefoxOptions opts = new FirefoxOptions();
        if (config.isHeadless()) {
            opts.addArguments("-headless");
        }
        return new FirefoxDriver(opts);
    }

    private WebDriver buildEdge(DriverConfig config) {
        EdgeOptions opts = new EdgeOptions();
        if (config.isHeadless()) {
            opts.addArguments("--headless=new");
            opts.addArguments("--disable-gpu");
            opts.addArguments("--window-size=1920,1080");
        }
        return new EdgeDriver(opts);
    }
}
