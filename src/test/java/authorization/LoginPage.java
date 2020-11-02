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

    public static final String INPUT_ID_LOCATOR = "//*[@id='%s']";

    @When("^User pressed button with user icon$")
    public void pressIcon() {
        clickElement(userIcon);
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        base.driver.findElement(By.xpath(String.format(INPUT_ID_LOCATOR, input))).sendKeys(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        clickElement(enterButton);
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        WebElement element = base.driver.findElement(By.xpath(userName));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
    }

    public void clickElement(String string) {
        WebElement element = base.driver.findElement(By.xpath(string));
        element.click();
    }
}

