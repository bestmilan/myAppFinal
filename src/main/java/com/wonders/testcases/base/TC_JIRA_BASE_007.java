package com.wonders.testcases.base;

import com.wonders.configuration.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;

@Test(groups = { "base", "easy", "drag" })
public class TC_JIRA_BASE_007 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private SelfPageService selfPageService;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome") String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());
		loginPageService = new LoginPageService(home.driver);
		selfPageService = new SelfPageService(home.driver);
	}

	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}

	/**
	 * TODO: 拖拉(Drag andDrop)
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-30 20:37:40.583
	 * @point: alert
	 * @memo:
	 */
	@Test(description = "拖拉(Drag andDrop)")
	public void JIRA_BASE_007() {
		// into self page
		home.driver.switchToFrame("gadget-0");
		loginPageService.clickDragPage();
		home.driver .switchToWindow("Can't access your account? - Your Company JIRA");
		selfPageService.drag();
	}
}
