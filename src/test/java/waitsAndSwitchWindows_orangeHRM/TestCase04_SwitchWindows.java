package waitsAndSwitchWindows_orangeHRM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase04_SwitchWindows {

	public static void main(String[] args) throws InterruptedException {
		
		Set<String> windowIDs = null;
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		windowIDs = driver.getWindowHandles();
		System.out.println((windowIDs.size() > 1) ? "New tab opened." : "No new tab opened.");
		List<String> list_windowIDs = new ArrayList<>(windowIDs);
		
		String parentWindowID = list_windowIDs.get(0);
		String childWindowID = list_windowIDs.get(1);
		
		System.out.println("Title of the current window - " + driver.getTitle());
		System.out.println("Switching windows.");
		driver.switchTo().window(childWindowID);
		System.out.println("Title of the child window - " + driver.getTitle());
		System.out.println("Switching back to parent window.");
		driver.switchTo().window(parentWindowID);
		System.out.println("Title of the parent window - " + driver.getTitle());
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
