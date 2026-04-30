package execution.core;

import org.openqa.selenium.WebDriver;

/**
 * Strategy pattern — swappable algorithm for actually constructing the WebDriver.
 *
 * Each concrete strategy handles one execution environment:
 *   - LocalStrategy  → spins up a driver process on this machine
 *   - RemoteStrategy → connects to a Selenium Grid / remote node
 *
 * The factory picks the right strategy based on DriverConfig.isRemote().
 * You can add new strategies (Docker, cloud providers, etc.) without
 * touching any existing code.
 */
public interface DriverCreationStrategy {

    /**
     * @param config fully-built run configuration
     * @return a ready-to-use WebDriver instance
     */
    WebDriver createDriver(DriverConfig config);
}
