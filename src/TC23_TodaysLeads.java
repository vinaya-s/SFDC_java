

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC23_TodaysLeads extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		TodaysLeads();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
	
/*	List item "Todays Leads" work
	Click leads tab link from Home Page ::	Link should navigate to Leads Home page
	select Todays Leads from the view drop down	:: click on Today's Leads from the view drop down click on go button
 */
	
	public static void TodaysLeads() throws InterruptedException {
	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(1000);
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
		
		new Select(driver.findElement(By.name("fcf"))).selectByVisibleText("Today's Leads");
		
		WebElement go =driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		Click(go,"default view Go Button");
		
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "Todays leads selected from dropdown and pushed Go."
				+ "// TC_23 is Complete. //");

		Thread.sleep(1000);
	}
	
	
	
}
