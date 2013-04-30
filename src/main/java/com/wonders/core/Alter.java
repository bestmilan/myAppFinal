package com.wonders.core;

import org.openqa.selenium.NoAlertPresentException;

import browser.common.IGenericWebDriver;
import testngext.Logger;
import utils.Utils;

public class Alter {

	int DefaultWaitedTime = -1;
	IGenericWebDriver _driver = null;
	
	public Alter(IGenericWebDriver driver, int timeout) {
		
		_driver = driver;
		DefaultWaitedTime = timeout;
		
	}
	
	public void WaitAlterWindowPresent() {
	
		while (!IsAlterWindowPresent()) {
			
			Utils.wait(1);	
			int temp = DefaultWaitedTime - 1;
			
			if (temp == 0) {
				Logger.logInfo("Time to wait the page to load complete is more than " + DefaultWaitedTime + " seconds.");
				break;
			}
		}
		
	}

	public boolean IsAlterWindowPresent() {
		
		try {	
			_driver.switchToAlertWindow();
			return true;
			
		} catch (NoAlertPresentException e) {	
			return false;
		}
	}
		
	public void CloseAlterWindowWithAcception() {
		_driver.switchToAlertWindow().accept();
	}
	
	public void CloseAlterWindowWithAcception(String sMessage, boolean bIsMatchWholeMessage) {
		
		if (bIsMatchWholeMessage) {			
			if (_driver.switchToAlertWindow().getText().equals(sMessage)) {
				CloseAlterWindowWithAcception();
			}
		}
		
		if (!bIsMatchWholeMessage) {
			if (_driver.switchToAlertWindow().getText().contains(sMessage)) {
				CloseAlterWindowWithAcception();
			}
		}
		
	}
}
