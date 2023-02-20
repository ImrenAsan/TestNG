package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TableTestPage03 {
    public TableTestPage03() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath="//table[1]/tbody/tr[1]/td[4]")
    public WebElement firstRowFourthData;

    @FindBy(xpath ="//table[1]/tbody/tr[2]/td[4]" )
    public WebElement secRowFourthData;

    @FindBy(xpath ="//table[1]/tbody/tr[3]/td[4]")
    public WebElement thirdRowFourthData;

    @FindBy(xpath="//table[1]/tbody/tr[4]/td[4]")
    public WebElement fourthRowFourthData;


}
