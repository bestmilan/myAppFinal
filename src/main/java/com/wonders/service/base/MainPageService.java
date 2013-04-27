package com.wonders.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import utils.Alter;
import browser.common.Find;
import browser.common.FindBy;
import browser.common.IGenericWebDriver;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.MainPage;

public class MainPageService {
	private IGenericWebDriver driver;
	@Autowired
	private MainPage mainPage;
	public MainPageService(IGenericWebDriver _driver){
		driver = _driver;
		mainPage = new MainPage(_driver);
	}
	// log out
	public void logout() {
		driver.waitForComplete();
		mainPage.btnLogOutArrow().click();
		mainPage.btnLogOut().click();
	}

	public void showCreateIssuePage() {
		mainPage.divCreateItem().click();
		driver.waitForComplete();
	}

	public String getIssueCreatedKey() {
		return mainPage.lnkIssueCreatedKey().getText();
	}

	public boolean checkIssueCreate(String issueSummary) {
		return getIssueCreatedKey().indexOf(issueSummary) != -1;
	}

	public void quickSearch(String issueSummary) {
		mainPage.txtQuickSearchInput().typeText(issueSummary);
		driver.executeScript("document.getElementById('quicksearch').submit();");
		closeWin();
	}

	public void closeWin() {
		Alter alterWindow = new Alter(driver, Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithAcception();
	}

	public FindBy assertMainPage() {
		return Find.byID("gadget-10000-title");
	}

	//
	public void gotoIssueSearch() {
		mainPage.lnkIssueSearch().click();
	}

	public String getUserErrorMessage() {
		return mainPage.divUserError().getText();
	}
	
	public String getVersion() {
		return mainPage.spnVersion().getText();
	}
}
