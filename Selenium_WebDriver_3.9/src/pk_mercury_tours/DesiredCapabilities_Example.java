package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class DesiredCapabilities_Example {
@SuppressWarnings("deprecation")
@Test
  public void Desire_Capability_IE() throws InterruptedException {
	  

		// Method and Description - static DesiredCapabilities internetExplorer()
		 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 //Among the facilities provided by the System class are standard input, standard output, and error output streams; access to externally defined "properties"; a means of loading files and libraries; and a utility method for quickly copying a portion of an array.
		 System.setProperty("webdriver.ie.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\IEDriverServer.exe");
		 
		 //InternetExplorerDriver(Capabilities capabilities)
		 InternetExplorerDriver driver = new InternetExplorerDriver();
	  
	 //driver.manage().window().maximize();

		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//a[contains(text(),'SIGN')]")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(6000);
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
	 //driver.quit();
	 }
}
