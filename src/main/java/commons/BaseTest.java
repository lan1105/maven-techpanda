package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest {
	private WebDriver driver;
	public BaseTest() {		
	}
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch(browserList) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid!");	
		}
		driver.get(GlobalContants.LIVE_USER_URL);
		driver.manage().timeouts().implicitlyWait(GlobalContants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;	
	}
	
	public boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureFortest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	public boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureFortest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	public boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureFortest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return status;
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);		
	}
}
