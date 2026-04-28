package qa.tools.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePOM {
    public static final String DROPPABLE_URL = "http://demoqa.com/droppable/";
    public static final String DRAGABLE_URL = "https://demoqa.com/dragabble";

    @FindBy(id = "draggable")
    public WebElement draggable;

    @FindBy(id = "droppable")
    public WebElement droppable;

    @FindBy(id = "dragBox")
    public WebElement dragBox;
}
