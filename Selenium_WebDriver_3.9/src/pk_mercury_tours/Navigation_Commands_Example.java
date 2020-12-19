package pk_mercury_tours;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_Commands_Example {

@Test
	//This is for Sign On Functionality
	public void Sign_On() throws InterruptedException
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			String title =driver.getTitle();
			System.out.println(title);
			String url =driver.getCurrentUrl();
			System.out.println(url);
			driver.navigate().back();
			Thread.sleep(5000);
			String Hometitle =driver.getTitle();
			System.out.println(Hometitle);
			String Homeurl =driver.getCurrentUrl();
			System.out.println(Homeurl);
			driver.navigate().forward();
			Thread.sleep(5000);

		}
	
	
}
