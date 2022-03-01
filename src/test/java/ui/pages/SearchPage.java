package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class SearchPage {
    public SearchPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchSubmitButton;

    @FindBy(xpath = "//*[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> searchResultList;

    @FindBy(id="a-autoid-0-announce")
    public WebElement sortByButton;

    @FindBy(xpath = "//a[text()='Price: Low to High']")
    public WebElement lowToHigh;

    @FindBy(xpath = "//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span[@class='a-price']")
    public List<WebElement> sortedItemList;
    //div[@class='a-row a-size-base a-color-base']
}
