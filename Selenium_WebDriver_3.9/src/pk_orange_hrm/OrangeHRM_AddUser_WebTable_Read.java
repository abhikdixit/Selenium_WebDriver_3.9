package pk_orange_hrm;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class OrangeHRM_AddUser_WebTable_Read {

@Test
	//This is for Sign On Functionality
	public void Sign_On() throws InterruptedException
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println(Element);
			WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

	        Actions action = new Actions(driver);
	        action.moveToElement(admin).build().perform();
			WebElement usermanagement = driver.findElementByLinkText("User Management");
	        action.moveToElement(usermanagement).build().perform();
	        driver.findElementByLinkText("Users").click();
	        driver.findElementById("searchBtn").click();
	        driver.findElementById("btnAdd").isDisplayed();
	        driver.findElementById("btnAdd").click();
	        Select SelectPass = new Select(driver.findElementById("systemUser_userType"));
			SelectPass.selectByValue("1");
			driver.findElementById("systemUser_employeeName_empName").sendKeys("Fiona Grace");
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000); 
			driver.findElementById("systemUser_userName").sendKeys("abhidixit"+randomInt);
			driver.findElementById("systemUser_password").sendKeys("Pass@2212");
			driver.findElementById("systemUser_confirmPassword").sendKeys("Pass@2212");
			Thread.sleep(5000);
			driver.findElementById("btnSave").click();
			Thread.sleep(5000);
			String ExpUserName="abhidixit"+randomInt;
			System.out.println(ExpUserName);
		    //WebElement cellIneed = driver.findElementByXPath("//*[@id='resultTable']/tbody/tr[1]/td[2]/a");
			WebElement cellIneed = driver.findElementByXPath("//a[contains(text(),'abhidixit"+randomInt+"')]");
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
		    Assert.assertEquals(ExpUserName, valueIneed);
			driver.close();//Close will close only current chrome browser
		}
	
	
}
