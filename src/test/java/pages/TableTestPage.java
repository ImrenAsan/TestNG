package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TableTestPage {
    public TableTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table[@id='table1']")

    public WebElement table1;

    @FindBy (xpath = "//table[@id='table2']")

    public WebElement table2;

    @FindBy(xpath = "//table[1]/tbody/tr[4]/td[5]")

    public WebElement table1R4D5;

    @FindBy(xpath = "//table[1]/thead/tr")

    public List<WebElement> firstTableHead;

    @FindBy(xpath = "//table[2]/thead/tr")

    public List<WebElement> secondTableHead;

    @FindBy (xpath = "//table[2]/tbody/tr[3]/td[4]")
    public WebElement tab2Row3Da4;

}
