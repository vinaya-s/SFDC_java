

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReusableMethods {


	static ExtentReports report;
	static ExtentTest logger;

	static WebDriver driver;

	public static void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","/Users/visusri/Downloads/chromedriver");
		driver = new ChromeDriver();
	}

	public static void OpenUrl(String url) {
		driver.get(url);

	}

	public static void CloseBrowser() {
		driver.quit();
	}

	public static void CloseReport() {
		report.flush();
	}

	/*
	 * name of the Method: CreateReport
	 * BriefDescription  : This will create a empty Extent Report.
	 * Arguments		 : No Arguments
	 * Created By 		 : Automation Team
	 * created Date		 : 14/02/2020
	 * Last Modified	 : 14/02/2020
	 */


	public static void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYY.MM.dd.HH.mm'.html'").format(new Date());
		String path = "/Users/visusri/Documents/JavaSelenium/Report/" + fileName;
		report = new ExtentReports(path);
	}


	/* name of the method:   EnterText
	 * BriefDescription  :   entering text value for text box
	 * Arguments         :  element --->object
	 *                      text    --->to be entered 
	 *                      objName --->object name
	 *  created by       :  Automation team 
	 *  created date     :  14/02/20209 
	 *  LastModified Date:  14/02/2020          
	 */


	public static void EnterText(WebElement element, String text, String objName) { //THREE args to be passed
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	public static void Click(WebElement element, String objName) {  			// TWO args to be passed
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
	
	/*
	 * Name of the method: selectDropdown Brief Description: Select the Dropdown
	 * list Arguments: obj --> web object, objName--> name of the object Created by:
	 * Automation team Creation Date: Feb 12 2019 Last Modified: Feb 12 2019
	 */
	
	public static void SelectDropdown(WebElement obj, String objName) {

		if (obj.isDisplayed()) {
			System.out.println("Pass: " + objName + " is  selected");
			obj.click();
		} else {

			System.out.println("Fail:" + objName + " is not present.Please chk application");
			
		}
	}

	/*
	 * name of the method: switchFrameid 
	 * BriefDescription : iframe using webelement
	 * Arguments : driver--->driver obj--->iframe id 
	 * createdby : Automation team
	 * created date :02/13/19 LastModified Date:02/13/19
	 */

	public static void SwitchFrame(String id) {
		driver.switchTo().frame(id);
		//System.out.println("Pass: we can switch to the " + id + " frame");
	}
	
	public static void SwitchFrame(WebElement element) {
		driver.switchTo().frame(element);
		//System.out.println("Pass: we can switch to the frame");
	}

	public static void SwitchFrame() {
		driver.switchTo().defaultContent();
		//System.out.println("Pass: we can switch to the frame");
	}
	
	/* 
	 * name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	 *  created by        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 

	public static void MouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}

	public static void LoginToSalesForce() throws InterruptedException {

		
		logger = report.startTest("User Login");

		OpenUrl("https://login.salesforce.com");

		logger.log(LogStatus.INFO, "URL Opened Successfully");


		Thread.sleep(2000);
		WebElement un=driver.findElement(By.id("username"));
		un.sendKeys("vinaya@abc.com"); 								//Providing Username

		Thread.sleep(1000);
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("SalesF@1");									//Providing Password

		Thread.sleep(1000);
		WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();											//Login Page Clicked

		Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "HomePage Launched Successfully, User is on home page");

		else
			logger.log(LogStatus.FAIL, "home page is not Launched");
		

	}

	public static void UserMenu_dropdown() throws InterruptedException {


		Thread.sleep(2000);

		WebElement usernm = driver.findElement(By.id("userNav"));

		if (usernm == null || !usernm.isDisplayed()) {
			logger.log(LogStatus.ERROR, " UserName is not found.");
		} else {
			logger.log(LogStatus.INFO," Username is found");
			usernm.click();
		}

		Thread.sleep(2000);
		WebElement usermenu =driver.findElement(By.id("userNavMenu"));
		if(!usermenu.isDisplayed()) {
			logger.log(LogStatus.ERROR, "UserMenu is NOT able to display");
		}else {
			logger.log(LogStatus.INFO, "UserMenu is Displaying");

		}
	}
}

