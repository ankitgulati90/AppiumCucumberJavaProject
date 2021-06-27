package com.appium.testRunner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.appium.util.AppiumServer;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = { "com/appium/stepDefinitions",
		"com/appium/hooks" }, tags = { "~@Ignore" }, plugin = { "pretty",
				"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:TestReport/CucumberReport.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void setUp() throws IOException {
		AppiumServer.start();
	}

	@AfterSuite
	public void tearDown() {
		AppiumServer.stop();
	}

}
