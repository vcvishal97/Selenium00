package alerts_internetHerokuApp;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonCode.ManageWebDriver;

public class TestCase01_handlingAlerts_usingSwitchTo {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver = ManageWebDriver.getDriver(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Alert alert = null;
		manageAlerts(driver, alert, "jsAlert");
		manageAlerts(driver, alert, "jsConfirm");
		manageAlerts(driver, alert, "jsPrompt");
		
		driver.quit();
	}
	
	private static void manageAlerts(WebDriver driver, Alert alert, String alertType) {
		System.out.println();
		
		System.out.println(driver.findElement(By.xpath("//button[contains(@onClick,'"+ alertType + "')]")).getText());
		driver.findElement(By.xpath("//button[contains(@onClick,'"+ alertType + "')]")).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		if(alertType.contains("Prompt"))
			alert.sendKeys("Nothing");
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
		
		driver.findElement(By.xpath("//button[contains(@onClick,'"+ alertType + "')]")).click();
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//*[@id='result']")).getText());
	}

}
