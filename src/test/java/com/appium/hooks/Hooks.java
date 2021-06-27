package com.appium.hooks;

import static com.google.common.io.Files.copy;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appium.base.BaseClass;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Ankit Gulati");
		Reporter.addScenarioLog("Starting execution of : " + scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_") + getDateAndTime() + ".png";
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
				File destinationCopyPath = new File("TestReport/srcnshot/" + screenshotName);

				// Copy taken screenshot from source location to destination location
				copy(sourcePath, destinationCopyPath);
				File destinationReportPath = new File("srcnshot/" + screenshotName);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationReportPath.toString());
				LOGGER.error("Screenshot taken");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("Tear Down called");
		tearDown();
	}
}
