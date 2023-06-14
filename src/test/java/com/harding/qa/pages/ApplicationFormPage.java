package com.harding.qa.pages;

import com.harding.qa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationFormPage {
    public  ApplicationFormPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @CacheLookup
    @FindBy(css = "#ApplicantDetailsControl")
    public WebElement personalDetailsForm;

    @CacheLookup
    @FindBy(name = "ApplicantFirstName")
    public WebElement firstName;

    @CacheLookup
    @FindBy(name = "ApplicantSurname")
    public WebElement surname;

    @CacheLookup
    @FindBy(name = "ApplicantEmail")
    public WebElement email;

    @CacheLookup
    @FindBy(name = "ApplicantMobile")
    public WebElement mobileNumber;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='fa fa-upload'])[1]")
    public  WebElement uploadCv;

    @CacheLookup
    @FindBy(name = "ApplicantMunicipality")
    public WebElement address;

    @CacheLookup
    @FindBy(id = "btnCreateApplication")
    public  WebElement nextButton;


    @FindBy(xpath = "//div[@class='circle-loader load-complete']")
    public WebElement successMessage;

    @CacheLookup
    @FindBy(name = "6ff4a8a3-9a51-4ef5-9e8f-32d2da1bf8c4")
    public WebElement genderDropDown;

    @CacheLookup
    @FindBy(name = "ee813448-841b-4e59-9fb0-bf5370b4c419")
    public WebElement ageDropDown;

    @CacheLookup
    @FindBy(name = "1c114711-53f1-4cad-9277-7bd245050327")
    public WebElement nationalityDropDown;

    @CacheLookup
    @FindBy(name = "202fd5a2-dbba-4a3d-a260-09a0d9cdb4a5")
    public WebElement ethnicityDropDown;

    @CacheLookup
    @FindBy(name = "03470c0d-262d-41d5-96de-93b2e43000d1")
    public WebElement religionDropDown;

    @CacheLookup
    @FindBy(name = "c94e8d99-6e94-4e6e-aced-768882667dcd")
    public WebElement disabilitySectionDropDown;

    @CacheLookup
    @FindBy(name = "9569d2ef-4239-4209-9894-552131170269")
    public WebElement sexualOrientationDropDown;

    @CacheLookup
    @FindBy(name = "c730862c-6db4-44dd-b477-27c47b4cd8e9")
    public WebElement salaryAndNoticeDropDown;

    @CacheLookup
    @FindBy(name = "c5eff365-f289-4ac0-b5da-8d335b37755e")
    public WebElement rightToWorkRadioButton;

    @CacheLookup
    @FindBy(name = "917887de-cddd-423f-bfaa-d9977b6d3b52")
    public WebElement confirmGivenDetailsRadioButton;

    @CacheLookup
    @FindBy (name = "f53a5f5f-f2db-4278-aefe-a31fe919c572")
    public WebElement confirmPrivacyPolicyRadioButton;

    @CacheLookup
    @FindBy(name = "e191c33c-85c9-45c9-b297-2dd12e723eb4")
    public WebElement givingConsentToHardingRadioButton;

    @CacheLookup
    @FindBy(css = "button[class='btn btn btn-success complete-application-form']")
    public WebElement submitApplicationButton;

    @CacheLookup
    @FindBy(id = "ApplicationCompleted")
    public WebElement applicationCompletedExpression;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='fa fa-upload'])[2]")
    public WebElement uploadCoverLetter;

    @CacheLookup
    @FindBy(css = "label[class='error']")
    public WebElement fieldRequiredErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//h3[text()='Upload error']")
    public WebElement coverLetterErrorMessage;










}
