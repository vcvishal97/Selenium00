package date;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonCode.ManageWebDriver;

public class TestCase01_DatePicker_jQueryui {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://jqueryui.com/datepicker/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String date = "27", month = "May", year = "2025";
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[contains(@src,'datepicker')]"));
		driver.switchTo().frame(iFrame);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[contains(@class,'datepicker-month')]")).getText();
			String currentYear = driver.findElement(By.xpath("//span[contains(@class,'datepicker-year')]")).getText();
			if(currentMonth.equals(month) && currentYear.equals(year))
				break;
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		}
		driver.findElement(By.xpath("//table[contains(@class,'datepicker-calendar')]//a[@data-date='" + date + "']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
