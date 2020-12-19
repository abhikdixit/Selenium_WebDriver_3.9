package pk_mercury_tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadDataFromExcel extends ApplicationTestData {
	WebDriver driver;
	 
    @BeforeMethod
    public void LaunchApp() throws Exception {

    	System.setProperty("webdriver.chrome.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		 driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
	}

@Test(dataProvider="LoginData")
public void LoginApp(String uname,String password)throws  Exception{
	
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("login")).click();
	driver.quit();
	}


}
