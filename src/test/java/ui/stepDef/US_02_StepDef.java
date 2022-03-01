package ui.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import ui.pages.SignInPage;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.ReusableMethods;




public class US_02_StepDef {

    SignInPage signInPage=new SignInPage();
    Actions action=new Actions(Driver.getDriver());
    Logger log = (Logger) LogManager.getLogger(US_02_StepDef.class);



    @Given("navigate to sign in page")
    public void navigate_to_sign_in_page() {
     action.moveToElement(signInPage.hooverAccount).perform();
     signInPage.navSignInPage.click();
     log.info("Navigated to sign in page");
    }

    @Then("enter valid email address to the email box")
    public void enter_valid_email_address_to_the_email_box() {
        signInPage.emailBox.sendKeys(ConfigReader.getProperty("valid_email"));
        log.info("Valid email is entered");
    }

    @Then("click continue button")
    public void click_continue_button() {
        signInPage.continueButton.click();
        log.info("clicked to continue button");
    }


    @Then("enter valid password to the password box")
    public void enter_valid_password_to_the_password_box() {
        signInPage.passwordBox.sendKeys(ConfigReader.getProperty("valid_password"));
       log.info("entered valid password");
    }

    @Then("click sign-in button")
    public void click_sign_in_button() {
        signInPage.signInButton.click();
        log.info("clicked sign in button");
    }

    @Then("verify sign in is successful")
    public void verify_sign_in_is_successful() {
        action.moveToElement(signInPage.helloName).perform();
        Assert.assertTrue(signInPage.signOut.isDisplayed());
        log.info("successfully signed in");
    }

    @Given("enter invalid email address to the email box")
    public void enter_invalid_email_address_to_the_email_box() {
        signInPage.emailBox.sendKeys(ConfigReader.getProperty("invalid_email"));

    }
    @Given("verify failure message is displayed")
    public void verify_email_failure_message_is_displayed() {
        Assert.assertTrue(signInPage.continueButton.isDisplayed());
    }

    @Given("clear email box")
    public void clear_email_box() {
        signInPage.emailBox.clear();
    }

    @Given("enter invalid password to password box")
    public void enter_invalid_password_to_password_box() {
        signInPage.passwordBox.sendKeys(ConfigReader.getProperty("invalid_password"));
    }

    @And("enter {string} addresses to the email box")
    public void enter_AddressesToTheEmailBox(String invalid) {
        signInPage.emailBox.sendKeys(invalid);

    }

    @Then("close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }

    @And("wait some")
    public void waitSome() {
        ReusableMethods.waitFor(2);
    }
    @And("enter {string} into password box")
    public void enterIntoPasswordBox(String invalidPAssword) {
        signInPage.passwordBox.sendKeys(invalidPAssword);
    }

    @And("verify important message is displayed")
    public void verifyImportantMessageIsDisplayed() {
        Assert.assertTrue(signInPage.thereWasProblemMessage.isDisplayed());

    }


}
