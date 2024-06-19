package com.techpanda.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.MyDashBoardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserPageGeneratorManager;
import pageObject.user.UserRegisterPageObject;
import reportConfig.ExtentManager;

public class User_Register extends BaseTest {
	WebDriver driver;
	String browserName;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserRegisterPageObject userRegisterPage;
	MyDashBoardPageObject myDashBoardPage;
	AccountInformationPageObject accountInformationPage;
	

	String firstName, lastName, emailAddress, password;
	String editFirstName, editLastName, editEmailAddress;
	Random rand;

	@Parameters({ "browser", "server" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		this.browserName = browserName;
		driver = getBrowserDriver(browserName);
		userHomePage = UserPageGeneratorManager.getUserHomePage(driver);

		firstName = "Lan";
		lastName = "Nguyen";
		emailAddress = "automation_demo" + getRandomNumber() + "@live.com";
		password = "123456789";
		editFirstName = "Lan Testing";
		editLastName = "Automation";
		editEmailAddress = "software_test" + getRandomNumber() + "@hotmail.com";
	}

	@Test
	public void TC_01_Register_Success_To_System(Method method) {
		ExtentManager.startTest(method.getName() + " - " + this.browserName, "TC_01_Register_Success_To_System");
		ExtentManager.getTest().log(Status.INFO, "Step 01: Click to My Account link");
		
		userLoginPage = userHomePage.clickToMyAccountLink();
		
		ExtentManager.getTest().log(Status.INFO, "Step 02: Click to Create an account");
		userRegisterPage = userLoginPage.clickToCreateAnAccountButton();
		
		ExtentManager.getTest().log(Status.INFO, "Step 03: Enter data to FirstName textbox");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		
		ExtentManager.getTest().log(Status.INFO, "Step 04: Enter data to LastName textbox");
		userRegisterPage.inputToLastNameTextbox(lastName);
		
		ExtentManager.getTest().log(Status.INFO, "Step 05: Enter data to Email Address textbox");
		userRegisterPage.inputToEmailAddressTextbox(emailAddress);
		
		ExtentManager.getTest().log(Status.INFO, "Step 06: Enter data to Password textbox");
		userRegisterPage.inputToPasswordTextbox(password);
		
		ExtentManager.getTest().log(Status.INFO, "Step 07: Enter data to Confirm password textbox");
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		ExtentManager.getTest().log(Status.INFO, "Step 08: Click to Register Button");
		myDashBoardPage = userRegisterPage.clickToRegisterButton();
		
		ExtentManager.getTest().log(Status.INFO, "Step 09: Verify success message is displayed");
		verifyEquals(myDashBoardPage.getSuccessRegisterMessage(), "Thank you for registering with Main Website Store");
	}
	

	@Test
	public void TC_02_Verify_User_Information_Is_Correct(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_02_Verify_Information_Is_Correct");
		ExtentManager.getTest().log(Status.INFO, "Step 01: Click Account Information link");
		accountInformationPage = myDashBoardPage.openAccountInformationPage();

		ExtentManager.getTest().log(Status.INFO, "Step 02: Verify Firstname is correct");
		verifyTrue(accountInformationPage.isFirstNameDisplayed(firstName));

		ExtentManager.getTest().log(Status.INFO, "Step 03: Verify LastName is correct");
		verifyTrue(accountInformationPage.isLastNameDisplayed(lastName));

		ExtentManager.getTest().log(Status.INFO, "Step 02: Verify Email Address is correct");
		verifyTrue(accountInformationPage.isEmailAddressDisplayed(emailAddress));
	}

	@Test
	public void TC_03_Update_Account_Information(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_03_Update_Account_Information");
		ExtentManager.getTest().log(Status.INFO, "Step 01: Enter data to First Name textbox");
		accountInformationPage.inputToFirstNameField(editFirstName);

		ExtentManager.getTest().log(Status.INFO, "Step 02: Enter data to Last Name textbox");
		accountInformationPage.inputToLastNameField(editLastName);

		ExtentManager.getTest().log(Status.INFO, "Step 03: Enter data to Email Address textbox");
		accountInformationPage.inputToEmailAddressField(editEmailAddress);

		ExtentManager.getTest().log(Status.INFO, "Step 04: Enter data to Current Password textbox");
		accountInformationPage.inputToCurrentPasswordField(password);

		ExtentManager.getTest().log(Status.INFO, "Step 05: Click to Save button");
		myDashBoardPage = accountInformationPage.clickToSaveButton();

		ExtentManager.getTest().log(Status.INFO, "Step 06: Verify  Message is displayed");
		verifyTrue(myDashBoardPage.isAccountInformationMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
