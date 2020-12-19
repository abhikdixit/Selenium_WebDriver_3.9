package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Doss extends App_Doss {
	ChromeDriver driver;
@Test(dataProvider="Login")
public void Sign_On(String uname,String password)
	
	{
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.xpath("//a[contains(text(),'SIGN')]")).click();
		//driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
		String strng = element.getText();
				System.out.println(strng);
		Assert.assertEquals("SIGN-OFF", strng);
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
