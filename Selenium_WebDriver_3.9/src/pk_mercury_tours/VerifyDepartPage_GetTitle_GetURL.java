package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDepartPage_GetTitle_GetURL {
  @Test
  public void Depart_GetTitle_GetURL() throws InterruptedException {
	  

		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	  	//WebDriver driver = new FirefoxDriver();
	 	ChromeDriver driver = new ChromeDriver();
	 	driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(6000);
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("findFlights")).click();
		//String depart = driver.findElement(By.xpath("//td[@class='title']/font/b/font[contains(text(), 'DEPART')]")).getText();
		String depart = driver.findElement(By.xpath("//td[@class='title']//font[contains(text(), 'DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART", depart);
		String gettitle = driver.getTitle();
		System.out.println(gettitle);
		String getURL = driver.getCurrentUrl();
		System.out.println(getURL);
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).sendKeys("Demo");
		driver.findElement(By.name("passLast0")).sendKeys("Selenium");
		driver.findElement(By.name("creditnumber")).sendKeys("1234567891234567");
		driver.findElement(By.name("buyFlights")).click();
		driver.quit();
		
  }
}
