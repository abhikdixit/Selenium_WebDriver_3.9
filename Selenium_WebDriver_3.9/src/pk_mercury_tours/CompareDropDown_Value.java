package pk_mercury_tours;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CompareDropDown_Value {
  @Test
  public void DropDown() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
//		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
		String[] exp = {"Acapulco", "London", "Frankfurtt", "New York", "Paris", "Portland", "San Francisco", "Seattle", "Sydney", "Zurich"}; 
		Select oSelect = new Select(driver.findElement(By.name("fromPort")));
	 	//oSelect.selectByValue("London");
		
		 List<WebElement> options = oSelect.getOptions(); 
		    int i = 0;
	        for(WebElement we:options)  
	        {  
	         //for (int i=0; i<exp.length; i++){
	        	 
	            if (we.getText().equals(exp[i])){
	             System.out.println("Matched");
	             
	            }
	            i = i+1;
	            //else
	             {
	            	 System.out.println("Not Matched");	
	             }
	             } 
	           }

}
