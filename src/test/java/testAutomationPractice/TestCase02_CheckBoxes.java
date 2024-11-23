package testAutomationPractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase02_CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> listCheckBoxes = driver.findElements(By.xpath("//input[contains(@class,'form-check') and @type='checkbox']"));
		
		System.out.println("Checking.");
		for(WebElement checkBox : listCheckBoxes) {
			System.out.println(checkBox.getAttribute("value"));
			checkBox.click();
		}
		
		System.out.println("Unchecking using alternate method.");
		for(int i = 1; i <= listCheckBoxes.size(); i++) {
			System.out.println(driver.findElement(By.xpath("(//input[contains(@class,'form-check') and @type='checkbox'])[" + i + "]/following-sibling::*")).getText());
			listCheckBoxes.get(i-1).click();
		}
		
		driver.quit();
		
	}

}
