package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeworkPage07 {
    public HomeworkPage07() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='accept-cookie-notification']")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//input[@id='user_full_name']")
    public WebElement fullNameBox;

    @FindBy(xpath = "//input[@id='user_email_login']")
    public WebElement businessEmailBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='tnc_checkbox']")
    public WebElement checkBoxButton;

    @FindBy(xpath="//input[@id='user_submit']")
    public WebElement signUpButton;

    @FindBy(xpath = "(//div[@class='msg-body'])[2]")
    public WebElement validateEmail;

    @FindBy(xpath = "(//div[@class='msg-body'])[3]")
    public WebElement validatePassword;

    @FindBy(xpath ="//img[@class='w-svg']")
    public WebElement signUpValidation;



}
