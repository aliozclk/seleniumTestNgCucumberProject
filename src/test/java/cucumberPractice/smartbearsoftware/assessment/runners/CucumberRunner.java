package cucumberPractice.smartbearsoftware.assessment.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports/cucumber.html"},
        features = "src/test/java/cucumberPractice/smartbearsoftware/features",
        glue = "cucumberPractice/smartbearsoftware/assessment/stepDefinitions",
        dryRun = false
)

public class CucumberRunner {
}
