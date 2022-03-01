package ui.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ui.pages.CreateShoppingList;
import ui.utilities.Driver;

public class US_09_StepDef {

    CreateShoppingList createShoppingList=new CreateShoppingList();
    Actions actions=new Actions(Driver.getDriver());
    String productName="";


      @Given("add the first product to {string}")
       public void add_the_first_product_to(String groceryList) {
          productName=createShoppingList.productList.get(0).getText();
          System.out.println(productName);
        actions.doubleClick(createShoppingList.productList.get(0)).perform();
        //actions.doubleClick(createShoppingList.addToListDropDown).perform();
       createShoppingList.addToListDropDown.click();
       




   }
    @Given("verify the product in the list")
    public void verify_the_product_in_the_list() {
        Assert.assertTrue(productName.equals(createShoppingList.productAddedToList.getText()));

    }
    @And("clic view your list button")
    public void clicViewYourListButton() {
          createShoppingList.viewYourList.click();
    }
    @Given("click Remove button for added product")
    public void click_remove_button_for_added_product() {
          createShoppingList.deleteProductButton.click();

    }
    @Then("verify that product is removed")
    public void verify_that_product_is_removed() {
          Assert.assertTrue(createShoppingList.ProductDeletedExpression.isDisplayed());

    }


}
