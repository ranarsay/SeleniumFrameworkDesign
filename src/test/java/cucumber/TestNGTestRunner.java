package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber depends on testng or junit just for the runners
@CucumberOptions(features = "src/test/java/cucumber" , glue = "stepDefinitions", monochrome = true,
        plugin = {"html:target/cucumber.html"}, tags = "@ErrorValidations")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}
