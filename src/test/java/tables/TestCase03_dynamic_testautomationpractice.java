package tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase03_dynamic_testautomationpractice {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Pagination')]")).getText());
		int pageCount = driver.findElements(By.xpath("//ul[@class='pagination']//a")).size();
		int rowCount = 0;
		
		System.out.println("Selected products - ");
		for(int page = 1; page <= pageCount; page++) {
			if(page > 1)
				driver.findElement(By.xpath("//ul[@class='pagination']/li[" + page + "]/a")).click();
			rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
			for(int row = 1; row <= rowCount; row++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + row + "]/td[2]")).getText());
				System.out.println("\t" + driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + row + "]/td[3]")).getText());
				driver.findElement(By.xpath("//table[@id='productTable']//tr[" + row + "]//input[@type='checkbox']")).click();
			}
		}
		
		driver.quit();
	}

}
