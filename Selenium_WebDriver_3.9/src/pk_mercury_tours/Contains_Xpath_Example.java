package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Contains_Xpath_Example {
	WebDriver driver;
	@Test
	public void Sign_On()
		
		{
			driver.navigate().to("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("SIGN-ON")).click();
			//Below is contains example
			driver.findElement(By.xpath("//input[contains(@name,'user')]")).sendKeys("testing");
			//Below is Start With example
			driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys("testing");
			//Below is OR  example
			//driver.findElement(By.xpath("//input[@name='login' or @value='login']")).click();
			//Below is AND example
			//driver.findElement(By.xpath("//input[@name='login' and @value='Login']")).click();
			//Below is Text example
			driver.findElement(By.xpath("//a[text()='Home']")).click();
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
