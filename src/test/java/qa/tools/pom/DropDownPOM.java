package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DropDownPOM {
    public static final String SELECT_URL = "https://demoqa.com/select-menu";

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy(id = "cars")
    @CacheLookup
    public WebElement cars;

}
