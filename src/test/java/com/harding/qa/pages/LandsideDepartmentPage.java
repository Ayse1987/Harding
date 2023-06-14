package com.harding.qa.pages;

import com.harding.qa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandsideDepartmentPage {

    public LandsideDepartmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "searchTerm")
    public WebElement searchBox;

    @FindBy(id = "btnSearch")
    public WebElement searchButton;

    @CacheLookup
    @FindBy(css = "h2 a[href='/job/414311']")
    public WebElement procurementCoordinatorJob;


    @FindBy(css = "div[class='pull-right pa-b'] a[class='btn btn-primary']")
    public WebElement applyButton;


}
