package execution.core;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

/**
 * Singleton (per-thread) — holds the WebDriver for the current thread.
 *
 * Using ThreadLocal means each parallel worker gets its own driver instance
 * without any synchronisation overhead.  The class itself is never
 * instantiated; everything goes through static methods.
 *
 * Lifecycle:
 *   DriverManager.init(config)  — called once per test class (@BeforeAll)
 *   DriverManager.get()         — returns the driver for the current thread
 *   DriverManager.quit()        — called once per test class (@AfterAll)
 */
public final class DriverManager {

    /** Private so no one ever creates an instance. */
    private DriverManager() {}

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    // Default implicit wait applied to every newly-created driver
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);

    /**
     * Creates a driver according to {@code config} and stores it for the
     * current thread.  Throws if a driver is already running (guards against
     * accidental double-initialisation in the same thread).
     */
    public static void init(DriverConfig config) {
        if (DRIVER.get() != null) {
            throw new IllegalStateException(
                    "Driver already initialised for this thread. " +
                    "Call DriverManager.quit() before re-initialising.");
        }

        WebDriverFactory factory = WebDriverFactory.forConfig(config);
        WebDriver driver         = factory.createDriver(config);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);

        DRIVER.set(driver);
        System.out.printf("[DriverManager] Started: %s%n", config);
    }

    /**
     * Returns the WebDriver for the current thread.
     * Throws if {@link #init} has not been called.
     */
    public static WebDriver get() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException(
                    "No driver found for this thread. " +
                    "Ensure DriverManager.init() is called in @BeforeAll.");
        }
        return driver;
    }

    /**
     * Quits the driver and removes the ThreadLocal entry to prevent memory
     * leaks across test suite runs.
     */
    public static void quit() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DRIVER.remove();
                System.out.println("[DriverManager] Driver quit and removed.");
            }
        }
    }
}
