package ui.stepDef;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.pages.AddToCart;
import ui.pages.SearchPage;
import ui.utilities.Driver;
import ui.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class US_06_StepDef {

    SearchPage searchPage=new SearchPage();
    AddToCart addToCart=new AddToCart();
    List<Integer> actualTotalPrice=new ArrayList<Integer>();
    Actions actions=new Actions(Driver.getDriver());
    @When("Select first three products and add them to basket")
    public void select_first_three_products_and_add_them_to_basket() {

       for(int i=0;i<=2;i++){

           actualTotalPrice.add(Integer.parseInt(searchPage.sortedItemList.get(i).
                   getText().replaceAll("\\D","")));
           searchPage.sortedItemList.get(i).click();
           ReusableMethods.waitForClickablility(addToCart.addToCartButton,3);
           actions.moveToElement(addToCart.addToCartButton).doubleClick().perform();
           ReusableMethods.waitFor(10);


           try {
               if(addToCart.crossSignInCart.isDisplayed()){
                   addToCart.crossSignInCart.click();
                   ReusableMethods.waitFor(2);
                   Driver.getDriver().navigate().back();
               }

           }catch(Exception e){
               Driver.getDriver().navigate().back();
               Driver.getDriver().navigate().back();

           }
           ReusableMethods.waitFor(2);

       }



    }
    @When("Navigate to basket page")
    public void navigate_to_basket_page() {
        addToCart.navToCart.click();
        ReusableMethods.waitFor(1);

    }
    @When("Verify the subtotal is correct")
    public void verify_the_subtotal_is_correct() {
        int expectedTotal=0;
        for(Integer w:actualTotalPrice){
            expectedTotal+=w;
        }
        int cartTotalPrice=Integer.parseInt(addToCart.totalPriceInCart.getText().replaceAll("\\D",""));
        //System.out.println(actualTotalPrice);
        System.out.println(expectedTotal);
        Assert.assertEquals(expectedTotal,cartTotalPrice);
    }

}
