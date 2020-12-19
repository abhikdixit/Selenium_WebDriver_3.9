package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Sfly_DeskCalendar {
	FirefoxDriver driver;
  @Test
  public void SignOn() throws InterruptedException {
		driver.get("https://www.shutterfly.com/");
		//driver.findElementByXPath("//*[@id='ip2EmailOverlay']/span").click();
		driver.findElementByXPath("//img[@alt='Close']").click();
		WebElement element = driver.findElementByXPath("//a[@id='cat-link-10014']//span[@class='cat-item-text'][contains(text(),'Calendars')]");
       Actions action = new Actions(driver);
       action.moveToElement(element).build().perform();
       Thread.sleep(6000);
       driver.findElementByXPath("//img[@alt='desk calendars']").click();
       Thread.sleep(6000);
       driver.findElementByXPath("//div[contains(text(),'Watercolor Ombre')]").click();
       
  }
  @BeforeTest
  public void LaunchBrowser() {
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver",filepath);
		 	driver = new FirefoxDriver();
		 	driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
		//driver.quit();
  }

}
