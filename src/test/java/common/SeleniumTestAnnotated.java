//package common;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//public class SeleniumTestAnnotated {
//    protected  WebDriver driver;
//
//    @BeforeSuite
//    public void setUpSuite() {
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
//    }
//
//    @BeforeTest
//    public void setUpTest() {
////        driver = new ChromeDriver();
////        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
//    }
//
//    @BeforeMethod
//    public void setUpMethod() {
//        System.out.println(driver.getTitle());
//    }
//
//    @AfterMethod
//    public void shutDownMethod() {
//        if (driver.toString().contains("null")) {
//            driver.quit();
//        }
//    }
//
//    @AfterTest
//    public void shutDownTest() {
//        System.out.println(System.currentTimeMillis());
//    }
//
//    @AfterSuite
//    public void shutDownSuite() {
//        driver.close();
//    }
//
////    @Test
////    public void test() {
////        driver.manage().window().maximize();
////        driver.navigate().to("https://epam.com");
////        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
////        WebElement element = driver.findElement(By.cssSelector(".header-search__button"));
////        element.click();
////    }
//}
