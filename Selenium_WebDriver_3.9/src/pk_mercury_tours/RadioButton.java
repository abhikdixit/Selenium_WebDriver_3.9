package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {
  @Test
  public void SelectRadio() throws InterruptedException {
	  

		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	 	ChromeDriver driver = new ChromeDriver();
	 	driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
		//To Verify whether RoundTrip Seleted or not
		String str = driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if (str.equalsIgnoreCase("true"))
		{
		    System.out.println("RoundTrip selected");
		}
		//To select Radio Button
		//driver.findElement(By.xpath("//input[@value='oneway']")).click();
		
		//To Verify whether OneWay get Seleted or not post click
		WebElement element = driver.findElement(By.xpath("//input[@value='oneway']"));
		element.click();
		Assert.assertEquals(element.isSelected(),true);
		
		driver.findElement(By.cssSelector("input[value='Business']")).click();
		Thread.sleep(6000);
		driver.quit();
  }
}
