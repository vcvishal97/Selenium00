package tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase02_dynamicPagination_OpenCartAdmin {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://demo3x.opencartreports.com/admin/index.php?route=common/login";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Customers') and @class='parent']/following-sibling::ul//a[contains(text(),'Customers')]")).click();
		
		String pagesData = driver.findElement(By.xpath("//div[contains(text(),'Showing') and contains(text(),'Pages')]")).getText();
		System.out.println("pagesData - " + pagesData);
		int numberOfpages = Integer.parseInt(pagesData.substring(pagesData.indexOf("(")+1, pagesData.indexOf("Pages")-1));
		System.out.println("numberOfpages - " + numberOfpages);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
