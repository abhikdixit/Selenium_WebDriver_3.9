package pk_orange_hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRM_SignOn_Parameters {
	//This is for Sign On Functionality
@Test
@Parameters({"url","uname","upass"})
public void Sign_On(String url,String uname,String upass)
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.findElement(By.name("txtUsername")).sendKeys(uname);
			driver.findElement(By.name("txtPassword")).sendKeys(upass);
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println(Element);
			driver.close();//Close will close only current chrome browser
		}
}
