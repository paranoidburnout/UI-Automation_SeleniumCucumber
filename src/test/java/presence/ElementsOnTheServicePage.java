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

public class ElementsOnTheServicePage extends BaseClass {
    public static final String URL_DIFF_ELEMENT_PAGES = "https://jdi-framework.github.io/tests/page8.htm";
    private final BaseClass base;

    public ElementsOnTheServicePage(BaseClass base) {
        this.base = base;
    }

    @When("^User opened through the header menu Service -> Different Elements Page$")
    public void openDifferentElementsPage() {
        WebElement element = base.driver.findElement((By.xpath(pageService)));
        element.click();
        base.driver.findElement((By.cssSelector(differentElementPage)));
        element.click();
        base.driver.get(URL_DIFF_ELEMENT_PAGES);
        base.driver.manage().window().maximize();
    }

    @Then("^4 radios was displayed$")
    public void check4RadiosOnServicePage() {
        List<WebElement> radios = base.driver.findElements(By.xpath(labelRadio));
        Assert.assertEquals(radios.size(), 4);
        for (WebElement radio : radios) {
            Assert.assertTrue(radio.isDisplayed());
        }
    }

    @And("^Interface on Service page contain 4 checkboxes was displayed$")
    public void check4CheckboxesOnServicePage() {
        List<WebElement> checkboxes = base.driver.findElements(By.xpath(labelCheckbox));
        assertEquals(checkboxes.size(), 4);
        for (WebElement check : checkboxes) {
            assertTrue(check.isDisplayed());
        }
    }


    @And("^Dropdown was displayed$")
    public void checkDropdownOnServicePage() {
        WebElement element = base.driver.findElement(By.xpath(uuiFormElement));
        assertTrue(element.isDisplayed());
    }

    @And("^2 - buttons was displayed$")
    public void buttons2OnServicePage() {
        List<WebElement> buttons = base.driver.findElements(By.cssSelector(uuiButtons));
        assertEquals(buttons.size(), 2);
        for (WebElement but : buttons) {
            assertTrue(but.isDisplayed());
        }
    }

    @And("^Left section was displayed$")
    public void leftSectionOnServicePage() {
        WebElement element = base.driver.findElement(By.xpath(leftSection));
        assertTrue(element.isDisplayed());
    }

    @And("^Right section was displayed$")
    public void rightSectionOnServicePage() {
        WebElement element = base.driver.findElement(By.xpath(rightSection));
        assertTrue(element.isDisplayed());
    }
}
