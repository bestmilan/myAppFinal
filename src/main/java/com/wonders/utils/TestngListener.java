package com.wonders.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("onTestFailure");
		// call the superclass
		super.onTestFailure(tr);
		WebDriver driver =  WebDriverManager.getDriverInstance();
	} 

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println("onTestSuccess");
	}
}
