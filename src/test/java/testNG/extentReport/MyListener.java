package testNG.extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{

	public void onStart(ITestContext context) {
		System.out.println("started");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("test started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test successful");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("finished");
	}
}
