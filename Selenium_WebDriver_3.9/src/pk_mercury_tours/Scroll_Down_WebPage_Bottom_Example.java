package pk_mercury_tours;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll_Down_WebPage_Bottom_Example {

	ChromeDriver driver;
    @Test
    public void ByPage() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("https://www.shutterfly.com/");
		Thread.sleep(6000);
		driver.findElementByClassName("overlay-modal-close").click();
		Thread.sleep(6000);
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElementByLinkText("Order Status").click();
    }
}
