package com.wonders.service.base;

import com.wonders.pagewrapper.base.LoginPage;
import com.wonders.utils.BaseHome;

public class LoginPageService {

	public static void login(String adminUser, String adminPW) {
		LoginPage.swtichToFrame();
		LoginPage.txtLoginUserName().typeText(adminUser);
		LoginPage.txtLoginPassWord().typeText(adminPW);
		LoginPage.btnLogin().click();
	}


	public static void clickSignUp() {
		BaseHome.driver.waitForComplete();
		LoginPage.lnkSignUp().click();
	}
	
	public static void clickDragPage() {
		BaseHome.driver.waitForComplete();
		LoginPage.lnkDrag().click();
	}

}
