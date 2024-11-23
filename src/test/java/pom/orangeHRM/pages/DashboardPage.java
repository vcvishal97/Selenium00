package pom.orangeHRM.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='oxd-main-menu-item']")
	List<WebElement> mainMenu;
	
	@FindBy(xpath = "//a[@class='oxd-main-menu-item']//span[text()='Admin']")
	WebElement menuAdmin;
	
	
	public void clickAdmin() {
		menuAdmin.click();
	}
}
