package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.TestTableTest02;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {


    TestTableTest02 tableTest02 = new TestTableTest02();

    //SoftAssert softAssert = new SofAssert();
    //Caselerden herhangi biri fail etse de diger caseleri test etmeye devam ediyor.
    //softAssert.assertAll(); hangi casede hata var görülebilir.
    @Test
    public void tableTest() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String tableTitle = tableTest02.table.getText();
        System.out.println("tableTitle = " + tableTitle);

        System.out.println("=======================================================================");

        String tableFirstRowSecondData = tableTest02.tr.getText();
        System.out.println("tableFirstRowSecondData = " + tableFirstRowSecondData);

        List<WebElement> satir3 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

        for (WebElement satir : satir3) {
            System.out.println(satir.getText());
        }

        System.out.println("=======================================================================");
        WebElement dataEmail1 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4)));
        System.out.println("dataEmail1 = " + dataEmail1);
        WebElement dataEmail2 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,3,4)));
        System.out.println("dataEmail2 = " + dataEmail2);
        WebElement dataEmail3 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4,5)));
        System.out.println("dataEmail3 = " + dataEmail3);
    }
}
