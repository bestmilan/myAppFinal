package com.wonders.core;

import com.wonders.utils.Common;

import browser.common.BrowserType;
import browser.common.GenericWebDriverFactory;
import browser.common.IGenericWebDriver;

public class BaseHome {

	/* Get driver for Home Page */ 
	public IGenericWebDriver driver;

	public void Launch(String sBrowserType, String sURL) {

		if (sBrowserType.equals(BrowserType.FireFox.toString())) {
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getFireFoxDriver());
		}else if (sBrowserType.equals(BrowserType.InternetExplorer.toString())) {
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getIEDriver());
		}else if (sBrowserType.equals(BrowserType.Chrome.toString())) {			
			driver = GenericWebDriverFactory.getGenericWebDriver(sBrowserType,
					sURL, Common.getChromeDriver());
		}
		GenericWebDriverManager.startDriver(driver);
	}

	/* Quit Browser */
	public void Quit() {
		driver.quit();
	}

	/* Close Browser */
	public void Close() {
		driver.close();
	}
	
}
