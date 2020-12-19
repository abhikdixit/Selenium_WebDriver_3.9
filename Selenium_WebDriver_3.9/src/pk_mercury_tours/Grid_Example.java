package pk_mercury_tours;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.gargoylesoftware.htmlunit.Version;

public class Grid_Example {
 RemoteWebDriver driver;
 	@Test
	//This is for Sign On Functionality
	public void Sign_On()
		{
			//driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();
		}
	@BeforeTest
	public void LaunchBrowser() throws MalformedURLException
		{
        ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);
        //driver = new RemoteWebDriver(new URL("http://192.168.43.120:4444/wd/hub"), options);
        driver = new RemoteWebDriver(new URL("http://192.168.100.12:4444/wd/hub"), capability);
        driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
        driver.manage().window().maximize();
		}
	
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
