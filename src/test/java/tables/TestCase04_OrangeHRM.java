package tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase04_OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'Admin')]")).click();
		String recordsStr = driver.findElement(By.xpath("//span[contains(normalize-space(),'Records Found')]")).getText();
		System.out.println("recordsStr - " + recordsStr);
		int recordsCount = Integer.parseInt(recordsStr.substring(recordsStr.indexOf("(") + 1, recordsStr.indexOf(")")));
		System.out.println("recordsCount - " + recordsCount);
		
		System.out.println("\nUsers -");
		for(int row = 1; row <= recordsCount; row++)
			System.out.println(driver.findElement(By.xpath("//div[contains(@class,'body')]/div[" + row + "]/div[@role='row']//div[4]")).getText());
		
		driver.quit();
	}

}
