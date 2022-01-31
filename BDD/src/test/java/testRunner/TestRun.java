package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//features/Customers.feature",
        glue= {"stepDefinition"},
        monochrome=true,
        dryRun = false,
        plugin= {"pretty","json:target/JSONReports"})
public class TestRun {

}
