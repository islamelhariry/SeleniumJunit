package test.selenium.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormPageObject {
    @FindBy(how = How.ID, using = "firstName")
    public WebElement firsName;

    @FindBy(how = How.ID, using = "lastName")
    public WebElement lastName;
}
