package alerts_internetHerokuApp;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase03_handlingAlerts_basicAuthentication {

	/*
	 * Basic authentication is the pop which asks for the credentials.
	 * To handle this, we need to pass the credentials along with the URL.
	 * URL format - <protocol>://<username>:<password>@<URL>
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		String username = "adming", password = "admin";
		String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			if(driver.findElement(By.xpath("//div[@class='example']/p")).getText().contains("Congratulations"))
				System.out.println("Logged in.");
		} catch (Exception NoSuchElementException) {
			System.out.println("Wrong credentials.");
		}
		
		driver.quit();
	}

}
