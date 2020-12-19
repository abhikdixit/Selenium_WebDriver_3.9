package pk_mercury_tours;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Switch_Tab_Example {
	ChromeDriver driver;
	@Test
	public void testTabs() {
	  	 System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	   	driver = new ChromeDriver();
	   	
	    driver.get("https://business.twitter.com/start-advertising");
	    assertStartAdvertising();

	    // considering that there is only one tab opened in that point.
	    String oldTab = driver.getWindowHandle();
	    driver.findElement(By.linkText("Twitter Advertising Blog")).click();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    assertAdvertisingBlog();

	    // Do what you want here, you are in the new tab

	    driver.close();
	    // change focus back to old tab
	    driver.switchTo().window(oldTab);
	    assertStartAdvertising();

	    // Do what you want here, you are in the old tab
	}

	private void assertStartAdvertising() {
	    Assert.assertEquals("Start Advertising | Twitter for Business", driver.getTitle());
	}

	private void assertAdvertisingBlog() {
		Assert.assertEquals("Twitter Advertising", driver.getTitle());
	}
}
