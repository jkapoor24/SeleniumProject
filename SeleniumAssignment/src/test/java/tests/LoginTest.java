package tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import utils.TestDataUtil;


public class LoginTest extends BaseTest {
	
	@DataProvider
	public Iterator<Object[]> getValidLoginData() {
		ArrayList<Object[]> testData = TestDataUtil.getValidLoginDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getInvalidPassTestData() {
		ArrayList<Object[]> testData = TestDataUtil.getInvalidPassDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getInvalidUsernameTestData() {
		ArrayList<Object[]> testData = TestDataUtil.getInvalidUsernameDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getBlankDetailsTestData() {
		ArrayList<Object[]> testData = TestDataUtil.getBlankDetailsDataExcel();
		return testData.iterator();
	}

	
	SoftAssert softAssertion = new SoftAssert();
	
/*	-----------------------Valid Scenario-------------------------- */
	
	@Test(groups= {"valid", "login"}, dataProvider="getValidLoginData")
	public void validLogin(String username, String password) throws InterruptedException {
		
		extentTest = extent.startTest("Valid scenario Test");
		LoginPage login = new LoginPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
//		Assert.assertEquals("Sign-In", login.getHeaderText());
		log.info("Entering Email Address");
		login.enterUserEmail(username);
		log.info("Entering Password");
		login.enterPassword(password);
		log.info("Clicking Log In Button");
		login.clickLogin();
		softAssertion.assertEquals("My account - My Store", driver.getTitle());
		softAssertion.assertAll();
		Thread.sleep(2000);
	}

	
/*	-----------------------Invalid Scenarios-------------------------- */
	
//	Invalid Password
	@Test(groups= {"invalid", "login"}, dataProvider="getInvalidPassTestData")
	public void invalidPassword(String userName, String password) throws InterruptedException {
		
		extentTest =extent.startTest("Invalid Password scenario Test");
		LoginPage login = new LoginPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		login.enterUserEmail(userName);
		log.info("Entering Password");
		login.enterPassword(password);
		login.clickLogin();
		log.info("Clicking Log In Button");
		Assert.assertEquals("My account - My Store", driver.getTitle()); // Failing Test Case
		softAssertion.assertAll();
		Thread.sleep(2000);
	}
	
//	Invalid Username
	@Test(groups= {"invalid", "login"}, dataProvider="getInvalidUsernameTestData")
	public void invalidUsername(String userName, String password) throws InterruptedException {
		
		extentTest =extent.startTest("Invalid Username scenario Test");
		LoginPage login = new LoginPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		login.enterUserEmail(userName);
		log.info("Entering Password");
		login.enterPassword(password);
		login.clickLogin();
		log.info("Clicking Log In Button");
		Assert.assertEquals("My account - My Store", driver.getTitle());
		softAssertion.assertAll();
		Thread.sleep(2000);
	}
	
	// Blank Details
	@Test(groups= {"invalid", "login"}, dataProvider="getBlankDetailsTestData")
	public void blankDetails(String userName, String password) throws InterruptedException {

		extentTest =extent.startTest("Blank Details scenario Test");
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		login.enterUserEmail(userName);
		log.info("Entering Password");
		login.enterPassword(password);
		login.clickLogin();
		log.info("Clicking Log In Button");
		Assert.assertEquals("My account - My Store", driver.getTitle()); //Failing Test Case
		softAssertion.assertAll();
		Thread.sleep(2000);
	}
}
