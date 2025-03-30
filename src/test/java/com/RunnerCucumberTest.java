package com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.steps",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        monochrome = true,
        tags = "@login"
)
public class RunnerCucumberTest {
    
}
