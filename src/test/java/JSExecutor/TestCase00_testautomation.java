package JSExecutor;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Only needs to be used when there is any element intercept exception or any other issues.
 */
public class TestCase00_testautomation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement maleRadio = driver.findElement(By.xpath("//input[@type='radio' and @name='gender' and @value='male']"));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', 'BATMAN')", name);
		jsExecutor.executeScript("arguments[0].setAttribute('value', 'IAMBATMAN@universe.dc')", email);
		jsExecutor.executeScript("arguments[0].click()", maleRadio);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	
}
