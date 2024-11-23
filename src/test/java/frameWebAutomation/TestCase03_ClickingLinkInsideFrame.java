package frameWebAutomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase03_ClickingLinkInsideFrame {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://ui.vision/demo/webtest/frames/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame05 = driver.findElement(By.xpath("//frame[contains(@src,'frame_5')]"));
		System.out.println("Switching to frame05.");
		driver.switchTo().frame(frame05);
		System.out.println(driver.findElement(By.xpath("//input[@name='mytext5']/parent::*")).getText());
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Something");
		
		System.out.println(driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).getText());
		driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();
		if(driver.findElement(By.xpath("//img[contains(@src,'logo')]")).isDisplayed())
			System.out.println("Logo displayed.");
		else
			System.out.println("Logo not displayed.");
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
