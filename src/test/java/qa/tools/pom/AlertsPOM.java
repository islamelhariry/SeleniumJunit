package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPOM {
    public static final String ALERTS_URL = "https://demoqa.com/alerts";

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "promtButton")
    public WebElement promtButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;
}
