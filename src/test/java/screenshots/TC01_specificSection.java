package screenshots;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_specificSection {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		WebElement loginSlot = driver.findElement(By.xpath("//div[@class='orangehrm-login-slot']"));
		String path = ".\\screenshots\\loginSlot.png";

		File sourceFile = loginSlot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(path);
		
		sourceFile.renameTo(targetFile);
		
		driver.quit();
	}

}
