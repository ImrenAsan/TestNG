package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.TestBase;

import java.time.Duration;

public class Wait extends TestBase {

    public void waitTest(){

        // Hard wait : Thread.sleep(1000) her halükarda beklem yapar.
        // implicitly wait driverin yolu üzerindeki elemanlarin ortaya cikmasi iin dinamik bekleme yapar.
                    // eger eleman belirlenen süre icerisdnde cikmaz ise test fail eder.
        // explicitlywait -> Driver özel olarak bir elementi bekler. Cikmazsa hata verir.
        // Implicitly wait ve explicitly wait elementin ortaya cikmasi ile beklemyi sonlandirir.
        // Her ikisi de dinamik WAit dir.


        //1. Kullanici "" sayfasina gider.
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Kullanici Remove butonuna tiklar.
        WebElement removeButton = Driver.getDriver().findElement(By.xpath("//button[@autocomplete='off']"));
        removeButton.click();

        //3. It's gone! mesajini görür ve dogrular.
        String expectedMessageText = "It's gone!";

            // wait objesini olusturma sebebi, özel bir butona tiklandiginda beklemek icin wait  objesini atiyoruz.
        // senkronizasyon icin gerekli!!
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // wait object i olusturuldu. () arasina Driver ve bekleme süresi yazilir.
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))); // Bu butona özel bir bekleme yapiyoruz.
        String actualMessageText = message.getText();

        // WebElement obj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id())); bu sekilde istedigimiz elemnti locate ederek istedigimiz süre kadar bekletebiliyoruz.

        Assert.assertEquals(expectedMessageText, actualMessageText);



    }
}
