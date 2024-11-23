package waitsAndSwitchWindows_orangeHRM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase01_implicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Set<String> windowIDs = null;
		
		WebDriver driver = ManageWebDriver.getDriver(url);
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Window ID - " + driver.getWindowHandle());
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		windowIDs = driver.getWindowHandles();
		System.out.println((windowIDs.size() > 1) ? "New tab opened." : "No new tab opened.");
		System.out.println(windowIDs.toString());
		
		System.out.println("Title of the page - " + driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//span[contains(@class,'header')]/h6")).isDisplayed()) {
			System.out.println("Logged in.");
			System.out.println("\"" + driver.findElement(By.xpath("//span[contains(@class,'header')]/h6")).getText() + "\"" + " is displayed.");
		}
		else
			System.out.println("Couldn't login.");
		
		driver.quit();
		
	}

}
