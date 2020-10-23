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

    @And("^Checkbox \"([^\"]*)\" elements have been selected$")
    public void selectEarthElement(String element) {
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class = 'label-checkbox']"));
        WebElement water = list.stream().filter(e -> e.getText().contains(element)).findFirst().get();
        water.click();
    }

    @And("^Radio \"([^\"]*)\" element has been selected$")
    public void selectRadio(String radio) {
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class = 'label-radio']"));
        WebElement selen = list.stream().filter(e -> e.getText().contains(radio)).findFirst().get();
        selen.click();
    }

    @And("^In dropdown Yellow element has been selected$")
    public void selectDropdown() {
        base.driver.findElement((By.xpath("//select[@class = 'uui-form-element']"))).click();
        base.driver.findElement((By.xpath("//*[@class = 'uui-form-element']/option[contains(., 'Yellow')]"))).click();
    }

    @Then("^In logs panel \"([^\"]*)\" status changed to \"([^\"]*)\"$")
    public void inLogsPanelWaterStatusChangedToTrue(String water, boolean status) {
        Assert.assertTrue(status);
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class='panel-body-list logs']/li"));
        status = list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(water));
    }

    @And("^Panel \"([^\"]*)\" status changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelWindStatusChangesToTrue(String wind, boolean status) {
        Assert.assertTrue(status);
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class='panel-body-list logs']/li"));
        status = list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(wind));
    }

    @And("^In logs panel \"([^\"]*)\" value changed to \"([^\"]*)\"$")
    public void inLogsPanelMetalsValueChangedToBronze(String bronze, String typeValue) {
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class='panel-body-list logs']/li"));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(bronze)));
    }

    @And("^Panel \"([^\"]*)\" value changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelColorsValueChangedToYellow(String yellow, String typeValue) {
        List<WebElement> list = base.driver.findElements(By.xpath("//*[@class='panel-body-list logs']/li"));
        typeValue = String.valueOf(list
                .stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.contains(yellow)));
    }

}
