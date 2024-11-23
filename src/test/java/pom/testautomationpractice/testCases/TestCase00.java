package pom.testautomationpractice.testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.testautomationpractice.pages.HomePage;

public class TestCase00 {

	WebDriver driver;
	HomePage homePage;
	
	@BeforeClass
	@Parameters({"url"})
	void setUp(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	void testTextInputs() {
		homePage = new HomePage(driver);
		homePage.setName("AAA");
		homePage.setEmail("BBB@CCC.com");
		homePage.setPhone("123456789");
		homePage.setAddress("qwerty");
	}
	
	@Test(priority = 2)
	void testRadioButton() {
		homePage.setRadioButton(0);
	}
	
	@Test(priority = 3)
	void testCheckBoxes() {
		if(homePage.getNumberOfDays() == 0)
			Assert.fail("CheckBoxes not found");
		homePage.setDays(0);
		homePage.setDays(3);
	}
	
	@Test(priority = 4)
	void testDropDown() {
		homePage.getCountries().stream().map(WebElement::getText).forEach(System.out::println);
		homePage.selectCountry(9);
		String selectedCountry = homePage.getSelectedCountry().get(0).getText();
		if(!selectedCountry.toLowerCase().equals("india"))
			Assert.fail("Selected country isn't India.");
	}
	
	@Test(priority = 5)
	void testColors() {
		homePage.selectColors(1, 3);
		if(homePage.getSelectedColors().size() == 0)
			Assert.fail("Nothing selected.");
	}
	
	@Test(priority = 6)
	void testCalendar() {
		homePage.selectDate(22, "January", 2023);
	}
	
	@Test(priority = 7)
	void testWebTable() {
		homePage.getBooksByAuthor("Amit");
	}
	
	@Test(priority = 8)
	void testPaginationTable() throws InterruptedException {
		homePage.selectProducts();
	}
	
	@Test(priority = 9)
	void testWikipediaSearch() throws InterruptedException {
		homePage.searchWikipedia("Tesla");
		homePage.printSearchResults();
		homePage.clickSearchResultsAndSwitchWindows();
	}
	
	@Test(priority = 10)
	void testJSAlerts() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.clickJSAlerts();
	}
	
	@Test(priority = 11)
	void testDoubleClick() {
		homePage = new HomePage(driver);
		homePage.clickCopyTextButton();
	}
	
	@Test(priority = 12)
	void testDragAndDrop() {
		homePage = new HomePage(driver);
		homePage.testDragAndDrop();
	}
	
	@Test(priority = 13)
	void testSlider() {
		homePage = new HomePage(driver);
		homePage.moveSlider();
	}
	
	@AfterClass
	void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
