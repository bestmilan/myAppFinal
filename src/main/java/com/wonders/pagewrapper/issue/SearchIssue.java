package com.wonders.pagewrapper.issue;
import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebCheckBox;
import browser.common.IGenericWebComboBox;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebRadioButton;
import browser.common.IGenericWebSelect;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTable;
import browser.common.IGenericWebTableCell;
import browser.common.IGenericWebTextField;

import com.wonders.utils.WebTable;
@SuppressWarnings("unused")
public class SearchIssue{
	private IGenericWebDriver driver;
	public SearchIssue(IGenericWebDriver _driver) {
		driver = _driver;
	}
	public IGenericWebTable tblIssueSearch() {
		return driver.findTable(Find.byID("issuetable"));
	}

	public WebTable tblIssueTable(){
		return new WebTable(driver, Find.byID("issuetable"));
	}
	
	public IGenericWebTableCell tblclIssueCell(int rowNum, int cellNum) {
		return tblIssueTable().GetCellsOfRow(rowNum).get(cellNum);
	}

	public IGenericWebTextField txtSearcherQuery() {
		return driver.findTextField(Find.byID("searcher-query"));
	}

	public IGenericWebSpan spnIssueAttribute() {
		return driver.findSpan(Find.byClassName("toggle-title").addAttribute(
				"text()", "Issue Attributes"));
	}

	public IGenericWebSelect selReporter() {
		return driver.findSel(Find.byID("searcher-reporterSelect"));
	}

	public IGenericWebTextField txtSearcherReporter() {
		return driver.findTextField(Find.byID("searcher-reporter"));
	}

	public IGenericWebComboBox cobSearcherStatus() {
		return driver.findComboBox(Find.byID("searcher-status"));
	}

	public IGenericWebCheckBox chkSearcherSummaryId() {
		return driver.findCheckBox(Find.byID("searcher-summaryId"));
	}

	public IGenericWebCheckBox chkSearcherDescriptionId() {
		return driver.findCheckBox(Find.byID("searcher-descriptionId"));
	}

	public IGenericWebCheckBox chkSearcherBodyId() {
		return driver.findCheckBox(Find.byID("searcher-bodyId"));
	}

	public IGenericWebCheckBox chkSearcherEnvironmentId() {
		return driver.findCheckBox(Find.byID("searcher-environmentId"));
	}

	public IGenericWebSpan spnShowDateTime() {
		return driver.findSpan(Find.byClassName("toggle-title").addAttribute(
				"text()", "Dates and Times"));
	}

	public IGenericWebSpan spnShowSelectDateRange() {
		return driver.findSpan(Find.byClassName("aui-icon icon-range")
				.addAttribute("text()", "Select a date range"));
	}

	public IGenericWebRadioButton rdbDateSelectType(String value) {
		return driver.findRadioButton(Find.byName("selectedType").addAttribute(
				"@value", value));
	}

	public IGenericWebTextField txtStartDateDaysAgo() {
		return driver.findTextField(Find.byID("startDateDaysAgo"));
	}

	public IGenericWebButton btnSelectDate() {
		return driver.findSubmitButton(Find.byClassName("aui-button"));
	}

	public IGenericWebButton btnIssueSubmit() {
		return driver.findSubmitButton(Find.byID("issue-filter-submit"));
	}

	public IGenericWebElement eleResultsCountTotal() {
		return driver.findElement(Find.byClassName("results-count-total"));
	}

	public IGenericWebElement eleNoSearchResult() {
		return driver.findElement(Find.byText("No matching issues found."));
	}
	
	public IGenericWebLink lnkReporterAdmin() {
		return driver.findLink(Find.byID("reporter_admin"));
	}
	
	public IGenericWebLink lnkAvatarLink() {
		return driver.findLink(Find.byID("avatar-full-name-link"));
	}
}