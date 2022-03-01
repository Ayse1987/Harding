package ui.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.pages.HomePageBottomLinks;
import ui.utilities.Driver;
import ui.utilities.ReusableMethods;

import java.util.Locale;

public class US_07_StepDef {
    Actions actions=new Actions(Driver.getDriver());
    HomePageBottomLinks homePageBottomLinks=new HomePageBottomLinks();

    @Given("scroll down to the bottom of the home page")
    public void scroll_down_to_the_bottom_of_the_home_page() {
        actions.sendKeys(Keys.END).perform();

    }
    @Then("click the links in the second column and verifies page name")
    public void click_the_links_in_the_second_column_and_verifies_page_name() {
        int counter=0;
        String eachLinkAtBottom="";
        for(int i=0;i<homePageBottomLinks.linksAtBottom.size();i++){
           eachLinkAtBottom= homePageBottomLinks.linksAtBottom.get(i).getText().
                    replace(homePageBottomLinks.linksSubTitles.get(i).getText(),"").
                    replace("Amazon ","").toLowerCase().trim();
           homePageBottomLinks.linksAtBottom.get(i).click();
           //Driver.getDriver().manage().deleteAllCookies();
           String linkarr[]=eachLinkAtBottom.split(" ");
           if(Driver.getDriver().getTitle().toLowerCase().contains(linkarr[0])||Driver.getDriver().getCurrentUrl().toLowerCase().contains(linkarr[0])){
               counter++;
           }
           Driver.getDriver().navigate().back();
        }
        System.out.println(counter);

        Assert.assertTrue(counter==homePageBottomLinks.linksAtBottom.size());

    }
}
