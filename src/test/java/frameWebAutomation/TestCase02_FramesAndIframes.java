package frameWebAutomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase02_FramesAndIframes {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://ui.vision/demo/webtest/frames/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement frame03 = driver.findElement(By.xpath("//frame[contains(@src,'frame_3')]"));
		System.out.println("Switching to frame.");
		driver.switchTo().frame(frame03);
		System.out.println(driver.findElement(By.xpath("//input[@name='mytext3']/parent::*")).getText());
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Something");
		
		System.out.println("\nSwitching to iframe.");
		driver.switchTo().frame(0);
		System.out.println(driver.findElement(By.xpath("//div[@role='heading' and @aria-level='1']")).getText());
		driver.findElement(By.xpath("//label[@for='i5']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//label[@for='i19']//div[@class='uHMk6b fsHoPb']")).click();
		driver.findElement(By.xpath("//label[@for='i22']//div[@class='uHMk6b fsHoPb']")).click();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
