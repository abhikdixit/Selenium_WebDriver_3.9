package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Edge_Browser_Example {
	WebDriver driver;
	//InternetExplorerDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		Thread.sleep(6000);
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
  }
  @BeforeTest
  public void LaunchBrowser() {
		String absolutePath=System.getProperty("user.dir");
		// Below details for Edge Browser
		String filepath=absolutePath+"\\MicrosoftWebDriver.exe";
		System.setProperty("webdriver.edge.driver",filepath);
		driver = new EdgeDriver();
		
		//Below details for IE 11 Browser
		//String filepath=absolutePath+"\\IEDriverServer.exe";
		//System.setProperty("webdriver.ie.driver",filepath);
		//driver = new InternetExplorerDriver();
		
		//Below details for Firefox Browser
		//String filepath=absolutePath+"\\geckodriver.exe";
		//System.setProperty("webdriver.gecko.driver",filepath);
		//driver = new FirefoxDriver();
	 	driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
		driver.quit();
  }

}
