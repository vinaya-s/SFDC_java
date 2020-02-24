

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_LoginToSalesForce{

	/*
	 * TC-2   Login To SalesForce -2
	 * Launch SFDC application :: Open <https://www.Login.salesforce.com> page in browser
	 * Login to SFDC :: Provide valid <username> in username text field 
	 * 					and valid <password> in password text field 
	 * 					and click on Login to Slaesforce button
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
		
		Thread.sleep(1000);
		WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();											//Login Page Clicked	
		
		Thread.sleep(3000);
		System.out.println("Homepage id Displayed");
		Thread.sleep(2000);

		driver.quit();

	}

}
