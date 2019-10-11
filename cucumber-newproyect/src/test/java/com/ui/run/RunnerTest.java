package com.ui.run;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ui.driver.BaseDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/Login.feature"},
        glue = {"com.ui.steps"},
        tags = {"not @tag"},
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        monochrome = true)
public class RunnerTest {

    static BaseDriver bd = new BaseDriver();

    @BeforeClass
    public static void iniciarDriver() throws MalformedURLException, Exception {
        bd.inicializarDriver();
        Thread.sleep(5000);
    }

    @AfterClass
    public static void CerrarDriver() {
        bd.endDriver();
    }
}

