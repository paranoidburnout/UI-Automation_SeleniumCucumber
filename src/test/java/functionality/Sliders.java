package functionality;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static constants.Constants.*;

public class Sliders extends BaseClass {
    public static final String URL_DATES = " https://jdi-framework.github.io/tests/page4.htm";
    private final BaseClass base;

    public Sliders(BaseClass base) {
        this.base = base;
    }

    Integer sliderL;
    Integer sliderR;

    @And("^Opened through the left menu Service -> Dates$")
    public void openedServiceAndDatesPages() {
        WebElement element = base.driver.findElement((By.xpath(pageService)));
        element.click();
        base.driver.findElement((By.xpath(pageDates)));
        element.click();
        base.driver.get(URL_DATES);
        base.driver.manage().window().maximize();
    }

    @When("User clicked on the left slider and drag it to {int}")
    public void movingTheLeftSlider(int sliderLeft) {
        sliderL = sliderLeft;
        WebElement left = base.driver.findElement(By.cssSelector(leftSlider));
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", left);
        Actions actions = new Actions(base.driver);
        actions.dragAndDropBy(left, -276, 0).build().perform();
        actions.dragAndDropBy(left, (int) ((sliderLeft * 2.64)), 0).build().perform();
    }

    @And("On the right slider and drag it to {int} user clicked")
    public void movingTheRightSlider(int sliderRight) {
        sliderR = sliderRight;
        WebElement right = base.driver.findElement(By.cssSelector(rightSlider));
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", right);
        int currentPercentage = Integer.parseInt(right.getText());
        int diff = currentPercentage - sliderRight;
        Actions actions = new Actions(base.driver);
        actions.dragAndDropBy(right, (int) ((-(diff) * 2.64)), 0).build().perform();
        int newCurrentPercentage = Integer.parseInt(right.getText());
        if (newCurrentPercentage > sliderRight) {
            while (true) {
                actions.dragAndDropBy(right, -5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        } else if (newCurrentPercentage < sliderRight) {
            while (true) {
                actions.dragAndDropBy(right, 5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        }
    }

    @Then("The \"([^\"]*)\" slider has been successfully moved$")
    public void sliderHasBeenSuccessfullyMoved(String slider) {
        WebElement left = base.driver.findElement(By.cssSelector(leftSlider));
        WebElement right = base.driver.findElement(By.cssSelector(rightSlider));
        switch (slider) {
            case "left":
                Objects.equals(left.getText(), sliderL.toString());
                break;
            case "right":
                Objects.equals(right.getText(), sliderR.toString());
                break;
        }
    }
}