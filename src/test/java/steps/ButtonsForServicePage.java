package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class ButtonsForServicePage extends Hooks {
    @Before
    public void startBrowser() {
        setUp();
    }

    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
        driver.findElement((By.cssSelector("a[href*='page1.htm'].dropdown-toggle"))).click();
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        WebElement element = driver.findElement(By.cssSelector(".dropdown-menu>li"));
        assertTrue(element.isDisplayed());
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
        driver.findElement((By.cssSelector(".sidebar-menu .sub-menu"))).click();
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        WebElement element = driver.findElement(By.cssSelector(".sub>li"));
        assertTrue(element.isDisplayed());
    }

    @After
    public void closeBrowser() {
        turnOff();
    }
}
