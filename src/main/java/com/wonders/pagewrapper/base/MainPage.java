package com.wonders.pagewrapper.base;

import browser.common.Find;
import browser.common.FindBy;
import browser.common.IGenericWebDiv;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTextField;

import com.wonders.utils.BaseHome;

public class MainPage extends BaseHome {
	public static IGenericWebSpan spnVersion() {
		return driver.findDiv(Find.byClassName("footer-body")).findSpan(
				Find.byID("footer-build-information"));
	}

	public static IGenericWebSpan btnLogOutArrow() {
		return driver.findSpan(Find.byText("Access more options"));
	}

	// log out btn
	public static IGenericWebLink btnLogOut() {
		return driver.findLink(Find.byID("log_out"));
	}

	// create issue
	public static IGenericWebLink lnkCreateIssue() {
		return driver.findLink(Find.byID("create_link"));
	}

	public static IGenericWebDiv divCreateItem() {
		return driver.findDiv(Find.byID("createItem"));
	}

	public static IGenericWebLink lnkIssueCreatedKey() {
		return driver.findLink(Find.byClassName("issue-created-key"));
	}

	// quick search fields
	public static IGenericWebTextField txtQuickSearchInput() {
		return driver.findTextField(Find.byID("quickSearchInput"));
	}

	// introduction of mainpage
	public static IGenericWebElement eleIntroduction() {
		return driver.findElement(Find.byID("gadget-10000-title"));
	}

	// issue search lnk
	public static IGenericWebLink lnkIssueSearch() {
		return driver.findLink(Find.byID("find_link"));
	}
	
	public static FindBy assertMainPage(){
		return Find.byID("gadget-10000-title");	
	}
	
	public static IGenericWebDiv divUserError(){
		return driver.findDiv(Find.byID("usernameerror"));
	}
}
