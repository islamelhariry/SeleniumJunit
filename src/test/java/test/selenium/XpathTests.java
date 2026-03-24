package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XpathTests extends BaseTest{

    public static final String TextBoxURL = "https://demoqa.com/text-box";

    @Test
    public void EveryXpathTest(){
        driver.get(TextBoxURL);

        // Single slash “/” to validate image at start of page
        boolean imgFlag = driver.findElement(By.xpath("/html/body/div/header/a/img")).isDisplayed();
        System.out.println("The image is displayed : " + imgFlag);

        // Double slash “//” to validate image
        boolean img_Flag = driver.findElement(By.xpath("//img")).isDisplayed();
        System.out.println("The image is displayed (located by //) : " + img_Flag);

        // Address sign “@” full name textbox
        driver.findElement(By.xpath("//input[contains(@id, 'userN')]")).sendKeys("Full Name");

        // Dot “.” - Full name texbox
        driver.findElement(By.xpath("//input[contains(@id, 'userN')]/.")).sendKeys("Full Name");

        // Double dot “..” - Full name label
        String label = driver.findElement(By.xpath("//input[contains(@id, 'userN')]/../../div/label")).getText();
        System.out.println("The label of full text is : " + label);

        // Asterisk “*” - Full Name textbox
        driver.findElement(By.xpath("//div[contains(@id, 'userName-wrapper')]/div[2]/*")).sendKeys("Full Name");

        // Address and Asterisk “@*” - full name text box
        driver.findElement(By.xpath("//input[@*= 'userName']")).sendKeys("Full Name");

        // Pipe “|” - to locate both full name and Email label
        List<WebElement> lst = driver.findElements(By.xpath("//label[@*= 'userName-label']|//label[@*= 'userEmail-label']"));

        // Iterating and printing both labels
        for (WebElement e : lst) {
            System.out.println(" The label is : " + e.getText());
        }

        /*
         * Opening web table page
         */

        driver.get("https://demoqa.com/webtables");

        // Get the last node - Last val in table
        boolean lstCol = driver.findElement(By.xpath("//table[.//th[text()='First Name']]//tbody/tr[1]/td[last()]")).isDisplayed();
        System.out.println("The last table element is displayed : " + lstCol);

        // Get the 2 node - validate 2 position in table
        boolean positionCol = driver.findElement(By.xpath("//table[.//th[text()='First Name']]//tbody/tr[1]/td[2]")).isDisplayed();
        System.out.println("The 2nd table element is displayed : " + positionCol);
    }

    @Test
    public void AbsoluteXpathTest(){
        driver.get("https://demoqa.com");

        //Locate the web element using absolute xpath
        WebElement headerImage = driver.findElement(By.xpath("/html/body/div/header/a/img"));

        // Validate that the header image is displayed on the web page
        System.out.println("The image is displayed : " + headerImage.isDisplayed());
    }

    @Test
    public void RelativeXpathTest(){
        driver.get("https://demoqa.com");

        //Locate the web element using absolute xpath
        WebElement headerImage = driver.findElement(By.xpath("//img[@src='/assets/Toolsqa-DZdwt2ul.jpg']"));

        // Validate that the header image is displayed on the web page
        System.out.println("The image is displayed : " + headerImage.isDisplayed());
    }
}
