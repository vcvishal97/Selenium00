package mouse;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonCode.ManageWebDriver;

public class TestCase04_DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.globalsqa.com/demo-site/draganddrop/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		
		driver.switchTo().frame(iFrame);
		
		WebElement source = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
