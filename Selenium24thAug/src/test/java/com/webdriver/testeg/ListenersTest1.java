package com.webdriver.testeg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest1 implements ITestListener{

	public void onFinish(ITestContext Result) {
		System.out.println("The name of the test which is finished: "+Result.getName() );
		
	}

	public void onStart(ITestContext Result) {
		System.out.println("The name of the test which is started: "+Result.getName() );
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println("The name of the test which is failedwith percentage: "+Result.getName() );
		
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the test which is failed: "+Result.getName() );
		
		
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("the name of the test case is skipped" + Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("the name of the test case is test started" + Result.getName());
		
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("the name of the test case is success" + Result.getName());
		
	}

}
