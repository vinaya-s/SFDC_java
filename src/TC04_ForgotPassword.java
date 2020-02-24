

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC04_ForgotPassword extends ReusableMethods {

	public static void main(String[] args)throws InterruptedException { 
		
		InitializeDriver();
		CreateReport();

		ForgotPassword_4A();
		ForgotPassword_4B();

		Thread.sleep(1000);
		CloseBrowser();
		CloseReport();

	}
	
	/*  Forgot Password- 4 A
	 * Launch SFDC application							::	SFDC login page is opened
	 * Click on Forgot password							::	Salesforce forgot password page is displayed
	 * Test Forgot password								::	Password reset message page is displayed.
	 															An email associated with the <username> account is sent.
	 * Provide <username> in salesforce 
	 forgot password page and click on continue button 	:: Password reset message page is displayed.
	 														An email associated with the <username> account is sent.
	 * 
	 * */

	public static void ForgotPassword_4A() throws InterruptedException {
	

		logger = report.startTest("ForgotPassword");

		OpenUrl("https://login.salesforce.com");

		logger.log(LogStatus.INFO, "URL Opened Successfully");

		Thread.sleep(1000);
		WebElement forgotpwdBtn = driver.findElement(By.id("forgot_password_link"));
		Click(forgotpwdBtn, "Forgot Your Password");


		Thread.sleep(3000);
		String expectedTitle = "Forgot Your Password | Salesforce";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "Forgot Your Password Page Opened");

		else
			logger.log(LogStatus.FAIL, "Forgot Password Page Not Opened");
		
		Thread.sleep(1000);
		WebElement Uname = driver.findElement(By.xpath("//*[@id=\"un\"]"));
		EnterText(Uname, "vinaya@abc.com", "Username");
		
		Thread.sleep(1000);
		WebElement continueBtn = driver.findElement(By.id("continue"));
		Click(continueBtn, "Continue");

		
	}
	
	/* Forgot Password- 4 B
	 * Launch the application	::
	 * Enter Wrong USerName		:: Username 123 is entered in username field
	 * Enter wrong PWd			:: Password 22131 is entered in the pwd field
	 * Click Login				:: "Error message should be displayed
								'Your login attempt has failed. 
								The username or password may be incorrect, 
								or your location or login time may be restricted.
								Please contact the administrator at your company for help'"
	 */	

	public static void ForgotPassword_4B() throws InterruptedException {
		

		logger = report.startTest("ForgotPassword");

		OpenUrl("https://login.salesforce.com");

		logger.log(LogStatus.INFO, "URL Opened Successfully");
 
		Thread.sleep(1000);
		WebElement Un = driver.findElement(By.id("username"));
		EnterText(Un, "123", "Username");
		
		Thread.sleep(1000);
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "22131", "Password");
		
		Thread.sleep(1000);
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='Login']"));
		Click(loginBtn, "Login Button");
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.INFO, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");

	}

}
