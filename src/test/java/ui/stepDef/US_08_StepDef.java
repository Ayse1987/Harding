package ui.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import ui.pages.CreateShoppingList;
import ui.pages.SignInPage;
import ui.utilities.Driver;
import ui.utilities.ReusableMethods;

public class US_08_StepDef {
    SignInPage signInPage=new SignInPage();
    CreateShoppingList createShoppingList=new CreateShoppingList();
    Actions actions=new Actions(Driver.getDriver());

    @Given("select Create a List from Account & Lists menu")
    public void select_Create_a_List_from_account_lists_menu() {
        actions.moveToElement(signInPage.hooverAccount).perform();
        createShoppingList.creatListInDropDown.click();
    }
    
    @Given("click create list button in page")
    public void click_create_list_button_in_page() {
        actions.moveToElement(createShoppingList.createListInPage).doubleClick().perform();
    }

    @Given("enter {string} to the List name box")
    public void enter_to_the_list_name_box(String listName) {
        createShoppingList.listNameBox.clear();
        createShoppingList.listNameBox.sendKeys(listName);
    }

    @Given("click create List button")
    public void click_create_list_button() {
        actions.moveToElement(createShoppingList.createListFinal).doubleClick().perform();
        ReusableMethods.waitFor(3);
    }

    @Given("verify that {string} is created")
    public void verify_that_is_created(String listName) {
        Assert.assertTrue(createShoppingList.createdShoppingList.getText().contains(listName));
    }

    @Given("click Manage List from More menu")
    public void click_Manage_List_from_more_menu() {
        actions.moveToElement(createShoppingList.moreMenuInShoppingListPage).doubleClick().perform();
        createShoppingList.manageList.click();
        ReusableMethods.waitFor(1);
    }

    @Given("click Delete list button")
    public void click_delete_list_button() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        actions.moveToElement(createShoppingList.deleteButton).doubleClick().perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(createShoppingList.yesToDeleteShoppingList).doubleClick().perform();
        ReusableMethods.waitFor(1);
    }

    @Then("verify the list is deleted")
    public void verify_the_list_is_deleted() {

        try{
          createShoppingList.createdShoppingList.isDisplayed();
                Assert.assertTrue(false);
        }catch(Exception e){
            Assert.assertTrue(true);
        }

    }

}
