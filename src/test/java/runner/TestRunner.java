package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
glue = {"common", "presence", "authorization", "service_page", "functionality"}
, tags = "@1"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
