package com;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    features = {"src/test/resources/features"},
    glue = {"com.steps"},
    monochrome = true,
    tags = "not @Ignore"
)
public class RunCucumberTest {
    
}
