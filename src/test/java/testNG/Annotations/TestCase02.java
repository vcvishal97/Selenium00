package testNG.Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase02 {

	@Test
	public void method0() {
		System.out.println("method0 test02");
	}
	
	@Test
	public void method1() {
		System.out.println("method1 test02");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod02");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod02");
	}
	
}
