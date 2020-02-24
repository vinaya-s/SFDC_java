

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC19_TestQuarterlySummaryReport extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		TestQuarterlySummaryReport();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
	
/*	Launch and Login 
	Click on opportunities link		:: Click on opportunities link from the main menu
	Click on Quarterly Summary link  :: Click on Quarterly Summary link and 
										choose list of values for Interval such as Current FQ,
										Next FQ and Include such as All,Open or closed Opportunities
*/
	public static void TestQuarterlySummaryReport() throws InterruptedException {
		
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
		
//		WebElement selectElement = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@id='quarter_q']"))).selectByValue("curfy");
	   
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@id='open']"))).selectByValue("open");
		
		WebElement runReport =driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
		Click(runReport,"Run Report Link");
		
		String expTitle = "Opportunity Report ~ Salesforce - Developer Edition";
		String actTitle = driver.getTitle();

		if (actTitle.equalsIgnoreCase(expTitle))
		{	logger.log(LogStatus.PASS, "Opportunity Report is Showing");
		}else {
			logger.log(LogStatus.FAIL, "Opportunity Report Page Not showing");
		}
		
		
		logger.log(LogStatus.INFO, "Quarterly Summary Report Run Successfully. // TC_19 is Completed //");
		
		Thread.sleep(2000);
	}
}
