package pom.testautomationpractice.pages;

import java.time.Month;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InnerFrame {

	WebDriver driver;

	public InnerFrame(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='RESULT_TextField-0']")
	WebElement name;
	
	@FindBy(xpath = "//span[text()='Gender:']/following-sibling::table//label")
	List<WebElement> genderRadioButton;
	
	@FindBy(xpath = "//label[text()='DOB']/following-sibling::input")
	WebElement dobTextInput;
	
	@FindBy(xpath = "//label[text()='DOB']/following-sibling::span")
	WebElement dobCalendar;
	
	@FindBy(xpath = "//select[@data-handler='selectYear']")
	WebElement yearDropDown;
	
	@FindBy(xpath = "//div[@class='ui-datepicker-title']/span")
	WebElement month;
	
	@FindBy(xpath = "//a[@data-handler='prev']")
	WebElement prevCalendar;
	
	@FindBy(xpath = "//a[@data-handler='next']")
	WebElement nextCalendar;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a")
	List<WebElement> days;
	
	@FindBy(xpath = "//label[contains(text(),'Job')]/following-sibling::select")
	WebElement jobInput;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitButton;
	
	public void selectJob(String jobName) {
		jobInput.click();
		Select options = new Select(jobInput);
		options.selectByVisibleText(jobName);
		submitButton.click();
	}
	
	public void setDOB(int day, String month, int year) {
		dobCalendar.click();
		Select options = new Select(yearDropDown);
		options.selectByValue(year+"");
		
		int difference;
		while(true) {
			difference = Month.valueOf(month.toUpperCase()).compareTo(Month.valueOf(this.month.getText().toUpperCase()));
			if(difference < 0) prevCalendar.click();
			else if(difference > 0) nextCalendar.click();
			else break;
		}
		days.get(day - 1).click();
	}
	
	public void setName(String name) {
		this.name.sendKeys(name);
	}
	
	public void setGender(int index) {
		genderRadioButton.get(index).click();
	}
	
}
