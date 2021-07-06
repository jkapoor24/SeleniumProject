package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import utils.ScreenShots;

public class BaseTest {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(groups= {"valid" , "invalid" , "login", "register"})
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}
	
	@AfterSuite(groups= {"valid" , "invalid" , "login", "register"})
	public void endReport() {
		extent.flush();
		extent.close();
	}	
	
	
	@BeforeMethod(groups = { "valid", "invalid", "login", "register" })
	public static void intializeWebdriver() {
		
		if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			log.info("Launching Chrome Browser");
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			boolean isHeadlessMode = Boolean.parseBoolean(prop.getProperty("headless"));
			if(isHeadlessMode) {
//				To open Chrome Driver in Headless mode
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
					driver = new ChromeDriver(); // To open Chrome Driver
				}
		} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
			log.info("Launching Microsoft Edge Browser");
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver(); // To open Edge Driver
		} else if (prop.getProperty("browserName").equalsIgnoreCase("gecko")) {
			log.info("Launching Firefox Browser");
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); // To open FireFox Driver
		}

//		Implicit Wait
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWaitTimeout")), TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(groups= {"valid" , "invalid" , "login", "register"})
	public void attachScreenshot(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			
		} 
		else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		
		extent.endTest(extentTest);
	}

	@BeforeMethod(groups = { "valid", "invalid", "login", "register"})
	public static void openBrowser() {
		log.info("Hitting URL");
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod(groups = { "valid", "invalid", "login", "register" })
	public static void closeBrowser() {
		log.info("Closing Browser");
		driver.close();
	}

}
