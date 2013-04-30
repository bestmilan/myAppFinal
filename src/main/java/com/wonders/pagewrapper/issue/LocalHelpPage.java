package com.wonders.pagewrapper.issue;
import browser.common.Find;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
@SuppressWarnings("unused")
public class LocalHelpPage{
	private IGenericWebDriver driver;
	public LocalHelpPage(IGenericWebDriver _driver) {
		driver = _driver;
	}
	public IGenericWebElement h1LocalHelpContent() {
		return driver.findElement(Find.byID("content")).findElement(Find.byTagName("h1"));
	}
}