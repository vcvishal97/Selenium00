package dropdowns;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase02_Bootstrap {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label[contains(@class,'checkbox')]"));
		System.out.println("Number of options - " + options.size());
		System.out.println("\nAll options -");
		options.stream().map(WebElement::getText).forEach(System.out::println);
		
		for(WebElement option : options) {
			String optionStr = option.getText();
			if(optionStr.contains("Java") || optionStr.contains("MySQL"))
				option.click();
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
