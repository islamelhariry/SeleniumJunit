package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CashedFormPOM {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "firstName")
    @CacheLookup
    public WebElement firstNameCached;

}
