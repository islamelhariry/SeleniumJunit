package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import test.selenium.POM.PracticeFormModifiedPageObject;
import test.selenium.POM.PracticeFormPageObject;

public class PageObjectModelTests extends BaseTest{
    @Test
    public void pageObjectModelTest(){
        PracticeFormPageObject pageObject = PageFactory.initElements(driver, PracticeFormPageObject.class);
        driver.get("https://demoqa.com/automation-practice-form");

        // Write some values to First and Last Name
        pageObject.firsName.sendKeys("Virender"); // A FindBy call is triggered to fetch First Name
        pageObject.lastName.sendKeys("Singh"); // A FindBy call is triggered to fetch Last Name

        // Read values from the Text box.
        pageObject.firsName.getText(); // A FindBy call is triggered to fetch First Name
        pageObject.lastName.getText(); // A FindBy call is triggered to fetch Last Name

    }

    @Test
    public void modifiedPageObjectModelTest(){
        // Initialize the Page object
        PracticeFormModifiedPageObject pageObject = PageFactory.initElements(driver, PracticeFormModifiedPageObject.class);
        driver.get("https://demoqa.com/automation-practice-form");

        // set some text to fetch it later
        pageObject.firstName.sendKeys("Virender");

        // We will first try to get Text from the WebElement version which is not cached.
        // We will measure the time to perform 1000 getText operations
        long withoutCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i ++)
        {
            pageObject.firstName.getText();
        }
        long withoutCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds Without cache " + ((withoutCacheEndTime - withoutCacheStartTime)/ 1000));

        // Let us now repeat the same process on the cached element and see
        // the amount of time it takes to perform the same operation 1000 times
        long withCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i ++)
        {
            pageObject.firstNameCached.getText();
        }
        long withCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds With cache " + ((withCacheEndTime - withCacheStartTime)/ 1000));

    }
}
