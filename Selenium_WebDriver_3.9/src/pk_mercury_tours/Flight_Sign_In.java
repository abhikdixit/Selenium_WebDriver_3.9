package pk_mercury_tours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight_Sign_In {
	ChromeDriver driver;
@Test
public void Sign_On()
	
	{
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	String Element = driver.findElement(By.linkText("Dashboard")).getText();
	System.out.println(Element);
				
			}
@Before
public void LaunchBrowser()
	
	{
	String absolutePath=System.getProperty("user.dir");
	String filepath=absolutePath+"\\chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver",filepath);
	 	driver = new ChromeDriver();
	 	driver.manage().window().maximize();
	}
@After
public void CloseBrowser()
	
	{
		driver.quit();
	}
}
