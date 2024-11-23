package openCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase01 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ManageWebDriver.getDriver("https://www.opencart.com/");

		String title = driver.getTitle();
		System.out.println("Home page title " + (title.equals("OpenCart - Open Source Shopping Cart Solution") ? "found." : "not found."));

		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[1]/a")).click();
		System.out.println("Features page title " + (title.equals("OpenCart - Features") ? "found." : "not found."));
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
