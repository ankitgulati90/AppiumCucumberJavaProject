package com.appium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appium.base.BaseClass;
import com.appium.locators.SignupLocators;

import io.appium.java_client.MobileElement;

public class SignUpPageObjects extends BaseClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpPageObjects.class);

	By pune_BTN = By.id(SignupLocators.BUTTON_PUNE);
	By delhi_BTN = By.id(SignupLocators.BUTTON_DELHI);
	By skills_BTN = By.id(SignupLocators.BUTTON_SKILLS);
	By course_BTN = By.id(SignupLocators.BUTTON_COURSE);
	By submit_BTN = By.id(SignupLocators.BUTTON_SUBMIT);
	By mumbai_BTN = By.id(SignupLocators.BUTTON_MUMBAI);
	By age_TXTBX = By.id(SignupLocators.TEXT_FIELD_AGE);
	By bengaluru_BTN = By.id(SignupLocators.BUTTON_BENGALURU);
	By maleGender_BTN = By.id(SignupLocators.BUTTON_GENDER_MALE);
	By citySubmit_BTN = By.id(SignupLocators.BUTTON_CITY_SUBMIT);
	By fullName_TXTBX = By.id(SignupLocators.TEXT_FIELD_FULL_NAME);
	By femaleGender_BTN = By.id(SignupLocators.BUTTON_GENDER_FEMALE);
	By fresher_BTN = By.id(SignupLocators.BUTTON_EXPERIENCE_FRESHER);
	By englishLvl1_BTN = By.id(SignupLocators.BUTTON_ENGLISH_LEVEL_1);
	By englishLvl2_BTN = By.id(SignupLocators.BUTTON_ENGLISH_LEVEL_2);
	By englishLvl3_BTN = By.id(SignupLocators.BUTTON_ENGLISH_LEVEL_3);
	By englishLvl4_BTN = By.id(SignupLocators.BUTTON_ENGLISH_LEVEL_4);
	By englishLang_BTN = By.id(SignupLocators.BUTTON_LANGUAGE_ENGLISH);
	By mediumHindi_BTN = By.id(SignupLocators.BUTTON_SCHOOL_MEDIUM_HINDI);
	By mediumOther_BTN = By.id(SignupLocators.BUTTON_SCHOOL_MEDIUM_OTHER);
	By mobileNumber_TXTBX = By.id(SignupLocators.TEXT_FIELD_MOBILE_NUMBER);
	By qualification10_BTN = By.id(SignupLocators.BUTTON_QUALIFICATION_10);
	By experienced_BTN = By.id(SignupLocators.BUTTON_EXPERIENCE_EXPERIENCED);
	By mediumEnglish_BTN = By.id(SignupLocators.BUTTON_SCHOOL_MEDIUM_ENGLISH);
	By skillPopUpSubmit_BTN = By.id(SignupLocators.BUTTON_SKILL_POPUP_SUBMIT);
	By nearestLocation_TXTBX = By.id(SignupLocators.TEXT_FIELD_NEAREST_LOCATION);
	By qualificationBelow10_BTN = By.id(SignupLocators.BUTTON_QUALIFICATION_BELOW_10);
	By qualificationAbove12_BTN = By.id(SignupLocators.BUTTON_QUALIFICATION_12_ABOVE);
	By qualificationGraduate_BTN = By.id(SignupLocators.BUTTON_QUALIFICATION_GRADUATE);
	By submitDetailedProfile_BTN = By.id(SignupLocators.BUTTON_SUBMIT_DETAILED_PROFILE);

	public void setFullName(String value) {
		getWebElement(fullName_TXTBX).sendKeys(value);
		LOGGER.info("Set the Full Name: " + value);
	}

	public void setMobileNumber(String value) {
		getWebElement(mobileNumber_TXTBX).sendKeys(value);
		LOGGER.info("Set the Mobile Number: " + value);
	}

	public void clickOnSubmit() {
		getWebElement(submit_BTN).click();
		LOGGER.info("Submit button is clicked");
	}

	public boolean isFullNameDisplayed() {
		LOGGER.info("Verify Full Name is displayed");
		return getWebElement(fullName_TXTBX).isDisplayed();

	}

	public boolean isMobileNumberDisplayed() {
		LOGGER.info("Verify Mobile Number is displayed");
		return getWebElement(mobileNumber_TXTBX).isDisplayed();
	}

	public boolean isSubmitButtonDisplayed() {
		LOGGER.info("Verify Submit button is displayed");
		return getWebElement(submit_BTN).isDisplayed();
	}

	public void selectCity(String value) {
		waitUntilElementIsVisible(pune_BTN);

		MobileElement cityButton;
		switch (value.toUpperCase().trim()) {
		case "MUMBAI":
			cityButton = getWebElement(mumbai_BTN);
			break;
		case "PUNE":
			cityButton = getWebElement(pune_BTN);
			break;
		case "DELHI":
			cityButton = getWebElement(delhi_BTN);
			break;
		case "BENGALURU":
			cityButton = getWebElement(bengaluru_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid city provided");
		}

		LOGGER.info("Select the City: " + value);
		cityButton.click();
		LOGGER.info("City button is clicked");
	}

	public void setNearestLocation(String value) {
		waitUntilElementIsVisible(nearestLocation_TXTBX);

		getWebElement(nearestLocation_TXTBX).sendKeys(value);
		LOGGER.info("Update the nearest Location: " + value);
	}

	public boolean verifyCitySubmitButtonDisplayed() {
		LOGGER.info("Verify City Submit button is displayed");
		return getWebElement(citySubmit_BTN).isDisplayed();
	}

	public boolean verifyCitySubmitButtonIsEnabled() {
		LOGGER.info("Verify City Submit button is Enabled");
		return getWebElement(citySubmit_BTN).isEnabled();
	}

	public void clickCitySubmitButton() {
		getWebElement(citySubmit_BTN).click();
		LOGGER.info("City Submit button is clicked");
	}

	public void selectGender(String value) {
		waitUntilElementIsVisible(femaleGender_BTN);

		MobileElement gender;
		switch (value.toUpperCase().trim()) {
		case "MALE":
			gender = getWebElement(maleGender_BTN);
			break;
		case "FEMALE":
			gender = getWebElement(femaleGender_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid gender provided");
		}

		LOGGER.info("Gender value selected: " + value);
		gender.click();
		LOGGER.info("Gender option is clicked");
	}

	public void selectQualification(String value) {
		waitUntilElementIsVisible(qualification10_BTN);
		MobileElement qualification;
		switch (value.toUpperCase().trim()) {
		case "BELOW 10TH PASS":
			qualification = getWebElement(qualificationBelow10_BTN);
			break;
		case "10TH PASS":
			qualification = getWebElement(qualification10_BTN);
			break;
		case "12TH PASS & ABOVE":
			qualification = getWebElement(qualificationAbove12_BTN);
			break;
		case "GRADUATE":
			qualification = getWebElement(qualificationGraduate_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid qualification provided");
		}

		LOGGER.info("Qualification value selected: " + value);
		qualification.click();
		LOGGER.info("Qualification option is clicked");
	}

	public void selectSchoolMedium(String value) {
		waitUntilElementIsVisible(mediumEnglish_BTN);
		MobileElement medium;
		switch (value.toUpperCase().trim()) {
		case "ENGLISH":
			medium = getWebElement(mediumEnglish_BTN);
			break;
		case "HINDI":
			medium = getWebElement(mediumHindi_BTN);
			break;
		case "OTHERS":
			medium = getWebElement(mediumOther_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid Medium provided");
		}
		LOGGER.info("Value of the School Medium: " + value);
		medium.click();
		LOGGER.info("Medium option is clicked");
	}

	public void selectExperience(String value) {
		waitUntilElementIsVisible(fresher_BTN);
		MobileElement experience;
		switch (value.toUpperCase().trim()) {
		case "FRESHER":
			experience = getWebElement(fresher_BTN);
			break;
		case "EXPERIENCE":
			experience = getWebElement(experienced_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid experience provided");
		}
		experience.click();
		LOGGER.info("Experience option is clicked");
	}

	public void setInputAge(String age) {
		waitUntilElementIsClickable(age_TXTBX);
		getWebElement(age_TXTBX).sendKeys(age);
		LOGGER.info("Set the Input Age: " + age);
	}

	public void setEnglishLevel(String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(englishLvl3_BTN));
		MobileElement englishLevel;
		switch (value.toUpperCase().trim()) {
		case "NO ENGLISH":
			englishLevel = getWebElement(englishLvl1_BTN);
			break;
		case "THODA ENGLISH":
			englishLevel = getWebElement(englishLvl2_BTN);
			break;
		case "GOOD ENGLISH":
			englishLevel = getWebElement(englishLvl3_BTN);
			break;
		case "FLUENT ENGLISH":
			englishLevel = getWebElement(englishLvl4_BTN);
			break;
		default:
			throw new InvalidArgumentException("Invalid english level provided");
		}
		englishLevel.click();
	}

	public void clickInterestArea(String value) {
		String interestAreaXpath = SignupLocators.BUTTON_INTEREST_XPATH.replaceAll("INDEX", value);
		waitUntilElementIsClickable(By.xpath(interestAreaXpath));

		getWebElement(By.xpath(interestAreaXpath)).click();
		LOGGER.info("Interest Area is clicked");
	}

	public void clickPersonalDetailSubmitBtn() {
		getWebElement(submitDetailedProfile_BTN).click();
		LOGGER.info("Personal Detail Submit Button is clicked");
	}

	public boolean isSkillsButtonDisplayed() {
		waitUntilElementIsVisible(skills_BTN);

		LOGGER.info("Verify Skill button is displayed");
		return getWebElement(skills_BTN).isDisplayed();
	}

	public boolean isCourseButtonDisplayed() {
		LOGGER.info("Verify Course button is displayed");
		return getWebElement(course_BTN).isDisplayed();
	}

	public void clickSkillsButton() {
		waitUntilElementIsVisible(skills_BTN);

		getWebElement(skills_BTN).click();
		LOGGER.info("Skills Button is clicked");
	}

	public void clickSelectedSkillsButton() {
		String skillsXpath = SignupLocators.CHECKBOX_SKILLS.replaceAll("INDEX", "MS Word");
		waitUntilElementIsClickable(By.xpath(skillsXpath));

		getWebElement(By.xpath(skillsXpath)).click();
		LOGGER.info("Selected skills button is clicked");
	}

	public void clickPopUpSubmitBtn() {
		getWebElement(skillPopUpSubmit_BTN).click();
		LOGGER.info("Pop-up submit button is clicked");
	}

	public void clickCoursesBtn() {
		waitUntilElementIsVisible(course_BTN);

		getWebElement(course_BTN).click();
		LOGGER.info("Course button is clicked");
	}

	public void clickSelectedCourseButton() {
		String coursesXpath = SignupLocators.RADIO_QUALIFICATION.replaceAll("INDEX", "BA");
		waitUntilElementIsClickable(By.xpath(coursesXpath));

		getWebElement(By.xpath(coursesXpath)).click();
		LOGGER.info("Selected Course button is clicked");
	}

	public void clickAppLanguage() {
		waitUntilElementIsVisible(englishLang_BTN);

		getWebElement(englishLang_BTN).click();
		LOGGER.info("App Language button is clicked");
	}
}
