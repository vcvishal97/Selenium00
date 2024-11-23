package blazedemo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import commonCode.ManageWebDriver;

public class TestCase01_BookFlight {

	public static void main(String[] args) {
		
		String url = "https://blazedemo.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//select[@name='fromPort']/option[1]")).click();
		driver.findElement(By.xpath("//select[@name='toPort']/option[1]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Find')]")).click();

		int rowCount = driver.findElements(By.xpath("//table[@class='table']//tbody/tr")).size();
		float minPrice = Float.MAX_VALUE;
		float currentPrice = 0;
		String currentPriceStr = "";
		int minPriceRow = Integer.MAX_VALUE;
		for(int i = 2; i <= rowCount; i++) {
			currentPriceStr = driver.findElement(By.xpath("//tr[" + i + "]//td[contains(text(),'$')]")).getText();
			currentPrice = Float.parseFloat(currentPriceStr.substring(1));
			if(currentPrice < minPrice) {
				minPrice = currentPrice;
				minPriceRow = i;
			}
		}
		System.out.println("Minimum price - " + minPrice);
		driver.findElement(By.xpath("//tr[" + minPriceRow + "]//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@name='inputName']")).sendKeys("aaa");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("bbb");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("ccc");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("ddd");
		driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys("12345");
		WebElement cardType = driver.findElement(By.xpath("//select[@name='cardType']"));
		Select drpCardType = new Select(cardType);
		drpCardType.selectByIndex(2);
		driver.findElement(By.xpath("//input[@name='creditCardNumber']")).sendKeys("9999999999999999");
		driver.findElement(By.xpath("//input[@name='creditCardMonth']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@name='creditCardYear']")).sendKeys("2222");
		driver.findElement(By.xpath("//input[@name='nameOnCard']")).sendKeys("Something");
		driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Purchase')]")).click();
		
		String validationStr = "Thank you";
		if(driver.findElement(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")).getText().contains(validationStr))
			System.out.println("Flights booked");
		
		driver.quit();
		
	}

}
