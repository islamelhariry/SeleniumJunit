package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPOM {
    public static final String BROWSER_WINDOWS_URL = "https://demoqa.com/browser-windows/";

    @FindBy(id = "windowButton")
    public WebElement windowButton;

    @FindBy(id = "sampleHeading")
    public WebElement sampleHeading;

    @FindBy(id = "messageWindowButton")
    public WebElement messageWindowButton;
}
