package testNG.DataDrivenTesting.OrangeHRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase01_Login {

	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser", "url"})
	void setup(String browser, String url) {
		switch(browser.toLowerCase()) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default : System.out.println("Invalid browser name."); return;
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "credentials")
	void testLogin(String username, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		boolean dashboardStatus = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		if(dashboardStatus) {
			Assert.assertTrue(dashboardStatus);
			driver.findElement(By.xpath("//p[contains(@class,'userdropdown-name')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		}
		else
			Assert.fail();
	}

	@AfterTest
	@Parameters({"browser"})
	void tearDown(String browser) {
		driver.quit();
		System.out.println("Done with " + browser);
	}
	
	@DataProvider(name = "credentials")
	Object[][] getCredentials() {
		Object[][]  credentials = {
				{"Admin", "admin123"},	
				{"xyz", "xyz"}
		};
		return credentials;
	}
	
}
