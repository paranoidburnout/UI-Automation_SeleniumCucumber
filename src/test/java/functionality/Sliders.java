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

public class Sliders extends BaseClass {
    private BaseClass base;

    public Sliders(BaseClass base) {
        this.base = base;
    }

    Integer sliderL;
    Integer sliderR;

    @And("^Opened through the left menu Service -> Dates$")
    public void openedServiceAndDatesPages() {
        WebElement element = base.driver.findElement((By.xpath("//a/span[contains(text(),'Service')]")));
        element.click();
        base.driver.findElement((By.xpath("//a/p/span[contains(text(),'Dates')]")));
        element.click();
        base.driver.get(" https://jdi-framework.github.io/tests/page4.htm");
        base.driver.manage().window().maximize();
    }

    @When("User clicked on the left slider and drag it to {int}")
    public void movingTheLeftSlider(int sliderLeft) {
        sliderL = sliderLeft;
        WebElement left = base.driver.findElement(By.cssSelector("div:nth-child(2) > div > a:nth-child(1)"));
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", left);
        Actions actions = new Actions(base.driver);
        actions.dragAndDropBy(left, -276, 0).build().perform();
        actions.dragAndDropBy(left, (int) ((sliderLeft * 2.64)), 0).build().perform();
    }

    @And("On the right slider and drag it to {int} user clicked")
    public void movingTheRightSlider(int sliderRight) {
        sliderR = sliderRight;
        WebElement right = base.driver.findElement(By.cssSelector("div:nth-child(2) > div > a:nth-child(3)"));
        ((JavascriptExecutor) base.driver).executeScript("arguments[0].scrollIntoView(true);", right);
        int currentPercentage = Integer.parseInt(right.getText());
        int diff = currentPercentage - sliderRight;
        Actions actions = new Actions(base.driver);
        actions.dragAndDropBy(right, (int) ((-(diff) * 2.64)), 0).build().perform();
        int newCurrentPercentage = Integer.parseInt(right.getText());
        if (newCurrentPercentage > sliderRight) {
            while (newCurrentPercentage > sliderRight) {
                actions.dragAndDropBy(right, -5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        } else if (newCurrentPercentage < sliderRight) {
            while (newCurrentPercentage < sliderRight) {
                actions.dragAndDropBy(right, 5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        }
    }

    @Then("The \"([^\"]*)\" slider has been successfully moved$")
    public void leftSliderHasBeenSuccessfullyMoved(String slider) {
        WebElement left = base.driver.findElement(By.cssSelector("div:nth-child(2) > div > a:nth-child(1)"));
        WebElement right = base.driver.findElement(By.cssSelector("div:nth-child(2) > div > a:nth-child(3)"));
        switch (slider) {
            case "left":
                Objects.equals(left.getText(), sliderL);
                break;
            case "right":
                Objects.equals(left.getText(), sliderR);
                break;
        }
    }
}