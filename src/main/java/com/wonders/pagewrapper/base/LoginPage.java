package com.wonders.pagewrapper.base;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebTextField;

public class LoginPage {
	private IGenericWebDriver driver;

	public LoginPage(IGenericWebDriver _driver) {
		driver = _driver;
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

	public IGenericWebLink lnkSignUp() {
		return driver.findLink(Find.byID("signup"));
	}

	public IGenericWebLink lnkDrag() {
		return driver.findLink(Find.byID("forgotpassword"));
	}

}
