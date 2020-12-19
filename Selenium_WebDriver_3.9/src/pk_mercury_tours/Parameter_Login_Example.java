package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_Login_Example 
{
	WebDriver driver;
	  @Test
	  @Parameters({"uname","upass"})
	  public void Login(String uname,String upass) 
	  {
		  
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();
			
	  }
	  
	  @BeforeTest
	  public void LaunchBrowser() {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
				driver = new ChromeDriver();
	 }
	  
	  @AfterTest
	  public void CloseBrowser() {
		  driver.quit();
	  }
}
