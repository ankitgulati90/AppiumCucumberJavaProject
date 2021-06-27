package com.appium.stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.appium.base.BaseClass;
import com.appium.locators.SignupLocators;
import com.appium.pageObjects.SignUpPageObjects;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupSteps {
	SignUpPageObjects signUp;

	@Given("App is launched")
	public void app_is_launched() {
		signUp = new SignUpPageObjects();
		signUp.loadDriver();
		signUp.waitUntilElementIsVisible(By.id(SignupLocators.TEXT_FIELD_FULL_NAME));
	}

	@When("^User input \"([^\"]*)\" as Full Name$")
	public void userInputAsFullName(String arg0) {
		signUp.setFullName(arg0);
	}

	@And("^User input \"([^\"]*)\" as mobile number$")
	public void userInputAsMobileNumber(String arg0) {
		signUp.setMobileNumber(arg0);
	}

	@And("^User clicks on submit button$")
	public void userClicksOnSubmitButton() {
		signUp.clickOnSubmit();
	}

	@Then("^Verify Input is not accepted as valid input$")
	public void verifyInputIsNotAcceptedAsValidInput() {
		Assert.assertTrue(signUp.isFullNameDisplayed());
		Assert.assertTrue(signUp.isMobileNumberDisplayed());
		Assert.assertTrue(signUp.isSubmitButtonDisplayed());
	}

	@When("^User provides basic details$")
	public void userProvidesBasicDetails() {
		userInputAsFullName("Test User 123");
		userInputAsMobileNumber("9011111111");
		userClicksOnSubmitButton();
	}

	@And("^User selects city as \"([^\"]*)\"$")
	public void userSelectsCityAs(String arg0) {
		signUp.selectCity(arg0);
	}

	@And("^User input \"([^\"]*)\" as Nearest location$")
	public void userInputAsNearestLocation(String arg0) {
		signUp.setNearestLocation(arg0);
	}

	@And("^User submit city selection$")
	public void userSubmitCitySelection() {
		Assert.assertTrue(signUp.verifyCitySubmitButtonDisplayed() && signUp.verifyCitySubmitButtonIsEnabled());
		signUp.clickCitySubmitButton();
	}

	@And("^User selects gender as \"([^\"]*)\"$")
	public void userSelectsGenderAs(String arg0) {
		signUp.selectGender(arg0);
	}

	@And("^User selects qualification as \"([^\"]*)\"$")
	public void userSelectsQualificationAs(String arg0) {
		signUp.selectQualification(arg0);
	}

	@And("^User selects school medium as \"([^\"]*)\"$")
	public void userSelectsSchoolMediumAs(String arg0) {
		signUp.selectSchoolMedium(arg0);
	}

	@And("^User selects english speaking level as \"([^\"]*)\"$")
	public void userSelectsEnglishSpeakingLevelAs(String arg0) {
		signUp.setEnglishLevel(arg0);
	}

	@And("^User selects \"([^\"]*)\" as Experience$")
	public void userSelectsAsExperience(String arg0) {
		BaseClass.swipeDown();
		signUp.selectExperience(arg0);
	}

	@And("^User input age as \"([^\"]*)\"$")
	public void userInputAgeAs(String arg0) {
		signUp.setInputAge(arg0);
	}

	@And("^User selects \"([^\"]*)\" as Interest area$")
	public void userSelectsAsInterestArea(String arg0) {
		BaseClass.swipeDown();
		signUp.clickInterestArea(arg0);
	}

	@And("^User submit personal details$")
	public void userSubmitPersonalDetails() {
		signUp.clickPersonalDetailSubmitBtn();
	}

	@Then("^Verify details are submitted successfully$")
	public void verifyDetailsAreSubmittedSuccessfully() {
		Assert.assertTrue(signUp.isSkillsButtonDisplayed());
		Assert.assertTrue(signUp.isCourseButtonDisplayed());
	}

	@And("^User is registered$")
	public void userIsRegistered() {
		userProvidesBasicDetails();
		userSelectsCityAs("Delhi");
		userInputAsNearestLocation("Karol Bagh");
		userSubmitCitySelection();
		userSelectsGenderAs("female");
		userSelectsQualificationAs("graduate");
		userSelectsSchoolMediumAs("english");
		userSelectsEnglishSpeakingLevelAs("FLUENT ENGLISH");
		userSelectsAsExperience("Fresher");
		userInputAgeAs("23 Years");
		userSelectsAsInterestArea("Back Office");
		userSubmitPersonalDetails();
		verifyDetailsAreSubmittedSuccessfully();
		signUp.clickSkillsButton();
		signUp.clickSelectedSkillsButton();
		signUp.clickPopUpSubmitBtn();
		signUp.clickCoursesBtn();
		signUp.clickSelectedCourseButton();

		signUp.waitUntilElementIsVisible(By.id(SignupLocators.BUTTON_SUBMIT_DETAILED_PROFILE));
		signUp.clickPersonalDetailSubmitBtn();

		signUp.clickAppLanguage();
	}
}
