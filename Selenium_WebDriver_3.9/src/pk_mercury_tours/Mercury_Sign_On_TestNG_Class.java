package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Mercury_Sign_On_TestNG_Class {
	ChromeDriver driver;
  @Test
  public void Sing_On() {
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		//driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElementByXPath("//input[@name='userName']").sendKeys("testing");
		//driver.findElement(By.name("password")).sendKeys("testingg");
		driver.findElementByCssSelector("input[name='password']").sendKeys("testing");
		driver.findElement(By.name("login")).click();
  }
  @BeforeTest
  public void LaunchBrowser() {
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://flipcart.com");
  }

  @AfterTest
  public void CloseBrowser() {
		driver.quit();
  }

}
