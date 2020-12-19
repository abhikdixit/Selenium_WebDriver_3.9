package pk_mercury_tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Mobile_Browser_View_Flight_Login {
	ChromeDriver driver;
  @Test
  public void SignOn() {
		driver.get("https://www.borrowlenses.com/");
		//driver.findElement(By.xpath("//a[contains(text(),'SIGN')]")).click();
		driver.findElementByXPath("//*[@id='welcomeContent']/div[1]/div[3]/a/span/span").click();
		driver.findElement(By.linkText("Cameras")).click();

  }
  @BeforeTest
  public void LaunchBrowser() {
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",filepath);
		
        ChromeOptions iPhoneOption = new ChromeOptions();

        driver = new ChromeDriver(iPhoneOption);
        Dimension d = new Dimension(640, 960);
        driver.manage().window().maximize();
        driver.manage().window().setSize(d);

  }

  @AfterTest
  public void CloseBrowser() {
	//	driver.quit();
  }

}
