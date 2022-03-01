package ui.stepDef;

import io.cucumber.java.en.When;
import org.junit.Assert;
import ui.pages.AllMenu;
import ui.utilities.ReusableMethods;

public class US_03_StepDef {
    AllMenu allMenu=new AllMenu();

    @When("click All menu")
    public void click_all_menu() {
        allMenu.allMenu.click();


    }
    @When("click {string} department")
    public void click_department(String departmentName) {
        allMenu.smartHome.click();

    }
    @When("Verify that there are {int} subcategories under the {string} department")
    public void verify_that_there_are_subcategories_under_the_department(int int1, String departmentName) {
        int actualSize=ReusableMethods.getElementsText(allMenu.smartHomeSubCategory).size();
        System.out.println(ReusableMethods.getElementsText(allMenu.smartHomeSubCategory));
        Assert.assertEquals(int1,actualSize);

    }


}
