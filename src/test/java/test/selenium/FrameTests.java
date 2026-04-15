package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class FrameTests extends BaseTest {
    @Test
    public void frameTests() {
        driver.get("https://demoqa.com/frames");
        //By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        int numberOfFrames = Integer.parseInt(Objects.requireNonNull(exe.executeScript("return window.length")).toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        //By finding all the web elements using iframe tag
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
    }

    @Test
    public void switchFrameByIndexTests() {
        driver.get("https://demoqa.com/frames");
        //Switch by Index
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchFrameByIdTests() {
        driver.get("https://demoqa.com/frames");
        //Switch by frame name
        driver.switchTo().frame("frame2");
        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchFrameByWebElementTests() {
        driver.get("https://demoqa.com/frames");
        //First find the element using any of locator strategy
        WebElement iframeElement = driver.findElement(By.id("frame1"));

        //now use the switch command
        driver.switchTo().frame(iframeElement);
        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("Content of frame is: " + text.getText());
    }

    @Test
    public void switchBackToPageTests() {
        driver.get("https://demoqa.com/frames");

        //now use the switch command
        driver.switchTo().frame(1);
        WebElement text = driver.findElement(By.tagName("body"));
        System.out.println("Content of frame is: " + text.getText());

        //Do all the required tasks in the frame 0
        //Switch back to the main window
        driver.switchTo().defaultContent();
    }

    @Test
    public void nestedFrameTests() {
        driver.get("https://demoqa.com/nestedframes");
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
        driver.get("https://demoqa.com/nestedframes");
        //Number of Frames on a Page
        int countIframesInPage =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames on a Page:"+countIframesInPage);

        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));

        //Switch to Frame1
        driver.switchTo().frame(frame1);

        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);

        //Swiitch to child frame
        driver.switchTo().frame(0);
        int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
        System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);

        //Switch to Parent iFrame
        driver.switchTo().parentFrame();

        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));

        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();

        //Try to Print the text present inside parent frame
        System.out.println("Frame1 is :"+frame1Text);
    }

    @Test
    public void switchToMainPageTests() {
        driver.get("https://demoqa.com/nestedframes");

        WebElement pageHeadingElement=driver.findElement(By.xpath("//h1[@class='text-center']"));
        String pageHeading=pageHeadingElement.getText();
        System.out.println("Page Heading is :"+pageHeading);

        //Switch to Parent frame
        WebElement frame1=driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement frame1Element= driver.findElement(By.tagName("body"));
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);

        //Switch to child frame
        driver.switchTo().frame(0);
        WebElement frame2Element= driver.findElement(By.tagName("p"));
        String frame2Text=frame2Element.getText();
        System.out.println("Frame2 is :"+frame2Text);

        //Switch to default content
        driver.switchTo().defaultContent();

        //Try to print the heading of the main page without swithcing
        WebElement mainPageText=driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        System.out.println(mainPageText.getText());
    }
}
