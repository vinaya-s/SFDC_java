

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC24_NewLead extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		NewLead();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
	
/*	Click leads tab link from Home Page
	Click New button			::click on the new button displayed in the Recent Leads frame
	enter last name				::enter "ABCD" in the last name field 
	enter company name 			::enter "ABCD" in the company name field
	Click save button			::click on the save button
 */
	
	public static void NewLead() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(5000);
		WebElement LeadsLink =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/a/img"));
		Click(LeadsLink,"Leads Link Clicked");
		
		Thread.sleep(1000);
		String expectedTitle = "Leads: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
		{	logger.log(LogStatus.PASS, "Leads: Home Page Opened");
		}else {
			logger.log(LogStatus.FAIL, "Leads: Home Page Not Opened");
		}
		
		Thread.sleep(4000);//Pop up window
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
	
		WebElement newL =driver.findElement(By.xpath("//input[@name='new']"));
		Click(newL,"New Lead creation link");
		
		WebElement firstnm =driver.findElement(By.xpath("//input[@id='name_firstlea2']"));
		EnterText(firstnm, "aaa", "Populating first name field ");
	
		WebElement lastnm =driver.findElement(By.id("name_lastlea2"));
		EnterText(lastnm, "ABCD", "Populating last name field ");
	
		WebElement cmpny =driver.findElement(By.id("lea3"));
		EnterText(cmpny, "ABCD", "Populating Company name field ");
		
		new Select(driver.findElement(By.name("lea13"))).selectByValue("Working - Contacted");

		WebElement save =driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		Click(save,"save button");
		
		WebElement leadDetails =driver.findElement(By.xpath("//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2"));
		if(!leadDetails.isDisplayed()) {
			logger.log(LogStatus.ERROR, "New Lead page is NOT displaying");
		}else {
			logger.log(LogStatus.INFO, "New Lead page is Displaying");
		}
		
		//Lead Edit: New Lead ~ Salesforce - Developer Edition
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "New Lead Created giving Last name, company name and SAVE."
				+ "// TC_24 is Complete. //");

	}
}
