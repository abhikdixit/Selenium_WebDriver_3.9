package pk_orange_hrm;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrangeHRM_AddUser extends OrangeHRM_ApplicationTestData {

@Test(dataProvider="Users")
	//This is for Sign On Functionality
	public void Add_Users(String Epname,String uname,String pwd, String cpwd) throws InterruptedException
		
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println("User has landed to"+Element);
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
			driver.findElementById("systemUser_employeeName_empName").sendKeys(Epname);
			/*Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000); 
			driver.findElementById("systemUser_userName").sendKeys("abhidixit"+randomInt);*/
			driver.findElementById("systemUser_userName").sendKeys(uname);
			driver.findElementById("systemUser_password").sendKeys(pwd);
			driver.findElementById("systemUser_confirmPassword").sendKeys(cpwd);
			Thread.sleep(5000);
			driver.findElementById("btnSave").click();
			
			driver.close();//Close will close only current chrome browser
		}
	
	
}
