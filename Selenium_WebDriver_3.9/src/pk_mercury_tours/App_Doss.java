package pk_mercury_tours;

import org.testng.annotations.DataProvider;

public class App_Doss {
	@DataProvider(name="Login")

    public Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "testing", "testing"},
                { "dixit", "dixit" }
                };
    }
}
