package testNG.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase01 {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod01");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod01");
	}
	
	@Test
	public void test() {
		System.out.println("test01");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
}
