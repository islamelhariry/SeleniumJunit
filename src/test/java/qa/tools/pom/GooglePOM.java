package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePOM {
    public static final String GOOGLE_URL = "https://google.com";
    public static final String GOOGLE_COOKIE = "CAESEwgDEgk0OTI5NzM5MjgaAmVuIAEaBgiAo_CmBg";

    @FindBy(xpath = "//textarea[@class=\"gLFyf\"]")
    public WebElement searchBox;


}
