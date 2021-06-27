package com.appium.stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.appium.base.BaseClass;
import com.appium.locators.JobsFeedLocators;
import com.appium.locators.ProfileLocators;
import com.appium.pageObjects.ProfilePageObjects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfileSteps {
	ProfilePageObjects profile;

	@And("^Job feeds section is open$")
	public void jobFeedsSectionIsOpen() {
		profile = new ProfilePageObjects();
		profile.waitUntilElementIsVisible(By.id(JobsFeedLocators.BUTTON_SORT));
		profile.waitUntilElementIsVisible(By.id(JobsFeedLocators.BUTTON_FILTER));
	}

	@When("^User goes to \"([^\"]*)\" section$")
	public void userGoesToSection(String arg0) {
		profile.clickOnDesiredSection(arg0);
	}

	@And("^Selects my profile option$")
	public void selectsMyProfileOption() {
		profile.selectMyProfileOption();
	}

	@And("^Selects English fluency to \"([^\"]*)\"$")
	public void selectsEnglishFluencyTo(String arg0) {
		profile.clickEnglishFluencyBtn();
		profile.selectLevelOfEnglish(arg0);

		profile.clickPopUpButton();
	}

	@And("^Clicks on Update profile button$")
	public void clicksOnUpdateProfileButton() {
		profile.waitUntilElementIsClickable(By.id(ProfileLocators.BUTTON_EDIT_ENGLISH_LEVEL));
		BaseClass.swipeDown();
		BaseClass.swipeDown();

		Assert.assertTrue(profile.verifyUpdateProfileBtnDisplayed() && profile.verifyUpdateProfileBtnIsEnabled());
		profile.clickUpdateProfileButton();
	}

	@Then("^Verify profile is updated successfully$")
	public void verifyProfileIsUpdatedSuccessfully() {
		profile.waitUntilElementIsVisible(By.id(ProfileLocators.BANNER_UPDATE_SUCCESSFUL));

		Assert.assertEquals("Profile Update Done!", profile.getUpdateProfileMessage());
	}

	@And("^Clicks on edit profile link$")
	public void clicksOnEditProfileLink() {
		profile.clickEditBasicProfileButton();
	}

	@And("^updates Full name to \"([^\"]*)\"$")
	public void updatesFullNameTo(String arg0) {
		profile.setFullName(arg0);
	}

	@And("^updates Mobile number to \"([^\"]*)\"$")
	public void updatesMobileNumberTo(String arg0) {
		profile.updateMobileNumber(arg0);
	}

	@And("^Clicks on DONE$")
	public void clicksOnDONE() {
		profile.clickDone();
	}

	@Then("^Verify full name is updated as \"([^\"]*)\" and mobile number is updated as \"([^\"]*)\"$")
	public void verifyFullNameIsUpdatedAsAndMobileNumberIsUpdatedAs(String arg0, String arg1) {

		Assert.assertEquals(arg0.toUpperCase().trim(), profile.getRealNameText().toUpperCase().trim());
		Assert.assertEquals(arg1.trim(), profile.getMobileNumberText().trim());
	}
}
