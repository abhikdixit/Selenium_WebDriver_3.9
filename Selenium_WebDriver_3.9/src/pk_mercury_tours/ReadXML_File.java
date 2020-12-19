package pk_mercury_tours;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadXML_File {
  @Test
  public void FlightLogin_Read_Data_From_XML() throws DocumentException {
	  
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
			
			// Reading XML File    		
		    File inputFile = new File("D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\src\\pk_mercury_tours\\FlightObjectRepository.xml");									
		    SAXReader saxReader = new SAXReader();					
		    Document document = saxReader.read(inputFile);							
		    String SignOnLink = document.selectSingleNode("//menu/SignOnLink").getText();							
		    String uname = document.selectSingleNode("//menu/uname").getText();							
		    String LoginButton = document.selectSingleNode("//menu/LoginButton").getText();	
		    
			//driver.get("http://newtours.demoaut.com/mercurywelcome.php");

			driver.findElement(By.linkText(SignOnLink)).click();
			driver.findElement(By.name(uname)).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name(LoginButton)).click();		
			driver.quit();			
		}
  }
}
