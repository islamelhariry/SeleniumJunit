package qa.tools.examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@Tag("smoke")
public class SSLHandlingTests {

    public static final String EXPIRED_BADSSL_COM = "https://expired.badssl.com/";
    public static final String SELF_SIGNED_BADSSL_COM = "https://self-signed.badssl.com/";

    @Test
    public void SSLWithoutHandlingOnChrome() {
        //Creating instance of Chrome driver (Assuming Chromedriver is installed at system level)
        WebDriver driver = new ChromeDriver();

        //Launching the URL
        driver.get(EXPIRED_BADSSL_COM);
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void SSLWithHandlingOnChrome() {
        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriver driver = new ChromeDriver(handlingSSL);

        //Launching the URL
        driver.get(EXPIRED_BADSSL_COM);
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void SSLWithoutHandlingOnFirefox() {
        WebDriver driver = new FirefoxDriver();

        driver.get(SELF_SIGNED_BADSSL_COM);
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void SSLWithHandlingOnFirefox() {
        //Creating an object of the FirefoxOptions Class
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        //Using the setAcceptInsecureCerts() method to pass parameter as False
        firefoxOptions.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get(SELF_SIGNED_BADSSL_COM);
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }

    @Test
    public void SSLWithHandlingOnEdge() {
        //Creating an object of EdgeOptions class
        EdgeOptions edgeOptions = new EdgeOptions();

        //Accepting the Insecure certificates through boolean parameter
        edgeOptions.setAcceptInsecureCerts(true);

        //Creating instance of Edge driver by passing reference of EdgeOptions object
        // Assuming EdgeDriver path has been set in system properties
        WebDriver driver = new EdgeDriver(edgeOptions);

        driver.get(SELF_SIGNED_BADSSL_COM);
        System.out.println("The page title is : " +driver.getTitle());
        driver.quit();
    }
}
