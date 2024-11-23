package screenshots;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_specificElement {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String path = ".\\screenshots\\forgotPassword.png";
		WebElement forgotPasswordElement = driver.findElement(By.xpath("//p[contains(@class,'forgot')]"));
		
		File sourceFile = forgotPasswordElement.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(path);
		sourceFile.renameTo(targetFile);
		
		driver.quit();
		
	}

}
