package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Select_DropDown_Example {
	@Test
	public void DropDwon() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	 	ChromeDriver driver = new ChromeDriver();
	 	driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
	
		Select SelectPass = new Select(driver.findElement(By.name("passCount")));
		SelectPass.selectByValue("4");
		//SelectPass.selectByIndex(1);
		String SelectedValue = SelectPass.getFirstSelectedOption().getText();
		System.out.println(SelectedValue);
		Select oSelect = new Select(driver.findElement(By.name("fromPort")));
	 	oSelect.selectByValue("London");
	 	Select AirlineSelect = new Select(driver.findElementByName("airline"));
	 	AirlineSelect.selectByVisibleText("Unified Airlines");
	 	//oSelect.selectByVisibleText("London");
	 driver.findElementByXPath("//input[@value='Business']").click();
	 
	 driver.findElementByName("findFlights").click();
	  
	String ActValue = driver.findElement(By.xpath("//font[contains(text(),'DEPART')]")).getText();
	Assert.assertEquals(ActValue, "DEPART");

	}
}
