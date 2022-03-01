package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/parallel2-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},

        tags = "@readStates2",

        features="src/test/resources/uiFeatures",

        glue="ui/stepDef",

        dryRun=false

)

public class ParallelTestRunner2 {
}
