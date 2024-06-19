package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.sidebar.SideBarMyDashBoardPageObject;
import pageUIs.user.MyDashBoardPageUI;

public class MyDashBoardPageObject extends SideBarMyDashBoardPageObject {
	WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getSuccessRegisterMessage() {
		waitForElementVisible(driver, MyDashBoardPageUI.SUCCESS_MESSAGE_REGISTER);
		return getElementText(driver, MyDashBoardPageUI.SUCCESS_MESSAGE_REGISTER);

	}

	public boolean isAccountInformationMessageDisplayed() {
		waitForElementVisible(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED_MESSAGE);
		return isElementDisplayed(driver, MyDashBoardPageUI.ACCOUNT_INFORMATION_SAVED_MESSAGE);
	}

	public boolean isContactInforDisplayed(String contactInfor) {
		waitForElementVisible(driver, MyDashBoardPageUI.CONTACT_INFOR_TEXT);
		String actualContactInforText = getElementText(driver, MyDashBoardPageUI.CONTACT_INFOR_TEXT);
		return actualContactInforText.contains(contactInfor);
	}

}
