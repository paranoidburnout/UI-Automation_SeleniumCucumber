package service_page;

import common.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class ButtonsForServicePage extends BaseClass {

private BaseClass base;
    public ButtonsForServicePage(BaseClass base){
        this.base = base;
    }
    public static String serviceHeader = "a[href*='page1.htm'].dropdown-toggle";
    public static String dropdownInTheHeader = ".dropdown-menu>li";
    public static String leftService = ".sidebar-menu .sub-menu";
    public static String dropdownInTheLeft = ".sub>li";

    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        base.driver.findElement((By.cssSelector(serviceHeader))).click();
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        WebElement element = base.driver.findElement(By.cssSelector(dropdownInTheHeader));
        assertTrue(element.isDisplayed());
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        base.driver.findElement((By.cssSelector(leftService))).click();
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        WebElement element = base.driver.findElement(By.cssSelector(dropdownInTheLeft));
        assertTrue(element.isDisplayed());
    }

}
