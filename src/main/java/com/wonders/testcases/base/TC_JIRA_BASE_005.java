package com.wonders.testcases.base;

import com.wonders.configuration.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.pagewrapper.base.LoginPage;
import com.wonders.pagewrapper.base.MainPage;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.MainPageService;

@Test(groups = { "base", "easy", "fail" })
public class TC_JIRA_BASE_005 {
	private BaseHome home;
	private LoginPageService loginPageService;
	private MainPageService mainPageService;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome") String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());
		loginPageService = new LoginPageService(home.driver);
		mainPageService = new MainPageService(home.driver);
	}

	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}

	/**
	 * TODO: 验证校验失败时的截图功能
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-30 20:33:28.744
	 * @point: frame, span, div, @Parameters
	 * @memo:
	 */
	@Test(description = "登录系统，校验jira版本")
	public void JIRA_BASE_005() {
		// login
		loginPageService.login();
		home.driver.switchToWindow(mainPageService.assertMainPage());
		// check jira version
		String ver = mainPageService.getVersion();
		Assertion.AssertEquals(ver.substring(1, ver.indexOf("#")), "123");
		// log out
		mainPageService.logout();
		home.driver.switchToDefaultWindow();

	}
}
