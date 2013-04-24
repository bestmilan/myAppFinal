package com.wonders.pagewrapper.issueFields;

import browser.common.Find;
import browser.common.IGenericWebElement;

import com.wonders.utils.BaseHome;

public class LocalHelpPage extends BaseHome {
	public static IGenericWebElement h1LocalHelpContent() {
		return driver.findElement(Find.byID("content")).findElement(Find.byTagName("h1"));
	}
}
