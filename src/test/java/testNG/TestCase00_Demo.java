package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase00_Demo {

	@BeforeClass
	public void openBrowser() {
		System.out.println("Open browser");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
	}
	
	@Test(priority = 1)
	public void search() {
		System.out.println("Search");
	}
	
	@Test(priority = 2)
	public void advancedSearch() {
		System.out.println("Advanced search");
	}
	
}
