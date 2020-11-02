package common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static constants.Constants.*;

public class CommonPageSteps {

    public static final String URL = "https://jdi-framework.github.io/tests/index.htm";
    private final BaseClass base;

    public CommonPageSteps(BaseClass base) {
        this.base = base;
    }

    @Given("^Page opened$")
    public void page_opened() {
        base.driver.get(URL);
        base.driver.manage().window().maximize();
        Assert.assertEquals(base.driver.getTitle(), "Index Page");
    }

    @And("^Pressed button with user icon$")
    public void pressIcon() {
        WebElement element = base.driver.findElement(By.xpath(userIcon));
        element.click();
    }

    @And("^Entered text \"([^\"]*)\" to the field \"([^\"]*)\"$")
    public void inputWithNameText(String login, String password) {
        base.driver.findElement(By.cssSelector(loginForm)).sendKeys(login);
        base.driver.findElement(By.cssSelector(passwordForm)).sendKeys(password);
    }

    @And("^Pressed element with value 'Enter'$")
    public void pressElementWithValueEnter() {
        WebElement element = base.driver.findElement(By.xpath(enterButton));
        element.click();
    }
}
