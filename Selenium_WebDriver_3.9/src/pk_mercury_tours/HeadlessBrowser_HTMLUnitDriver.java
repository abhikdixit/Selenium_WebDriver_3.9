package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessBrowser_HTMLUnitDriver {
	ChromeDriver driver;
  @Test
  public void PhantomJS() {
	  
	 /*DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setJavascriptEnabled(true);                
	  caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\phantomjs.exe");
	  WebDriver driver = new  PhantomJSDriver(caps);*/
	  
	  ChromeOptions options = new ChromeOptions();
	  options.setHeadless(false);
	  //options.setHeadless(true)
	  
	  	options.addArguments("incognito");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		/*driver.navigate().to("https://www.google.co.in");
		driver.findElementByName("q").sendKeys("selenium");
		driver.findElementByName("btnK").click();*/
		
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.quit();	
  }
}
