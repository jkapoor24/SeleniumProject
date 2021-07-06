package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ValidationPage;

public class ValidationTest extends BaseTest {
	
	SoftAssert softAssertion = new SoftAssert();
	
//	Valid Scenario
	@Test(groups = {"valid"})
	public void validate() {
		extentTest = extent.startTest("Valid Searched Product displayed scenario Test");
		ValidationPage valid = new ValidationPage(driver);
		log.info("Clicking on Element");
		valid.clickElement();
		Assert.assertEquals(valid.getProductText(), valid.getSearchedText());
	}
	
//	Invalid Scenario
	@Test(groups = {"invalid"})
	public void invalidation() {
		extentTest = extent.startTest("Invalid Searched Product displayed scenario Test");
		ValidationPage valid = new ValidationPage(driver);
		log.info("Clicking on Element");
		valid.clickElement();
		softAssertion.assertEquals("Faded", valid.getSearchedText());	//Failing Test Case
		softAssertion.assertAll();
	}
}
