package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handle_Window_Alert {
	ChromeDriver driver;	
	@Test
	public void HDFCLAlert() throws Exception
	{
			
		driver.get("https://netbanking.hdfcbank.com/netbanking/");		
		 driver.switchTo().frame("login_page");
		 driver.findElement(By.xpath("//img[@alt='continue']")).click();
		String ActTest = driver.switchTo().alert().getText();
		String ExpTest="Customer ID  cannot be left blank.";
		Assert.assertEquals(ActTest, ExpTest);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
			
	}

@BeforeTest
public void LaunchBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	driver = new ChromeDriver();
}

@AfterTest
public void CloseBrowser() {
	  //driver.quit();
}

}
