package com.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        tags = "not @Ignore",
        glue = "com.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html" ,
                "json:target/cucumber-reports/cucumber.json" ,
        }
)
public class RunCucumberTest {
}
