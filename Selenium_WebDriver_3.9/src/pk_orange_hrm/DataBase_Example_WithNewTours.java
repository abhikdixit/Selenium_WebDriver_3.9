package pk_orange_hrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DataBase_Example_WithNewTours {
	ChromeDriver driver;
	// Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/newtours";   
    // Constant for Database Username
    public static String DB_USER = "root";
    // Constant for Database Password
    public static String DB_PASSWORD = "root";
 
    @BeforeTest
    public void setUp() throws Exception {
                  // Make the database connection
                  String dbClass = "com.mysql.jdbc.Driver";
                  Class.forName(dbClass).newInstance();
                  // Get connection to DB
                  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                  // Statement object to send the SQL statement to the Database
                  stmt = con.createStatement();
                  
    //------------------------------------------
          		String absolutePath=System.getProperty("user.dir");
        		String filepath=absolutePath+"\\chromedriver.exe";
        		
        		System.setProperty("webdriver.chrome.driver",filepath);
        		 	driver = new ChromeDriver();
        		 	//driver.manage().window().maximize();
    }
    
  @Test
  public void ConnectMySQLDatabase() throws SQLException {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
          String query = "select * from sign_on";
          // Get the contents of userinfo table from DB
          ResultSet res = stmt.executeQuery(query);
          // Print the result untill all the records are printed
          // res.next() returns true if there is any next record else returns false
          while (res.next())
          {
          System.out.print("\t" + res.getString("uname"));
          System.out.println("\t" + res.getString("upassword"));
          String uname = res.getString("uname");
          String upassword = res.getString("upassword");
  		driver.findElementByPartialLinkText("SIGN").click();
  		//driver.findElement(By.linkText("SIGN-ON")).click();
  		driver.findElement(By.name("userName")).sendKeys(uname);
  		driver.findElement(By.name("password")).sendKeys(upassword);
  		driver.findElement(By.name("login")).click();
  		driver.findElementByLinkText("SIGN-OFF").click();
          }
          
              
  }
  
  @AfterTest
  public void tearDown() throws Exception {
         // Close DB connection
         if (con != null) {
         con.close();
         }
         driver.quit();
  }
}
