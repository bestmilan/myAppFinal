package com.wonders.service.issue;
import org.springframework.beans.factory.annotation.Autowired;

import browser.common.Find;
import browser.common.IGenericWebDriver;

import com.wonders.pagewrapper.issue.SearchIssue;

public class SearchIssueService {
	private IGenericWebDriver driver;
	@Autowired
	private SearchIssue searchIssue;
	public SearchIssueService(IGenericWebDriver _driver){
		driver = _driver;
		searchIssue = new SearchIssue(_driver);
	}
	public boolean checkSummary(String issueSummary) {
		return searchIssue.tblclIssueCell(1, 2).getText().equals(issueSummary);
	}

	public void setSearchFields(String blockType, String block,
			String status, String reporter, String days) {
		setBlock(blockType);
		searchIssue.txtSearcherQuery().typeText(block);
		searchIssue.spnIssueAttribute().click();
		driver.waitForComplete();
		searchIssue.selReporter().findOption(Find.byValue("specificuser"))
				.select();
		driver.waitForComplete();
		searchIssue.txtSearcherReporter().typeText(reporter);
		setSearcherStatus(status);
		setDateAndTime(days);
		searchIssue.btnIssueSubmit().click();
	}

	public void search() {
		searchIssue.btnIssueSubmit().click();
	}

	public void setSearcherStatus(String status) {
		String[] statusArray = status.split(",");
		for (int i = 0; i < statusArray.length; i++) {
			searchIssue.cobSearcherStatus().select(statusArray[i]);
		}
	}

	public void setBlock(String block) {
		String[] blockArray = block.split(",");
		for (int i = 0; i < blockArray.length; i++) {
			if ("Summary".equals(blockArray[i])) {
				searchIssue.chkSearcherSummaryId().check();
			} else if ("Environment".equals(blockArray[i])) {
				searchIssue.chkSearcherEnvironmentId().check();
			} else if ("Comments".equals(blockArray[i])) {
				searchIssue.chkSearcherBodyId().check();
			} else if ("Description".equals(blockArray[i])) {
				searchIssue.chkSearcherDescriptionId().check();
			}
		}
	}

	public void setDateAndTime(String days) {
		searchIssue.spnShowDateTime().click();
		searchIssue.spnShowSelectDateRange().click();
		driver.switchToWindow("Date Range Selector - Your Company JIRA");
		searchIssue.rdbDateSelectType("START_DATE_DAYS_AGO");
		searchIssue.txtStartDateDaysAgo().typeText(days);
		searchIssue.btnSelectDate().click();
		driver.waitForComplete();
		driver.switchToWindow("Issue Navigator - Your Company JIRA");
	}

	/**
	 * 第一个参数：blockType(Summary,Environment,Comments,Description) 第二个参数：block
	 * 第三个参数：status(In Progress,Open,Reopened,Resolved,Closed,Any) 第四个参数：report
	 * 第五个参数：create time
	 * 
	 * @return
	 */
	public Object[][] setTestData() {
		Object[][] result = new Object[][] {
				{
						"Summary,Environment",
						"Summary_20130326165637219_a3e347e1-d849-4bd8-af1f-aced38485d31",
						"In Progress", "admin", "15" },
				{ "Summary,Environment", getBlockTestData(),
						"In Progress,Open,Reopened,Resolved,Closed", "user1",
						"1" } };
		return result;
	}

	public String getBlockTestData() {
		// return "Summary_"+ DateManage.getNowTimeWithOutSign().substring(0,
		// 4);
		return "";
	}

	public void stay() {
		searchIssue.lnkReporterAdmin().mouseMove();
		/*(new GenericActions(BaseHome.driver))
				.moveToElement(SearchIssue.lnkReporterAdmin()).build().perform();*/
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAvatar() {
		driver.waitForComplete();
		return searchIssue.lnkAvatarLink().getTitle();
	}
	
}