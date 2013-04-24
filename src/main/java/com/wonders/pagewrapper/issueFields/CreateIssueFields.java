package com.wonders.pagewrapper.issueFields;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDiv;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebImage;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebSelect;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTextArea;
import browser.common.IGenericWebTextField;

import com.wonders.configuration.Config;
import com.wonders.utils.BaseHome;

public class CreateIssueFields extends BaseHome {

	public static IGenericWebDiv divIssueSetupFields() {
		return driver.findDiv(Find.byID("create-issue-dialog"));
	}

	public static IGenericWebTextField txtSummary() {
		return driver.findTextField(Find.byID("summary"));
	}

	public static IGenericWebSelect selPriority() {
		return driver.findSel(Find.byID("priority"));
	}

	public static IGenericWebTextField txtDueDate() {
		return driver.findTextField(Find.byID("duedate"));
	}

	public static IGenericWebTextArea txtrEnvironment() {
		return driver.findTextArea(Find.byID("environment"));
	}

	public static IGenericWebTextArea txtrDescription() {
		return driver.findTextArea(Find.byID("description"));
	}

	public static IGenericWebSpan btnSelDueDate() {
		return driver.findSpan(Find.byText("Select a date"));
	}

	public static IGenericWebElement eleAttachement() {
		return driver.findElement(Find.byID("attachment_box").addAttribute(
				"@type", "file"));
	}

	public static IGenericWebButton btnCreateIssueSubmit() {
		return driver.findSubmitButton(Find.byID("create-issue-submit"));
	}

	public static IGenericWebLink lnkCancel() {
		return driver.findLink(Find.byClassName("cancel"));
	}

	public static IGenericWebLink lnkViewHelp() {
		return driver.findLink(Find.byID("viewHelp"));
	}

	public static IGenericWebImage imgLocalHelp() {
		return driver.findImage(Find.byTitle("Get local help about Time Tracking"));
	}
	
	public static boolean checkUploadSuccess(String fileName){
		return driver.waitForElementPresent(Find.byText(fileName), Config.getDefaultWaitedTime());
	}
}
