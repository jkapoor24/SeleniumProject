package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
/*	---------------Finding Web Elements using Locators------------------ */
	
	@FindBy(how = How.NAME, using ="email_create")
	public WebElement emailAddress;
	
	@FindBy(how = How.ID, using ="SubmitCreate")
	public WebElement createAccount;
	
	@FindBy(how = How.CSS, using ="#customer_firstname")
	public WebElement firstName;
	
	@FindBy(how = How.ID, using ="customer_lastname")
	public WebElement lastName;
	
	@FindBy(how = How.NAME, using ="passwd")
	public WebElement passWord;
	
	@FindBy(how = How.ID, using ="address1")
	public WebElement address1;
	
	@FindBy(how = How.ID, using ="city")
	public WebElement city;
	
	@FindBy(how = How.NAME, using ="postcode")
	public WebElement zipCode;
	
	@FindBy(how = How.ID, using ="id_country")
	public WebElement countryName;
	
	@FindBy(how = How.ID, using ="id_state")
	public WebElement state;
	
	@FindBy(how = How.NAME, using ="phone_mobile")
	public WebElement phoneNumber;
	
	@FindBy(how = How.ID, using ="submitAccount")
	public WebElement registerButton;
	

	
//	Function to enter Email Address 
	public void enterEmailAddress(String Email) {
		emailAddress.sendKeys(Email);
	}
	
//	Function to click on Create Account Button
	public void clickCreateAccount() {
//		Explicit Wait
		WebElement waitCreateAcc = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitCreate"))); 
		createAccount.click();
	}
	
//	Function to Enter Registration Details
	public void enterRegisterDetails(String Firstname, String Lastname, String Password, 
			String Address1, String City, String ZipCode, String Country, String State, String Mobile) {
		WebElement waitFirst = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customer_firstname"))); 
		firstName.sendKeys(Firstname);
		lastName.sendKeys(Lastname);
		passWord.sendKeys(Password);
		address1.sendKeys(Address1);
		city.sendKeys(City);
		zipCode.sendKeys(ZipCode);
		Select select = new Select(countryName);
		select.selectByVisibleText(Country);
		Select dropDown = new Select(state);
		dropDown.selectByVisibleText(State);
		phoneNumber.sendKeys(Mobile);
//		Explicit Wait
		WebElement waitRegister = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("submitAccount"))); 
		registerButton.click();
	}
}
