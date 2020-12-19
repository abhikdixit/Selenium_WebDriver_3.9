package pk_mercury_tours;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllDropDownValue {
	  @Test
	  public void AllValue() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		  WebElement fromelement = driver.findElement(By.name("fromPort"));
	      Select froms = new Select(fromelement);
	      List <WebElement> fromelementcount = froms.getOptions();

	      System.out.println(fromelementcount.size());
	      for(int i=0 ;i<fromelementcount.size();i++)
	      {
	          String value = fromelementcount.get(i).getText();
	          froms.selectByValue(value);
	      
	          System.out.println(value);
	          
      }
	      driver.quit();
	  }
}
