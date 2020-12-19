package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Chrome_Browser_incognito_mode {
	ChromeDriver driver;
  @Test
  public void Login() {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		//driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		//driver.findElement(By.name("login")).isDisplayed();
		//String Element = driver.findElement(By.name("login")).getText();
		driver.findElement(By.name("login")).click();
		String ExpResult="SIGN-OF";
		String ActResult=driver.findElement(By.linkText("SIGN-OFF")).getText();
		Assert.assertEquals(ExpResult, ActResult);
  }
  @BeforeTest
  public void LaunchBrowser() {
	  ChromeOptions options = new ChromeOptions();
	  //options.setHeadless(true);
	  options.addArguments("incognito");
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
