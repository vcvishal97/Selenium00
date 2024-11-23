package testAutomationPractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import commonCode.ManageWebDriver;

public class TestCase03_SelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement drpCountryElement = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountry = new Select(drpCountryElement);
		
		List<WebElement> options = drpCountry.getOptions();
		System.out.println("All options -");
		for(WebElement option : options)
			System.out.println(option.getText());
		
		System.out.println("Number of options - " + options.size());
		
		drpCountry.selectByIndex(1);

		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
