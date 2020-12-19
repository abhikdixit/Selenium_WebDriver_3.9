package pk_mercury_tours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Mouse_Hover_Example {
	/*@Test(priority=1)
	public void MouseHoverShutterfly()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get( "https://www.shutterfly.com/");
		driver.findElementById("cboxClose").click();
        WebElement element = driver.findElementByLinkText("Gifts");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Photo Mugs")).click();

	}*/
	
	@Test()
	public void MouseHoverFlipCart() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get( "https://www.flipkart.com/");
		Thread.sleep(6000);
		driver.findElementByXPath("/html/body/div[2]/div/div/button").click();
		 WebElement element = driver.findElementByXPath("//span[contains(text(),'Electronics')]");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(6000);
		driver.findElementByXPath("//a[@title='Samsung']").click();


	}
}
