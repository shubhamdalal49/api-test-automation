package com.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.api.stepdefinitions", "com.api.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
    // possibly tags = "@smoke" or similar
)
public class TestRunner extends AbstractTestNGCucumberTests {}
