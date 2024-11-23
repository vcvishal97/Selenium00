package testNG.extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;	//to configure the UI of the report
	public ExtentReports extent;				//to populate common info in the report
	public ExtentTest test;						//to create test case entry in the report and update the status
	
	@Override
	public void onTestStart(ITestResult result) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation report");
		sparkReporter.config().setReportName("Functional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "Vishal");
		extent.setSystemInfo("Browser name", "Chrome");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is - " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is - " + result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is - " + result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is - " + result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
