package pk_mercury_tours;

import org.testng.annotations.DataProvider;


public class ApplicationTestData {

	@DataProvider(name="Login")
	public Object[][] getDataFromDataprovider(){

		return new Object[][] {

			{"http://newtours.demoaut.com/mercurywelcome.php","testing", "testing"},

			{"http://newtours.demoaut.com/mercurywelcome.php","dixit", "dixit" },
			{"http://newtours.demoaut.com/mercurywelcome.php","testabhi", "testabhi" }

		};
	}


	@DataProvider(name="HDFC")
	public Object[][] getDataForHDFC(){

		return new Object[][] {

			{"1000"},
			{"2000" },
			{"3000" }

		};
	}


	@DataProvider(name="Search")
	public Object[][] SearchDataprovider(){

		return new Object[][] {

			{"Paris", "London"},

			{"New York", "Portland" }

		};
	}

	//-------------------------------------------- This is to read Excel Data------------

	@DataProvider(name = "LoginData")
	public Object[][] Authentication() throws Exception{
		ReadExcel excel = new ReadExcel();
		Object[][] testObjArray = excel.getExcelData("D:\\F Drive\\Selenium Training Data\\workspace\\Selenium_WebDriver_3.9\\FlightTestData.xls","TestData");
		System.out.println(testObjArray);
		return testObjArray;

	}
	
	//---------This is to read Data from DataBase------------

/*	@DataProvider(name = "LoginDB")
	public Object[][] ReadDataFromDB() throws Exception{
		DataBase_Example db = new DataBase_Example();
		Object[][] testObjArray = db.ConnectMySQLDatabase("uname", "upassword");
		System.out.println(testObjArray);
		return testObjArray;

	}*/
}
