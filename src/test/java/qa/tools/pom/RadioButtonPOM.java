package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPOM {
    public static final String RADIO_BUTTON_URL = "https://demoqa.com/radio-button";

    @FindBy(id = "yesRadio")
    public WebElement yesRadio;

    @FindBy(css = "input[id='noRadio']")
    public WebElement noRadio;

    @FindBy(xpath = "//div/input[@id='impressiveRadio']")
    public WebElement impressiveRadio;
}
