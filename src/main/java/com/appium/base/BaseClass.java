package com.appium.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.configuration2.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appium.util.Common;
import com.appium.util.enums.Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClass.class);
	protected static AppiumDriver<MobileElement> driver;
	protected static WebDriverWait wait;
	private Configuration commonConfig = Common.getConfig(Config.COMMON);
	private Configuration androidConfig = Common.getConfig(Config.ANDROID);

	public static void swipeDown() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		LOGGER.debug("Height" + height);

		int x = 15;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		TouchAction ts = new TouchAction(driver);
		ts.press(new PointOption().withCoordinates(x, top_y)).moveTo(new PointOption().withCoordinates(x, bottom_y))
				.release().perform();
		LOGGER.info("Swipe Down action performed");
	}

	public static void swipeUp() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		LOGGER.debug("Height" + height);
		int x = 15;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		TouchAction ts = new TouchAction(driver);
		ts.press(new PointOption().withCoordinates(x, bottom_y)).moveTo(new PointOption().withCoordinates(x, top_y))
				.release().perform();
		LOGGER.info("Swipe Up action performed");
	}

	public void loadDriver() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		LOGGER.debug("classpathRoot: " + classpathRoot);

		File appDir = new File(classpathRoot, androidConfig.getString("APK_DIR"));
		LOGGER.debug("appDir: " + appDir);

		File app = new File(appDir, androidConfig.getString("APK_NAME"));
		LOGGER.debug("app: " + app);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonConfig.getString("PLATFORM_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				commonConfig.getString("PLATFORM_VERSION"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonConfig.getString("DEVICE_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, commonConfig.getString("UDID"));
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
				commonConfig.getInt("NEW_COMMAND_TIMEOUT"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		desiredCapabilities.setCapability("appPackage", androidConfig.getString("APP_PACKAGE"));
		desiredCapabilities.setCapability("appActivity", androidConfig.getString("APP_ACTIVITY"));
		try {
			URL url = new URL(commonConfig.getString("DRIVER_URL"));
			driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
			LOGGER.info("Driver initialized");
			wait = new WebDriverWait(driver, commonConfig.getInt("TIMEOUT"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
				LOGGER.info("Driver closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error:" + e.getMessage());
		}
	}

	public void waitUntilElementIsVisible(By locator) {
		LOGGER.info("Wait for the Element to be Visible: " + locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitUntilElementIsClickable(By locator) {
		LOGGER.info("Wait for the Element to be Clickable: " + locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public MobileElement getWebElement(By byLocator) {
		LOGGER.debug("Get Element: " +byLocator);
		return driver.findElement(byLocator);
	}

	public String getDateAndTime() {
		Date date = new Date();
		long timeMilli = date.getTime();
		String strDate = Long.toString(timeMilli);
		return strDate;
	}
}
