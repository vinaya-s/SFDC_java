

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC05_UserMenu extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {

		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		UserMenu_dropdown();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();

	}

	/*  TC05: Select user menu for <username> drop down
	 * Launch and Login 								:: SalesForce login page is launched and application
	 															home page is logged in with correct username.
	 * Check for user menu for <username> drop down		:: User menu drop down should be available
	 * Click on the user menu for <username> drop down	:: Drop down with "My profile", "My Settings",
	  														"Developer Console","Logout" ,
	 															"Switching to lightning Experience" is displayed
	 * 
	 */
	public static void UserMenu_dropdown() throws InterruptedException {


		Thread.sleep(3000);

		WebElement usernm = driver.findElement(By.id("userNav"));

		if (usernm == null || !usernm.isDisplayed()) {
			logger.log(LogStatus.ERROR, " UserName is not found.");
		} else {
			logger.log(LogStatus.INFO," Username is found");
			usernm.click();
		}

		Thread.sleep(2000);
		WebElement usermenu =driver.findElement(By.xpath("//div[@id='userNav-menuItems']"));
		if(!usermenu.isDisplayed()) {
			logger.log(LogStatus.ERROR, "UserMenu is NOT able to display");
		}else {
			logger.log(LogStatus.INFO, "UserMenu is Displaying");

		}
		WebElement MyProfile =driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		if(MyProfile.isDisplayed()) {
			logger.log(LogStatus.INFO, "My Profile is Displaying");
		}

		WebElement MySettings =driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		if(MySettings.isDisplayed()) {
			logger.log(LogStatus.INFO, "My Settings is Displaying");
		}

		WebElement DeveloperConsole =driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		if(DeveloperConsole.isDisplayed()) {
			logger.log(LogStatus.INFO, "Developer Console is Displaying");
		}

		WebElement StLE =driver.findElement(By.xpath("//a[@class='menuButtonMenuLink'][contains(text(),'Switch to Lightning Experience')]"));
		if(StLE.isDisplayed()) {
			logger.log(LogStatus.INFO, "Switch to Lightning Experience is Displaying");
		}

		WebElement Logout =driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		if(Logout.isDisplayed()) {
			logger.log(LogStatus.INFO, "Logout is Displaying");
		}
		
		logger.log(LogStatus.INFO, "// TC05 Complete //  Verified all usermenu dropdown list");
	}
}
