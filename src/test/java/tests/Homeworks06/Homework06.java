package tests.Homeworks06;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DragAndDropPage02;
import pages.TableTestPage03;
import pages.TestTableTest02;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Homework06 extends TestBase {

    TableTestPage03 tableTestPage03 = new TableTestPage03();
    DragAndDropPage02 dragAndDropPage02 = new DragAndDropPage02();

    @Test
    public void webTablesTest01() throws InterruptedException {
        //1.Kullanıcı https://demo.guru99.com/test/drag_drop.html  sayfasına gider
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        dragAndDropPage02.acceptAllCookiesButton.click();
        Driver.wait(2);

        //2.Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(dragAndDropPage02.bankValue, dragAndDropPage02.accountInDebitLeftSide).build().perform();
        Driver.wait(2);
        //3.Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(dragAndDropPage02.salesValue, dragAndDropPage02.accountInCreditLeftSide).build().perform();
        Driver.wait(2);
        //4.Kullanıcı 5000 objesini Debit Side Sağ Account"/ Amount kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(dragAndDropPage02.sourceValue5000InDebitSide, dragAndDropPage02.amountInDebitSide).build().perform();
        Driver.wait(2);
        //5.Kullanıcı 5000 objesini Credit Side Sağ Account/Amount kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(dragAndDropPage02.sourceValue5000InCreditSide, dragAndDropPage02.amountInCreditSide).build().perform();
        Driver.wait(2);

        //6.Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide edilir.
        String expectedAmount = "5000";
        String actualAmountOfDebit = dragAndDropPage02.foundValue5000OfDebitInTable.getText();
        String actualAmountOfCredit = dragAndDropPage02.foundValue5000OfCreditInTable.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualAmountOfDebit, expectedAmount, "Wrong Amount");
        softAssert.assertEquals(actualAmountOfCredit, expectedAmount, "Wrong Amount");

        softAssert.assertAll();

        //7.Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard Assert ile teyit edilir.
        String expectedText = "Perfect!";
        String actualText = dragAndDropPage02.perfectVerify.getText();
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void webTablesTest02() throws InterruptedException {
        //1. Kullanici "https://the-internet.herokuapp.com/tables"  sayfasına gidiniz
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        Driver.wait(4);

        //2. Birinci Tablonun 4 üncü sütunudaki tüm değerleri bir listeye alınız. (Başına $ işareti olmadan double değer  olarak.)
       /* WebElement firstData = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(1,1,4)));
          String data1= firstData.getText();
        */
        String text1, text2, text3, text4;
        text1 = tableTestPage03.firstRowFourthData.getText().replace("$", "");
        System.out.println("text1 = " + text1);
        text2 = tableTestPage03.secRowFourthData.getText().replace("$", "");
        System.out.println("text2 = " + text2);
        text3 = tableTestPage03.thirdRowFourthData.getText().replace("$", "");
        System.out.println("text3 = " + text3);
        text4 = tableTestPage03.fourthRowFourthData.getText().replace("$", "");
        System.out.println("text4 = " + text4);

        double firstDouble, secDouble, thirdDouble, fourthDouble;
        firstDouble = Double.parseDouble(text1);
        secDouble = Double.parseDouble(text2);
        thirdDouble = Double.parseDouble(text3);
        fourthDouble = Double.parseDouble(text4);
        //double value= Double.parseDouble(tableTestPage03.firstRowFourthData.getText().replace("$", ""));
        List<Double> valueList = new ArrayList<>();
        valueList.add(firstDouble);
        valueList.add(secDouble);
        valueList.add(thirdDouble);
        valueList.add(fourthDouble);

        //3.Değerler içinden 50.00’den fazla olanları ayrı bir listeye ekleyiniz.
        double fifty = 50.00;
        List<Double> overFiftyList = new ArrayList<Double>();
        for (Double each : valueList) {
            if (each > fifty) {
                overFiftyList.add(each);
            }
        }
        System.out.println("overFiftyList = " + overFiftyList);

        //4.Bu liste içinde 100.00 değeri olup olmadığını doğrulayınız. (Assertion)
        double hundred = 100.00;
        Assert.assertTrue(valueList.contains(hundred));
    }
}
