package task_baseclass;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Task_ListnerImp implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("OnStart ISuite Executed");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("OnFinish ISuite Executed");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart Executed");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("OnTestSuccess Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailure Executed");	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped Executed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("OnTestFailedButWithinSuccessPercentage Executed");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("OnTestFailedWithTimeout Executed");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("OnStart ITestContext Executed");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish ITestContext Executed");
	}
}

	