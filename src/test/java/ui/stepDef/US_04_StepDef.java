package ui.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.pages.SearchPage;
import ui.utilities.ReusableMethods;

import javax.swing.text.Utilities;
import java.util.List;

public class US_04_StepDef {

    SearchPage searchPage=new SearchPage();

    @When("enter {string} into search box")
    public void enter_into_search_box(String whatToSearch) {
        searchPage.searchBox.sendKeys(whatToSearch);
        ReusableMethods.waitFor(3);

    }
    @When("click the search button")
    public void click_the_search_button() {
       searchPage.searchSubmitButton.click();
       ReusableMethods.waitForPageToLoad(2);

    }
    @Then("verify that all the products listed includes {string}")
    public void verify_that_all_the_products_listed_includes(String searchedItem) {
        int count=0;
        for(WebElement w:searchPage.searchResultList){
            System.out.println(w.getText());
            if(!w.getText().contains(searchedItem)){
                count++;
            }
        }
        System.out.println(count);
        if(count==0){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }

}
