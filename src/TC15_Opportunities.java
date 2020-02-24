

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC15_Opportunities extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		OppDropDown();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	} 

	/*	Launch and Login 
		Click on opportunities link	  :: Click on opportunities link from the main menu
		Verify opportunities drop down is present :: Verify opportunities drop down is present //DROPDOWN WITH ALL THE LIST
	
	*/
	public static void OppDropDown() throws InterruptedException {

		Thread.sleep(2000);	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		
		WebElement OppTab =driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"));
		Click(OppTab,"Opportunities Link");
//		
//		if(OppTab.isDisplayed()) {
//			logger.log(LogStatus.INFO, "Opportunity Tab Selected");
//		}else {
//			logger.log(LogStatus.ERROR, "opportunity tab Not Selected");
//		}
		
		Thread.sleep(2000);
		String expectedTitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Opportunities home Page is Open");
		}else {
			logger.log(LogStatus.FAIL, "Opportunities home page is not Opened");
		}
		
		Thread.sleep(2000);//Pop up window showing up
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");

		Thread.sleep(2000);
		WebElement dropdwn =driver.findElement(By.xpath("//select[@id='fcf']"));
		Click(dropdwn,"Showing DropDown Link of Opportunities");
		
		logger.log(LogStatus.INFO, "Opportunity drop down is present and verified /n // TC_15 is Completed. //");
		
//		WebElement mySelectElm = driver.findElement(By.id("mySelectID")); 
//		Select mySelect= new Select(mySelectElm);
//		mySelect.selectByValue("Value");
		/*
		WebElement myoption = driver.findElement(By.xpath(
			    "//Select[@id='mySelectID']/option[normalize-space(text())='Option']")
			);
			 myoption.click();
		*/
		
		WebElement selectElement = driver.findElement(By.id("fcf"));
		Select select = new Select(selectElement);
	    List<WebElement> allOptions = select.getOptions();
	   
	    Thread.sleep(2000);
	}
	
}
