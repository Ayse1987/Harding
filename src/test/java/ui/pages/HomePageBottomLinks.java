package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class HomePageBottomLinks {
   public HomePageBottomLinks(){
       PageFactory.initElements(Driver.getDriver(),this);
   }
   @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> linksAtBottom;

   @FindBy(xpath = "(//img[@alt='Amazon Ads'])[2]")
    public WebElement amazonAdvertisingLogo;

   @FindBy(xpath = "(//img[@alt='Amazon Business'])[1]")
    public WebElement amazonBusinessLogo;

   @FindBy(xpath = "//tbody//td[3]//span[@class='navFooterDescText']")
    public List<WebElement>linksSubTitles;
}
