package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void  setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void turnOff() {
        driver.close();
    }
}
