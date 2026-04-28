package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPOM {
    public static final String LOG_IN_URL = "https://demoqa.com/login";
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "Password@123";

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(css = ".text-right.col-md-5.col-sm-12")
    public WebElement logoutBtn;

    @FindBy(id = "submit")
    public WebElement submit;
}
