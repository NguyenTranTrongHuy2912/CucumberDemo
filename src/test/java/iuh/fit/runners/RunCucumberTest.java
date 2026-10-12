package iuh.fit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "iuh.fit.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html"
        }
)
public class RunCucumberTest {

}