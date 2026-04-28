package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPOM {
    public static final String MENU_URL = "https://demoqa.com/menu/";

    @FindBy(xpath = ".//a[contains(text(),'Main Item 2')]")
    public WebElement menu2;

    @FindBy(xpath = ".//a[contains(text(),'Sub Item')]")
    public WebElement subMenuOption;
}
