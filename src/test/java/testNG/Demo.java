package testNG;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	@BeforeMethod(alwaysRun = true)
	public void login() {
		Reporter.log("login",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		Reporter.log("logout",true);
	}
	
	@Test
	public void createCustomer() {
		Reporter.log("createCustomer",true);
	}
	
	@Test(groups="deleteCustomer")
	public void deleteCustomer() {
		Reporter.log("deleteCustomer",true);
	}
	
	
}
