

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC17_TestOptyPipelineReport extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		TestPipelineReport();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}

/*	Launch and Login 
	Click on opportunities link		:: Click on opportunities link from the main menu
	Click on Opportunity Pipeline link  :: Click on Opportunity Pipeline link  under Reports.
*/
	public static void TestPipelineReport() throws InterruptedException {
		
		
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(1000);
		WebElement OppTab =driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"));
		Click(OppTab,"Opportunities Link");
		
	
		String expectedTitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
		{	logger.log(LogStatus.PASS, "Opportunity Home Page Opened");
		}else {
			logger.log(LogStatus.FAIL, "Opportunity home Page Not Opened");
		}
		
		Thread.sleep(3000); //Pop up window
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		Thread.sleep(1000);
		WebElement OptyPL =driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		Click(OptyPL,"Opportunity Pipeline Link");
		
		String expTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		String actTitle = driver.getTitle();

		if (actTitle.equalsIgnoreCase(expTitle))
			logger.log(LogStatus.PASS, "Opportunity Pipeline Page Opened");

		else
			logger.log(LogStatus.FAIL, "Opportunity Pipeline Page Not Opened");
		
		Thread.sleep(1000);
		logger.log(LogStatus.INFO, " Opportunity Pipeline window opened and checked.  // TC_17 is Completed. //");

	}
	
}