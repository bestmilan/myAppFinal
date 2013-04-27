package com.wonders.utils;

import org.testng.Assert;

import testngext.Logger;

public class Assertion{
	public static void AssertEquals(String sActual, String sExpected) {
		Assert.assertEquals(sActual, sExpected);
		Logger.logToConsole("Asserting Passed --- Actual Value: {" + sActual
				+ "}; " + "Expected Value: {" + sExpected + "}");
		//ScreenShot.genScreenShot(driver);
	}

	public static void AssertEquals(int iAcutal, int iExpected) {
		Assert.assertEquals(iAcutal, iExpected);
		Logger.logToConsole("Asserting Passed --- Actual Value: {" + iAcutal
				+ "}; " + "Expected Value: {" + iExpected + "}");
	}

	public static void AssertTrue(boolean bCondition) {
		Assert.assertTrue(bCondition);
		Logger.logToConsole("Asserting Passed --- Actual Value: {" + bCondition
				+ "}");
	}

	public static void AssertFalse(boolean bCondition) {
		Assert.assertFalse(bCondition);
		Logger.logToConsole("Asserting Passed --- Actual Value: {" + bCondition
				+ "}");
	}

	/* Asserting if string is equal and add title */
	public static void AssertEquals(String sActual,
			String sExpected, String purpose) {
		Assert.assertEquals(sActual, sExpected);
		Logger.logToConsole(purpose + ": Asserting Passed --- Actual Value: {"
				+ sActual + "}; " + "Expected Value: {" + sExpected + "}");
		/*
		 * Reporter.log(purpose + "	Asserting Passed --- Actual Value: {" +
		 * sActual + "}; " + "Expected Value: {" + sExpected + "}");
		 */
	}

	public static void AssertTrue(boolean bCondition, String purpose) {
		Assert.assertTrue(bCondition);
		Logger.logToConsole(purpose + ": Asserting Passed --- Actual Value: {"
				+ bCondition + "}");
	}

	public static void VertifyEquals(String sActual, String sExpected) {
		try {
			Assert.assertEquals(sActual, sExpected);
			Logger.logToConsole("Vertify Passed --- Actual Value: {"
					+ sActual + "}; " + "Expected Value: {" + sExpected + "}");

		} catch (AssertionError e) {
			Logger.logToConsole("Vertify Failed --- Actual Value: {"
					+ sActual + "}; " + "Expected Value: {" + sExpected + "}");
		}
	} 

	public static void VertifyEquals(int iAcutal, int iExpected) {
		try {

			Assert.assertEquals(iAcutal, iExpected);
			Logger.logToConsole("Vertify Passed --- Actual Value: {"
					+ iAcutal + "}; " + "Expected Value: {" + iExpected + "}");

		} catch (AssertionError e) {
			Logger.logToConsole("Vertify Failed --- Actual Value: {"
					+ iAcutal + "}; " + "Expected Value: {" + iExpected + "}");
		}
	}

	public static void VertifyTrue(boolean bCondition) {
		try {

			Assert.assertTrue(bCondition);
			Logger.logToConsole("Vertify Passed --- Actual Value: {"
					+ bCondition + "}");

		} catch (AssertionError e) {
			Logger.logToConsole("Vertify Failed --- Actual Value: {"
					+ bCondition + "}");
		}
	}

	public static void VertifyFalse(boolean bCondition) {
		try {

			Assert.assertFalse(bCondition);
			Logger.logToConsole("Vertify Passed --- Actual Value: {"
					+ bCondition + "}");

		} catch (AssertionError e) {
			Logger.logToConsole("Vertify Failed --- Actual Value: {"
					+ bCondition + "}");
		}
	}

	/* Vertify if string is equal and add title */
	public static void VertifyEquals(String sActual, String sExpected,
			String purpose) {
		try {
			Assert.assertEquals(sActual, sExpected);
			Logger.logToConsole(purpose
					+ ": Vertify Passed --- Actual Value: {" + sActual
					+ "}; " + "Expected Value: {" + sExpected + "}");
			/*
			 * Reporter.log(purpose + "	Asserting Passed --- Actual Value: {" +
			 * sActual + "}; " + "Expected Value: {" + sExpected + "}");
			 */
		} catch (AssertionError e) {
			Logger.logToConsole(purpose
					+ ": Vertify Failed --- Actual Value: {" + sActual
					+ "}; " + "Expected Value: {" + sExpected + "}");
		}
	}

	public static void VertifyTrue(boolean bCondition, String purpose) {
		try {

			Assert.assertTrue(bCondition);
			Logger.logToConsole(purpose
					+ ": Vertify Passed --- Actual Value: {" + bCondition
					+ "}");

		} catch (AssertionError e) {
			Logger.logToConsole(purpose
					+ ": Vertify Failed --- Actual Value: {" + bCondition
					+ "}");
		}
	}
}
