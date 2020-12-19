package pk_mercury_tours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Before_After_Test_Junti_Example {
	ChromeDriver driver;
	@Test
	public void Sign_On()
		
		{
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			//driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElementByXPath("//input[@name='userName']").sendKeys("testing");
			//driver.findElement(By.name("password")).sendKeys("testingg");
			driver.findElementByCssSelector("input[name='password']").sendKeys("testingg");
			driver.findElement(By.name("login")).click();
	
		}
	
	
	@Before
	public void LaunchBrowser()
	{
		
		String absolutePath=System.getProperty("user.dir");
		//String filepath=absolutePath+"\\chromedriver.exe";
		String filepath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://flipcart.com");
	}
	@After
	public void CloseBrowser()
	{
		driver.quit();	
	}
}
