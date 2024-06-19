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
import reportConfig.ExtentManager;

public class User_Login extends BaseTest {
	WebDriver driver;
	String browserName;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	MyDashBoardPageObject myDashboardPage;
	AccountInformationPageObject accountInformationPage;
	
	String emailAddress, password;
	String editEmailAddress;
	Random rand;

	@Parameters({ "browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		this.browserName = browserName;
		driver = getBrowserDriver(browserName);
		userHomePage = UserPageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = "automation_demo" + getRandomNumber() + "@live.com";
		password = "123456789";
		editEmailAddress = "software_test" + getRandomNumber() + "@hotmail.com";
	}

	@Test
	public void TC_01_Login_With_Empty_Email_And_Password(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_01_Login_With_Empty_Email_And_Password");
		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 01: Click to My Account link");

		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox("");

		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox("");

		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_01 - Step 05: Verify error message is displayed");
		verifyEquals(userLoginPage.getEmailAddressEmptyErrorMsg(), "This is a required field");
		verifyEquals(userLoginPage.getPasswordEmptyErrorMsg(), "This is a required field.");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_02_Login_With_Invalid_Email");
		ExtentManager.getTest().log(Status.INFO, "Login_02 - Step 01: Click to My Account link");
		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_02 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox("123@45.789");

		ExtentManager.getTest().log(Status.INFO, "Login_02 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox(password);

		ExtentManager.getTest().log(Status.INFO, "Login_02 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_02 - Step 05: Verify error message is displayed.");
		verifyEquals(userLoginPage.getEmailAddressInvalidMsg(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Email not exist in application")
	public void TC_03_Login_With_Incorrect_Email(Method method) {
		ExtentManager.startTest(method.getName() + " - " + this.browserName, "TC_03_Login_With_Incorrect_Email");
		ExtentManager.getTest().log(Status.INFO, "Login_03 - Step 01: Click to My Account link");
		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_03 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox(emailAddress);

		ExtentManager.getTest().log(Status.INFO, "Login_03 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox(password);

		ExtentManager.getTest().log(Status.INFO, "Login_03 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_03 - Step 05: Verify error message is displayed");
		verifyEquals(userLoginPage.getAddressPasswordIncorrectMsg(), "Invalid login or password.");
	}

	@Test(description = "Password less than 6 characters")
	public void TC_04_Login_With_InValid_Password(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_04_Login_With_InValid_Password");
		ExtentManager.getTest().log(Status.INFO, "Login_04 - Step 01: Click to My Account link");
		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_04 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox(emailAddress);

		ExtentManager.getTest().log(Status.INFO, "Login_04 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox("123");

		ExtentManager.getTest().log(Status.INFO, "Login_04 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_04 - Step 05: Verify error message is displayed");
		verifyEquals(userLoginPage.getPasswordInvalidMsg(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_Login_With_Incorrect_Password(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_05_Login_With_Incorrect_Password");
		ExtentManager.getTest().log(Status.INFO, "Login_05 - Step 01: Click to My Account link");
		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_05 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox(emailAddress);

		ExtentManager.getTest().log(Status.INFO, "Login_05 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox(String.valueOf(getRandomNumber()));

		ExtentManager.getTest().log(Status.INFO, "Login_05 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_05 - Step 05: Verify error message is displayed");
		verifyEquals(userLoginPage.getAddressPasswordIncorrectMsg(), "Invalid login or password.");
	}

	@Test
	public void TC_06_Login_With_Valid_Email_And_Password(Method method) {
		ExtentManager.startTest(method.getName()+ " - " + this.browserName, "TC_06_Login_With_Valid_Email_And_Password");
		ExtentManager.getTest().log(Status.INFO, "Login_06 - Step 01: Click to My Account link");
		userLoginPage = userHomePage.clickToMyAccountLink();

		ExtentManager.getTest().log(Status.INFO, "Login_06 - Step 02: Enter to Email Address textbox");
		userLoginPage.inputToEmailAddressTextbox(emailAddress);

		ExtentManager.getTest().log(Status.INFO, "Login_06 - Step 03: Enter to Password textbox");
		userLoginPage.inputToPasswordTextbox(password);

		ExtentManager.getTest().log(Status.INFO, "Login_06 - Step 04: Click to Login button");
		myDashboardPage = userLoginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login_06 - Step 05: Verify information is displayed successfuly");
		verifyTrue(myDashboardPage.isContactInforDisplayed("software Testing Demo"));
		verifyTrue(myDashboardPage.isContactInforDisplayed("automation_test@hotmail.com"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
