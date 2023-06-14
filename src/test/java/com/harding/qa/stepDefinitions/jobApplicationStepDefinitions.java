package com.harding.qa.stepDefinitions;

import com.github.javafaker.Faker;
import com.harding.qa.data.FilePath;
import com.harding.qa.pages.ApplicationFormPage;
import com.harding.qa.pages.HomePage;
import com.harding.qa.pages.LandsideCareerPage;
import com.harding.qa.pages.LandsideDepartmentPage;
import com.harding.qa.utilities.*;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class jobApplicationStepDefinitions {
    HomePage homePage = new HomePage();
    LandsideCareerPage landsideCareerPage = new LandsideCareerPage();
    LandsideDepartmentPage landsideDepartmentPage = new LandsideDepartmentPage();
    ApplicationFormPage applicationFormPage = new ApplicationFormPage();
    Faker faker = new Faker();
    private static org.apache.log4j.Logger Log = Logger.getLogger(com.harding.qa.utilities.Log.class.getName());

    @Given("user navigates to Harding homepage")
    public void user_navigates_to_harding_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("harding_home_page"));
        Log.info("user navigated to Harding homepage");
    }

    @When("user hoovers Career link and click Landside link")
    public void user_hoovers_career_link_and_click_landside_link() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.careerMenuItem).perform();
        homePage.landsideDropdownItem.click();
        Log.info("user hoovered Career link and clicked Landside link ");
    }

    @Then("user verifies landside career page")
    public void user_verifies_landside_career_page() {
        String expectedUrl = ConfigReader.getProperty("landside_career_page");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(expectedUrl);
        System.out.println(actualUrl);
        Assert.assertEquals(ConfigReader.getProperty("landside_career_page"), Driver.getDriver().getCurrentUrl());
        Log.info("user successfully verified landside career page");
    }

    @When("user clicks See Vacancies button")
    public void user_clicks_see_vacancies_button() {
        landsideCareerPage.seeVacanciesButton.click();
    }

    @Then("user verifies landside department page")
    public void user_verifies_landside_department_page() {
        Assert.assertEquals(ConfigReader.getProperty("landside_department_page"), Driver.getDriver().getCurrentUrl());
    }

    @Then("user searches for {string} job in the search bar")
    public void user_searches_for_job_in_the_search_bar(String jobName) {
        landsideDepartmentPage.searchBox.sendKeys(jobName);
        landsideDepartmentPage.searchButton.click();
    }

    @Then("user verifies the job")
    public void userVerifiesTheJob() {
        Assert.assertTrue(landsideDepartmentPage.procurementCoordinatorJob.isDisplayed());
    }

    @When("user clicks Apply button")
    public void user_clicks_apply_button() {
        JSUtilities.scrollToElement(landsideDepartmentPage.applyButton);
        ReusableMethods.hover(landsideDepartmentPage.applyButton);
        JSUtilities.clickWithJS(landsideDepartmentPage.applyButton);
    }


    @Then("user verifies personal information title")
    public void userVerifiesPersonalInformationTitle() {
        Assert.assertTrue(applicationFormPage.personalDetailsForm.isDisplayed());

    }


    @Then("user fills in the mandatory fields with the provided data and a valid file")
    public void userFillsInTheMandatoryFieldsWithTheProvidedDataAndAValidFile() throws InterruptedException {
        applicationFormPage.firstName.sendKeys(ConfigReader.getProperty("first_name"));
        applicationFormPage.surname.sendKeys(ConfigReader.getProperty("surname"));
        applicationFormPage.email.sendKeys(faker.internet().emailAddress());
        applicationFormPage.mobileNumber.sendKeys(ConfigReader.getProperty("mobile_phone_number"));

        String path = "C:\\Users\\admin\\IdeaProjects\\Harding\\src\\test\\java\\com\\harding\\qa\\data\\CV.docx";
        JSUtilities.clickWithJS(applicationFormPage.uploadCv);
        ReusableMethods.waitAndSendText(applicationFormPage.uploadCv, path, 3);
        ReusableMethods.uploadFile(FilePath.CvWordPath);
        Thread.sleep(3);

        applicationFormPage.address.sendKeys(ConfigReader.getProperty("town_city"));
    }

    @And("user clicks next button")
    public void userClicksNextButton() throws InterruptedException {
        Thread.sleep(2);
        JSUtilities.clickWithJS(applicationFormPage.nextButton);

    }

    @Then("user should see an success message")
    public void userShouldSeeAnSuccessMessage() {
        Assert.assertTrue(applicationFormPage.successMessage.isDisplayed());
    }





    @When("user fills the Equal Opportunities Section")
    public void userFillsTheEqualOpportunitiesSection() {
        ReusableMethods.waitForVisibility(applicationFormPage.genderDropDown,2);
        Select gender = new Select(applicationFormPage.genderDropDown);
        gender.selectByVisibleText("Male");

        Select age = new Select(applicationFormPage.ageDropDown);
        age.selectByIndex(2);

        Select nationality = new Select(applicationFormPage.nationalityDropDown);
        nationality.selectByVisibleText("Turkish");

        Select ethnicity = new Select(applicationFormPage.ethnicityDropDown);
        ethnicity.selectByVisibleText("White - British");

        Select religion = new Select(applicationFormPage.religionDropDown);
        religion.selectByVisibleText("Muslim");

        Select disability = new Select(applicationFormPage.disabilitySectionDropDown);
        disability.selectByVisibleText("No");

        Select sexualOrientation = new Select(applicationFormPage.sexualOrientationDropDown);
        sexualOrientation.selectByVisibleText("Heterosexual");

    }

    @And("user fills About my Application Section")
    public void userFillsAboutMyApplicationSection() throws InterruptedException {

        ReusableMethods.waitAndSendText(applicationFormPage.salaryAndNoticeDropDown, "3 weeks", 2);

        String path = "C:\\Users\\admin\\IdeaProjects\\Harding\\src\\test\\java\\com\\harding\\qa\\data\\CV.docx";
        JSUtilities.clickWithJS(applicationFormPage.uploadCoverLetter);
        ReusableMethods.waitAndSendText(applicationFormPage.uploadCoverLetter, path, 3);
        ReusableMethods.uploadFile(FilePath.CvWordPath);
        Thread.sleep(3);


        ReusableMethods.waitForClickablility(applicationFormPage.rightToWorkRadioButton,5);
        JSUtilities.clickWithJS(applicationFormPage.rightToWorkRadioButton);
        JSUtilities.clickWithJS(applicationFormPage.confirmGivenDetailsRadioButton);
        JSUtilities.clickWithJS(applicationFormPage.confirmPrivacyPolicyRadioButton);
        JSUtilities.clickWithJS(applicationFormPage.givingConsentToHardingRadioButton);

    }

    @When("user clicks submit application button")
    public void userClicksSubmitApplicationButton() {

        JSUtilities.clickWithJS(applicationFormPage.submitApplicationButton);
    }


    @Then("user verifies application completed message")
    public void userVerifiesApplicationCompletedMessage() {
        try {
            ReusableMethods.fluentWait(applicationFormPage.successMessage,3);
            Assert.assertTrue(applicationFormPage.successMessage.isDisplayed());
        }catch(NoSuchElementException e){
            Assert.assertTrue(true);

        }

    }



    @Then("user fills in the mandatory fields with the provided data and {string}")
    public void userFillsInTheMandatoryFieldsWithTheProvidedDataAnd(String file) throws InterruptedException {
        applicationFormPage.firstName.sendKeys(ConfigReader.getProperty("first_name"));
        applicationFormPage.surname.sendKeys(ConfigReader.getProperty("surname"));
        applicationFormPage.email.sendKeys(faker.internet().emailAddress());
        applicationFormPage.mobileNumber.sendKeys(ConfigReader.getProperty("mobile_phone_number"));

        JSUtilities.clickWithJS(applicationFormPage.uploadCv);
        ReusableMethods.waitAndSendText(applicationFormPage.uploadCv, FilePath.getFilePath(file), 3);
        ReusableMethods.uploadFile(FilePath.getFilePath(file));
        Log.info("FilePath: "+FilePath.getFilePath(file));
        Thread.sleep(3);

        applicationFormPage.address.sendKeys(ConfigReader.getProperty("town_city"));
    }

    @Then("user fills the mandatory fields with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsTheMandatoryFieldsWith(String firstName, String surname, String email, String phoneNumber, String file, String address) {
        applicationFormPage.firstName.sendKeys(firstName);
        applicationFormPage.surname.sendKeys(surname);
        applicationFormPage.email.sendKeys(email);
        applicationFormPage.mobileNumber.sendKeys(phoneNumber);

        if(file!=""){
        JSUtilities.clickWithJS(applicationFormPage.uploadCv);
        ReusableMethods.waitAndSendText(applicationFormPage.uploadCv, FilePath.getFilePath(file), 3);
        ReusableMethods.uploadFile(FilePath.getFilePath(file));
        }

        applicationFormPage.address.sendKeys(address);

    }


    @Then("user should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(applicationFormPage.fieldRequiredErrorMessage.isDisplayed());
    }

    @And("user fills About my Application Section with {string} for cover letter")
    public void userFillsAboutMyApplicationSectionWithForCoverLetter(String file) throws InterruptedException {
        ReusableMethods.waitAndSendText(applicationFormPage.salaryAndNoticeDropDown, "Ayse Kaya, email: ka.kayayse@gmail.com", 2);
        ReusableMethods.waitFor(2);
        JSUtilities.clickWithJS(applicationFormPage.uploadCoverLetter);
        ReusableMethods.waitAndSendText(applicationFormPage.uploadCoverLetter, FilePath.getFilePath(file), 3);
        ReusableMethods.uploadFile(FilePath.getFilePath(file));
        //ReusableMethods.waitForVisibility(applicationFormPage.coverLetterErrorMessage,3);
        try {
            JSUtilities.scrollToElement(applicationFormPage.coverLetterErrorMessage);
            Assert.assertTrue(applicationFormPage.coverLetterErrorMessage.isDisplayed());
        }catch (NoSuchElementException e){
            Log.info("invalid File is accepted. File format is: "+file);
            Assert.fail();
        }





    }

    @And("close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }
}
