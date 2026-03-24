package test.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TableTests extends BaseTest{
    public static final String SelectURL = "https://demoqa.com/webtables";

    @Test
    public void PracticeTables() {
        driver.get(SelectURL);

        //Here we are storing the value from the cell in to the string variable
        String sCellValue = driver.findElement(By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[1]/td[2]")).getText();
        System.out.println(sCellValue);

        // Here we are clicking on the link of first row and the last column
        driver.findElement(By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[1]/td[7]")).click();
        System.out.println("Link has been clicked otherwise an exception would have thrown");
    }

    @Test
    public void PracticeTable_2() {
        driver.get(SelectURL);

        String sRow = "1";
        String sCol = "2";

        //Here we are locating the xpath by passing variables in the xpath
        String sCellValue = driver.findElement(By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println(sCellValue);
        String sRowValue = "Cierra";

        //First loop will find the 'ClOCK TWER HOTEL' in the first column
        for (int i=1;i<=3;i++){
            String sValue;
            sValue = driver.findElement(By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[" + sRow + "]/td[" + 1 + "]")).getText();
            if(sValue.equalsIgnoreCase(sRowValue)){
                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                for (int j=1;j<=7;j++){
                    String sColumnValue= driver.findElement(By.xpath(".//*[@class='web-tables-wrapper']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
                    System.out.println(sColumnValue);
                }
                break;
            }
        }
    }
}
