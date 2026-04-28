package qa.tools.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import qa.tools.BaseTest;
import qa.tools.pom.MenuPOM;
import qa.tools.pom.SliderPOM;

import static qa.tools.pom.MenuPOM.MENU_URL;
import static qa.tools.pom.SliderPOM.SLIDER_URL;

public class MoveToElementTests extends BaseTest {

    private MenuPOM pageObject;
    private SliderPOM sliderPageObject;

    @BeforeAll
    public void initPageObject() {
        // Created ONCE for all tests in this class
        pageObject = PageFactory.initElements(driver, MenuPOM.class);
        sliderPageObject = PageFactory.initElements(driver, SliderPOM.class);
    }
    @Test
    public void moveToElementTest(){
        driver.get(MENU_URL);

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        WebElement menu2 = pageObject.menu2;

        actions.moveToElement(menu2).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

        WebElement subMenuOption = pageObject.subMenuOption;
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on first 'Sub Item' from 'Main Item 2'");

        subMenuOption.click();
        System.out.println("Selected first 'Sub Item' from 'Main Item 2'");
    }

    @Test
    public void moveSliderTest(){
        driver.get(SLIDER_URL);

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        WebElement slider = sliderPageObject.slider;

        actions.moveToElement(slider,50,0).perform();
        slider.click();
        System.out.println("Moved slider in horizontal directions");
    }
}
