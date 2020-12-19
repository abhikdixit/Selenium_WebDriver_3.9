package pk_mercury_tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login_Read_Properties_File {
	@Test	
	public static void Flight_Login() throws IOException{
		 System.setProperty("webdriver.gecko.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 
	File file = new File("C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\src\\pk_mercury_tours\\DataFile.properties");
	Properties prop = new Properties();
	FileInputStream fileInput = new FileInputStream(file);
	prop.load(fileInput);
	
	driver.get(prop.getProperty("URL"));
	driver.manage().window().maximize();
	driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
	driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
	driver.findElement(By.name(prop.getProperty("Inuserpass"))).sendKeys("testing");
	driver.findElement(By.name("login")).click();
	driver.quit();
  }
}
