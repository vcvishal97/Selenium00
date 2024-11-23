package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonCode.ManageWebDriver;

public class TestCase05_Hidden_OrangeHRM {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();

		try {
			System.out.println("Header - " + driver.findElement(By.xpath("//*[contains(@class,'topbar-header')]/h6")).getText());
		} catch (Exception e) {
			 System.out.println("Coudln't log in.");
		}
		
		driver.findElement(By.xpath("//a[contains(@href,'Pim')]")).click();
		System.out.println("Header - " + driver.findElement(By.xpath("//*[contains(@class,'topbar-header')]/h6")).getText());
		
		driver.findElement(By.xpath("//label[text()='Employment Status']/parent::div/following-sibling::div//div[contains(@class,'input')]")).click();
		Thread.sleep(5000);
		List<WebElement> optionsEmploymentStatus = driver.findElements(By.xpath("//div[@role='option']/span"));
		System.out.println("Number of options - " + optionsEmploymentStatus.size());
		System.out.println("Options -");
		optionsEmploymentStatus.stream().map(WebElement::getText).forEach(System.out::println);
		Thread.sleep(1000);
		optionsEmploymentStatus.get(2).click();
	
		Thread.sleep(3000);
		driver.quit();
		
	}

}
