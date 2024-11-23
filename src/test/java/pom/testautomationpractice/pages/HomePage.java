package pom.testautomationpractice.pages;

import java.time.Month;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//label[contains(text(),'Address')]/following-sibling::*")
	WebElement address;
	
	@FindBy(xpath = "//input[@type='radio' and @name='gender']")
	List<WebElement> radioButtons;
	
	@FindBy(xpath = "//label[contains(text(),'Days')]//parent::div//input[@type='checkbox']")
	List<WebElement> daysCheckBoxes;

	@FindBy(xpath = "//select[@id='country']")
	WebElement countryDropDown;
	
	@FindBy(xpath = "//select[@id='colors']")
	WebElement colors;
	
	@FindBy(xpath = "//input[@id='datepicker']")
	WebElement datePicker;
	
	@FindBy(xpath = "//div[@id='ui-datepicker-div']//table//a")
	List<WebElement> dates;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	WebElement year;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	WebElement month;
	
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
	WebElement prevCalendar;
	
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement nextCalendar;
	
	@FindBy(xpath = "//table[@name='BookTable']//td[2]")
	List<WebElement> authorNames;
	
	@FindBy(xpath = "//ul[@id='pagination']//a")
	List<WebElement> pagesInPagination;
	
	@FindBy(xpath = "//table[@id='productTable']//tbody/tr")
	List<WebElement> productsInPagination;
	
	@FindBy(xpath = "//table[@id='productTable']//tbody/tr/td[4]/input")
	List<WebElement> productCheckBox;
	
	@FindBy(xpath = "//input[@id='Wikipedia1_wikipedia-search-input']")
	WebElement wikipediaSearchInput;
	
	@FindBy(xpath = "//input[@class='wikipedia-search-button']")
	WebElement wikipediaSearchButton;
	
	@FindBy(xpath = "//div[@id='Wikipedia1_wikipedia-search-results']//a")
	List<WebElement> searchResults;
	
	@FindBy(xpath = "//h2[text()='JS Alerts']/following-sibling::div[1]/button")
	List<WebElement> alertButtons;
	
	@FindBy(xpath = "//h2[text()='JS Alerts']/following-sibling::div[1]/p")
	WebElement alertMessage;
	
	@FindBy(xpath = "//button[text()='Copy Text']")
	WebElement copyTextButton;
	
	@FindBy(xpath = "//h2[text()='Double Click']/following-sibling::div[1]/input[@id='field1']")
	WebElement field1;

	@FindBy(xpath = "//h2[text()='Double Click']/following-sibling::div[1]/input[@id='field2']")
	WebElement field2;

	@FindBy(xpath = "//div[@id='draggable']/p")
	WebElement draggableElement;
	
	@FindBy(xpath = "//div[@id='droppable']/p")
	WebElement droppableElement;
	
	@FindBy(xpath = "//div[@id='slider']/span")
	WebElement slider;
	
	public void moveSlider() {
		Actions action = new Actions(driver);
		for(int i = 0; i < 10; i++)
			action.dragAndDropBy(slider, i, 0).perform();
	}
	
	public void testDragAndDrop() {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableElement, droppableElement).perform();;
		Assert.assertEquals(droppableElement.getText(), "Dropped!");
	}
	
	public void clickCopyTextButton() { 
		Actions action = new Actions(driver);
		field1.clear();
		field1.sendKeys("BATMAN");
		action.doubleClick(copyTextButton).perform();;
		System.out.println(field1.getText());
		System.out.println(field2.getText());
		Assert.assertEquals(field1.getAttribute("value"), field2.getAttribute("value"));
	}
	
	public void clickJSAlerts() throws InterruptedException {
		System.out.println("Number of alerts - " + alertButtons.size());
		Alert alert;
		for(WebElement alertButton : alertButtons) {
			System.out.println(alertButton.getText());
			if(alertButton.getText().contains("Alert")) {
				alertButton.click();
				alert = driver.switchTo().alert();
				alert.accept();
			}
			else if(alertButton.getText().contains("Confirm Box")) {
				alertButton.click();
				alert = driver.switchTo().alert();
				alert.accept();
				Assert.assertEquals("You pressed OK!", alertMessage.getText());
			}
			else if(alertButton.getText().contains("Prompt")) {
				alertButton.click();
				alert = driver.switchTo().alert();
				alert.accept();
				Assert.assertEquals("Hello Harry Potter! How are you today?", alertMessage.getText());
			}
			else
				Assert.fail("Something else - " + alertButton.getText());
		}
	}
	
	public void clickSearchResultsAndSwitchWindows() throws InterruptedException {
		String mainWindowID =driver.getWindowHandle();
		for(WebElement result : searchResults)
			result.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowID : windowHandles) {
			driver.switchTo().window(windowID);
			Thread.sleep(1500);
		}
		for(String windowID : windowHandles)
			if(!windowID.equals(mainWindowID))
				driver.switchTo().window(windowID).close();
		//Switching to main window
		driver.switchTo().window(mainWindowID);
	}
	
	public void printSearchResults() {
		for(WebElement result : searchResults)
			System.out.print(result.getText() + ", ");
		System.out.println();
	}
	
	public void searchWikipedia(String searchTerm) {
		wikipediaSearchInput.sendKeys(searchTerm);
		wikipediaSearchButton.click();
	}
	
	public void selectProducts() throws InterruptedException {
		System.out.println("pagesInPagination - " + pagesInPagination.size());
		for(int i = 0; i < pagesInPagination.size(); i++) {
			if(i != 0)
				pagesInPagination.get(i).click();
			for(int j = 0; j < productsInPagination.size(); j++)
				productCheckBox.get(j).click();
			Thread.sleep(1000);
		}
	}
	
	public void getBooksByAuthor(String authorName) {
		List<WebElement> books = driver.findElements(By.xpath("//table[@name='BookTable']//td[contains(text(),'" + authorName + "')]/parent::tr/td[1]"));
		for(WebElement book : books)
			System.out.print(book.getText() + ", ");
		System.out.println();
	}
	
	public void selectDate(int date, String month, int year) {
		datePicker.click();
		while(true) {
			int currentYear = Integer.parseInt(this.year.getText());
			if(currentYear < year) nextCalendar.click();
			else if(currentYear > year) prevCalendar.click();
			else break;
		}
		while(true) {
			String currentMonth = this.month.getText();
			int difference = Month.valueOf(month.toUpperCase()).compareTo(Month.valueOf(currentMonth.toUpperCase()));
			if(difference < 0) prevCalendar.click();
			else if(difference > 0) nextCalendar.click();
			else break;
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + date + "']")).click();
	}
	
	public void selectColors(int... indexes) {
		Select colors = new Select(this.colors);
		for(int index : indexes)
			colors.selectByIndex(index);
	}
	
	public List<WebElement> getSelectedColors(){
		return new Select(this.colors).getAllSelectedOptions();
	}
	
	public List<WebElement> getSelectedCountry() {
		Select drpCountry = new Select(countryDropDown);
		return drpCountry.getAllSelectedOptions();
	}
	
	public List<WebElement> getCountries() {
		Select drpCountry = new Select(countryDropDown);
		return drpCountry.getOptions();
	}
	
	public void selectCountry(int index) {
		Select drpCountry = new Select(countryDropDown);
		drpCountry.selectByIndex(index);
	}
	
	public int getNumberOfDays() {
		return this.daysCheckBoxes.size();
	}
	
	public void setDays(int index) {
		this.daysCheckBoxes.get(index).click();
	}
	
	public void setName(String name) {
		this.name.sendKeys(name);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPhone(String phone) {
		this.phone.sendKeys(phone);;
	}

	public void setAddress(String address) {
		this.address.sendKeys(address);;
	}
	
	public void setRadioButton(int index) {
		this.radioButtons.get(index).click();
	}
	
}
