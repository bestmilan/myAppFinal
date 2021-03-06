package com.wonders.testcases.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.base.SelfPageService;

@Test(groups = { "base", "easy", "test2" })
public class TC_JIRA_BASE_002 {
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
	 * TODO: 验证alert，confirm
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-30 17:52:06.564
	 * @point:alert
	 * @memo:
	 */
	@Test(description = "验证alert，confirm")
	public void JIRA_BASE_002() {
		// into self page
		home.driver.switchToFrame("gadget-0");
		loginPageService.clickSignUp();
		home.driver.switchToWindow("Sign up for JIRA - Your Company JIRA");
		Assertion.AssertTrue(selfPageService.checkAlter(), "验证alter");
		Assertion.AssertTrue(selfPageService.checkConfirmAccept(),
				"验证confirm确定");
		Assertion.AssertTrue(selfPageService.checkConfirmRefuse(),
				"验证confirm取消");

	}
}
