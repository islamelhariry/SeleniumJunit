package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.FramesPOM;
import qa.tools.pom.NestedFramesPOM;

import java.util.List;
import java.util.Objects;

import static qa.tools.pom.FramesPOM.FRAMES_URL;
import static qa.tools.pom.NestedFramesPOM.NESTED_FRAMES_URL;
@Tag("regression")
public class FrameTests extends BaseTest {
    private FramesPOM pageObject;
    private NestedFramesPOM nestedFramesPOM;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, FramesPOM.class);
        nestedFramesPOM = PageFactory.initElements(driver, NestedFramesPOM.class);
    }

    @Test
    public void frameTests() {
        driver.get(FRAMES_URL);
        //By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        int numberOfFrames = Integer.parseInt(Objects.requireNonNull(exe.executeScript("return window.length")).toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //By finding all the web elements using iframe tag
        List<WebElement> iframeElements = pageObject.iframe;
        System.out.println("The total number of iframes are " + iframeElements.size());
    }

    @Test
    public void switchFrameByIndexTests() {
        driver.get(FRAMES_URL);
        //Switch by Index
        driver.switchTo().frame(0);
        WebElement text = pageObject.body;
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchFrameByIdTests() {
        driver.get(FRAMES_URL);
        //Switch by frame name
        driver.switchTo().frame("frame2");
        WebElement text = pageObject.body;
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchFrameByWebElementTests() {
        driver.get(FRAMES_URL);
        //First find the element using any of locator strategy
        WebElement iframeElement = pageObject.frame1;

        //now use the switch command
        driver.switchTo().frame(iframeElement);
        WebElement text = pageObject.body;
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchBackToPageTests() {
        driver.get(FRAMES_URL);

        //now use the switch command
        driver.switchTo().frame(1);
        WebElement text = pageObject.body;
        System.out.println("Content of frame is: " + text.getText());

        //Do all the required tasks in the frame 0
        //Switch back to the main window
        driver.switchTo().defaultContent();
    }

    @Test
    public void nestedFrameTests() {
        driver.get(NESTED_FRAMES_URL);
        //Number of Frames on a Page
        int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        //Number of Frames on a Frame1
        int countIframesInParent =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the parent frame:" + countIframesInParent);

        //switch to child frame
        driver.switchTo().frame(0);

        int countIframesInChild =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the child frame:" + countIframesInChild);
    }

    @Test
    public void switchToParentFrameTests() {
        driver.get(NESTED_FRAMES_URL);
        //Number of Frames on a Page
        int countIframesInPage =nestedFramesPOM.iframe.size();
        System.out.println("Number of Frames on a Page:"+countIframesInPage);

        //Locate the frame1 on the webPage
        WebElement frame1=nestedFramesPOM.frame1;

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Number of Frames on a Frame1
        int countIframesInFrame1 =nestedFramesPOM.iframe.size();
        System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);

        //Swiitch to child frame
        driver.switchTo().frame(0);
        int countIframesInFrame2 =nestedFramesPOM.iframe.size();
        System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);

        //Switch to Parent iFrame
        driver.switchTo().parentFrame();

        //Locate the Element inside the Frame1
        WebElement frame1Element= nestedFramesPOM.body;

        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();

        //Try to Print the text present inside parent frame
        System.out.println("Frame1 is :"+frame1Text);
    }

    @Test
    public void switchToMainPageTests() {
        driver.get(NESTED_FRAMES_URL);

        WebElement pageHeadingElement= nestedFramesPOM.pageHeadingElement;
        String pageHeading=pageHeadingElement.getText();
        System.out.println("Page Heading is :"+pageHeading);

        //Switch to Parent frame
        WebElement frame1=nestedFramesPOM.frame1;
        driver.switchTo().frame(frame1);
        WebElement frame1Element= nestedFramesPOM.body;
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        //Switch to child frame
        driver.switchTo().frame(0);
        WebElement frame2Element= nestedFramesPOM.frame2Element;
        String frame2Text=frame2Element.getText();
        System.out.println("Frame2 is :"+frame2Text);

        //Switch to default content
        driver.switchTo().defaultContent();

        //Try to print the heading of the main page without swithcing
        WebElement mainPageText=nestedFramesPOM.mainPageText;
        System.out.println(mainPageText.getText());
    }
}
