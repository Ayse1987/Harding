package com.harding.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},


        tags = "@JobApplication",

        features="src/test/resources/hardingFeatures",

        glue= "com/harding/qa/stepDefinitions",

        dryRun=false

)
public class Runner {

}
