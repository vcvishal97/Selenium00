package pom.testautomationpractice.testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.testautomationpractice.pages.InnerFrame;

public class TestCase_Temp {

	WebDriver driver;
	InnerFrame innerFrame;
	
	@BeforeClass
	@Parameters({"url"})
	void setUp(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
	}
	
	@Test(priority = 1)
	void testName() {
		innerFrame = new InnerFrame(driver);
		innerFrame.setName("BATMAN");
	}

	@Test(priority = 2)
	void testGenderInput() {
		innerFrame.setGender(0);
	}
	
	@Test(priority = 3)
	void testDOBInput() {
		innerFrame.setDOB(27, "May", 1997);
	}
	
	@Test(priority = 4)
	void testJobInput() {
		innerFrame.selectJob("Automation Engineer");
	}
	
	@AfterClass
	void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
