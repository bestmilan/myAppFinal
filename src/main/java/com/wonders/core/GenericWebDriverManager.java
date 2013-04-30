package com.wonders.core;

import java.util.HashMap;

import browser.common.IGenericWebDriver;

public class GenericWebDriverManager {
	private static HashMap<Long, IGenericWebDriver> map = new HashMap<Long, IGenericWebDriver>();

	public static IGenericWebDriver getDriverInstance() {
		IGenericWebDriver d = map.get(Thread.currentThread().getId());
		return d;
	}

	public static void startDriver(IGenericWebDriver driver) {
		map.put(Thread.currentThread().getId(), driver);
	}
}
