package com.wonders.service.issueFields;

import browser.common.Find;

import com.wonders.pagewrapper.issueFields.SearchIssue;
import com.wonders.utils.BaseHome;

public class SearchIssueService {
	public static boolean checkSummary(String issueSummary) {
		return SearchIssue.tblclIssueCell(1, 2).getText().equals(issueSummary);
	}

	public static void setSearchFields(String blockType, String block,
			String status, String reporter, String days) {
		setBlock(blockType);
		SearchIssue.txtSearcherQuery().typeText(block);
		SearchIssue.spnIssueAttribute().click();
		BaseHome.waitForComplete();
		SearchIssue.selReporter().findOption(Find.byValue("specificuser"))
				.select();
		BaseHome.waitForComplete();
		SearchIssue.txtSearcherReporter().typeText(reporter);
		setSearcherStatus(status);
		setDateAndTime(days);
		SearchIssue.btnIssueSubmit().click();
	}

	public static void search() {
		SearchIssue.btnIssueSubmit().click();
	}

	public static void setSearcherStatus(String status) {
		String[] statusArray = status.split(",");
		for (int i = 0; i < statusArray.length; i++) {
			SearchIssue.cobSearcherStatus().select(statusArray[i]);
		}
	}

	public static void setBlock(String block) {
		String[] blockArray = block.split(",");
		for (int i = 0; i < blockArray.length; i++) {
			if ("Summary".equals(blockArray[i])) {
				SearchIssue.chkSearcherSummaryId().check();
			} else if ("Environment".equals(blockArray[i])) {
				SearchIssue.chkSearcherEnvironmentId().check();
			} else if ("Comments".equals(blockArray[i])) {
				SearchIssue.chkSearcherBodyId().check();
			} else if ("Description".equals(blockArray[i])) {
				SearchIssue.chkSearcherDescriptionId().check();
			}
		}
	}

	public static void setDateAndTime(String days) {
		SearchIssue.spnShowDateTime().click();
		SearchIssue.spnShowSelectDateRange().click();
		BaseHome.driver
				.switchToWindow("Date Range Selector - Your Company JIRA");
		SearchIssue.rdbDateSelectType("START_DATE_DAYS_AGO");
		SearchIssue.txtStartDateDaysAgo().typeText(days);
		SearchIssue.btnSelectDate().click();
		BaseHome.waitForComplete();
		BaseHome.driver.switchToWindow("Issue Navigator - Your Company JIRA");
	}

	/**
	 * 第一个参数：blockType(Summary,Environment,Comments,Description) 第二个参数：block
	 * 第三个参数：status(In Progress,Open,Reopened,Resolved,Closed,Any) 第四个参数：report
	 * 第五个参数：create time
	 * 
	 * @return
	 */
	public static Object[][] setTestData() {
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

	public static String getBlockTestData() {
		// return "Summary_"+ DateManage.getNowTimeWithOutSign().substring(0,
		// 4);
		return "";
	}

	public static void stay() {
		SearchIssue.lnkReporterAdmin().mouseMove();
		/*(new GenericActions(BaseHome.driver))
				.moveToElement(SearchIssue.lnkReporterAdmin()).build().perform();*/
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getAvatar() {
		BaseHome.waitForComplete();
		return SearchIssue.lnkAvatarLink().getTitle();
	}
}
