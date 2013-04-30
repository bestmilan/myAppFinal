package com.wonders.testcases.base;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;

@Test(groups = { "base", "normal", "test3" })
public class TC_JIRA_BASE_003 {
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
	 * TODO: 验证ajax
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-30 20:27:26.7
	 * @point: ajax
	 * @memo:
	 */
	@Test(description = "验证ajax")
	public void JIRA_BASE_003() {
		// into self page
		home.driver.switchToFrame("gadget-0");
		loginPageService.clickSignUp();
		home.driver.switchToWindow("Sign up for JIRA - Your Company JIRA");
		Assert.assertTrue(selfPageService.checkAjax());

	}
}
