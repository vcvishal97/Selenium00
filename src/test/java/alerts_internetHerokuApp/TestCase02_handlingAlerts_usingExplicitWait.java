package alerts_internetHerokuApp;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonCode.ManageWebDriver;

public class TestCase02_handlingAlerts_usingExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://the-internet.herokuapp.com/javascript_alerts";
		WebDriver driver = ManageWebDriver.getDriver(url);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		manageAlerts(driver, wait, "jsAlert");
		manageAlerts(driver, wait, "jsConfirm");
		manageAlerts(driver, wait, "jsPrompt");
		
		driver.quit();
	}
	
	private static void manageAlerts(WebDriver driver, WebDriverWait wait, String alertType) {
		System.out.println();
		
		System.out.println(driver.findElement(By.xpath("//button[contains(@onClick,'"+ alertType + "')]")).getText());
		driver.findElement(By.xpath("//button[contains(@onClick,'"+ alertType + "')]")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
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
