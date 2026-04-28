package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPOM {
    public static final String DYNAMIC_PROPERTIES_URL = "https://demoqa.com/dynamic-properties";

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfter;

    @FindBy(id = "colorChange")
    public WebElement colorChange;
}
