package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handle_Frame {
	 @Test
	 public  void real() throws Exception
	 {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
		 driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		//driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("input[class='input_password']")).sendKeys("10000");
		 driver.findElement(By.xpath("//img[@alt='continue']")).click();
		 driver.switchTo().defaultContent();
 
		 
	 }
}
