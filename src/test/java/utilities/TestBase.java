package utilities;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utilities.Driver.driver;

public class TestBase {

        protected static WebDriver driver;

        @BeforeClass
        public void setUp(){
            driver = Driver.getDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

        @AfterClass

        public void tearDown(){
        driver.close();


    }

}
