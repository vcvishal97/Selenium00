package dropdowns;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase04_phppot {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//select[@name='country']")).click();
		List<WebElement> optionsCountry = driver.findElements(By.xpath("//select[@name='country']/option[@value!='']"));
		System.out.println("Number of options - " + optionsCountry.size());
		System.out.println("The options are - ");
		optionsCountry.stream().map(WebElement::getText).forEach(System.out::println);
		optionsCountry.get(3).click();
		
		driver.findElement(By.xpath("//select[@name='state']")).click();
		List<WebElement> optionsStates = driver.findElements(By.xpath("//select[@name='state']/option[@value!='']"));
		System.out.println("\nNumber of options - " + optionsCountry.size());
		System.out.println("The options are - ");
		optionsStates.stream().map(WebElement::getText).forEach(System.out::println);
		optionsStates.get(2).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
