package tests;

import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.TestBase;

public class IFrame extends TestBase {

     /*
     WebElement iframe = driver.findElement();
     driver.switchTo.frame(iframe); //konumlandirilmis iframe in web elementi eklenerek gecis yapilir.
     driver.switchTo().frame(0); // index numarasi ile gecis yapilir.
     driver. switchTo().frame("id"); // id ile gecis yapilir.

     // ic ice gecis yapmis iframe ler icin
     driver.switchTo().parentFrame();
     driver.switchTo().defaultContent(); //??
      */


    public void iframeTest(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        Driver.getDriver().switchTo().frame(""); // you should first locate it!!
        // IFrame <iframe> ile bulabiliriz. ve id sini locate edebiliriz. En üst satirlarda frame alma sekilleri mevcut!!

       // WebElement textDoc = Driver.getDriver().findElement(); //locate edilmesi gerekiyor.

    }
}
