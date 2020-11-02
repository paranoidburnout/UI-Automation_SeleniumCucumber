package service_page;

import common.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constants.Constants.*;
import static org.testng.Assert.assertTrue;

public class ButtonsForServicePage extends BaseClass {

    private final BaseClass base;

    public ButtonsForServicePage(BaseClass base) {
        this.base = base;
    }

    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        clickElement(serviceHeader);
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        displayedElement(dropdownInTheHeader);
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        clickElement(leftService);
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        displayedElement(dropdownInTheLeft);
    }

    public void clickElement(String string) {
        base.driver.findElement((By.cssSelector(string))).click();
    }

    public void displayedElement(String string) {
        WebElement element = base.driver.findElement(By.cssSelector(string));
        assertTrue(element.isDisplayed());
    }
}
