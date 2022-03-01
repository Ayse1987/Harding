package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class CreateShoppingList {
    public CreateShoppingList(){
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(xpath = "//*[text()='Create a List']")
                public WebElement creatListInDropDown;

    @FindBy(id = "createList-announce")
    public WebElement createListInPage;

    @FindBy(id = "list-name")
    public WebElement listNameBox;

    @FindBy(xpath = "//*[text()='Create List']")
    public WebElement createListFinal;

    @FindBy(id = "profile-list-name")
    public WebElement createdShoppingList;

    @FindBy(id = "overflow-menu-popover-trigger")
    public WebElement moreMenuInShoppingListPage;

    @FindBy(id = "editYourList")
    public WebElement manageList;

    @FindBy(xpath = "//span[text()='Delete list']")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[@id='list-delete-confirm-announce']")
    public WebElement yesToDeleteShoppingList;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> productList;

    @FindBy(id="add-to-wishlist-button-submit")
    public WebElement addToListDropDown;

    @FindBy(xpath = "//*[text()='View Your List']")
    public WebElement viewYourList;

    @FindBy(xpath = "//a[text()='Tillamook Sharp Cheddar Cheese, 8 oz (Packaging May Vary)']")
    public WebElement productAddedToList;

    @FindBy(xpath = "//input[@name='submit.deleteItem']")
    public WebElement deleteProductButton;

    @FindBy(xpath="//div[text()='Deleted']")
    public WebElement ProductDeletedExpression;

}
