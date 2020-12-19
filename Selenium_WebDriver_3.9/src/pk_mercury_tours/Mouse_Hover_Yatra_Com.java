package pk_mercury_tours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Mouse_Hover_Yatra_Com {
	@Test
	public void MouseHoverYatra() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get( "https://www.yatra.com/");
		WebElement element = driver.findElementByXPath("//a[contains(text(),'My Account')]");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        //Thread.sleep(6000);
		driver.findElementById("signInBtn").click();


	}
}
