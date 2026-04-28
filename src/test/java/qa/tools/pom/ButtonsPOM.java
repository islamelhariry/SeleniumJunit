package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPOM {
    public static final String BUTTONS_URL = "https://demoqa.com/buttons";

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(xpath = "//*[@id=\"rightClickMessage\"]")
    public WebElement rightClickMessage;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(xpath = "//*[@id=\"doubleClickMessage\"]")
    public WebElement doubleClickMessage;

}
