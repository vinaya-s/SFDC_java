

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC11_CreateNewView extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		CreateNewView();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
	
/*	
 	Launch and Login 							::SalesForce login page is launch and logged in with correct <username.
	Click on Accounts link on the home page		::Accounts page is displayed with correct <username>
	Click on create new view link on accounts page:: Newly added View should be displayed in the account view list
*/	
	
	public static void CreateNewView() throws InterruptedException {
		
		Thread.sleep(1000);	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
	
		WebElement Accounts =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a/img"));
		Click(Accounts,"Accounts Link");
		
		Thread.sleep(2000);
		String expectedTitle = "Accounts: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Accounts Page is Displayed");
		}else {
			logger.log(LogStatus.FAIL, "Accounts page is not Opened");
		}
		
		Thread.sleep(1000);
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		Thread.sleep(2000);
		WebElement newview =driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		Click(newview,"Create new view Link");
		
		Thread.sleep(1000);
		String exTitle = "Accounts: Create New View ~ Salesforce - Developer Edition";
		String acTitle = driver.getTitle();

		if (acTitle.equalsIgnoreCase(exTitle))
			logger.log(LogStatus.PASS, "Create New View Page is Opened");

		else
			logger.log(LogStatus.FAIL, "Create New View page is not Opened");
		
		Thread.sleep(2000);
		
		WebElement viewname =driver.findElement(By.xpath("//input[@id='fname']"));
		EnterText(viewname,"acctnew1","view name entered");
		
		Thread.sleep(2000);
		WebElement save =driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		Click(save,"New view saved");
		
		
		//select[@id='fcf']
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("fcf"))).getOptions();
		logger.log(LogStatus.INFO, "Account Page Opened and New view Created and Displaying. // TC_11 is Completed //");

	}
}
