package rediffMoney;

import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase01 {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://money.rediff.com/gainers";
		WebDriver driver = ManageWebDriver.getDriver(url);
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
