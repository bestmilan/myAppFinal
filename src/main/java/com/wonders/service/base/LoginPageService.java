package com.wonders.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import browser.common.IGenericWebDriver;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.LoginPage;

public class LoginPageService {
	private IGenericWebDriver driver;
	@Autowired
	private LoginPage loginPage;
	public LoginPageService(IGenericWebDriver _driver){
		driver = _driver;
		loginPage = new LoginPage(_driver);
	}
	
	public void login(String userName, String passWord) {
		loginPage.swtichToFrame();
		loginPage.txtLoginUserName().typeText(userName);
		loginPage.txtLoginPassWord().typeText(passWord);
		loginPage.btnLogin().click();
	}
	
	public void login() {
		loginPage.swtichToFrame();
		loginPage.txtLoginUserName().typeText(Config.getUser());
		loginPage.txtLoginPassWord().typeText(Config.getPassword());
		loginPage.btnLogin().click();
	}
	
	public void clickSignUp() {
		driver.waitForComplete();
		loginPage.lnkSignUp().click();
	}
	
	public void clickDragPage() {
		driver.waitForComplete();
		loginPage.lnkDrag().click();
	}

}
