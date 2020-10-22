package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseTest {

    @Before
    public void startBrowser() {
        setUp();
    }

    @Given("^Page opened$")
    public void page_opened() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @When("^User pressed button with user icon$")
    public void pressIcon() {
        WebElement element = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        element.click();
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        driver.findElement(By.xpath("//*[@id='" + input + "']")).sendKeys(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        WebElement element = driver.findElement(By.xpath("//button/i[@class='fa fa-sign-in']"));
        element.click();
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        WebElement element = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Index Page");
    }

    @After
    public void closeBrowser() {
        turnOff();
    }
}

