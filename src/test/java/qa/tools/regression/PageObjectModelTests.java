package qa.tools.regression;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.CashedFormPOM;
import qa.tools.pom.FormPOM;

import static qa.tools.pom.FormPOM.FORM_URL;

public class PageObjectModelTests extends BaseTest {

    private FormPOM pageObject;
    private CashedFormPOM cashedPageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, FormPOM.class);
        cashedPageObject = PageFactory.initElements(driver, CashedFormPOM.class);

    }

    @BeforeEach
    public void navigateToPage() {
        // Navigation resets per test — this DOES change between tests
        driver.get(FORM_URL);
    }

    @Test
    public void pageObjectModelTest(){

        // Write some values to First and Last Name
        pageObject.firsName.sendKeys("Virender"); // A FindBy call is triggered to fetch First Name
        pageObject.lastName.sendKeys("Singh"); // A FindBy call is triggered to fetch Last Name

        // Read values from the Text box.
        pageObject.firsName.getText(); // A FindBy call is triggered to fetch First Name
        pageObject.lastName.getText(); // A FindBy call is triggered to fetch Last Name

    }

    @Test
    public void modifiedPageObjectModelTest(){
        // set some text to fetch it later
        cashedPageObject.firstName.sendKeys("Virender");

        // We will first try to get Text from the WebElement version which is not cached.
        // We will measure the time to perform 1000 getText operations
        long withoutCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i ++)
        {
            cashedPageObject.firstName.getText();
        }
        long withoutCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds Without cache " + ((withoutCacheEndTime - withoutCacheStartTime)/ 1000));

        // Let us now repeat the same process on the cached element and see
        // the amount of time it takes to perform the same operation 1000 times
        long withCacheStartTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i ++)
        {
            cashedPageObject.firstNameCached.getText();
        }
        long withCacheEndTime = System.currentTimeMillis();
        System.out.println("Time take in seconds With cache " + ((withCacheEndTime - withCacheStartTime)/ 1000));

    }
}
