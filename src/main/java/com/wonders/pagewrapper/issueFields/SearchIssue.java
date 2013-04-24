package com.wonders.pagewrapper.issueFields;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebCheckBox;
import browser.common.IGenericWebComboBox;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebRadioButton;
import browser.common.IGenericWebSelect;
import browser.common.IGenericWebSpan;
import browser.common.IGenericWebTable;
import browser.common.IGenericWebTableCell;
import browser.common.IGenericWebTextField;

import com.wonders.utils.BaseHome;
import com.wonders.utils.WebTable;

public class SearchIssue extends BaseHome { 
	public static IGenericWebTable tblIssueSearch() {
		return driver.findTable(Find.byID("issuetable"));
	}

	public static WebTable tblIssueTable(){
		return new WebTable(driver, Find.byID("issuetable"));
	}
	
	public static IGenericWebTableCell tblclIssueCell(int rowNum, int cellNum) {
		return tblIssueTable().GetCellsOfRow(rowNum).get(cellNum);
	}

	public static IGenericWebTextField txtSearcherQuery() {
		return driver.findTextField(Find.byID("searcher-query"));
	}

	public static IGenericWebSpan spnIssueAttribute() {
		return driver.findSpan(Find.byClassName("toggle-title").addAttribute(
				"text()", "Issue Attributes"));
	}

	public static IGenericWebSelect selReporter() {
		return driver.findSel(Find.byID("searcher-reporterSelect"));
	}

	public static IGenericWebTextField txtSearcherReporter() {
		return driver.findTextField(Find.byID("searcher-reporter"));
	}

	public static IGenericWebComboBox cobSearcherStatus() {
		return driver.findComboBox(Find.byID("searcher-status"));
	}

	public static IGenericWebCheckBox chkSearcherSummaryId() {
		return driver.findCheckBox(Find.byID("searcher-summaryId"));
	}

	public static IGenericWebCheckBox chkSearcherDescriptionId() {
		return driver.findCheckBox(Find.byID("searcher-descriptionId"));
	}

	public static IGenericWebCheckBox chkSearcherBodyId() {
		return driver.findCheckBox(Find.byID("searcher-bodyId"));
	}

	public static IGenericWebCheckBox chkSearcherEnvironmentId() {
		return driver.findCheckBox(Find.byID("searcher-environmentId"));
	}

	public static IGenericWebSpan spnShowDateTime() {
		return driver.findSpan(Find.byClassName("toggle-title").addAttribute(
				"text()", "Dates and Times"));
	}

	public static IGenericWebSpan spnShowSelectDateRange() {
		return driver.findSpan(Find.byClassName("aui-icon icon-range")
				.addAttribute("text()", "Select a date range"));
	}

	public static IGenericWebRadioButton rdbDateSelectType(String value) {
		return driver.findRadioButton(Find.byName("selectedType").addAttribute(
				"@value", value));
	}

	public static IGenericWebTextField txtStartDateDaysAgo() {
		return driver.findTextField(Find.byID("startDateDaysAgo"));
	}

	public static IGenericWebButton btnSelectDate() {
		return driver.findSubmitButton(Find.byClassName("aui-button"));
	}

	public static IGenericWebButton btnIssueSubmit() {
		return driver.findSubmitButton(Find.byID("issue-filter-submit"));
	}

	public static IGenericWebElement eleResultsCountTotal() {
		return driver.findElement(Find.byClassName("results-count-total"));
	}

	public static IGenericWebElement eleNoSearchResult() {
		return driver.findElement(Find.byText("No matching issues found."));
	}
	
	public static IGenericWebLink lnkReporterAdmin() {
		return driver.findLink(Find.byID("reporter_admin"));
	}
	
	public static IGenericWebLink lnkAvatarLink() {
		return driver.findLink(Find.byID("avatar-full-name-link"));
	}
}
