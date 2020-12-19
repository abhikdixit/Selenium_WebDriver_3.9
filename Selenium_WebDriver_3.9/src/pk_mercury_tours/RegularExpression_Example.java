package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RegularExpression_Example {
  @Test
  public void RegualExpression() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[6]/span"));
		String s = element.getText();
		
		System.out.println(s);
		boolean RegularOutput =s.matches("*");
		System.out.println(RegularOutput);
		//driver.quit();
  }
}
