package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Drag_and_Drop {
  @Test
	public void DragDrop() throws InterruptedException {
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Open webpage
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		// Add 5 seconds wait
		//System.out.println("Jenkins Execution");
		Thread.sleep(5000);
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to drag
		WebElement drag=driver.findElementById("draggable");
		//WebElement drag=driver.findElement(By.id("draggable"));
		// find element which we need to drop
		WebElement drop=driver.findElementById("droppable");
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		 Thread.sleep(5000);
		driver.quit();
		//	System.out.println("Jenkins Execution Done");
		 
		}
}
