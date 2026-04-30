package execution.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Strategy: remote execution — connects to a Selenium Grid node.
 *
 * Works with Selenium Grid 4 (standalone, hub/node, or fully distributed).
 * The node decides where to run the session; we only specify capabilities.
 *
 * Typical grid URLs:
 *   http://localhost:4444          (local standalone grid)
 *   http://grid-host:4444          (hub)
 *   http://selenoid:4444/wd/hub    (Selenoid)
 */
public class RemoteStrategy implements DriverCreationStrategy {

    @Override
    public WebDriver createDriver(DriverConfig config) {
        AbstractDriverOptions<?> capabilities = buildCapabilities(config);
        URL gridUrl = parseGridUrl(config.getGridUrl());
        return new RemoteWebDriver(gridUrl, capabilities);
    }

    private AbstractDriverOptions<?> buildCapabilities(DriverConfig config) {
        return switch (config.getBrowser()) {
            case CHROME -> {
                ChromeOptions opts = new ChromeOptions();
                if (config.isHeadless()) {
                    opts.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
                }
                yield opts;
            }
            case FIREFOX -> {
                FirefoxOptions opts = new FirefoxOptions();
                if (config.isHeadless()) {
                    opts.addArguments("-headless");
                }
                yield opts;
            }
            case EDGE -> {
                EdgeOptions opts = new EdgeOptions();
                if (config.isHeadless()) {
                    opts.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
                }
                yield opts;
            }
        };
    }

    private URL parseGridUrl(String rawUrl) {
        try {
            return new URL(rawUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid grid URL: " + rawUrl, e);
        }
    }
}
