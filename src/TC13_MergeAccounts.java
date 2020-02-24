

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC13_MergeAccounts  extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException, AWTException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		MergeAccounts();
		
		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	} 
/*	Launch and Login 
	Click on Accounts link on the home page
	Select accounts to merge	:: Merge by Accounts step 2 page is displayed with the selected accounts details to merge
	Merge accounts				:: New pop up for account merge confirmation is displayed 
									and once the accounts are merged, account page is displayed.
									In recently viewed view, new merged account is listed.
*/	
	public static void MergeAccounts() throws InterruptedException, AWTException {
		
		Thread.sleep(2000);	
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(2000);
		WebElement Accounts =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a/img"));
		Click(Accounts,"Accounts Link");
		
		String expectedTitle = "Accounts: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Accounts Page is Displayed");
		}else {
			logger.log(LogStatus.FAIL, "Accounts page is not Opened");
		}
		
		Thread.sleep(2000);
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
//		driver.switchTo().alert().dismiss();
		
		WebElement mergeAccount =driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		Click(mergeAccount,"Merge Accounts Link");
		logger.log(LogStatus.INFO, "Merge Accounts Page is Opened ");
		
		Thread.sleep(2000);	
		WebElement search1=driver.findElement(By.name("srch"));
		EnterText(search1, "acc", "Search 1 Account");
		
		Thread.sleep(2000);	
		WebElement findAcc =driver.findElement(By.xpath("//input[@name='srchbutton']"));
		Click(findAcc,"Find button");
		
		Thread.sleep(2000);	
		WebElement checkbox1 =driver.findElement(By.xpath("//input[@id='cid0']"));
		WebElement checkbox2 =driver.findElement(By.xpath("//input[@id='cid1']"));
		
//			Thread.sleep(2000);	
//			Click(checkbox1,"select check box");
//			Click(checkbox2,"select check box");
		
		Thread.sleep(2000);		
		WebElement next =driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='goNext']"));
		Click(next,"select Next");
		
		Thread.sleep(2000);	
		WebElement merge =driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		Click(merge,"select Merge Button");
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
		
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.INFO, "Accounts Merged, Back to Accounts page");
		}else {
			logger.log(LogStatus.ERROR, "Not Merged, please check");
		}
		
		Thread.sleep(3000);
		 List<WebElement> viewList=new Select (driver.findElement(By.name("fcf"))).getOptions();
		 viewList.get(0).click();
		 for (int i=0; i<viewList.size();i++){
	      if (viewList.get(i).getText().equals("acc")){
	    	  
	    	  logger.log(LogStatus.PASS, "Accounts listed in View");
	      }
		 }
		
//	List<WebElement> viewList = driver.findElements(By.name("fcf"));
//	  System.out.println(viewList +" "+ viewList.size());
//	   

//List<WebElement> drop = driver.findElements(By.name("customerId"));
//java.util.Iterator<WebElement> i = drop.iterator();
//while(i.hasNext()) {
//    WebElement row = i.next();
//    System.out.println(row.getText());
//} 
		Thread.sleep(2000);
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		}
		
//		WebElement search2=driver.findElement(By.name("srch"));
//		EnterText(search1, "123", "Search 1 Account");
		
		
	}
}
