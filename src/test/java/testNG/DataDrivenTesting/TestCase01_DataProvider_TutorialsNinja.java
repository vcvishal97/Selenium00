package testNG.DataDrivenTesting;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase01_DataProvider_TutorialsNinja {
	
	WebDriver driver;
	String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "credentials")
	void testLogin(String email, String password) {
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
