package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions", "hook"},
        plugin = {"pretty", "html:target/cucumber-html-report/index.html", "json:target/cucumber.json"}
)
public class TestRunner {
}
