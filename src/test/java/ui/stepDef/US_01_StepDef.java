package ui.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;

public class US_01_StepDef {
    Logger log = (Logger) LogManager.getLogger(US_01_StepDef.class);
    @Given("go to the Amazon url")
    public void go_to_the_Amazon_url (){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        log.info("went to amazon url");

    }
    @Then("verify the page title")
    public void verify_the_page_title() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle=ConfigReader.getProperty("amazon_title");
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
