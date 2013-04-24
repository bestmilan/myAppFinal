package com.wonders.pagewrapper.issueFields;

import browser.common.Find;
import browser.common.IGenericWebElementCollection;

import com.wonders.utils.BaseHome;

public class WikiHelpPage extends BaseHome {

	public static IGenericWebElementCollection divLeftNav() {
		return driver.findTableCell(Find.byID("lefthand-nav")).findDivs(
				Find.byClassName("optionPadded"));
	}
}
