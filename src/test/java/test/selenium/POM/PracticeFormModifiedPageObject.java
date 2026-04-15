package test.selenium.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormModifiedPageObject {

    @FindBy(how = How.ID, using = "firstName")
    public WebElement firstName;

    @FindBy(how = How.ID, using = "firstName")
    @CacheLookup
    public WebElement firstNameCached;

}
