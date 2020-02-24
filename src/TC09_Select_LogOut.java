

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC09_Select_LogOut extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		UserMenu_dropdown();
		LogOut();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
/*
  	Select user menu for <username> drop down[TC01] :: 	user menu for <username> drop down is selected
	Click on Logout option from the drop down		::	Logout  of current sales force application  
														and https://login.salesforce.com/ page is displayed.
*/	
	
	public static void LogOut() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement logout =driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		Click(logout,"LogOut Button");
		
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "Page LoggedOut, Login page is displayed.  // TC_09 is Completed.//");
	
	}
	
}
