package navigation_nopCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase03_NavigationCommands {

	public static void main(String[] args) {
		
		String url = "https://demo.nopcommerce.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Title of the page - " + driver.getTitle());
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		System.out.println("Title of the page - " + driver.getTitle());
		System.out.println("Navigating back to the home page.");
		driver.navigate().back();
		System.out.println("Title of the page - " + driver.getTitle());
		
		driver.quit();
	}

}
