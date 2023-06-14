package com.harding.qa.pages;

import com.harding.qa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandsideCareerPage {

    public LandsideCareerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(css = "a[class='btn btn-outline-primary btn-lg']")
    public WebElement seeVacanciesButton;
}
