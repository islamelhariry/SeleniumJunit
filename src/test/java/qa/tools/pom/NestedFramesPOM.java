package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPOM {
    public static final String NESTED_FRAMES_URL = "https://demoqa.com/nestedframes";

    @FindBy(tagName = "iframe")
    public List<WebElement> iframe;

    @FindBy(tagName = "body")
    public WebElement body;

    @FindBy(id = "frame1")
    public WebElement frame1;

    @FindBy(xpath = "//h1[@class='text-center']")
    public WebElement pageHeadingElement;

     @FindBy(xpath = "//*[@id='framesWrapper']/div[1]")
    public WebElement mainPageText;

    @FindBy(tagName = "p")
    public WebElement frame2Element;
}
