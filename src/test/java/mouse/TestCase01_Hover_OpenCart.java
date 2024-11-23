package mouse;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonCode.ManageWebDriver;

public class TestCase01_Hover_OpenCart {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://demo.opencart.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		
		WebElement desktops = driver.findElement(By.xpath("//li[contains(@class,'dropdown')]//a[text()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//li[contains(@class,'dropdown')]//a[text()='Mac (1)']"));
		
		Actions action = new Actions(driver);
		
//		action.moveToElement(desktops).moveToElement(mac).click().build().perform();
		action.moveToElement(desktops).moveToElement(mac).click().perform();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
