package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowser_Example extends ApplicationTestData {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void LaunchBrowser(String browser) throws Exception {

		if(browser.equalsIgnoreCase("ie")){
			String absolutePath=System.getProperty("user.dir");
			String filepath=absolutePath+"\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",filepath);
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			String absolutePath=System.getProperty("user.dir");
			String filepath=absolutePath+"\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",filepath);
			driver = new ChromeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider="Login")
	public void Flight_Login(String baseurl,String uname,String password) {
		//@Test
		//public void Flight_Login() {

		//String baseurl = "http://newtours.demoaut.com/mercurywelcome.php";
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();

	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
