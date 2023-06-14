package com.harding.qa.pages;

import com.harding.qa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @CacheLookup
    @FindBy(id = "menu-item-dropdown-215")
    public WebElement careerMenuItem;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Landside']")
    public WebElement landsideDropdownItem;


}
