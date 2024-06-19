package pageObject.sidebar;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AccountInformationPageObject;
import pageObject.user.UserPageGeneratorManager;
import pageUIs.sidebar.SideBarMyDashBoardPageUI;

public class SideBarMyDashBoardPageObject extends BasePage{
	WebDriver driver;
	
	public SideBarMyDashBoardPageObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public AccountInformationPageObject openAccountInformationPage() {
		waitForElementClickable(driver, SideBarMyDashBoardPageUI.ACCOUNT_INFORMATION_LINK);
		clickToElement(driver, SideBarMyDashBoardPageUI.ACCOUNT_INFORMATION_LINK);
		return UserPageGeneratorManager.getAccountInformationPage(driver);
	}
}
