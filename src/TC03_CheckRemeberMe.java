

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_CheckRemeberMe {
	
	/*
	 * TC-3   Check RemeberMe - 3
	 * Launch SFDC application
	 * Login to SFDC 
	 with remember username check box checked :: Provide valid <username> in username text field 
	 										and valid <password> in password text field 
											 and select the remember user name check box 
											  and click on Login to Slaesforce button
											
	 * Log out of SFDC :: Click on user menu drop down and select log out link
	 
	 * Check for Username field :: UserName <userName> should be displayed 
	 * 
	 */

	WebDriver driver;
	@Test
	public void LoginToSalesForce() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");  				//Opening URL
		
		Thread.sleep(1000);
		WebElement un=driver.findElement(By.id("username"));
		un.sendKeys("vinaya@abc.com"); 								//Providing Username

		Thread.sleep(1000);
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("SalesF@1");									//Providing Password
		
		
		Thread.sleep(2000);
		WebElement rememberUn=driver.findElement(By.id("rememberUn"));
		rememberUn.click();											//Remember me is Selected
		
		Thread.sleep(1000);
		WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();											//Login Page Clicked
		
		
		
		Thread.sleep(1000);
		WebElement usermenu =driver.findElement(By.id("userNav"));
		usermenu.click();
		
		Thread.sleep(2000);
		WebElement logout =driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]") );
		logout.click();
		
		Thread.sleep(1000);
//		WebElement pwd1=driver.findElement(By.id("password"));
//		pwd1.clear();												//Clearing if any Passwords
		
		
	}
}
