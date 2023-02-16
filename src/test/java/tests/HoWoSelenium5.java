package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class HoWoSelenium5 extends TestBase {

        TableTestPage tablePage= new TableTestPage();
    @Test
    public static void webTableTest1() throws InterruptedException {


        driver.get("https://the-internet.herokuapp.com/tables");
        Driver.wait(4);
        WebElement firstTable = driver.findElement(By.xpath("//table/tbody/tr[4]/td[5]"));
        String actualValue = firstTable.getText();
        System.out.println("actualValue = " + actualValue);
        String expectedValue = "http://www.timconway.com";

        Assert.assertEquals(expectedValue, actualValue);




    }
    @Test

    public static void webTableTest2() throws InterruptedException {
        /*
       1. Kullanici "https://the-internet.herokuapp.com/tables" sayfasina gider.
       2. Birinci tablonun tüm basliklarinin ikinci tablonun tüm basliklari ile ayni oldugunu dogrular.
       (Dogrulama manuel degil döngü icinde yapilir.)
         */

        driver.get("https://the-internet.herokuapp.com/tables");
        Driver.wait(4);

        WebElement firstRow = driver.findElement(By.xpath("//table[1]/thead/tr"));
        String firstRowText = firstRow.getText();
        System.out.println("firstRoadText = " + firstRowText);

        WebElement secondRow = driver.findElement(By.xpath("//table[2]/thead/tr"));
        String secondRowText = secondRow.getText();
        System.out.println("secondRoadText = " + secondRowText);


       List<WebElement> tableHead = driver.findElements(By.tagName("thead"));
        System.out.println(tableHead.size());

        for (WebElement each:tableHead
             ) {
            System.out.println(each.getText());
        }

        Assert.assertEquals(firstRowText, secondRowText);

        //Döngü?

    }
    @Test
    public static void webTableTest3() throws InterruptedException {
        /*
       1. Kullanici "https://the-internet.herokuapp.com/tables" sayfasina gider.
       2. 2.tabloda 3.satir 4.veriyi xpath ile locate et.
       3. Verinin dogrulugunu kontrol et. Expected value = "$100.00";
         */

        driver.get("https://the-internet.herokuapp.com/tables");
        Driver.wait(3);

        WebElement fourthElement = driver.findElement(By.xpath("//table[2]/tbody/tr[3]/td[4]"));
        String actualText = fourthElement.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "$100.00";

        Assert.assertEquals(actualText,expectedText);
        
    }

}
