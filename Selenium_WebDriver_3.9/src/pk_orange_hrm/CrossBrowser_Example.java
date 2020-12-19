package pk_orange_hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser_Example extends OrangeHRM_ApplicationTestData {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void LaunchBrowser(String browser) throws Exception {

		if(browser.equalsIgnoreCase("firefox")){
			String absolutePath=System.getProperty("user.dir");
			String filepath=absolutePath+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",filepath);
			driver = new FirefoxDriver();
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
		//public void OrangeHRM_Login() {

			driver.get(baseurl);
			driver.findElement(By.name("txtUsername")).sendKeys(uname);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println(Element);

	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
