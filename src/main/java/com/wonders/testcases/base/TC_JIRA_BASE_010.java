package com.wonders.testcases.base;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wonders.configuration.Config;
import com.wonders.service.base.MainPageService;
import com.wonders.utils.BaseHome;

@Test(groups = { "base", "easy", "key" })
public class TC_JIRA_BASE_010 {
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome") String browser) {
		BaseHome.Launch(browser, Config.getLaunchUrl());
	}

	@AfterMethod()
	public void cleanup() {
		BaseHome.Quit();
	}

	/**
	 * TODO: 回车KEYS
	 * 
	 * @author: bluce
	 * @serialData: 2013-04-19
	 * @point:
	 * @memo:
	 */
	@Test(description = "回车KEYS")
	public void JIRA_BASE_010() {
		BaseHome.driver.waitForComplete();
		BaseHome.driver.sendKeys(Keys.ENTER);
		BaseHome.driver.switchToFrame("gadget-0");
		System.out.println(MainPageService.getUserErrorMessage());
	}
}
