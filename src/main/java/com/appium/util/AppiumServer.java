package com.appium.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppiumServer.class);
	
	public static AppiumDriverLocalService service;

	public static void start() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		LOGGER.info("Appium Service Started");
		
	}

	public static void stop() {
		service.stop();
		LOGGER.info("Appium Service Stopped");
	}

}
