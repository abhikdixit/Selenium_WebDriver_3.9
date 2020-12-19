package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Following_Sibling_Xpath_Example {
	WebDriver driver;
	@Test
	public void Sign_On() throws InterruptedException
		
		{
		
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
			//Below is Following-Sibling example
			driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
			Thread.sleep(3000);
			//Below is Preceding-Sibling example
			driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
		}
	
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void CloseBrowser()
	{
		//driver.quit();	
	}
}
