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

    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        base.driver.findElement((By.cssSelector("a[href*='page1.htm'].dropdown-toggle"))).click();
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        WebElement element = base.driver.findElement(By.cssSelector(".dropdown-menu>li"));
        assertTrue(element.isDisplayed());
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        base.driver.findElement((By.cssSelector(".sidebar-menu .sub-menu"))).click();
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        WebElement element = base.driver.findElement(By.cssSelector(".sub>li"));
        assertTrue(element.isDisplayed());
    }

}
