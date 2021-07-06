## Selenium Assignment

** How to create Maven Project **
* Open File
* Go to New
* Click on Other
* Type Maven Project then Next and again Next
* Now Select Artifact Id with the name maven-archetype-quickstart  1.1
* Now Write Group Id and Artifact Id and Click finish

** How to run Maven Project **
* Right click on Project Name
* Go to Run As
* Click on Maven Clean
* Then Click on Maven Install

### Drivers
**Includes Drivers For Different Browsers**
* chromedriver.exe - For Chrome Browser
* geckodriver.exe - For Firefox Browser
* msedgedriver.exe - For MS Edge Browser

### Packages

** 1. Pages - Includes Java Files **

* LoginPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button. 
* Includes Methods --
1. clickSignIn - Click Sign in button
2. enterUserEmail - Enter Email Address
3. enterPassword - Enter Password
4. clickLogin - Click Login Button


* RegistrationPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.
* Includes Methods --
1. enterEmailAddress - Enter Email Address
2. clickCreateAccount - Click create account button
3. enterRegisterDetails - Enter data in required fields


* ValidationPage.java File - This file finds Web Elements using locators and contains corresponding methods through which we send Data and performs actions like Click on Button.
* Includes Methods --
1. clickElement - Click on sub-menu element by hovering on Women category
2. getProductText - Returns product name
3. getSearchedText - Returns searched product name
 

** 2. Utils - Includes Java Files ** 

* TestDataUtil.java File - This file contains methods which fetches Test Data from Excel Sheets.
* Includes Methods --
1. getValidLoginDataExcel - Fetches valid login details from Excel Sheet
2. getInvalidPassDataExcel - Fetches Invalid Password from Excel Sheet
3. getInvalidUsernameDataExcel - Fetches Invalid Username from Excel Sheet
4. getBlankDetailsDataExcel - Fetches Blank details from Excel Sheet
5. getValidRegisterDataExcel - Fetches valid Registered details from Excel Sheet
6. getInvalidRegisterDataExcel - Fetches Invalid Email Address from Excel Sheet
7. getAlreadyRegisterDataExcel - Fetches Already Registered Data from Excel Sheet
8. getInvalidPinExcel - Fetches Invalid PinCode from Excel Sheet
9. getBlankRequiredFieldExcel - Fetches blank Required Field from Excel Sheet
10. getBlankEmailExcel - Fetches Blank Email Address from Excel Sheet


* ScreenShots.java File - This file contains method which takes Screenshot.

** 3. Tests - Includes Java Files ** 

* BaseTest.java File - This file includes main methods to run our project and also defines when to run individual method by using testNG annotations. 
* Includes methods --
1. setExtent - This method sets the Extent Report
2. endReport - This method ends the Extent Report
3. intializeWebdriver - This method initialize the web driver
4. attachScreenshot - This method attach the failing screenshots
5. openBrowser - This method opens the browser
6. closeBrowser - This method close the browser

* LoginTest.java File - This file includes methods for Data Providers and different test scenarios -- 
1. validLogin - To verify login page with valid details
2. invalidPassword - To verify with invalid password
3. invalidUsername - To verify with invalid username
4. blankDetails - To verify with blank details


* RegistrationTest.java File - This file includes methods for Data Providers and different test scenarios -- 
1. validDetails - To verify registration page with valid details
2. invalidEmail - To verify with invalid Email Address
3. alreadyRegistered - To verify with Already Registered Email
4. invalidPin - To verify with invalid PinCode
5. blankRequiredField - To verify with blank Required Field
6. blankEmail - To verify with blank Email field


* ValidationTest.java File - This file includes methods for Data Providers and different test scenarios -- 
1. validate - To verify that same product is displayed on searched page.
2. invalidation - Failing test scenario


** 4. com.excel.utility - Includes Java File ** 
* Xls_Reader.java File - Includes methods to use in TestDataUtil.java file related to Data Driven Framework to fetch data from Excel sheets


### Other Folders

** 1. FailedScreenshots **
* Includes Screenshots of `FAILED` Test cases
     
** 2. Reports **
* Includes Extent Report which contain whole Report in HTML format of each Test Scenario

** 3. Resources **
* Includes `log4j.properties`
* Includes `config.properties` file which contains configuration data like url, browserName, implicitWaitTimeout, headless.

*NOTE - End User needs to change this data at Run time for changing functionalities like Browser Name and Whether run in headless mode or not.*
*For Changing browser End User can change the name of browser like for chrome it is "chrome" in small case, for firefox it is "gecko" in small case and for microsoft edge it is "edge" in small case*

** 4. TestDataExcel**
* Includes AssignmentData.xlsx file which contains all the sheets(i.e., Test Data) in the same workbook for all test scenarios

*NOTE - It is required to change the Email Address in ValidRegTestData sheet if you Re-run the entire project or RegistrationTest.java file*

### Other Files

** POM.xml **
* This file is auto generated file which includes all the dependencies, plugins.

** TestNG.xml **
* This file includes how to run Project using testNG and it contains suits, test, groups, classes. We can also pass parameters using testNG.
