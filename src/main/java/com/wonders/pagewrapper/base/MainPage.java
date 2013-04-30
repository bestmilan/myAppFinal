package com.wonders.pagewrapper.base;

import browser.common.Find;
import browser.common.FindBy;
import browser.common.IGenericWebDiv;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTextField;

public class MainPage{
	private IGenericWebDriver driver;

	public MainPage(IGenericWebDriver _driver) {
		driver = _driver;
	}
	
	public IGenericWebSpan spnVersion() {
		return driver.findDiv(Find.byClassName("footer-body")).findSpan(
				Find.byID("footer-build-information"));
	}

	public IGenericWebSpan btnLogOutArrow() {
		return driver.findSpan(Find.byText("Access more options"));
	}

	// log out btn
	public IGenericWebLink btnLogOut() {
		return driver.findLink(Find.byID("log_out"));
	}

	// create issue
	public IGenericWebLink lnkCreateIssue() {
		return driver.findLink(Find.byID("create_link"));
	}

	public IGenericWebDiv divCreateItem() {
		return driver.findDiv(Find.byID("createItem"));
	}

	public IGenericWebLink lnkIssueCreatedKey() {
		return driver.findLink(Find.byClassName("issue-created-key"));
	}

	// quick search fields
	public IGenericWebTextField txtQuickSearchInput() {
		return driver.findTextField(Find.byID("quickSearchInput"));
	}

	// introduction of mainpage
	public IGenericWebElement eleIntroduction() {
		return driver.findElement(Find.byID("gadget-10000-title"));
	}

	// issue search lnk
	public IGenericWebLink lnkIssueSearch() {
		return driver.findLink(Find.byID("find_link"));
	}
	
	public FindBy assertMainPage(){
		return Find.byID("gadget-10000-title");	
	}
	
	public IGenericWebDiv divUserError(){
		return driver.findDiv(Find.byID("usernameerror"));
	}
}
