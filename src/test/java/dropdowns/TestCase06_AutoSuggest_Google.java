package dropdowns;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase06_AutoSuggest_Google {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.google.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String searchTerm = "Tesla";
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(searchTerm);
		
		List<WebElement> listofSuggestions = driver.findElements(By.xpath("//li[@data-attrid='AutocompletePrediction' and @role='presentation']//div[@role='option' and contains(@aria-label,'" + searchTerm.toLowerCase() + "')]"));
		System.out.println("Number of suggestions - " + listofSuggestions.size());
		System.out.println("\nSuggestions -");
		listofSuggestions.stream().map(WebElement::getText).forEach(System.out::println);
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
