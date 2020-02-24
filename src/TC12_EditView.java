

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC12_EditView extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		EditView();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	} 
/*
	Launch and Login  ::
	Click on Accounts link on the home page ::
	Select the <view name> from the view drop down list on the account page to edit ::  <View name> edit page Is displayed
	Edit the view 												::View page with <new view name> in the drop down is displayed. 
	View will have Last activity column added 
	and the data of the list will have all account names which has <a> in the text.
*/	
	public static void EditView() throws InterruptedException {
		
		Thread.sleep(2000);	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
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
		
		
		// Select from List **
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("fcf"))).selectByVisibleText("My Accounts");
		logger.log(LogStatus.INFO, "My Accounts Option is Selected from the View dropdown List.");

		
		Thread.sleep(2000);	
		WebElement Edit =driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		Click(Edit,"Edit Link Selected");
		
		String expTitle = "Accounts: Edit View ~ Salesforce - Developer Edition";
		String actTitle = driver.getTitle();

		if (actTitle.equalsIgnoreCase(expTitle)) {
			logger.log(LogStatus.PASS, "Accounts: Edit View Page is Opened");
		}else {
			logger.log(LogStatus.FAIL, "Accounts: Edit View is not Opened");
		}
		
		WebElement saveView =driver.findElement(By.xpath("//body/div/div/table/tbody/tr/td/div/form/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		Click(saveView,"Edit View Accounts saved");
		
	
		WebElement Acc_havngA =driver.findElement(By.xpath("//span[@class='listItemPad'][contains(text(),'A')]"));
		Click(Acc_havngA,"Accounts Starting or having <a> are Selected");
		
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "All Accounts Edit Page is Displayed.  // TC_12 is Completed. //");
		
	}
	
}