package demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase01 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ManageWebDriver.getDriver("https://demoblaze.com/#");
		
		System.out.println("Number of categories - " + driver.findElements(By.id("itemc")).size());
		driver.findElement(By.linkText("Phones")).click();
		Thread.sleep(3000);
		
		System.out.println("Number of phones - " + driver.findElements(By.className("card-block")).size());
		Thread.sleep(10000);
		
		driver.quit();
		
	}

}
