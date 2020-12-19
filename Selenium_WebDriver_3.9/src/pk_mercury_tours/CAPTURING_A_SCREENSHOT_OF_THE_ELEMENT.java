package pk_mercury_tours;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CAPTURING_A_SCREENSHOT_OF_THE_ELEMENT {
ChromeDriver driver;
	@Test
	public void capturingscreenshotexample() throws Exception
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.linkText("SIGN-ON")).click();
        driver.findElement(By.name("userName")).sendKeys("testing");
        driver.findElement(By.name("password")).sendKeys("testing");
        driver.findElement(By.name("logins")).click();
        WebElement element = driver.findElement(By.name("logins"));
	    File Browserscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(Browserscreenshot);
		Point point = element.getLocation();
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", Browserscreenshot);
		FileUtils.copyFile(Browserscreenshot, new File("D:/F Drive/Selenium Training Data/workspace/Selenium_WebDriver_3.9/shutterfly.png"));
		driver.quit();
	}

}
