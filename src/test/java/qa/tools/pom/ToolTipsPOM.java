package qa.tools.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPOM {
    public static final String TOOL_TIPS_URL = "https://demoqa.com/tool-tips/";

    @FindBy(id = "toolTipButton")
    public WebElement toolTipButton;

    public static final By TOOLTIP_INNER = By.cssSelector(".tooltip-inner");
}
