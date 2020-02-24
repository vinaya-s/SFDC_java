

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC06_Select_MyProfile extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		
		InitializeDriver();
		CreateReport();

		LoginToSalesForce();
		Select_MyProfile();

		Thread.sleep(3000);
		CloseBrowser();
		CloseReport();

	}
/* 	Select user menu for <username> drop down[TC01]
	Click "My profile" option from user menu ::  User profile page is displayed
	Click on edit profile button to edit contact information :: Edit profile pop up window is displayed with contact 
																		and About tabs to edit. 
	Click on About tab :: UserProfile Page with changed <lastname> is displayed
	Click on post link :: <text> entered should be displayed on the page
	Click on file link :: Selected file should be posted
	Click on Add photo link :: Uploaded photo should appear on the image.
*/
	
	public static void Select_MyProfile() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement usernm = driver.findElement(By.id("userNav"));
		if (usernm == null || !usernm.isDisplayed()) {
			logger.log(LogStatus.ERROR, " UserName is not found.");
		} else {
			logger.log(LogStatus.INFO," Username is found");
			usernm.click();
		}
		
	
		Thread.sleep(2000); 
		WebElement MyProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		Click(MyProfile, "MyProfile");
		
		
		//Edit Profile link
		WebElement Editprofile = driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
		Click(Editprofile, "Editlink");
		
	
		SwitchFrame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		
		Thread.sleep(2000);
		WebElement lastname=driver.findElement(By.id("lastName"));
		lastname.clear();
		
		EnterText(lastname, "xyz", "lastname");
		
		logger.log(LogStatus.INFO, "Switched to About Tab and Lastname is changed");

		//WebElement bodyElement=driver.findElement(By.xpath("//div[contains(@class,'zen-body')]"));
		WebElement saved= driver.findElement(By.xpath("//input[@value='Save All']"));
		Click(saved, "bodyElement");
		
		//Edit Post link
		Thread.sleep(4000);
		WebElement postlink = driver.findElement(By.id("publisherAttachTextPost"));
		Click(postlink, "postlink");
		
		
		WebElement postIframe=driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		SwitchFrame(postIframe);

		//driver.switchTo().frame(postIframe);
		WebElement postBody=driver.findElement(By.xpath("//html[1]/body[1]"));
		Click(postBody, "postBody");
		EnterText(postBody, "Hi ", "PostText");
		

		SwitchFrame();  //coming back to default frame
		
		WebElement ShareButton = driver.findElement(By.xpath("//input[@id='publishersharebutton']")); 
		Click(ShareButton, "ShareButton");

		logger.log(LogStatus.INFO, "Entered Text in PostLink and Shared");

		Thread.sleep(3000);
		WebElement FileLink = driver.findElement
				(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		Click(FileLink, "FileLink");
		WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		Click(UploadFile, "UploadFile");
		
		Thread.sleep(3000);
		WebElement choosefile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		EnterText(choosefile,
				"/Users/visusri/Documents/JavaSelenium/Report/SFDCReport_2020.02.14.22.47.html", 
				"choosefile");
		
		WebElement Share = driver.findElement(By.id("publishersharebutton"));
		Click(Share, "ShareButton");
		
		Thread.sleep(8000);
		logger.log(LogStatus.INFO, "report file attached and shared");

		//Uploading photo
		Thread.sleep(3000);
		WebElement moderator = driver.findElement(By.id("displayBadge"));
		
		//clickObj(AddPhoto, "AddPhoto");
		MouseOver(driver, moderator);
		
		WebElement AddPhotolink = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		Click(AddPhotolink, "AddPhotolink");
		
		SwitchFrame("uploadPhotoContentId");
		
		Thread.sleep(3000);
		WebElement choosefileoption = driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		EnterText(choosefileoption, "/Users/visusri/Downloads/dp.jpg", "choosefileoption");
		
		WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		Click(save, "save");
		
		Thread.sleep(3000);
		WebElement save2 = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
		Click(save2,"Save Crop");
		
		logger.log(LogStatus.INFO, "Photo uploaded cropped and saved.");

		logger.log(LogStatus.INFO, "Switch Tab- Done. Edited LN -Done. Post Share- Done. File upload- Done."
				+ "Photo Uploaded, Crop and Save -Done. // TC06 is completed. //");
		
//		WebElement AboutTab =driver.findElement(By.xpath("//a[contains(text(),'About')]") );
//		AboutTab.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(AboutTab).build().perform();
//		action.click();
		
//		Thread.sleep(1000);
//		WebElement aboutTab =driver.findElement(By.id("aboutTab"));
//		Click(aboutTab, "About Tab");
		
//		WebElement body = driver.findElement(By.tagName("body"));
//		body.click();
//		
//		driver.findElement(By.xpath("//*[@id=\"aboutTab\"]")).click();
//		Select editwindow = new Select(driver.findElement(By.xpath("//*[@id=\"email\"]")));
//		editwindow.deselectByValue("bvinayasri@gmail.com") ;
//		driver.switchTo().defaultContent();   
//		
//		Thread.sleep(1000);
//		WebElement cancel =driver.findElement(By.xpath("//input[@value='Cancel']"));
//		Click(cancel, "Cancel Edit Tab");
		
//		Thread.sleep(2000);
//		WebElement post =driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
//		Click(post, "Post Tab");
//		
//		
//		Thread.sleep(2000);
//		WebElement textpost =driver.findElement(By.xpath("/html"));
//		EnterText(textpost, "Hi", "Text Posting");
//		
//
//		Thread.sleep(2000);
//		WebElement ShareBtn =driver.findElement(By.xpath("//input[@value='Share']"));
//		Click(ShareBtn, "Share Button");
//		
//		Thread.sleep(7000);
//		WebElement file =driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
//		Click(file, "File Tab");
//		
//		Thread.sleep(2000);
//		WebElement AddPhoto =driver.findElement(By.xpath("//*[@id=\"listItem-addPhoto\"]/a"));
//		Click(AddPhoto, "Add Your Photo link");
		

		
	}

}
