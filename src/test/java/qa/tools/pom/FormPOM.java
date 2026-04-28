package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPOM {
    public static final String FORM_URL = "https://demoqa.com/automation-practice-form";
    @FindBy(id = "firstName")
    public WebElement firsName;

    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(css = "label[for='hobbies-checkbox-1']")
    public WebElement checkBox;
}
