package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class AddToCart {
    public AddToCart(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span[@class='a-price']")
    public List<WebElement> productsToAddToBasket;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id = "nav-cart-count")
    public WebElement navToCart;

    @FindBy(id = "sc-subtotal-amount-buybox")
    public WebElement totalPriceInCart;

    @FindBy(id = "attach-close_sideSheet-link")
    public WebElement crossSignInCart;


}
