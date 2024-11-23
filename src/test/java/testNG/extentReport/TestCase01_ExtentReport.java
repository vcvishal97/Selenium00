package testNG.extentReport;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase01_ExtentReport {

	WebDriver driver;
	String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String browserName) {
		switch(browserName.toLowerCase()) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default : System.out.println("Invalid browser name."); return;
		}
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "credentials")
	void testLogin(String email, String password) {
		String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		boolean status = driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
		if(status) {
			driver.findElement(By.xpath("//a[@title='My Account' and @data-toggle='dropdown']")).click();
			driver.findElement(By.xpath("//a[@title='My Account' and @data-toggle='dropdown']/parent::*//a[text()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
			Assert.fail();
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	@AfterTest
	@Parameters({"browser"})
	void printTestStatus(String browserName) {
		System.out.println(browserName.toLowerCase() + " done.");
	}
	
	@DataProvider(name = "credentials")
	Object[][] getLoginData() {
		Object credentials[][] = {
				{"vc.vishal971@gmail.com", "test@123"},
				{"asd", "fgbcv"},
				{"fbc", "afsz"},
				{"nfsdfc", "asdlksng"}
		};
		return credentials;
	}
	
}
