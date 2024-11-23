package dropdowns;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase03_Hidden {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println("Title of the page - " + driver.getTitle());
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'login-button')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'main-menu-item') and contains(@href,'Pim')]")).click();
		driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/parent::div/div[2]/div/div/div[1]")).click();
		
		Thread.sleep(5000);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("Options -");
		options.stream().map(WebElement::getText).forEach(System.out::println);
		System.out.println("Number of options - " + options.size());
		
//		options.get(2).click();
//		System.out.println("\nSelecting Chief Executive Officer");
//		driver.findElement(By.xpath("//span[normalize-space()='Chief Executive Officer']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
