package tables;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase01_static_testautomationpractice {

	public static void main(String[] args) {
		
		String url = "https://testautomationpractice.blogspot.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(driver.findElement(By.xpath("//h2[@class='title' and text()='Web Table']")).getText());
		List<WebElement> listRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		List<WebElement> listColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Number of rows - " + listRows.size());
		System.out.println("Number of columns - " + listColumns.size());
		
		//Book names whose author is Mukesh.
		String author = "Mukesh";
		System.out.println("\nBooks by " + author);
		for(int i = 2; i <= listRows.size(); i++) {
			String authorFromTable = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[2]")).getText();
			if(authorFromTable.equals(author))
				System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[1]")).getText());	
		}

		int totalPrice = 0;
		for(int i = 2; i <= listRows.size(); i++)
			totalPrice += Integer.parseInt(driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[4]")).getText());
		System.out.println("\nPrice of all books -" + totalPrice);		
		driver.quit();
	}

}
