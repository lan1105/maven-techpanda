package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAnAccountButton() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return new UserPageGeneratorManager().getUserRegisterPage(driver);
	}

	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return new UserPageGeneratorManager().getMyDashBoardPage(driver);
		
	}

	public String getEmailAddressEmptyErrorMsg() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.EMAIL_ADDRESS_EMPTY_ERROR_MSG);
	}

	public String getPasswordEmptyErrorMsg() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_EMPTY_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.PASSWORD_EMPTY_ERROR_MSG);
	}

	public String getEmailAddressInvalidMsg() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.EMAIL_ADDRESS_INVALID_ERROR_MSG);
	}

	public String getAddressPasswordIncorrectMsg() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.EMAIL_ADDRESS_PASSWORD_INCORRECT_ERROR_MSG);
	}

	public String getPasswordInvalidMsg() {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_INVALID_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.PASSWORD_INVALID_ERROR_MSG);
	}

}
