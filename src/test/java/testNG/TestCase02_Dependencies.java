package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02_Dependencies {

	@Test(priority = 1)
	public void login() {
		Assert.assertTrue(false);
	}
	
	@Test(priority = 2, dependsOnMethods = {"login"})
	public void search() {
		Assert.assertTrue(true);
	}
	
	@Test(priority = 3, dependsOnMethods = {"login", "search"})
	public void advancedSearch() {
		Assert.assertTrue(true);
	}
	
}
