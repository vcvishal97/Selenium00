package waitsAndSwitchWindows_orangeHRM;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase05_SwitchWindows01 {

	public static void main(String[] args) throws InterruptedException {
		
		Set<String> windowIDs = null;
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		windowIDs = driver.getWindowHandles();
		System.out.println((windowIDs.size() > 1) ? "New tab opened." : "No new tab opened.");

		for(String windowID : windowIDs)
			System.out.println(driver.switchTo().window(windowID).getTitle());
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
