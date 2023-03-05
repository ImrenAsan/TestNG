package tests.Homeworks05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class HoWoSelenium5 extends TestBase {
        TableTestPage tablePage= new TableTestPage();
        WebDriver driver = new ChromeDriver();
    @Test
    public void webTableTest1() throws InterruptedException {


        driver.get("https://the-internet.herokuapp.com/tables");
        String expectedText = "http://www.timconway.com";
        String actualText = tablePage.table1R4D5.getText();

        Assert.assertEquals(expectedText, actualText);

    }
    @Test

    public void webTableTest2() throws InterruptedException {
        /*
       1. Kullanici "https://the-internet.herokuapp.com/tables" sayfasina gider.
       2. Birinci tablonun tüm basliklarinin ikinci tablonun tüm basliklari ile ayni oldugunu dogrular.
       (Dogrulama manuel degil döngü icinde yapilir.)
         */

        driver.get("https://the-internet.herokuapp.com/tables");

        String firstTabText= tablePage.table1.getText();
        System.out.println("firstTabText = " + firstTabText);
        String secTabText = tablePage.table2.getText();
        System.out.println("secTabText = " + secTabText);

        for (WebElement each:tablePage.firstTableHead
             ) {
            System.out.println(each.getText());
        }

        for(int i=0; i< tablePage.firstTableHead.size(); i++){
            Assert.assertEquals(tablePage.firstTableHead.get(i).getText(), tablePage.secondTableHead.get(i).getText());
        }


    }
    @Test
    public void webTableTest3() throws InterruptedException {
        /*
       1. Kullanici "https://the-internet.herokuapp.com/tables" sayfasina gider.
       2. 2.tabloda 3.satir 4.veriyi xpath ile locate et.
       3. Verinin dogrulugunu kontrol et. Expected value = "$100.00";
         */

        driver.get("https://the-internet.herokuapp.com/tables");
        String actualText = tablePage.tab2Row3Da4.getText();
        String expectedText= "$100.00";

        Assert.assertEquals(actualText, expectedText);
    }

}
