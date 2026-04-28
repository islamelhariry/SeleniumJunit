package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPOM {
    public static final String FRAMES_URL = "https://demoqa.com/frames";

    @FindBy(tagName = "iframe")
    public List<WebElement> iframe;

    @FindBy(tagName = "body")
    public WebElement body;

    @FindBy(id = "frame1")
    public WebElement frame1;
}
