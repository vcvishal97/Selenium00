package testAutomationPractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase01_SearchClickSwitchWindows {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://testautomationpractice.blogspot.com/";
		String searchStr = "Apple";

		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[contains(@id,'search-input')]")).sendKeys(searchStr);
		driver.findElement(By.xpath("//input[contains(@class,'search-button')]")).click();
		
		List<WebElement> resultLinks = driver.findElements(By.xpath("//*[contains(@id,'search-result-link')]/a"));
		System.out.println("Number of result links - " + resultLinks.size());
		
		System.out.println("Clicking on each link.");
		for(WebElement resultLink : resultLinks) {
			if(resultLink.isEnabled()) {
				System.out.println(resultLink.getText());
				resultLink.click();
			}
		}
		
		System.out.println("Switching through each window and printing the titles below.");
		for(String windowHandle : driver.getWindowHandles())
			System.out.println(driver.switchTo().window(windowHandle).getTitle());
		
		driver.quit();
	}

}
