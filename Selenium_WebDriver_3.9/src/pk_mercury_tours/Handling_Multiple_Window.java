package pk_mercury_tours;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_Multiple_Window {
	ChromeDriver driver;
	@Test
  public void demo()
  {
      
      driver.manage().window().maximize();
      driver.get("https://www.naukri.com");
      String parent_window  = driver.getWindowHandle();        
      Set<String> child_window = driver.getWindowHandles();
      child_window.remove(parent_window);
      for(String child : child_window)
      {
         /* if(child.equals(parent_window))
          {
              driver.switchTo().defaultContent();
          }
          else{*/
              driver.switchTo().window(child);
              driver.close();
              System.out.println("child window closed: "+child);
              }
          driver.switchTo().window(parent_window);
          driver.findElementByXPath("//button[@title='Create Job Alert']").click();


}
  @BeforeTest
  public void LaunchBrowser() {
  	 System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
  	driver = new ChromeDriver();
  }

/* @AfterTest
  public void CloseBrowser() {
  	  driver.quit();
  }*/
}
