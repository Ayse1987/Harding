package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class AllMenu {
    public AllMenu(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//span[text()='All'])[2]")
    public WebElement allMenu;

    @FindBy(xpath = "//div[text()='Smart Home']")
    public WebElement smartHome;

    @FindBy (xpath = "//ul[@data-menu-id='7']//li//a[@class='hmenu-item']")
    public List<WebElement> smartHomeSubCategory;


    }

