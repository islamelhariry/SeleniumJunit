package test.selenium;

import org.htmlunit.BrowserVersion;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowserTests {

    @Test
    public void HeadlessBrowserTest(){

        HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
        // open demo site webpage
        unitDriver.get("https://demoqa.com/");

        //Print the title of the page
        System.out.println("Title of the page is -> " + unitDriver.getTitle());
    }

    @Test
    public void HeadlessChromeBrowserTest(){
        //create object of chrome options
        ChromeOptions options = new ChromeOptions();

        //add the headless argument
        options.addArguments("headless");

        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new ChromeDriver(options);

        //Navigate to toolsQA site url
        driver.get("https://demoqa.com/");

        //Print the Title of the Page
        System.out.println("Title of the page is -> " + driver.getTitle());

        //Close the driver
        driver.quit();
    }

    @Test
    public void HeadlessFirefoxBrowserTest(){
        //Set Firefox Headless mode as TRUE
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("headless"); //TODO: Need to be fixed

        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new FirefoxDriver(options);

        //Navigate to toolsQA site url
        driver.get("https://demoqa.com/");

        //Print the Title of the Page
        System.out.println("Title of the page is -> " + driver.getTitle());

        //Close the driver
        driver.quit();
    }

    @Test
    public void HeadlessEdgeBrowserTest(){
        //Set Firefox Headless mode as TRUE
        EdgeOptions options =new EdgeOptions();
        options.addArguments("headless");

        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new EdgeDriver(options);

        //Navigate to toolsQA site url
        driver.get("https://demoqa.com/");

        //Print the Title of the Page
        System.out.println("Title of the page is -> " + driver.getTitle());

        //Close the driver
        driver.quit();
    }
}
