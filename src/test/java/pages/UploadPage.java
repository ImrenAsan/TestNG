package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.TestBase;

public class UploadPage extends TestBase {

    public UploadPage(){
        PageFactory.initElements(Driver.getDriver(), this); // sayfa  icerisindeki tüm elemanlarin calismasini sagliyor.
    }

    @FindBy (id = "File Uploaded!")
    public WebElement chooseFile;
    @FindBy // locate edilmeli!
    public WebElement uploadBUtton;

    @FindBy // locate edilmeli!!
    public WebElement successMessage;
}
