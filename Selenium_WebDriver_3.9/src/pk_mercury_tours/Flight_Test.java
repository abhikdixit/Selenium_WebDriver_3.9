package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_Test {
	WebDriver driver;
	@Test
	public void Sign_On()
		
		{
		
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("logins")).isDisplayed();
			driver.findElement(By.name("login")).click();
				
		}
	
	@BeforeTest
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.edge.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\MicrosoftWebDriver.exe");
		//driver = new EdgeDriver();
		driver.manage().window().maximize();
		//driver.get("http://flipcart.com");
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();	
	}
}
