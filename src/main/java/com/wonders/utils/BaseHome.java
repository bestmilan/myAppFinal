package com.wonders.utils;

import browser.common.BrowserType;
import browser.common.GenericWebDriverFactory;
import browser.common.IGenericWebDriver;

public class BaseHome {

	/* Get driver for Home Page */ 
	public static IGenericWebDriver driver;

	public static void Launch(String sBrowserType, String sURL) {

		if (sBrowserType.equals(BrowserType.FireFox.toString())) {
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getFireFoxDriver());
		}

		if (sBrowserType.equals(BrowserType.InternetExplorer.toString())) {
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getIEDriver());
		}

		if (sBrowserType.equals(BrowserType.Chrome.toString())) {
			
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getChromeDriver());
		}
	}

	/* Quit Browser */
	public static void Quit() {
		driver.quit();
	}

	/* Close Browser */
	public static void Close() {
		driver.close();
	}
	
	/* wait for page complete */
	public static void waitForComplete() {
		driver.waitForComplete();
	}
	
	/* wait for complete */
	public static void excuteJs(String script) {
		driver.executeScript(script); 
	}
}
