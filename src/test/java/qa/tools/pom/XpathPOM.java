package qa.tools.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class XpathPOM {
    // URLs
    public static final String TEXT_BOX_URL = "https://demoqa.com/text-box";
    public static final String DEMOQA_URL = "https://demoqa.com";
    public static final String WEB_TABLES_URL = "https://demoqa.com/webtables";
    public static final String RADIO_BUTTON_URL = "https://demoqa.com/radio-button";

    // ── Elements present on page load (safe for @FindBy) ──────────────────────

    // Text Box page
    @FindBy(xpath = "//input[contains(@id, 'userN')]")
    public WebElement fullNameInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'example')]")
    public WebElement emailByPlaceholder;

    @FindBy(xpath = "//input[starts-with(@placeholder,'Fu')]")
    public WebElement fullNameByStartsWith;

    @FindBy(xpath = "//label[text()='Email']")
    public WebElement emailLabel;

    @FindBy(xpath = "//input[@placeholder ='Full Name' and @type = 'text']")
    public WebElement fullNameByAnd;

    @FindBy(xpath = "//input[@placeholder ='Full Name' or @type = 'text']")
    public WebElement fullNameByOr;

    @FindBy(xpath = "//label[text()='Full Name']/ancestor::form")
    public WebElement formByAncestor;

    @FindBy(xpath = "//form[@id='userForm']/child::div[1]//label")
    public WebElement firstFormLabel;

    @FindBy(xpath = "//input[@id='userName']/following::textarea")
    public WebElement currentAddressTextArea;

    @FindBy(xpath = "(//div[@class='col-md-3 col-sm-12']/following-sibling::div/input)[2]")
    public WebElement emailByFollowingSibling;

    @FindBy(xpath = "//input[@id='userName']/preceding::label")
    public WebElement precedingLabel;

    // Header image (demoqa home & text-box page)
    @FindBy(xpath = "/html/body/div/header/a/img")
    public WebElement headerImageAbsolute;

    @FindBy(xpath = "//img")
    public WebElement headerImageRelative;

    @FindBy(xpath = "//img[@src='/assets/Toolsqa-DZdwt2ul.jpg']")
    public WebElement headerImageBySrc;

    @FindBy(xpath = "//div[contains(@id, 'userName-wrapper')]/div[2]/*")
    public WebElement fullNameByAsterisk;

    @FindBy(xpath = "//input[@*= 'userName']")
    public WebElement fullNameByAtAsterisk;

    // ── Locators for elements that require explicit waits ──────────────────────

    // Web Tables page
    public static final By LAST_TABLE_COLUMN =
            By.xpath("//table[.//th[text()='First Name']]//tbody/tr[1]/td[last()]");
    public static final By SECOND_TABLE_COLUMN =
            By.xpath("//table[.//th[text()='First Name']]//tbody/tr[1]/td[2]");

    // Labels located via pipe (multi-element)
    public static final By USERNAME_AND_EMAIL_LABELS =
            By.xpath("//label[@*= 'userName-label']|//label[@*= 'userEmail-label']");

    // Double-dot parent traversal label
    public static final By FULL_NAME_LABEL =
            By.xpath("//input[contains(@id, 'userN')]/../../div/label");

    // Radio button page
    public static final By FIRST_RADIO_LABEL =
            By.xpath("//div[@class='row']/descendant::input/following-sibling::label");
    public static final By YES_RADIO_PARENT =
            By.xpath("//input[@id='yesRadio']/parent::div");


    public XpathPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}