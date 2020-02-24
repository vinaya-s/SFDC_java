

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC22_DefaultView extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		DefaultView();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}

/*
	Click leads tab link from Home Page
	Select 'Todays leads'		:: Todays leads' should be selected from the drop down 
									and the salesforce login page appears
	Login to salesforce again	:: 
	Click leads tab link from hp
	click Go button				::Which ever default view was selected during last session,
							that page should be displayed. 
							Ex:'Todays leads' view should have been the default view 
							and that view's page should be displayed once the go button is clicked
*/
	public static void DefaultView() throws InterruptedException {
		
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
		
		Thread.sleep(2000);
		
//		WebElement LVdropdown =driver.findElement(By.xpath("//select[@id='fcf']"));
		new Select(driver.findElement(By.name("fcf"))).selectByVisibleText("My Unread Leads");
	
	
		WebElement um =driver.findElement(By.xpath("//*[@id=\"userNav\"]"));
		Click(um,"user menu Button");
		
		WebElement logout =driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		Click(logout,"LogOut Button");
		
		Thread.sleep(2000);
		logger.log(LogStatus.INFO, "logged out to re-login");
		
		Thread.sleep(2000);
		WebElement un=driver.findElement(By.id("username"));
		EnterText(un, "vinaya@abc.com", " user name entered ");
		
		WebElement pwd=driver.findElement(By.id("password"));
		EnterText(pwd, "SalesF@1", " password entered ");
		
		WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();
		
		Thread.sleep(1000);
		WebElement allTabs1 =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs1,"Show AllTabs Link");
		
		
		Thread.sleep(1000);
		WebElement LeadsLink1 =driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[7]/td[2]/a/img"));
		Click(LeadsLink1,"Leads Link Clicked");
		
		
		Thread.sleep(3000);
		WebElement go =driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		Click(go,"default view Go Button");
		
		Thread.sleep(3000);
		logger.log(LogStatus.INFO, "Todays leads selected,logged out to re-login and default view -Go."
				+ "// TC_22 is Complete. //");

		
	}
}
