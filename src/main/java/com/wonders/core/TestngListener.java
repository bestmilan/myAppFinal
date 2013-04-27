package com.wonders.core;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import browser.common.IGenericWebDriver;

public class TestngListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		IGenericWebDriver driver = GenericWebDriverManager.getDriverInstance();
		ScreenShot.genScreenShot(driver, tr.getTestClass().getName());
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
