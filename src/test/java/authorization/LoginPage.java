package authorization;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginPage {
    private WebDriver driver;
    @When("^User pressed button with user icon$")
    public void pressIcon() {
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        driver.findElement(By.xpath("//*[@id='" + input + "']")).sendKeys(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        driver.findElement(By.xpath("//button/i[@class='fa fa-sign-in']")).click();
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
//      "//*[contains(text(),'Piter Chailovskii')]"
        WebElement element = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
    }
}

