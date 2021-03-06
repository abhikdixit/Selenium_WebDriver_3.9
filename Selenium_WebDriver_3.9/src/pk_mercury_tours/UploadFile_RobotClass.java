package pk_mercury_tours;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile_RobotClass {
	String URL = "https://gofile.io/?t=uploadFiles";
	WebDriver  driver;
	//WebDriverWait wait = new WebDriverWait(driver,10);
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testUpload() throws InterruptedException{		
		driver.get(URL);
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\Images\\Image0019.jpg";
		System.out.println(filepath);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.id("dropZoneBtnSelect")).click();
		uploadFile(filepath);
		Thread.sleep(1000);
	}

	public static void uploadFile(String fileLocation) {
		try {
			//Upload file through Robot API
			StringSelection ss = new StringSelection(fileLocation);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			//native key strokes for CTRL, V and ENTER kxeys
			Robot robot = new Robot();
			robot.delay(1000);     
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);    
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			//Press Enter
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);	
			robot.delay(1000);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
