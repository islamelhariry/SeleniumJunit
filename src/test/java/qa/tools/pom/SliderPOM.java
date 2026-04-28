package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPOM {
    public static final String SLIDER_URL = "https://demoqa.com/slider/";

    @FindBy(id = "slider")
    public WebElement slider;
}

