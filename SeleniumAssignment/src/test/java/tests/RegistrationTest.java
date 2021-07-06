package tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.RegistrationPage;
import utils.TestDataUtil;

public class RegistrationTest extends BaseTest {
	SoftAssert softAssertion = new SoftAssert();
	
	@DataProvider
	public Iterator<Object[]> getValidRegisterData() {
		ArrayList<Object[]> testData = TestDataUtil.getValidRegisterDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getInvalidRegisterEmail() {
		ArrayList<Object[]> testData = TestDataUtil.getInvalidRegisterDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getAlreadyRegisterEmail() {
		ArrayList<Object[]> testData = TestDataUtil.getAlreadyRegisterDataExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getInvalidPinCode() {
		ArrayList<Object[]> testData = TestDataUtil.getInvalidPinExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getBlankRequiredField() {
		ArrayList<Object[]> testData = TestDataUtil.getBlankRequiredFieldExcel();
		return testData.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> getBlankEmail() {
		ArrayList<Object[]> testData = TestDataUtil.getBlankEmailExcel();
		return testData.iterator();
	}


	/*	-----------------------Valid Scenario-------------------------- */
	
	@Test(groups= {"valid", "register"}, dataProvider="getValidRegisterData")
	public void validDetails(String Email, String Firstname, String Lastname, String Password, 
			String Address1, String City, String ZipCode, String Country, String State, String Mobile) {
		extentTest = extent.startTest("Valid Registration Details scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		log.info("Entering Registration Details");
		register.enterRegisterDetails(Firstname, Lastname, Password, Address1, City, ZipCode, Country, State, Mobile);
		softAssertion.assertAll();
	}
	
	
/*	-----------------------Invalid Scenarios-------------------------- */
	
//	Invalid Registration Email
	@Test(groups= {"invalid", "register"}, dataProvider="getInvalidRegisterEmail")
	public void invalidEmail(String Email) {
		extentTest = extent.startTest("Invalid Email scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		softAssertion.assertEquals("Login - My Store", driver.getTitle()); //Failing Test Case
		softAssertion.assertAll();
	}
	
//	Already Registered Email
	@Test(groups= {"invalid", "register"}, dataProvider="getAlreadyRegisterEmail")
	public void alreadyRegistered(String Email) {
		extentTest = extent.startTest("Already Registered Email scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		softAssertion.assertAll();
	}
	
//	Invalid Required Field Entry i.e., PinCode
	@Test(groups= {"invalid", "register"}, dataProvider="getInvalidPinCode")
	public void invalidPin(String Email, String Firstname, String Lastname, String Password, 
			String Address1, String City, String ZipCode, String Country, String State, String Mobile) {
		extentTest = extent.startTest("Invalid Pin Code scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		log.info("Entering Registration Details");
		register.enterRegisterDetails(Firstname, Lastname, Password, Address1, City, ZipCode, Country, State, Mobile);
		softAssertion.assertEquals("My account - My Store", driver.getTitle()); // Failing Test case
		softAssertion.assertAll();
	}
	
//	Blank Required Field Entry i.e., FirstName
	@Test(groups= {"invalid", "register"}, dataProvider="getBlankRequiredField")
	public void blankRequiredField(String Email, String Firstname, String Lastname, String Password, 
			String Address1, String City, String ZipCode, String Country, String State, String Mobile) {
		extentTest = extent.startTest("Invalid Pin Code scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		log.info("Entering Registration Details");
		register.enterRegisterDetails(Firstname, Lastname, Password, Address1, City, ZipCode, Country, State, Mobile);
		softAssertion.assertEquals("My account - My Store", driver.getTitle());
		softAssertion.assertAll();
	}
	
//	Blank Email Address
	@Test(groups= {"invalid", "register"}, dataProvider="getBlankEmail")
	public void blankEmail(String Email) {
		extentTest = extent.startTest("Blank Email scenario Test");
		LoginPage login = new LoginPage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		log.info("Clicking Sign In Button");
		login.clickSignIn();
		log.info("Sign In Button Clicked");
		softAssertion.assertEquals("Login - My Store", driver.getTitle());
		log.info("Entering Email Address");
		register.enterEmailAddress(Email);
		log.info("Clicking create account button");
		register.clickCreateAccount();
		softAssertion.assertAll();
	}
}
