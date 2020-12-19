package pk_mercury_tours;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DateSelect_Example {
	@Test
	public void Date_Select() 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
         driver.get("http://jqueryui.com/resources/demos/datepicker/other-months.html");
         driver.manage().window().maximize();
	    driver.findElement(By.id("datepicker")).click();
	    List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	    for(WebElement ele:allDates)
	 {
	   
	    	String date=ele.getText();
	    	Calendar now = Calendar.getInstance();
	    	int day = now.get(Calendar.DAY_OF_MONTH);
	    	String currentday=Integer.toString(day);
	    	System.out.println(day);
	    if(date.equalsIgnoreCase(currentday))
         {
	        ele.click();

	    break;
	 }
	 //driver.quit();
       }
    }
}
