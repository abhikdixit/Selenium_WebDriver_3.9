package pk_mercury_tours;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait_Example {
  @Test
	public void Explicit_Wait()
	
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//-----------------ImplicitWait Example-------------
		/*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String Element = driver.findElement(By.linkText("PIM")).getText();
		
		System.out.println(Element);*/
		//----------------ExplicitWait Example--------------
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		element.getText();
		element.click();
		
		//driver.quit();		
	}
}
