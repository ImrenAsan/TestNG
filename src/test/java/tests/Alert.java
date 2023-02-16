package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;
import utilities.TestBase;

public class Alert extends TestBase {


    @Test

    public void alertAccept() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
       Driver.wait(2);

       WebElement alertButton1 = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
       alertButton1.click();
       String expectedTextOfAlert ="I am a JS Alert";
       String actualTextOfAlert = Driver.getDriver().switchTo().alert().getText();
       Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        Assert.assertEquals(expectedTextOfAlert, actualTextOfAlert);
    }

    @Test

    public void alertAcceptAndDismiss() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);

        WebElement alertButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();
        Driver.wait(2);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(2);
        alertButton.click();
    }

    @Test
    public void sendMessageToAlert() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(2);

        WebElement alertButton2 = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alertButton2.click();
        Driver.wait(2);
        String expectedMessage = "Merhaba Alert";
        Driver.getDriver().switchTo().alert().sendKeys(expectedMessage);
        Driver.getDriver().switchTo().alert().accept();
        WebElement message = Driver.getDriver().findElement(By.id("result"));

        Assert.assertTrue(message.getText().contains(expectedMessage));

    }
}
