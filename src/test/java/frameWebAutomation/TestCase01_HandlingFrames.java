package frameWebAutomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase01_HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://ui.vision/demo/webtest/frames/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Switching to frame 1.");
		WebElement frame1 = driver.findElement(By.xpath("//frame[contains(@src,'frame_1')]"));
		driver.switchTo().frame(frame1);
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'mytext1')]/parent::*")).getText());
		driver.findElement(By.xpath("//input[contains(@name,'mytext1')]")).sendKeys("Something");
		
		//We can't directly switch from one frame to another.
		driver.switchTo().defaultContent();
		
		System.out.println("\nSwitching to frame 2.");
		WebElement frame2 = driver.findElement(By.xpath("//frame[contains(@src,'frame_2')]"));
		driver.switchTo().frame(frame2);
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'mytext2')]/parent::*")).getText());
		driver.findElement(By.xpath("//input[contains(@name,'mytext2')]")).sendKeys("Something else");

		driver.switchTo().defaultContent();
		System.out.println("\nSwitching to frame 3.");
		WebElement frame3 = driver.findElement(By.xpath("//frame[contains(@src,'frame_3')]"));
		driver.switchTo().frame(frame3);
		System.out.println(driver.findElement(By.xpath("//input[contains(@name,'mytext3')]/parent::*")).getText());
		driver.findElement(By.xpath("//input[contains(@name,'mytext3')]")).sendKeys("Something more");
		
		System.out.println("\nSwitching to iframe inside frame 3.");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
