package tests;

import org.openqa.selenium.JavascriptExecutor;
import utilities.Driver;

public class WindowHandle {

    public void testWindowHandle() throws InterruptedException {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.google.com', '_blank');");
        //Driveri casting ile yaptik.!!
        Driver.wait(3);

    }

}
