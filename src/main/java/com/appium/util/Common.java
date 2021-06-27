package com.appium.util;

import static com.appium.util.enums.Config.COMMON;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appium.util.enums.Config;

public class Common {
	private static final Logger LOGGER = LoggerFactory.getLogger(Common.class);
	private static HashMap<Config, Object> CONFIGS = new HashMap<>();

	public static Configuration getConfig(Config config) {
		if (!CONFIGS.containsKey(config) || CONFIGS.get(config) == null) {
			loadConfiguration(config);
		}
		return (Configuration) CONFIGS.get(config);
	}

	private static void loadConfiguration(Config config) {
		try {
			Configuration configuration = loadResources(config.value());
			CONFIGS.putIfAbsent(config, configuration);
			LOGGER.info("Configuration Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Configuration loadResources(String propertiesFile) {
		Parameters params = new Parameters();
		propertiesFile = propertiesFile + ".properties";
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
				PropertiesConfiguration.class).configure(params.properties().setFileName(propertiesFile));
		Configuration config = null;
		try {
			config = builder.getConfiguration();
		} catch (ConfigurationException cex) {
			cex.printStackTrace();
		}
		return config;
	}

	public static File loadExtentConfig() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File resourceDir = new File(classpathRoot, getConfig(COMMON).getString("REPORT_CONFIG_PATH"));
		return new File(resourceDir, getConfig(COMMON).getString("REPORT_FILE_NAME"));
	}
}
