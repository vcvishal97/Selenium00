package waitsAndSwitchWindows_orangeHRM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonCode.ManageWebDriver;

public class TestCase03_fluentWait {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Set<String> windowIDs = null;
		
		WebDriver driver = ManageWebDriver.getDriver(url);
		/*
		 * Explicit wait - no need to add for every element. 
		 * To be used only for those elements which are having synchronization problems. 
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println("Window ID - " + driver.getWindowHandle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='OrangeHRM, Inc']"))).click();
		windowIDs = driver.getWindowHandles();
		System.out.println((windowIDs.size() > 1) ? "New tab opened." : "No new tab opened.");
		System.out.println(windowIDs.toString());
		
		System.out.println("Title of the page - " + driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'username')]"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'password')]"))).sendKeys("admin123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'login-button')]"))).click();
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'header')]/h6"))).isDisplayed()) {
			System.out.println("Logged in.");
			System.out.println("\"" + driver.findElement(By.xpath("//span[contains(@class,'header')]/h6")).getText() + "\"" + " is displayed.");
		}
		else
			System.out.println("Couldn't login.");
		
		driver.quit();
		
	}

}
