package com.wonders.pagewrapper.issue;
import browser.common.Find;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElementCollection;
@SuppressWarnings("unused")
public class WikiHelpPage{
	private IGenericWebDriver driver;
	public WikiHelpPage(IGenericWebDriver _driver) {
		driver = _driver;
	}
	public IGenericWebElementCollection divLeftNav() {
		return driver.findTableCell(Find.byID("lefthand-nav")).findDivs(
				Find.byClassName("optionPadded"));
	}
}