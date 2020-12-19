package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Flight_Firefox_Example {
	FirefoxDriver driver;
  @Test
  public void SignOn() {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.findElement(By.xpath("//a[contains(text(),'SIGN')]")).click();
		driver.findElementByPartialLinkText("SIGN").click();
		//driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
  }
  @BeforeTest
  public void LaunchBrowser() {
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver",filepath);
		 	driver = new FirefoxDriver();
		 	driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
		driver.quit();
  }

}
