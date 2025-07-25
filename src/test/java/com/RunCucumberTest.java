package com;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.steps",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    tags = "@regression"
)
public class RunCucumberTest {
    
}
