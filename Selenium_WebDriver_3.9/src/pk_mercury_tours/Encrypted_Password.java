package pk_mercury_tours;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Encrypted_Password {
  @Test
  public void Encrypt() {
	 
	  String decodepassword="testing";

	byte[] encryptedPassword = Base64.getDecoder().decode(decodepassword.getBytes());
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("encryptedPassword");
		driver.findElement(By.name("login")).click();
	  driver.close();
  }
}
