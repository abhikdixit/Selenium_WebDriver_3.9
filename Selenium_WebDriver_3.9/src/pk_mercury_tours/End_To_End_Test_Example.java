package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End_To_End_Test_Example {
	ChromeDriver driver;
	
//*******Below test to verify Login Functionality********
	@Test(priority=1)	
	public void Login() {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys("testing");
	driver.findElement(By.name("password")).sendKeys("testing");
	driver.findElement(By.name("login")).click();
	// This is to Verify Title
	String ActTitle=driver.getTitle();
	String ExpTitle="Find a Flight: Mercury Tours: ";
	Assert.assertEquals(ActTitle,ExpTitle);
	//This is to Verify Sign Of Text
	String ActValue = driver.findElement(By.linkText("SIGN-OFF")).getText();
	String ExpValue = "SIGN-OF";
	Assert.assertEquals(ActValue, ExpValue);
	
	}
//*******Below test to to do Search Functionality********
	@Test(priority=2)
	public void SearchFlight()
	{
//--------------------Selecting Departing From--------and Trip
	driver.findElement(By.xpath("//input[@value='oneway']")).click();
	Select oSelect = new Select(driver.findElement(By.name("fromPort")));
 	oSelect.selectByValue("London");
	driver.findElement(By.name("findFlights")).click();
	}

//*******Below test to to do Select Flight Functionality********
	@Test()
	public void SelectFlight()
	{
		String depart = driver.findElement(By.xpath("//td[@class='title']/font/b/font[contains(text(),'DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART", depart);
		driver.findElement(By.name("reserveFlights")).click();
	}
	
//*******Below test to to do Book Flight Functionality********
	@Test(priority=3)
	public void BookFlight()
	{
	driver.findElement(By.name("passFirst0")).sendKeys("Demo");
	driver.findElement(By.name("passLast0")).sendKeys("Selenium");
	driver.findElement(By.name("creditnumber")).sendKeys("1234567891234567");
	driver.findElement(By.name("buyFlights")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	
}
