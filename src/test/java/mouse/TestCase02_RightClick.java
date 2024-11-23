package mouse;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonCode.ManageWebDriver;

public class TestCase02_RightClick {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		
		WebElement rightClickElement = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickElement).perform();
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}
