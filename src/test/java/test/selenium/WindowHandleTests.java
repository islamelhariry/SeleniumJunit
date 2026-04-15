package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class WindowHandleTests extends BaseTest{
    @Test
    public void windowHandleTest(){
        driver.get("https://demoqa.com/browser-windows");

        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        for (String ChildWindow : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }
    }

    @Test
    public void multipleChildWindows(){
        driver.get("https://demoqa.com/browser-windows");

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

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
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
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
        driver.get("https://demoqa.com/browser-windows");

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

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
