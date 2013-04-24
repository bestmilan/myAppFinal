package com.wonders.testcases.base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.utils.Assertion;
import com.wonders.utils.BaseHome;
import com.wonders.utils.RandomManage;
@Test(groups = { "base", "easy", "cookie" })
public class TC_JIRA_BASE_009 {
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());		
	}
	
	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}
	/**
	 * TODO:	cookie
	 * @author:	bluce
	 * @serialData:	2013-04-18
	 * @point:	alert
	 * @memo:	
	 */
	@Test(description = "cookie")
	public void JIRA_BASE_009(){		
		String uuid = RandomManage.getUuid();
		System.out.println(uuid);
		Cookie cookie = new Cookie("key", uuid);
		BaseHome.driver.setCookie(cookie);
		Assertion.AssertEquals(BaseHome.driver.getCookie("key").getValue(), uuid);
		BaseHome.driver.deleteCookieNamed("key");
		System.out.println("key:"+BaseHome.driver.getCookie("key"));
	} 
}
