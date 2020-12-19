package pk_mercury_tours;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight_Login_FirstTest {

@Test
	//This is for Sign On Functionality
	public void Sign_On()
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			//WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			//driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			//driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.linkText("SIGN-ON")).click();
			//driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			//driver.findElement(By.name("login")).isDisplayed();
			//String Element = driver.findElement(By.name("login")).getText();
			driver.findElement(By.name("login")).click();
			driver.quit();//Quit will close all opened chrome browser by Selenium
			//driver.close();//Close will close only current chrome browser
		}
	
	
}
