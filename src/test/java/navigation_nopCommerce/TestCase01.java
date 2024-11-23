package navigation_nopCommerce;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commonCode.ManageWebDriver;

public class TestCase01 {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://demo.nopcommerce.com/";
		List<WebElement> listOfProducts = new ArrayList<>();
		String searchTerm = "apple";
		String productFromResult = "Apple iCam";
		int numberOfCategories = 1;
		boolean productFound = false;
		
		WebDriver driver = ManageWebDriver.getDriver(url);
		
		System.out.println("Title of the page - " + driver.getTitle());
		System.out.println("Number of sub lists - " + driver.findElements(By.className("sublist-toggle")).size());
		numberOfCategories = driver.findElements(By.xpath("//div[contains(@class,'item-grid')]/div/div/h2/a[contains(@title,'Show products')]")).size();
		System.out.println("Number of categories - " + numberOfCategories);
		System.out.println("Category names - ");
		for(int i = 1; i <= numberOfCategories; i++)
			System.out.println(driver.findElement(By.xpath("//div[contains(@class,'item-grid')]/div[" + i + "]/div/h2/a[contains(@title,'Show products')]")).getText());
		
		System.out.println("SEARCHING");
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys(searchTerm);
		driver.findElement(By.cssSelector("button.button-1.search-box-button")).click();
		System.out.println("Number of results - " + driver.findElements(By.cssSelector("div.details")).size());
		System.out.println(driver.findElement(By.xpath("//*[@class=\"product-title\"]/a")).getText());
		
		listOfProducts = driver.findElements(By.xpath("//*[@class=\"product-title\"]/a"));
		System.out.println("Number of products - " + listOfProducts.size());
		
		productFound = driver.findElement(By.xpath("//a[text()=\'" + productFromResult + "\']")).isDisplayed();
		System.out.println(productFromResult + " found? - " + productFound);
		
//		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
