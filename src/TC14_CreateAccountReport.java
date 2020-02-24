

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC14_CreateAccountReport extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		CreateAccountReport();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	} 
/* 	
 	Launch and Login 
	Click on Accounts link on the home page
	Create account report			::	Click on Accounts with last activity > 30 days link in reports area on accounts page. 
	Select report options			::	Select create date in the date field drop down, select <todays date> in From 
										and To fields on the unsaved report filed
	Save report						::	Click on the save button on unsaved report page.
										Provide <report name>, <report unique name> in the pop window 
										and click on save and run report button.
*/
	//Unsaved Report page is displayed
	//List of accounts qualified is displayed
	//Report page with details and <report name>is displayed.
	
	public static void CreateAccountReport() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(1000);
		WebElement Accounts =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a/img"));
		Click(Accounts,"Accounts Link");
	
		String expectedTitle = "Accounts: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Accounts Page is Displayed");
		}else {
			logger.log(LogStatus.FAIL, "Accounts page is not Opened");
		}
		
		Thread.sleep(3000);//Pop up window showing up
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		Thread.sleep(1000);
		WebElement AccLastActivity =driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		if(AccLastActivity.isDisplayed()) 
			logger.log(LogStatus.PASS, "Accounts Last Activity Link opened");
		Click(AccLastActivity, "Accounts Last Activity Link");
		
		Thread.sleep(1000);
		WebElement FromDD =driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Click(FromDD, "From Date Link");
		
		WebElement todaydateL =driver.findElement(By.linkText("Today"));
		Click(todaydateL, "today date Link");
		
		WebElement ToDD =driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		Click(ToDD, "To Date Link");
		
		WebElement TodayL =driver.findElement(By.xpath("//button[@id='ext-gen349']"));
		Click(TodayL, "today date Link");
		
		Thread.sleep(1000);
		WebElement RunReport =driver.findElement(By.linkText("Run Report"));
		Click(RunReport, "Run report Link");
	
	}
	
}
