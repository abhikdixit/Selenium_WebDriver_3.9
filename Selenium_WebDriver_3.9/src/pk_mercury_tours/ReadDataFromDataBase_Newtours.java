package pk_mercury_tours;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadDataFromDataBase_Newtours {
	WebDriver driver;
	DataBase_Example db = new DataBase_Example();
    @BeforeMethod
    public void LaunchApp() throws Exception {

		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver",filepath);
		driver = new InternetExplorerDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		//driver.manage().window().maximize();
	}

@Test
public void LoginApp()throws  Exception{
	
	ResultSet testData = db.ConnectMySQLDatabase("uname", "upassword");
	do
	{
	
	String uname = testData.getString(1);
	String upass = testData.getString(2);
	
	driver.findElement(By.linkText("SIGN-ON")).click();
	driver.findElement(By.name("userName")).sendKeys(uname);
	driver.findElement(By.name("password")).sendKeys(upass);
	driver.findElement(By.name("login")).click();
	driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	while(testData.next());
	}


}
