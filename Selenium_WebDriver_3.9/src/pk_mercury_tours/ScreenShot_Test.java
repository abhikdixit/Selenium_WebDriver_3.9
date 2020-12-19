package pk_mercury_tours;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot_Test {
	
	ChromeDriver driver;
	String filePath = "D:/F Drive/Selenium Training Data/workspace/Selenium_WebDriver_3.9/Screenshot";
	@Test()
	public void OrangeHRM_Login() throws Exception
	{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLoginn")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
        }

	@BeforeTest
	public void LaunchBrowser()
		
		{
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		 	driver = new ChromeDriver();
		 	driver.manage().window().maximize();
		}
	
	@AfterMethod
public void CaptureScreenShot(ITestResult result) throws IOException  
{
	if ( ITestResult.FAILURE==result.getStatus())
	{
		 File Browserscreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(Browserscreenshot, new File("D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\Screenshot\\Login.png"));
		 
		FileUtils.copyFile(Browserscreenshot, new File(filePath +"/"+result.getName()+"_"+System.nanoTime() + ".png"));		 
   }
	
	driver.quit();
}


	
	
	
	
	
/*	WebDriver driver;
	String filePath = "D:/SCREENSHOTS";

	@Test
	public void captureScreenshot() throws Exception{
		// Initiate Firefox browser
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_2.43\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		// Pass application url
		driver.get("http://newtours.demoaut.com/");

		// Here we are forcefully passing wrong id so that it will fail our testcase
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();

	}

	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result){

		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try {
				// Create refernce of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;

				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				if (ensureScreenshotDirectoryExists()){
				}
				FileUtils.copyFile(source, new File(filePath +"/"+result.getName()+"_"+System.currentTimeMillis() + ".jpg"));

				System.out.println("Screenshot taken @ "+filePath +"\\"+result.getName()+"_"+System.currentTimeMillis() + ".jpg");
			} 
			catch (Exception e){	
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		// close application
		driver.quit();
	}
	private boolean ensureScreenshotDirectoryExists() {
		File parentDir = new File(getScreenshotDirParent());
		return ((parentDir.canWrite()) || (parentDir.mkdirs()));
	}

	protected String getScreenshotDirParent() {
		return filePath;
	}*/

}
