package authorization;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constants.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseClass {
    private final BaseClass base;

    public LoginPage(BaseClass base) {
        this.base = base;
    }

    @When("^User pressed button with user icon$")
    public void pressIcon() {
        WebElement element = base.driver.findElement(By.xpath(userIcon));
        element.click();

    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String login, String password) {
        base.driver.findElement(By.cssSelector(loginForm)).sendKeys(login);
        base.driver.findElement(By.cssSelector(passwordForm)).sendKeys(password);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        WebElement element = base.driver.findElement(By.xpath(enterButton));
        element.click();

    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        WebElement element = base.driver.findElement(By.xpath(userName));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
    }
}

