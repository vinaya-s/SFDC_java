

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC01_LoginErrorMessage {
	/*
	 * TC 1 -  Login Error Message - 1
	 *
	 * Launch App  :: Open Chrome window, provide <https://login.salesforce.com/> url to the browser.
	 * Enter User Name :: Enter User Name <User@gmail.com>
	 * Clear Password field :: clear Password filed
	 * Click on Log in button :: Error message should be displayed 
	 */
	
	WebDriver driver;
	@Test
	public void LoginErrorMessage() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");  				//Opening URL
		
		Thread.sleep(1000);
		WebElement un=driver.findElement(By.id("username"));
		un.sendKeys("vinaya@abc.com"); 								//Providing Username

		Thread.sleep(1000);
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.clear();												//Clearing if any Passwords
		
		Thread.sleep(1000);
		WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginBtn.click();


		String errormessage = driver.findElement(By.id("error")).getText();
		System.out.println(errormessage);
		if(errormessage.equals(errormessage)) {
			System.out.println("Error message is Displayed");
		}else {
			System.out.println("Error message Not Displayed");		//Error Messages are displayed
		}
		
			
		Thread.sleep(2000);

		driver.quit();

	}

}