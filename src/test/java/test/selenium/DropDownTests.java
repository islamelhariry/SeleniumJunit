package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownTests extends BaseTest{
    public static final String SelectURL = "https://demoqa.com/select-menu";

    @Test
    public void SingleSelectOperationsTest() {
        driver.get(SelectURL);

        //Step#3- Selecting the dropdown element by locating its id
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

        //Step#4- Printing the options of the dropdown
        //Get list of web elements
        List<WebElement> lst = select.getOptions();

        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(WebElement options: lst)
            System.out.println(options.getText());

        //Step#5- Selecting the option as 'Purple'-- selectByIndex
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#6- Selecting the option as 'Magenta'-- selectByVisibleText
        System.out.println("Select the Option by Text Magenta");
        select.selectByVisibleText("Magenta");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

        //Step#7- Selecting an option by its value
        System.out.println("Select the Option by value 6");
        select.selectByValue("6");
        System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
    }

    @Test
    public void MultiSelectOperationsTest() {
        driver.get(SelectURL);
        WebElement cars = driver.findElement(By.id("cars"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cars);

        //Selecting the multi-select element by locating its id
        Select select = new Select(cars);

        //Get the list of all the options
        System.out.println("The dropdown options are -");

        List<WebElement> options = select.getOptions();

        for(WebElement option: options)
            System.out.println(option.getText());

        //Using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else eit
        if(select.isMultiple()){

            //Selecting option as 'Opel'-- ByIndex
            System.out.println("Select option Opel by Index");
            select.selectByIndex(2);

            //Selecting the option as 'Saab'-- ByValue
            System.out.println("Select option saab by Value");
            select.selectByValue("saab");

            // Selecting the option by text
            System.out.println("Select option Audi by Text");
            select.selectByVisibleText("Audi");

            //Get the list of selected options
            System.out.println("The selected values in the dropdown options are -");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            for(WebElement selectedOption: selectedOptions)
                System.out.println(selectedOption.getText());


            // Deselect the value "Audi" by Index
            System.out.println("DeSelect option Audi by Index");
            select.deselectByIndex(3);

            //Deselect the value "Opel" by visible text
            System.out.println("Select option Opel by Text");
            select.deselectByVisibleText("Opel");

            //Validate that both the values are deselected
            System.out.println("The selected values after deselect in the dropdown options are -");
            List<WebElement> selectedOptionsAfterDeselect = select.getAllSelectedOptions();

            for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
                System.out.println(selectedOptionAfterDeselect.getText());

            //Step#8- Deselect all values
            select.deselectAll();
        }
    }
}
