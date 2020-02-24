

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC07_Select_MySettings extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {

		InitializeDriver();
		CreateReport();
		
		LoginToSalesForce();
		Select_MySettings();

		Thread.sleep(3000);
		CloseBrowser();
		CloseReport();

	}
	/* Select user menu for <username> drop down[TC01]
		Click "My Settings" option from user menu  :: My Settings page is displayed
		Click on personal link and select Login History link. :: Login history is displayed and the data is downloaded in .csv format.
		Click on Display & Layout link :: Reports field is added to Selected Tabs list 
											and also added in the links available in top of salesforce page 
											and sales force chatter page and sales and marketing pages.
		Click on Email link and click on my email settings link under that :: Provide <EmailName> in Email Name field, 
												<EmailAddress> in Email Address field, Select automatic BCC radio button 
												and click on save button
		Click on Calendar & Remainders		:: Click on Calendar & Remainders link and click on Activity Remainders link.
		 										On Remainders page click on Open a test Remainder button.
	*/
	public static void Select_MySettings() throws InterruptedException {
		
		
		Thread.sleep(1000);
		WebElement usermenu =driver.findElement(By.id("userNav"));
		Click(usermenu, "User menu");
		
		Thread.sleep(2000);
		WebElement mysettings =driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]") );
		Click(mysettings, "My Settings"); 
												//Click "My Settings" option from user menu
	
		Thread.sleep(2000);
		WebElement personal =driver.findElement(By.id("PersonalInfo") );
		Click(personal, "Personal Link");
		
		Thread.sleep(2000);
		WebElement lh =driver.findElement(By.xpath("//*[@id=\"PersonalInfo_child\"]/div[8]") );
		Click(lh, "Login History");
												//Click on personal link and select Login History link.
		
		Thread.sleep(2000);
		WebElement lhDownload =driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div") );
		Click(lhDownload, "Login History Download file");
													//History downloaded as .csv file
		Thread.sleep(3000);
		String expectedTitle = "Login History ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "Login History file Downloaded");
		else
			logger.log(LogStatus.FAIL, "file Not Downloaded");
		
		
		Thread.sleep(2000);
		WebElement DisplayAndLayout =driver.findElement(By.id("DisplayAndLayout") );
		Click(DisplayAndLayout, "Display And Layout Link");
		
		Thread.sleep(2000);
		WebElement CustomizeMyTabs =driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_child\"]/div[1]") );
		Click(CustomizeMyTabs, "Customize My Tabs link");
		
//		Thread.sleep(2000);
//		List<WebElement> CustomApp = (List<WebElement>) driver.findElements(By.id("p4"));
//		CustomApp.get(9).click();

		
//		Thread.sleep(2000);
//		Select  AvailableTabs =(Select) driver.findElement(By.id("duel_select_0") );
//		AvailableTabs.selectByValue("report");
		
//		List<WebElement> AvailableTabs = (List<WebElement>) driver.findElement(By.tagName("Select[@value='report']"));
//		((WebElement) AvailableTabs).click();
	
		Thread.sleep(2000);
		WebElement AddBtn =driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img") );
		Click(AddBtn, "Add");
		
		
//		Thread.sleep(2000);
//		WebElement CustomizeMyTabs =driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_child\"]/div[1]") );
//		Click(CustomizeMyTabs, "Customize My Tabs link");
//		
//		Thread.sleep(2000);
//		WebElement CustomizeMyTabs =driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_child\"]/div[1]") );
//		Click(CustomizeMyTabs, "Customize My Tabs link");
	}

}
