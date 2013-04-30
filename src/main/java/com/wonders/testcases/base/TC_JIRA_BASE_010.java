package com.wonders.testcases.base;
import com.wonders.configuration.Config;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;
import com.wonders.service.issue.SearchIssueService;

@Test(groups={""})
public class TC_JIRA_BASE_010 {
	private BaseHome home;
	private MainPageService mainPageService;
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());
		mainPageService = new MainPageService(home.driver);
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	回车KEYS
	 * @author:	bluce
	 * @serialData:	2013-04-30 20:48:25.149
	 * @point:	
	 * @memo:	
	 */
	@Test(description = "回车KEYS")
	public void JIRA_BASE_010(){		
		home.driver.waitForComplete();
		home.driver.sendKeys(Keys.ENTER);
		home.driver.switchToFrame("gadget-0");
		System.out.println(mainPageService.getUserErrorMessage());
	}
}
