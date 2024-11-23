package mouse;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonCode.ManageWebDriver;

public class TestCase03_DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		
//		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";
		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		
//		Thread.sleep(2000);
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
		driver.switchTo().frame(iFrame);
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement doubleClickElement = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		
		field1.clear();
		field1.sendKeys("XYZ");
		
		Actions action = new Actions(driver);
		action.doubleClick(doubleClickElement).perform();
		
		if(field1.getAttribute("value").equals(field2.getAttribute("value")))
			System.out.println("Equal");
		else
			System.out.println("Not equal");
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
