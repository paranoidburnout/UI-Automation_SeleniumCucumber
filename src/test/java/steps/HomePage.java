package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomePage extends Hooks {
    @Before
    public void startBrowser() {
        setUp();
    }

    @When("^User open the home page$")
    public void openHomePage() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @Then("^4 images was displayed$")
    public void checkImagesExistence() {
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon span"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }
    }

    @And("^4 text was displayed below 4 Icons$")
    public void checkTextBelowIcons() {
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
    }

    @And("^Main title text center was displayed$")
    public void checkMainTitleTextCenter() {
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(@class, 'main-title text-center')]")).isDisplayed());
    }

    @And("^Below main title text center was displayed$")
    public void checkBelowMainTitleTextCenter() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@class, 'main-txt text-center')]")).isDisplayed());
    }

    @After
    public void closeBrowser() {
        turnOff();
    }
}
