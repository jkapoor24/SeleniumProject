package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationPage {
	public static String productName;
	public static String searchedProductName;
	WebDriver driver;

	public ValidationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

/*	----------------Finding Web Elements using Locators------------------ */
	@FindBy(how = How.XPATH, using = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]")
	public WebElement element;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public WebElement link;

	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	public WebElement productText;

	@FindBy(how = How.XPATH, using = "//div[@class='right-block']//div//span[@class='price product-price']")
	public WebElement productPrice;

	@FindBy(how = How.NAME, using = "search_query")
	public WebElement searchQuery;

	@FindBy(how = How.NAME, using = "submit_search")
	public WebElement submitSearch;

	@FindBy(how = How.XPATH, using = "//div[@class='right-block']//a[@class='product-name']")
	public WebElement searchedProductText;

	
//	Function to Mouse Hover and click sub-menu i.e., T-shirts
	public void clickElement() {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		link.click();
		System.out.println(
				"Product Name is : " + productText.getText() + " Product Price is : " + productPrice.getText());
		productName = productText.getText();
		searchQuery.sendKeys(productName);
		WebElement waitSubmit = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.name("submit_search")));
		submitSearch.click();
		searchedProductName = searchedProductText.getText();
	}

//	Function to get Name of First Product after hovering and clicking sub-menu
	public String getProductText() {
		return productName;
	}

//	Function to get Name of Product after searching using same name as of first product
	public String getSearchedText() {
		return searchedProductName;
	}

}
