package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventListeners {
	
	private WebDriver driver;
	private EventFiringWebDriver e_driver;
	private WebEventListener eventListener;
	private String appURL = "http://newtours.demoaut.com/mercurywelcome.php";

	@BeforeClass()
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			e_driver.manage().window().maximize();
			e_driver.get(appURL);
	}

	@Test(priority=1)
	public void SignON() {
		System.out.println("***** Executing Test ONE ***** ");
		e_driver.findElement(By.linkText("SIGN-ON")).click();
		
	}

	@Test(priority=2)
	public void Login_and_Reserve()  {
		System.out.println("***** Executing Test Two ***** ");
		//Entering user name and clicking on next
		e_driver.findElement(By.linkText("SIGN-ON")).click();
		e_driver.findElement(By.name("userName")).sendKeys("testing");
		e_driver.findElement(By.name("password")).sendKeys("testing");
		e_driver.findElement(By.name("login")).click();
		e_driver.findElement(By.name("findFlights")).click();
		e_driver.findElement(By.name("reserveFlights")).click();
	}

	@AfterClass()
	public void tearDown() {
		if (e_driver != null) {
			e_driver.quit();
		}
	}


}
