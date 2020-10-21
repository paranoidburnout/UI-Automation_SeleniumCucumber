package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CommonPageSteps {
    private WebDriver driver;

    @Given("^Page opened$")
    public void openLink() throws Throwable {
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @And("^Pressed button with user icon$")
    public void pressIcon() {
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
    }

    @And("^Entered text \"([^\"]*)\" to the field \"([^\"]*)\"$")
    public void login(String value, String fieldName) {
        driver.findElement(By.xpath("//*[@id='" + fieldName + "']")).sendKeys(value);
    }

    @And("^Pressed element with value 'Enter'$")
    public void pressEnter() {
        driver.findElement(By.xpath("//button/i[@class='fa fa-sign-in']")).click();
    }

}
