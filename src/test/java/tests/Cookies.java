package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.Set;

public class Cookies {
    @Test
    public void testCookies() throws InterruptedException {

        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");

        /*
        Driver.getDriver().manage().addCookie(new Cookie("_pbjs_userid_consent_data", "8316820400794021"));
        Driver.getDriver().manage().addCookie(new Cookie("gdpr-auditId", "dab7478b364c4568a923928589d6a610"));
        Driver.getDriver().navigate().refresh();
        */

        //Selenium Query Commands for cookies
        //driver.manage().getCookies();                    -> return the list of all cookies
        //driver.manage().getCookieNamed(arg0);            -> return specific cookie according to name
        //driver.manage().addCookie(arg0);                 -> create and add the cookie
        //driver.manage().deleteCookie(arg0);              -> delete specific cookie
        //driver.manage().deleteCookieNamed(arg0);         -> delete specific cookie according to name
        //driver.manage().deleteAllCookies();              -> delete all cookies

        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.wait(2);
        WebElement accepButton = Driver.getDriver().findElement(By.xpath("//button[@id='save']"));
        accepButton.click();

        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        //Sayfa icinde olan cookies leri Set icine aldik.

        System.out.println("Mevcut cookie sayisi: " + cookies.size()); // icerisinde kac tane oldugunu döndürür.

        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        System.out.println(Driver.getDriver().manage().getCookieNamed("SOCS"));

        System.out.println("__________________________________________________");

        Cookie cookie = new Cookie("info321", "123_info_321");
        Driver.getDriver().manage().addCookie(cookie);
        //kendimiz sayfaya yeni bir cookie olusturduk.

        Set<Cookie> cookies2 = Driver.getDriver().manage().getCookies(); //Kendi ekledeigimiz cookie yi tekrardan bir set icinde aldik.
        System.out.println("cookies2 = " + cookies2);

    }

        /*     @Test
        public void simulateLogin() throws InterruptedException {
        Driver.getDriver().get("http://www.memotome.com/home.asp?display=reminder");
        Driver.getDriver().manage().addCookie(new Cookie("DisplayInfo1", "PADI=87765536akd"));
        Driver.wait(3);

        Driver.getDriver().get("http://www.memotome.com/home.asp?display=reminder");
        Driver.wait(3);
        //sonunda da Assertion edilir. (Assert.assertTrue(cookie.isDisplayed))
       }  */
// Birden fazla cookie eklendiginde sayfaya otomatik olarak login oluyor.

}
