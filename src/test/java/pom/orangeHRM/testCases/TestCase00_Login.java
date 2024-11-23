package pom.orangeHRM.testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.orangeHRM.pages.LoginPage;

public class TestCase00_Login {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"url"})
	void setup(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "credentials")
	void testLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "credentials")
	Object[][] getCredentials() {
		Object[][] credentials = {
				{"Admin", "admin123"}	
		};
		return credentials;
	}
}
