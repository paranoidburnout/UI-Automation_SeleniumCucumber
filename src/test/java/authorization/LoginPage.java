package authorization;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseClass {
    private BaseClass base;

    public LoginPage(BaseClass base) {
        this.base = base;
    }

    @When("^User pressed button with user icon$")
    public void pressIcon() {
        WebElement element = base.driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        element.click();
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        base.driver.findElement(By.xpath("//*[@id='" + input + "']")).sendKeys(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        WebElement element = base.driver.findElement(By.xpath("//button/i[@class='fa fa-sign-in']"));
        element.click();
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        WebElement element = base.driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
        assertEquals(base.driver.getTitle(), "Index Page");
    }
}

