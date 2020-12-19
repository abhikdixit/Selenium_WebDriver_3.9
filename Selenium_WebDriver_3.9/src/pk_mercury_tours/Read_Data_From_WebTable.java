package pk_mercury_tours;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Read_Data_From_WebTable {
  @Test
  public void WebTable() {

		//Navigate to the Web page
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa?"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = driver.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]"));
         String rowtext = tableRow.getText();

		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
		    
	         WebElement cellIneedThirdRow_FirstValue = tableRow.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[1]"));
	         cellIneedThirdRow_FirstValue.click();
		    //driver.close();
  }
}
