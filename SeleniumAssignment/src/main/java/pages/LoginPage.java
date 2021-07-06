package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
/*	---------------Finding Web Elements using Locators------------------ */
	
	 @FindBy(how = How.CLASS_NAME, using ="login") 
	 public WebElement signIn; 
	
	 @FindBy(how = How.ID, using ="email") 
	 public WebElement userName; 
	 
	 @FindBy(how = How.ID, using ="passwd")
	 public WebElement passWord;
	 
	 @FindBy(how = How.ID, using ="SubmitLogin")
	 public WebElement LogIn;
	  
	 
	 
//	 Function to click Sign In Button
	 public void clickSignIn(){
		 WebElement waitSignIn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("login")));
		 signIn.click();
	 }
	 
//	 Function to enter Email Address
	 public void enterUserEmail(String userNameEmail) {
		 userName.sendKeys(userNameEmail);
	 }
	 
//	 Function to enter Password
	 public void enterPassword(String password) {
		 passWord.sendKeys(password);
	 }
	 
//	 Function to click on Login Button
	 public void clickLogin() {
		 WebElement waitSubmit = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin"))); 
		 LogIn.click();
	 }
	 
}
