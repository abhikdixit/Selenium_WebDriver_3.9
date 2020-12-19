package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight_Login_DataProvider extends ApplicationTestData {
	
ChromeDriver driver;

@Test(dataProvider="Login")
public void Sign_On(String url,String uname,String password) throws InterruptedException
	
	{
		driver.get(url);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		driver.findElementById("welcome").click();
		Thread.sleep(5000);
		driver.findElementByLinkText("Logout").click();
	}

@BeforeTest
public void LaunchBrowser() {
	String absolutePath=System.getProperty("user.dir");
	String filepath=absolutePath+"\\chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver",filepath);
	 	driver = new ChromeDriver();
	 	driver.manage().window().maximize();
}

@AfterTest
public void CloseBrowser() {
	 driver.quit();
}
	
}
