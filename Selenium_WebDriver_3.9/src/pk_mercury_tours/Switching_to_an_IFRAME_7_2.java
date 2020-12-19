 package pk_mercury_tours;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switching_to_an_IFRAME_7_2 {

	@Test
	public void IFRAME()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shutterfly.com");
		driver.findElement(By.className("modal-close")).click();
		String Parent_window = driver.getWindowHandle();
		System.out.println("The Parent window is: "+Parent_window);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int size = frames.size();
		System.out.println("Total number of IFRAMES are: "+size);
	
		for(int i = 0 ; i < size ; i++)
		{
			if(i==1)
			{
				driver.switchTo().frame(i);
				System.out.println("The new frame is: "+frames);
				break;
			}
		}
		driver.switchTo().parentFrame();
		System.out.println("Again Switched back to parent window");
		//driver.quit();
}

}
