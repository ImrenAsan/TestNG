package tests.homework7;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SeleniumHomework7 extends TestBase {

    AllPages allPages = new AllPages();
    String path ="/Users/imrenasan/I-Informatik I/TestNG/src/test/resources/Capitals.xlsx"; //Excel dosyamiza ulasmak icin path ini kopyalayip buraya atadik.
    FileInputStream file = new FileInputStream(path);
    Workbook workbook = WorkbookFactory.create(file);
    Actions actions = new Actions(Driver.getDriver());

    public SeleniumHomework7() throws IOException {
    }


    @Test //Negatif Senaryo

    public void negativeTest01(){

        //Kullanıcı https://www.browserstack.com/users/sign_up sayfasına gider.//Testbase class da getPro. ile oraya sabitledim.
        //Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
        actions.click(allPages.homeworkPage07.acceptAllCookies).build().perform();

        //Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
        String name = workbook.getSheet("INVALID EMAILS").getRow(1).getCell(0).getStringCellValue();
        actions.click(allPages.homeworkPage07.fullNameBox).sendKeys(name).build().perform();

        //Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERSİZ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
        String invalidEmail = workbook.getSheet("INVALID EMAILS").getRow(1).getCell(1).getStringCellValue();
        actions.click(allPages.homeworkPage07.businessEmailBox).sendKeys(invalidEmail);

        //Kullanıcı password textbox kutusuna tıklar.
        //INVALID olarak girilen MAIL adresini yarattığı hata mesajı “Invalid Email” validate(assert) edilir.
        actions.click(allPages.homeworkPage07.passwordBox).build().perform();
        String actualText= allPages.homeworkPage07.validateEmail.getText();
        String expectedText= "Invalid Email";

        Assert.assertEquals(actualText,expectedText);
        }

            @Test//negatif senaryo02
            public void negativeTest02() {
            //Kullanıcı https://www.browserstack.com/users/sign_up sayfasına gider.//Testbase class da getPro. ile oraya sabitledim.
            //Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
            actions.click(allPages.homeworkPage07.acceptAllCookies).build().perform();

            //Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
            String name = workbook.getSheet("EMAILS").getRow(1).getCell(0).getStringCellValue();
            actions.click(allPages.homeworkPage07.fullNameBox).sendKeys(name).build().perform();

            //Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
            String email = workbook.getSheet("EMAILS").getRow(1).getCell(1).getStringCellValue();
            actions.click(allPages.homeworkPage07.businessEmailBox).sendKeys(email).build().perform();

            //actions.click(allPages.homeworkPage07.fullNameBox).sendKeys(email).build().perform();//Business email yerine buraya yazdim yine de test gecti!!
            //Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERSİZ PASSWORD Sheetinden aldığı 6 karakterden kısa password’ü yazar.
            String password = workbook.getSheet("INVALID PASSWORD").getRow(1).getCell(0).getStringCellValue();
            actions.click(allPages.homeworkPage07.passwordBox).sendKeys(password).build().perform();

            //Kullanıcı “I agrre…” Checkbox’ına tıklar.
            //INVALID olarak girilen PASSWORD’ün  yarattığı hata mesajı “At least 6 characters” validate(assert) edilir.
            actions.click(allPages.homeworkPage07.checkBoxButton).build().perform();
            String actualPasswordValidation = allPages.homeworkPage07.validatePassword.getText();
            String expectedPasswordValidation = "At least 6 characters";

            Assert.assertEquals(actualPasswordValidation, expectedPasswordValidation);

        }

        @Test //Pozitif Senaryo
        public void positiveTest01(){
            //Kullanıcı https://www.browserstack.com/users/sign_up sayfasına gider.//Testbase class da getPro. ile oraya sabitledim.
            //Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
            actions.click(allPages.homeworkPage07.acceptAllCookies).build().perform();

            //Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
            String name = workbook.getSheet("EMAILS").getRow(4).getCell(0).getStringCellValue();
            actions.click(allPages.homeworkPage07.fullNameBox).sendKeys(name).build().perform();

            //Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
            String email = workbook.getSheet("EMAILS").getRow(4).getCell(1).getStringCellValue();
            actions.click(allPages.homeworkPage07.businessEmailBox).sendKeys(email).build().perform();

            //Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERLİ PASSWORD Sheetinden aldığı şifreyi yazar.
            String password = workbook.getSheet("PASSWORD").getRow(4).getCell(0).getStringCellValue();
            actions.click(allPages.homeworkPage07.passwordBox).sendKeys(password).build().perform();

            //Kullanıcı “I agrre…” Checkbox’ına tıklar.
            actions.click(allPages.homeworkPage07.checkBoxButton).build().perform();

                //Kullanıcı “Sign me up” butonuna tıklar.
                actions.click(allPages.homeworkPage07.signUpButton).build().perform();
                //Başarılı bir şekilde kayıt yapıldığı Validate edilir.
               Assert.assertTrue(allPages.homeworkPage07.signUpValidation.isDisplayed());
        }
    }

