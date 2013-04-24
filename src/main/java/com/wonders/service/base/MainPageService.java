package com.wonders.service.base;

import utils.Alter;
import browser.common.Find;
import browser.common.FindBy;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.MainPage;
import com.wonders.utils.BaseHome;

public class MainPageService {
	// log out
	public static void logout() {
		BaseHome.waitForComplete();
		MainPage.btnLogOutArrow().click();
		MainPage.btnLogOut().click();
	}

	public static void showCreateIssuePage() {
		MainPage.divCreateItem().click();
		BaseHome.waitForComplete();
	}

	public static String getIssueCreatedKey() {
		return MainPage.lnkIssueCreatedKey().getText();
	}

	public static boolean checkIssueCreate(String issueSummary) {
		return getIssueCreatedKey().indexOf(issueSummary) != -1;
	}

	public static void quickSearch(String issueSummary) {
		MainPage.txtQuickSearchInput().typeText(issueSummary);
		BaseHome.excuteJs("document.getElementById('quicksearch').submit();");
		closeWin();
	}

	public static void closeWin() {
		Alter alterWindow = new Alter(BaseHome.driver,
				Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithAcception();
	}

	public static FindBy assertMainPage() {
		return Find.byID("gadget-10000-title");
	}

	//
	public static void gotoIssueSearch() {
		MainPage.lnkIssueSearch().click();
	}

	public static String getUserErrorMessage() {
		return MainPage.divUserError().getText();
	}
	
}
