package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Preceding_Sibling_Xpath_Example {
	WebDriver driver;
	@Test
	public void Sign_On()
		
		{
		
			driver.navigate().to("https://www.facebook.com/");
			//Below is Following-Sibling example
			driver.findElement(By.xpath("//div[@class='mbm _1iy_ _a4y rfloat _ohf']/preceding-sibling::div")).sendKeys("test");
				
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
