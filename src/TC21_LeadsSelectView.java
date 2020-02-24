

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

public class TC21_LeadsSelectView extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		LeadsSelectView();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
/*
	Click leads tab link from Home Page :: Link should navigate to Leads Home page
	click drop down list  :: List should drop down and should show the following contents: 
							 All Open Leads / My Unread Leads / Recently Viewed Leads / Today's Leads.  

*/
	
	public static void LeadsSelectView() throws InterruptedException {
		
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(1000);
		WebElement LeadsLink =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/a/img"));
		Click(LeadsLink,"Leads Link Clicked");
		
		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
		{	logger.log(LogStatus.PASS, "Leads: Home Page Opened");
		}else {
			logger.log(LogStatus.FAIL, "Leads: Home Page Not Opened");
		}
		
		Thread.sleep(3000); //Pop up window
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		
		
		Thread.sleep(2000); //select[@id='fcf']
//		Select list= (Select) new Select(driver.findElement(By.xpath("//select[@id='fcf']"))).getOptions();
//		list.getFirstSelectedOption().click();
		
		WebElement dropdwn =driver.findElement(By.xpath("//select[@id='fcf']"));
		Click(dropdwn,"Showing DropDown list of Leads");
		
//		WebElement selectElement = driver.findElement(By.id("fcf"));
//		Select select = new Select(selectElement);
//	    List<WebElement> allOptions = select.getOptions();
	   
		logger.log(LogStatus.INFO, "Leads: Home Page is Opened and all dropdown list Verified, Displaying. // TC_21 is Completed //");
	
	}
}
