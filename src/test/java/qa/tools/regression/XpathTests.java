package qa.tools.regression;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import qa.tools.BaseTest;
import qa.tools.pom.XpathPOM;

import java.util.List;

public class XpathTests extends BaseTest {

    @Test
    public void EveryXpathTest() {
        driver.get(XpathPOM.TEXT_BOX_URL);
        XpathPOM pom = new XpathPOM(driver);

        // Single slash "/" to validate image at start of page
        boolean imgFlag = pom.headerImageAbsolute.isDisplayed();
        System.out.println("The image is displayed : " + imgFlag);

        // Double slash "//" to validate image
        boolean img_Flag = pom.headerImageRelative.isDisplayed();
        System.out.println("The image is displayed (located by //) : " + img_Flag);

        // Address sign "@" - full name textbox
        pom.fullNameInput.sendKeys("Full Name");

        // Double dot ".." - Full name label
        String label = driver.findElement(XpathPOM.FULL_NAME_LABEL).getText();
        System.out.println("The label of full text is : " + label);

        // Asterisk "*" - Full Name textbox
        pom.fullNameByAsterisk.sendKeys("Full Name");

        // Address and Asterisk "@*" - full name textbox
        pom.fullNameByAtAsterisk.sendKeys("Full Name");

        // Pipe "|" - locate both Full Name and Email labels
        List<WebElement> lst = driver.findElements(XpathPOM.USERNAME_AND_EMAIL_LABELS);
        for (WebElement e : lst) {
            System.out.println("The label is : " + e.getText());
        }

        // Web Tables page
        driver.get(XpathPOM.WEB_TABLES_URL);
        boolean lstCol = driver.findElement(XpathPOM.LAST_TABLE_COLUMN).isDisplayed();
        System.out.println("The last table element is displayed : " + lstCol);

        boolean positionCol = driver.findElement(XpathPOM.SECOND_TABLE_COLUMN).isDisplayed();
        System.out.println("The 2nd table element is displayed : " + positionCol);
    }

    @Test
    public void AbsoluteXpathTest() {
        driver.get(XpathPOM.DEMOQA_URL);
        XpathPOM pom = new XpathPOM(driver);

        System.out.println("The image is displayed : " + pom.headerImageAbsolute.isDisplayed());
    }

    @Test
    public void RelativeXpathTest() {
        driver.get(XpathPOM.DEMOQA_URL);
        XpathPOM pom = new XpathPOM(driver);

        System.out.println("The image is displayed : " + pom.headerImageBySrc.isDisplayed());
    }

    @Test
    public void XpathAxesTest() {
        driver.get(XpathPOM.TEXT_BOX_URL);
        XpathPOM pom = new XpathPOM(driver);

        pom.fullNameInput.sendKeys("User Name");
        pom.emailByPlaceholder.sendKeys("Using Placeholder");
        pom.fullNameByStartsWith.sendKeys("Using start with");

        System.out.println(pom.emailLabel.getText());

        pom.fullNameByAnd.sendKeys("AND operator");
        pom.fullNameByOr.sendKeys("OR operator");

        System.out.println("Form is displayed : " + pom.formByAncestor.isDisplayed());
        System.out.println("The label text is : " + pom.firstFormLabel.getText());

        // Radio button page — dynamic elements use static By locators
        driver.get(XpathPOM.RADIO_BUTTON_URL);
        driver.findElement(XpathPOM.FIRST_RADIO_LABEL).click();
        boolean bo = driver.findElement(XpathPOM.YES_RADIO_PARENT).isSelected();
        System.out.println("The Yes radio is selected : " + bo);

        // Back to text-box for following/preceding axes
        driver.get(XpathPOM.TEXT_BOX_URL);
        pom = new XpathPOM(driver); // reinitialise after navigation

        pom.currentAddressTextArea.sendKeys("Text Area locate following");
        pom.emailByFollowingSibling.sendKeys("abc@xyz.com");

        System.out.println("The value of preceding : " + pom.precedingLabel.getText());
    }
}