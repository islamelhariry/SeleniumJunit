package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenLinksPOM {
    public static final String BROKEN_LINKS_URL = "https://demoqa.com/broken";
    public static final String LINKS_URL = "https://demoqa.com/links";

    @FindBy(tagName = "a")
    public List<WebElement> links;

    @FindBy(tagName = "img")
    public List<WebElement> images;
}