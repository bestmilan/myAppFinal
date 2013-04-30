package com.wonders.pagewrapper.issue;
import com.wonders.configuration.Config;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDiv;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebImage;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebSelect;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTextArea;
import browser.common.IGenericWebTextField;
@SuppressWarnings("unused")
public class CreateIssueFields{
	private IGenericWebDriver driver;
	public CreateIssueFields(IGenericWebDriver _driver) {
		driver = _driver;
	}
	public IGenericWebDiv divIssueSetupFields() {
		return driver.findDiv(Find.byID("create-issue-dialog"));
	}

	public IGenericWebTextField txtSummary() {
		return driver.findTextField(Find.byID("summary"));
	}

	public IGenericWebSelect selPriority() {
		return driver.findSel(Find.byID("priority"));
	}

	public IGenericWebTextField txtDueDate() {
		return driver.findTextField(Find.byID("duedate"));
	}

	public IGenericWebTextArea txtrEnvironment() {
		return driver.findTextArea(Find.byID("environment"));
	}

	public IGenericWebTextArea txtrDescription() {
		return driver.findTextArea(Find.byID("description"));
	}

	public IGenericWebSpan btnSelDueDate() {
		return driver.findSpan(Find.byText("Select a date"));
	}

	public IGenericWebElement eleAttachement() {
		return driver.findElement(Find.byID("attachment_box").addAttribute(
				"@type", "file"));
	}

	public IGenericWebButton btnCreateIssueSubmit() {
		return driver.findSubmitButton(Find.byID("create-issue-submit"));
	}

	public IGenericWebLink lnkCancel() {
		return driver.findLink(Find.byClassName("cancel"));
	}

	public IGenericWebLink lnkViewHelp() {
		return driver.findLink(Find.byID("viewHelp"));
	}

	public IGenericWebImage imgLocalHelp() {
		return driver.findImage(Find.byTitle("Get local help about Time Tracking"));
	}
	
	public boolean checkUploadSuccess(String fileName){
		return driver.waitForElementPresent(Find.byText(fileName), Config.getDefaultWaitedTime());
	}
}