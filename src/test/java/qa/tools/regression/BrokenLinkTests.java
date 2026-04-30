package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.BrokenLinksPOM;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static qa.tools.pom.BrokenLinksPOM.BROKEN_LINKS_URL;
import static qa.tools.pom.BrokenLinksPOM.LINKS_URL;
@Tag("regression")
public class BrokenLinkTests extends BaseTest {
    private BrokenLinksPOM pageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, BrokenLinksPOM.class);
    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(BROKEN_LINKS_URL);
    }

    @Test
    public void GetAllURLs (){
        driver.get(LINKS_URL);

        List<WebElement> allURLs = pageObject.links;
        System.out.println("Total links on the Wb Page: " + allURLs.size());

        //We will iterate through the list and will check the elements in the list.
        for (WebElement allURL : allURLs) {
            String url = allURL.getText();
            System.out.println(url);
        }
    }

    @Test
    public void BrokenLinks(){
        //Storing the links in a list and traversing through the links
        List<WebElement> links = pageObject.links;

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for (WebElement E1 : links) {
            String url = E1.getAttribute("href");
            verifyLinks(url);
        }
    }

    @Test
    public void BrokenImages(){
        // Storing all elements with img tag in a list of WebElements
        List<WebElement> images = pageObject.images;
        System.out.println("Total number of Images on the Page are " + images.size());
        //checking the links fetched.
        for(int index=0;index<images.size();index++)
        {
            WebElement image= images.get(index);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
            verifyLinks(imageURL);
            verifyImage(image);
        }
    }

    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }
        catch (Exception _) {
        }
    }

    private void verifyImage(WebElement image) {
        //Validate image display using JavaScript executor
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
            if (imageDisplayed) {
                System.out.println("DISPLAY - OK");
            }else {
                System.out.println("DISPLAY - BROKEN");
            }
        }
        catch (Exception e) {
            System.out.println("Error Occured");
        }
    }
}
