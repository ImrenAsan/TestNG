package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragAndDropPage02 {
    public DragAndDropPage02() {PageFactory.initElements(Driver.getDriver(), this);} //constructor

    //yukarida olusturduguuz constructor olmadan asagidaki lokasyonlar calismaz.
    //sayfayi baslatirken calismasini istedigimz özellikleri constructorlarin icine yazmamiz gerekir.
    @FindBy(xpath = "//span[text()='Tümünü Kabul Et']")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//a[text()=' BANK ']")
    public WebElement bankValue;

    @FindBy(xpath = "//ol[@id='bank']")
    public WebElement accountInDebitLeftSide;

    @FindBy (xpath = "//a[text()=' SALES ']")
    public WebElement salesValue;

    @FindBy (xpath = "//ol[@id='loan']")
    public WebElement accountInCreditLeftSide;

    @FindBy (xpath = "(//li[@id='fourth'])[1]")
    public WebElement sourceValue5000InDebitSide;

    @FindBy(xpath = "(//li[@id='fourth'])[2]")
    public WebElement sourceValue5000InCreditSide;

    @FindBy (xpath="//ol[@id='amt7']")
    public WebElement amountInDebitSide;

    @FindBy(xpath = "//ol[@id='amt8']")
    public WebElement amountInCreditSide;

    @FindBy(xpath= "//div[@id='t7']")
    public WebElement foundValue5000OfDebitInTable;

    @FindBy(xpath = "//div[@id='t8']")
    public WebElement foundValue5000OfCreditInTable;

    @FindBy(xpath= "//a[text()='Perfect!']")
    public WebElement perfectVerify;
}
