package com.appium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appium.base.BaseClass;
import com.appium.locators.ProfileLocators;

import io.appium.java_client.MobileElement;

public class ProfilePageObjects extends BaseClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePageObjects.class);

	By done_BTN = By.id(ProfileLocators.BUTTON_DONE);
	By fullName_TXT = By.id(ProfileLocators.TEXT_FULL_NAME);
	By editName_BTN = By.id(ProfileLocators.BUTTON_EDIT_NAME);
	By mobileNumber_TXT = By.id(ProfileLocators.TEXT_MOBILE_NUMBER);
	By fullName_TXTBX = By.id(ProfileLocators.TEXT_FIELD_FULL_NAME);
	By submitPopUp_BTN = By.id(ProfileLocators.BUTTON_SUBMIT_POPUP);
	By updatePopUp_BTN = By.id(ProfileLocators.BUTTON_PROFILE_UPDATE);
	By englishFluency_BTN = By.id(ProfileLocators.BUTTON_EDIT_ENGLISH_LEVEL);
	By englishOptionLvl1_BTN = By.id(ProfileLocators.OPTION_ENGLISH_LEVEL_1);
	By englishOptionLvl2_BTN = By.id(ProfileLocators.OPTION_ENGLISH_LEVEL_2);
	By englishOptionLvl3_BTN = By.id(ProfileLocators.OPTION_ENGLISH_LEVEL_3);
	By englishOptionLvl4_BTN = By.id(ProfileLocators.OPTION_ENGLISH_LEVEL_4);
	By sucessBannerMsg_TXT = By.id(ProfileLocators.BANNER_UPDATE_SUCCESSFUL);
	By mobileNumber_TXTBX = By.id(ProfileLocators.TEXT_FIELD_MOBILE_NUMBER);

	public void clickOnDesiredSection(String value) {
		String desiredProfileSectionXpath = ProfileLocators.BUTTON_SECTION.replaceAll("INDEX", value);
		waitUntilElementIsClickable(By.xpath(desiredProfileSectionXpath));

		getWebElement(By.xpath(desiredProfileSectionXpath)).click();
		LOGGER.info("Select Desired Profile Section");
	}

	public void selectMyProfileOption() {
		String myProfileSectionXpath = ProfileLocators.OPTION_PROFILE.replaceAll("INDEX", "My Profile");
		waitUntilElementIsClickable(By.xpath(myProfileSectionXpath));

		getWebElement(By.xpath(myProfileSectionXpath)).click();
		LOGGER.info("Select My Profile option");
	}

	public void clickEnglishFluencyBtn() {
		waitUntilElementIsClickable(englishFluency_BTN);

		getWebElement(englishFluency_BTN).click();
		LOGGER.info("English Fluency Button clicked");
	}

	public void selectLevelOfEnglish(String value) {
		waitUntilElementIsVisible(englishOptionLvl3_BTN);
		MobileElement englishLevel;
		switch (value.toUpperCase().trim()) {
		case "NO ENGLISH":
			englishLevel = getWebElement(englishOptionLvl1_BTN);
			break;
		case "THODA ENGLISH":
			englishLevel = getWebElement(englishOptionLvl2_BTN);
			break;
		case "GOOD ENGLISH":
			englishLevel = getWebElement(englishOptionLvl3_BTN);
			break;
		case "FLUENT ENGLISH":
			englishLevel = getWebElement(englishOptionLvl4_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid english level provided");
		}
		LOGGER.info("Select the Level of English: " + value);
		englishLevel.click();
		LOGGER.info("Selected Option of English Level clicked");
	}

	public void clickPopUpButton() {
		getWebElement(submitPopUp_BTN).click();
		LOGGER.info("Pop up button clicked");
	}

	public boolean verifyUpdateProfileBtnDisplayed() {
		LOGGER.info("Verify updated Profile button is displayed");
		return getWebElement(updatePopUp_BTN).isDisplayed();
	}

	public boolean verifyUpdateProfileBtnIsEnabled() {
		LOGGER.info("Verify updated Profile button is enabled");
		return getWebElement(updatePopUp_BTN).isEnabled();
	}

	public void clickUpdateProfileButton() {
		getWebElement(updatePopUp_BTN).click();
		LOGGER.info("Update Pop up button is clicked");
	}

	public String getUpdateProfileMessage() {
		LOGGER.info("Fetch the text of successfull banner message");
		return getWebElement(sucessBannerMsg_TXT).getText();
	}

	public void clickEditBasicProfileButton() {
		waitUntilElementIsVisible(editName_BTN);
		getWebElement(editName_BTN).click();
	}

	public void setFullName(String value) {
		waitUntilElementIsVisible(fullName_TXTBX);
		LOGGER.info("Fetch the text of successfull banner message");
		getWebElement(fullName_TXTBX).sendKeys(value);
	}

	public void updateMobileNumber(String value) {
		waitUntilElementIsVisible(mobileNumber_TXTBX);
		LOGGER.info("Update the mobile number: " + value);
		getWebElement(mobileNumber_TXTBX).sendKeys(value);
	}

	public void clickDone() {
		waitUntilElementIsVisible(done_BTN);
		getWebElement(done_BTN).click();
		LOGGER.info("Done button is clicked");
	}

	public String getMobileNumberText() {
		waitUntilElementIsVisible(mobileNumber_TXT);
		LOGGER.info("Fetch the text of Mobile Number");
		return getWebElement(mobileNumber_TXT).getText();
	}

	public String getRealNameText() {
		waitUntilElementIsVisible(fullName_TXT);
		LOGGER.info("Fetch the text of Full Name");
		return getWebElement(fullName_TXT).getText();
	}

}
