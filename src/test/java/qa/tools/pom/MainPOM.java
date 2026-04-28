package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPOM {
    public static final String MAIN_PAGE_URL = "https://demoqa.com/";

    @FindBy(className = "banner-image")
    public WebElement registrationBtn;
}

