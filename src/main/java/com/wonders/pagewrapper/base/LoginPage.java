package com.wonders.pagewrapper.base;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebLink;
import browser.common.IGenericWebTextField;

import com.wonders.utils.BaseHome;

public class LoginPage extends BaseHome {
	public static void swtichToFrame() {
		driver.switchToFrame("gadget-0");
	}

	public static IGenericWebTextField txtLoginUserName() {
		return driver.findTextField(Find.byID("login-form-username"));
	}

	public static IGenericWebTextField txtLoginPassWord() {
		return driver.findPasswordField(Find.byID("login-form-password"));
	}

	public static IGenericWebButton btnLogin() {
		return driver.findSubmitButton(Find.byID("login"));
	}
	
	public static IGenericWebLink lnkSignUp(){
		return driver.findLink(Find.byID("signup"));
	}
	
	public static IGenericWebLink lnkDrag(){
		return driver.findLink(Find.byID("forgotpassword"));
	}
}
