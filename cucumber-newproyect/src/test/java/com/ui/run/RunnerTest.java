package com.ui.run;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/Login.feature"},
        glue = {"com.ui.steps"},
        tags = {"not @tag", "@wip"},
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        monochrome = true)
public class RunnerTest {
}

