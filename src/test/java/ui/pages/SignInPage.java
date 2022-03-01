package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "nav-link-accountList")
    public WebElement hooverAccount;

    @FindBy(xpath = "(//span[text()='Sign in'])[1]")
    public WebElement navSignInPage;

    @FindBy(id = "ap_email")
    public WebElement emailBox;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//*[@class='a-button-input']")
    public WebElement signInButton;

    @FindBy(xpath = "(//*[text()='Hello, Necip'])[1]")
    public WebElement helloName;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//h4[text()='There was a problem']")
    public  WebElement thereWasProblemMessage;

    @FindBy(xpath = "//*[text()='Important Message!']")
    public WebElement importantMessage;

}
