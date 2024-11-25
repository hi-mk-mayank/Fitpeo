package com.fitpeo.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\MKESARWA\\OneDrive - Capgemini\\Desktop\\selenium\\Fitpeo\\FeatureFiles\\Test.feature",
    glue = "com.fitpeo.stepDef",
    plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class TestRunner {
}

	