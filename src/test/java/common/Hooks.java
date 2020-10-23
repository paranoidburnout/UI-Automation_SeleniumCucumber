package common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks extends BaseClass {

    private BaseClass base;

    public Hooks(BaseClass base) {
        this.base = base;
    }

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        base.driver.close();
    }
}
