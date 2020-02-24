

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC16_CreateNewOpty extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException, AWTException {
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		CreateNewOpty();

		Thread.sleep(2000);
		CloseBrowser();
		CloseReport();
	}

/*	Launch and Login 
	Click on opportunities link					:: Click on opportunities link from the main menu
	Click on the New button to create new Opty  :: New Opportunity Edit page is displayed.
													Enter Opportunity Name,Account Name,Close Date,Stage,
													Probability,Lead Source , Primary Campaign Source and click on save button.
*/
	public static void CreateNewOpty() throws InterruptedException, AWTException{

		
		WebElement allTabs =driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		Click(allTabs,"Show AllTabs Link");
		
		Thread.sleep(1000);
		WebElement OppTab =driver.findElement(By.xpath("//a[@class='listRelatedObject opportunityBlock title']"));
		Click(OppTab,"Opportunities Link");
		
		
		Thread.sleep(2000);
		String expectedTitle = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			logger.log(LogStatus.PASS, "Opportunities Page is Displayed");
		}else {
			logger.log(LogStatus.FAIL, "Opportunities page is not Opened");
		}
	
		
		//Pop up window showing up
/*		Robot r= new Robot();
		driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
*/
		
//		WebElement PopUpDBclose =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
//		Click(PopUpDBclose,"PopUp Dialogue Box");
		
//		WebElement PopUp_NT =driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
		
		Thread.sleep(3000);
		WebElement PopUpDB =driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]"));
		Click(PopUpDB,"PopUp Dialogue Box");
		
		
//		WebElement PopUp_NT = driver.findElement(By.xpath("//*[@id=\"lexNoThanks\"]"));
////		Click(PopUp_NT,"PopUp Dialogue Box NoThanks button");
//		PopUp_NT.click();
//		
//		WebElement PopUpchk1 =driver.findElement(By.xpath("//*[@id=\"tryLexDialogContent\"]/div/div[2]/div/div[2]/div[1]/div[2]/fieldset/div/span[2]/label/span[1]"));
//		Click(PopUpchk1,"PopUp Dialogue Box checkbox1 button");
//		
//		WebElement PopUpchk2 =driver.findElement(By.xpath("//*[@id=\"tryLexDialogContent\"]/div/div[2]/div/div[2]/div[1]/div[2]/fieldset/div/span[6]/label/span[1]"));
//		Click(PopUpchk2,"PopUp Dialogue Box checkbox2 button");
//		
//		WebElement submit =driver.findElement(By.xpath("//*[@id=\"lexSubmit\"]"));
//		Click(submit,"PopUp Dialogue Box submit button");
	
		
		//creating new opty
		Thread.sleep(2000);	
		WebElement newBtn =driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		Click(newBtn,"Click new Button");
		
		WebElement OptyNm=driver.findElement(By.id("opp3"));
		EnterText(OptyNm, "Optyabc", "Creating new Opty by giving a name");
		
		
		WebElement createDate =driver.findElement(By.xpath("//input[@id='opp9']"));
		Click(createDate,"Select date Button");
		
		WebElement selectToday =driver.findElement(By.xpath("//a[@class='calToday']"));
		Click(selectToday,"Select todays date");
		
		Select Stage =(Select) driver.findElement(By.xpath("//select[@id='opp11']"));
		Stage.getFirstSelectedOption().click();
		
		//select[@id='opp11']
		
		WebElement dropdwn =driver.findElement(By.xpath("//select[@id='fcf']"));
		Click(dropdwn,"Showing DropDown list ");
		
		
		//option[contains(text(),'Prospecting')]
		
//		WebElement stage = driver.findElement(By.id("opp11")); 
//		Select mySelect= new Select(mySelectElm);
//		WebElement option = mySelect.getFirstSelectedOption();
	}

}
