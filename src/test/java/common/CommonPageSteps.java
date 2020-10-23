package common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonPageSteps extends BaseClass {

    private BaseClass base;

    public CommonPageSteps(BaseClass base) {
        this.base = base;
    }

    @Given("^Page opened$")
    public void page_opened() {
        base.driver.get("https://jdi-framework.github.io/tests/index.htm");
        base.driver.manage().window().maximize();
        Assert.assertEquals(base.driver.getTitle(), "Index Page");
    }

    @And("^Pressed button with user icon$")
    public void pressIcon() {
        WebElement element = base.driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        element.click();
    }

    @And("^Entered text \"([^\"]*)\" to the field \"([^\"]*)\"$")
    public void inputWithNameText(String value, String fieldName) {
        base.driver.findElement(By.xpath("//*[@id='" + fieldName + "']")).sendKeys(value);
    }

    @And("^Pressed element with value 'Enter'$")
    public void pressElementWithValueEnter() {
        WebElement element = base.driver.findElement(By.xpath("//button/i[@class='fa fa-sign-in']"));
        element.click();
    }
}
