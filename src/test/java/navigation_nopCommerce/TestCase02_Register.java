package navigation_nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonCode.ManageWebDriver;

public class TestCase02_Register {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://demo.nopcommerce.com/";
		WebDriver driver = ManageWebDriver.getDriver(url);
		
		//Register page
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		if(driver.getTitle().contains("Register")) {
			System.out.println("Register page launched.");
			System.out.println("Title of the page - " + driver.getTitle());
		}
		else
			System.out.println("Register page not launched.");
		
		WebElement maleRadio = driver.findElement(By.xpath("//*[text()='Male']"));
		WebElement femaleRadio = driver.findElement(By.xpath("//*[text()='Female']"));
		
		System.out.println("Before selection : Male - " + maleRadio.isSelected() + "\tFemale - " + femaleRadio.isSelected());
		maleRadio.click();
		System.out.println("After selection : Male - " + maleRadio.isSelected() + "\tFemale - " + femaleRadio.isSelected());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
