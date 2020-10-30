package functionality;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckboxesFunctionalityOnServicePage extends BaseClass {
    private BaseClass base;

    public CheckboxesFunctionalityOnServicePage(BaseClass base) {
        this.base = base;
    }

    public static String labelCheckbox = "//*[@class = 'label-checkbox']";
    public static String labelRadio = "//*[@class = 'label-radio']";
    public static String uuiFormElement = "//select[@class = 'uui-form-element']";
    public static String yellow = "//*[@class = 'uui-form-element']/option[contains(., 'Yellow')]";
    public static String panelBodyListLogs = "//*[@class='panel-body-list logs']/li";

    @And("^Checkbox \"([^\"]*)\" elements have been selected$")
    public void selectEarthElement(String element) {
        List<WebElement> list = base.driver.findElements(By.xpath(labelCheckbox));
        WebElement water = list.stream().filter(e -> e.getText().contains(element)).findFirst().get();
        water.click();
    }

    @And("^Radio \"([^\"]*)\" element has been selected$")
    public void selectRadio(String radio) {
        List<WebElement> list = base.driver.findElements(By.xpath(labelRadio));
        WebElement selen = list.stream().filter(e -> e.getText().contains(radio)).findFirst().get();
        selen.click();
    }

    @And("^In dropdown Yellow element has been selected$")
    public void selectDropdown() {
        base.driver.findElement((By.xpath(uuiFormElement))).click();
        base.driver.findElement((By.xpath(yellow))).click();
    }

    @Then("^In logs panel \"([^\"]*)\" status changed to \"([^\"]*)\"$")
    public void inLogsPanelWaterStatusChangedToTrue(String water, boolean status) {
        Assert.assertTrue(status);
        List<WebElement> list = base.driver.findElements(By.xpath(panelBodyListLogs));
        status = list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(water));
    }

    @And("^Panel \"([^\"]*)\" status changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelWindStatusChangesToTrue(String wind, boolean status) {
        Assert.assertTrue(status);
        List<WebElement> list = base.driver.findElements(By.xpath(panelBodyListLogs));
        status = list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(wind));
    }

    @And("^In logs panel \"([^\"]*)\" value changed to \"([^\"]*)\"$")
    public void inLogsPanelMetalsValueChangedToBronze(String bronze, String typeValue) {
        List<WebElement> list = base.driver.findElements(By.xpath(panelBodyListLogs));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(bronze)));
    }

    @And("^Panel \"([^\"]*)\" value changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelColorsValueChangedToYellow(String yellow, String typeValue) {
        List<WebElement> list = base.driver.findElements(By.xpath(panelBodyListLogs));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(yellow)));
    }

}
