package qa.tools.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import qa.tools.pom.BrowserWindowsPOM;

import java.time.Duration;
import java.util.Set;

import static qa.tools.pom.BrowserWindowsPOM.BROWSER_WINDOWS_URL;

@Tag("smoke")
public class WindowHandleTests {
    private BrowserWindowsPOM pageObject;
    private WebDriver driver;

    private void initPageObject(WebDriver webDriver) {
        this.driver = webDriver;
        this.pageObject = PageFactory.initElements(driver, BrowserWindowsPOM.class);
    }

    @BeforeEach
    public void initDriver() {
        initPageObject(new FirefoxDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BROWSER_WINDOWS_URL);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void windowHandleTest(){

        // Open new child window within the main window
        pageObject.windowButton.click();

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        for (String ChildWindow : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = pageObject.sampleHeading;
                System.out.println("Heading of child window is " + text.getText());
            }
        }
    }

    @Test
    public void multipleChildWindows(){
        // Opening all the child window
        pageObject.windowButton.click();
        pageObject.messageWindowButton.click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        for (String ChildWindow : s1) {
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }
    }

    @Test
    public void switchbackParentWindow() {
        pageObject.windowButton.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();

        for (String ChildWindow : s1) {
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void multipleChildWindowsAndParentSwitchback() {
        // Opening all the child window
        pageObject.windowButton.click();
        pageObject.messageWindowButton.click();

        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();

        for (String ChildWindow : s1) {
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.tagName("body"));
                System.out.println("Title of child window is: " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }

        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainWindow);
    }


}
