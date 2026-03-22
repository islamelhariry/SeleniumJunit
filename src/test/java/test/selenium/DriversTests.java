package test.selenium;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriversTests {
    public static final String LogInURL = "https://demoqa.com/login";
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "Password@123";
    WebDriver driver;

    @Test
    public void FireFoxDriverTest() {
        driver = new FirefoxDriver();
        OpenLogInPage();
        LogIn();
        LogOut();
    }

    @Test
    public void ChromeDriverTest() {
        driver = new ChromeDriver();
        OpenLogInPage();
        LogIn();
        LogOut();
    }

    @Test
    public void EdgeDriverTest() {
        driver = new EdgeDriver();
        OpenLogInPage();
        LogIn();
        LogOut();
    }

    private void OpenLogInPage() {
        driver.get(LogInURL);
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    private void LogIn() {
        WebElement uName = driver.findElement(By.id("userName"));
        WebElement pswd = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login"));

        uName.sendKeys(USERNAME);
        pswd.sendKeys(PASSWORD);
        loginBtn.click();
    }

    private void LogOut() {
        try {

            WebElement logoutBtn = driver
                    .findElement(By.className("text-right col-md-5 col-sm-12"))
                    .findElement(By.id("'submit'"));

            if(logoutBtn.isDisplayed()){
                logoutBtn.click();
                System.out.println("LogOut Successful!");
            }
        }
        catch (Exception e) {
            System.out.println("Incorrect login....");
        }
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}

