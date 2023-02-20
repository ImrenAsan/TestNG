package tests.Homeworks04;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Homework4 extends TestBase {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test01() {

        // Amazon web sayfasian gider.
        driver.get("https://www.amazon.de/");
       // Driver.wait(2);

        //Cookies accept
        WebElement cookiesAccept = driver.findElement(By.id("sp-cc-accept"));
        cookiesAccept.click();
        //Driver.wait(3);

        //Account kismina tiklamadan sayfa üstüne gelme
        WebElement accountMenu = driver.findElement(By.id("nav-link-accountList"));
        //action.moveToElement(accountMenu).perform();
        //Driver.wait(3);


        //Find a gift linkine tiklar.
        WebElement geschenkeFinden = driver.findElement(By.xpath("//span[contains(text(), 'Geschenke finden')]"));
        geschenkeFinden.click();
        //Driver.wait(3);

        //Gifts for everyone textini kopyalar.
        WebElement geschenkeFürAlle = driver.findElement(By.xpath("//h2[contains(text(), 'Geschenke für alle')]"));
        String gfaText = geschenkeFürAlle.getText();
        System.out.println("gfaText = " + gfaText);
        //Driver.wait(3);

        //Ebay.com adresine gitmek icin yeni bir sekme acar.
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.ebay.com/', '_blank');");
        //Driver.wait(3);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys(gfaText + Keys.ENTER);

        WebElement firstProductPrice= driver.findElement(By.xpath("//span[contains(text(), '$2.13')]"));
        String actualPrice = firstProductPrice.getText();
        String expectedPrice = "$2.13";
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}
