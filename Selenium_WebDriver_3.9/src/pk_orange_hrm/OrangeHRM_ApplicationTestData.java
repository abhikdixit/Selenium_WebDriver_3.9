package pk_orange_hrm;

import org.testng.annotations.DataProvider;

public class OrangeHRM_ApplicationTestData {
	
	@DataProvider(name="Login")
	public Object[][] getDataforLogin(){
//Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

			{"https://opensource-demo.orangehrmlive.com/index.php/auth/login","Admin", "admin123"},
			{"https://opensource-demo.orangehrmlive.com/index.php/auth/login","vishal", "pass@1234" },
			{"https://opensource-demo.orangehrmlive.com/index.php/auth/login","abhikdixit", "test@1234" },
			{"https://opensource-demo.orangehrmlive.com/index.php/auth/login","agoel", "admin1234" }
		};

}
	
	@DataProvider(name="Users")
	public Object[][] getDataforAddUsers(){
//Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

			{"Fiona Grace","vikas", "admin123","admin123"},
			{"Fiona Grace","ankita", "admin123","admin123"},
			{"Fiona Grace","anjali", "admin123","admin123"},
			{"Fiona Grace","priyanka", "admin123","admin123"}
		};

		
}

	
}