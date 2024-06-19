package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;import pageUIs.user.AccountInformationPageUI;

public class AccountInformationPageObject extends BasePage{
	WebDriver driver;

	public AccountInformationPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isFirstNameDisplayed(String firstName) {
		waitForElementVisible(driver,AccountInformationPageUI.FIRST_NAME_FIELD , firstName);
		return isElementDisplayed(driver, AccountInformationPageUI.FIRST_NAME_FIELD , firstName);
	}

	public boolean isLastNameDisplayed(String lastName) {
		waitForElementVisible(driver,AccountInformationPageUI.LAST_NAME_FIELD , lastName);
		return isElementDisplayed(driver, AccountInformationPageUI.LAST_NAME_FIELD , lastName);
	}

	public boolean isEmailAddressDisplayed(String emailAddress) {
		waitForElementVisible(driver,AccountInformationPageUI.EMAIL_ADDRESS_FIELD , emailAddress);
		return isElementDisplayed(driver, AccountInformationPageUI.EMAIL_ADDRESS_FIELD , emailAddress);
	}

	public void inputToFirstNameField(String editFirstName) {
		waitForElementVisible(driver, AccountInformationPageUI.FIRST_NAME_FIELD);
		sendkeyToElement(driver, AccountInformationPageUI.FIRST_NAME_FIELD, editFirstName);		
	}

	public void inputToLastNameField(String editLastName) {
		waitForElementVisible(driver, AccountInformationPageUI.LAST_NAME_FIELD);
		sendkeyToElement(driver, AccountInformationPageUI.LAST_NAME_FIELD, editLastName);	
		
	}

	public void inputToEmailAddressField(String editEmailAddress) {
		waitForElementVisible(driver, AccountInformationPageUI.EMAIL_ADDRESS_FIELD);
		sendkeyToElement(driver, AccountInformationPageUI.EMAIL_ADDRESS_FIELD, editEmailAddress);	
		
	}

	public void inputToCurrentPasswordField(String currentPassword) {
		waitForElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD_FIELD);
		sendkeyToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_FIELD, currentPassword);
		
	}

	public MyDashBoardPageObject clickToSaveButton() {
		waitForElementClickable(driver, AccountInformationPageUI.SAVE_BUTTON);
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return new UserPageGeneratorManager().getMyDashBoardPage(driver);
	}

}
