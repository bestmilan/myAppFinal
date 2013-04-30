package com.wonders.testcases.base;
import com.wonders.configuration.Config;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.core.Assertion;
import com.wonders.core.BaseHome;
import com.wonders.service.base.LoginPageService;
import com.wonders.service.issue.SearchIssueService;
import com.wonders.utils.RandomManage;

@Test(groups={""})
public class TC_JIRA_BASE_009 {
	private BaseHome home;
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		home = new BaseHome();
		home.Launch(browser, Config.getLaunchUrl());
	}
	
	@AfterMethod()
	public void cleanup() {
		home.Quit();
	}
	/**
	 * TODO:	cookie
	 * @author:	bluce
	 * @serialData:	2013-04-30 20:47:20.85
	 * @point:	cookie
	 * @memo:	
	 */
	@Test(description = "cookie")
	public void JIRA_BASE_009(){		
		String uuid = RandomManage.getUuid();
		System.out.println(uuid);
		Cookie cookie = new Cookie("key", uuid);
		home.driver.setCookie(cookie);
		Assertion.AssertEquals(home.driver.getCookie("key").getValue(), uuid);
		home.driver.deleteCookieNamed("key");
		System.out.println("key:"+home.driver.getCookie("key"));
	}
}
