package keyboardActions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonCode.ManageWebDriver;

public class TestCase00_testautomation {
	
	public static void main(String args[]) throws InterruptedException {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("THIS WILL BE COPIED!!!!!!!!!!!");
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.TAB).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
