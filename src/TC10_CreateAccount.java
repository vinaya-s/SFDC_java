

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC10_CreateAccount extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {

		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		CreateNewAccount();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}
/*
	Launch and Login 							:: SalesForce login page is launch and logged in with correct username.
	Click on Accounts link on the home page		::	Accounts page is displayed with correct <username>
	Click on the New button to create new account :: New account page is displayed with account details.
*/
	
	
	public static void CreateNewAccount() throws InterruptedException {
		
		Thread.sleep(2000);	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(2000);	
		WebElement Accounts =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a/img"));
		Click(Accounts,"Accounts Link");
		
		
		String expectedTitle = "Accounts: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle))
			logger.log(LogStatus.PASS, "Accounts Page is Displayed");

		else
			logger.log(LogStatus.FAIL, "Accounts page is not Opened");
		
		Thread.sleep(3000);
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		
		Thread.sleep(1000);
		
		WebElement newAcc =driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		Click(newAcc,"Create New Account Link Clicked");

		String expTitle = "Account Edit: New Account ~ Salesforce - Developer Edition";
		String actTitle = driver.getTitle();

		if (actTitle.equalsIgnoreCase(expTitle))
			logger.log(LogStatus.PASS, "Account Edit: New Account Page is Displayed");

		else
			logger.log(LogStatus.FAIL, "Account Edit: New Account is not Opened");
		
		WebElement AccName =driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
		EnterText(AccName, "abc", "Entering Account Name ");

		WebElement saveBtn =driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		Click(saveBtn,"Saving the New Account Created");


		Thread.sleep(2000);
		WebElement NewAccPage=driver.findElement(By.xpath("//h2[@class='topName']"));
		if (NewAccPage.isDisplayed())
			logger.log(LogStatus.PASS, " New Created Account Page is Displayed");

		else
			logger.log(LogStatus.FAIL, " New Account page is not Displayed");
		
		
		logger.log(LogStatus.INFO, "Account Page Opened and New Account Created and Displaying. // TC_10 is Completed //");


	}
}
