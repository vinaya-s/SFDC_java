

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC08_Select_DevConsole extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		UserMenu_dropdown();
		DeveloperConsole();

		Thread.sleep(3000);
		CloseBrowser();
		CloseReport();
	}
/*
	Select user menu for <username> drop down[TC01]   :: Drop down with Options List is displayed
	Click on Developer Console link from the drop down :: Force.com Developer Console window is displayed
	Click on close button the developer console browser :: Force.com Developer Console window is closed
*/
	
	public static void DeveloperConsole() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement DevConsole =driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
		Click(DevConsole, "Developer Console");
		
		if(!DevConsole.isEnabled()) {
			logger.log(LogStatus.ERROR, "Developer Console is not opened");
		}else {
			logger.log(LogStatus.INFO, "Developer Console is Opened");
		}
		
		Thread.sleep(8000);
	
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
	}
	
	
	
}
