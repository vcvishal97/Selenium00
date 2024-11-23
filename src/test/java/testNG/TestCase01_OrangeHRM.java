package testNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import commonCode.ManageWebDriver;

public class TestCase01_OrangeHRM {

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
	@BeforeMethod
	public void launch() {
		driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		boolean userDropDown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed();
		Assert.assertEquals(userDropDown, true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//i[contains(@class,'userdropdown-icon')]")).click();
		driver.findElement(By.xpath("//li/a[contains(text(),'Logout')]")).click();
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
