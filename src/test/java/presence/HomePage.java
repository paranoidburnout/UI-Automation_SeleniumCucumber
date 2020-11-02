package presence;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static constants.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends BaseClass {

    public static final String URL = "https://jdi-framework.github.io/tests/index.htm";
    private final BaseClass base;

    public HomePage(BaseClass base) {
        this.base = base;
    }

    @When("^User open the home page$")
    public void openHomePage() {
        base.driver.get(URL);
        base.driver.manage().window().maximize();
    }

    @Then("^4 images was displayed$")
    public void checkImagesExistence() {
        List<WebElement> images = base.driver.findElements(By.cssSelector(imagesOnHomePage));
        Assert.assertEquals(images.size(), 4);
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed());
        }
    }

    @And("^4 text was displayed below 4 Icons$")
    public void checkTextBelowIcons() {
        List<WebElement> texts = base.driver.findElements(By.className(textsOnHomePage));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
    }

    @And("^Main title text center was displayed$")
    public void checkMainTitleTextCenter() {
        assertDis(mainTitleTextCenter);
    }

    @And("^Below main title text center was displayed$")
    public void checkBelowMainTitleTextCenter() {
        assertDis(belowMainTitleTextCenter);
    }

    public void assertDis(String string) {
        Assert.assertTrue(base.driver.findElement(By.xpath(string)).isDisplayed());
    }
}
