package ui.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ui.pages.SearchPage;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class US_05_StepDef {
    SearchPage searchPage=new SearchPage();

    @When("click sort by button")
    public void click_sort_by_button() {
        searchPage.sortByButton.click();

    }
    @When("select Low to High")
    public void select_low_to_high() {
        searchPage.lowToHigh.click();

    }
    @Then("verify items are sorted correctly")
    public void verify_items_are_sorted_correctly() {
        ReusableMethods.waitFor(3);
        System.out.println(searchPage.sortedItemList.size());

        List<Integer>actualList=new ArrayList<>();
        for(WebElement w: searchPage.sortedItemList){
            System.out.println(w.getText());
           actualList.add(Integer.parseInt(w.getText().replaceAll("\\D","")));
        }
        System.out.println(actualList);

        List<Integer>ascendingList=new ArrayList<>();
        for(Integer w:actualList){
            ascendingList.add(w);
        }
        Collections.sort(ascendingList);
        System.out.println(ascendingList);
        Assert.assertEquals(ascendingList,actualList);
        }
    }

