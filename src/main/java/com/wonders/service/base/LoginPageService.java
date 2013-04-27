package com.wonders.service.base;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebTextField;

import com.wonders.pagewrapper.base.LoginPage;
import com.wonders.utils.BaseHome;

public class LoginPageService {
	public IGenericWebDriver driver;
	public LoginPageService(IGenericWebDriver baseDriver){
		driver = baseDriver;
	}
	public void swtichToFrame() {
		driver.switchToFrame("gadget-0");
	}

	public IGenericWebTextField txtLoginUserName() {
		return driver.findTextField(Find.byID("login-form-username"));
	}

	public IGenericWebTextField txtLoginPassWord() {
		return driver.findPasswordField(Find.byID("login-form-password"));
	}

	public IGenericWebButton btnLogin() {
		return driver.findSubmitButton(Find.byID("login"));
	}
	
	public IGenericWebLink lnkSignUp(){
		return driver.findLink(Find.byID("signup"));
	}
	
	public IGenericWebLink lnkDrag(){
		return driver.findLink(Find.byID("forgotpassword"));
	}
///////////////////////////////////////service/////////////////////////////////////////////////
	public void login(String adminUser, String adminPW) {
		swtichToFrame();
		txtLoginUserName().typeText(adminUser);
		txtLoginPassWord().typeText(adminPW);
		btnLogin().click();
	}
	
	public void clickSignUp() {
		driver.waitForComplete();
		lnkSignUp().click();
	}
	
	public void clickDragPage() {
		driver.waitForComplete();
		lnkDrag().click();
	}

}
