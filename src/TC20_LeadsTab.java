

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC20_LeadsTab extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		LeadsTab();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}

	/*	Click leads tab link from Home Page :: Link should navigate to Leads Home page
	 */
	
	public static void LeadsTab() throws InterruptedException {
			
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
		
		Thread.sleep(1000);
		logger.log(LogStatus.INFO, "Leads Link navigated to Leads Home page. // TC_20 is Completed. //");

	}
}
