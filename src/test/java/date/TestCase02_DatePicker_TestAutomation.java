package date;

import java.time.Duration;
import java.time.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import commonCode.ManageWebDriver;

public class TestCase02_DatePicker_TestAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String date = "27", month = "January", year = "2025";

		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		WebElement drpYear = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select yearSelect = new Select(drpYear);
		yearSelect.selectByValue(year);
		
		String currentMonth = "";
		int difference = 0;
		while(true) {
			currentMonth = driver.findElement(By.xpath("//span[contains(@class,'datepicker') and contains(@class,'month')]")).getText();
			difference = Month.valueOf(month.toUpperCase()).compareTo(Month.valueOf(currentMonth.toUpperCase()));
			System.out.println("difference - " + difference);
			if(difference < 0)
				driver.findElement(By.xpath("//span[contains(@class,'triangle') and contains(text(),'Prev')]")).click();
			else if(difference > 0)
				driver.findElement(By.xpath("//span[contains(@class,'triangle') and contains(text(),'Next')]")).click();
			else
				break;
		}
		
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + date + "']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}

