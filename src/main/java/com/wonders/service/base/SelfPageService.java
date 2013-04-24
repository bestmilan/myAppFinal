package com.wonders.service.base;

import utils.Alter;
import browser.common.Find;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.SelfPage;
import com.wonders.utils.BaseHome;

public class SelfPageService {
	public static void clickAlter() {
		SelfPage.btnAlter().click();
	}

	public static void clickAlterError() {
		SelfPage.btnAlterError().click();
	}

	public static void clickConfirm() {
		SelfPage.btnConfirm().click();
	}

	public static void clickAjax() {
		SelfPage.btnAjax().click();
	}

	public static void acceptAlter() {
		Alter alterWindow = new Alter(BaseHome.driver,
				Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithAcception();
	}

	public static void refuseAlter() {
		Alter alterWindow = new Alter(BaseHome.driver,
				Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithRefuse();
	}

	public static boolean checkAlter() {
		clickAlter();
		acceptAlter();
		return "测试Alter".equals(SelfPage.txtResult().getValue());
	}

	public static boolean checkAlterError() {
		clickAlterError();
		acceptAlter();
		return "测试Alter".equals(SelfPage.txtResult().getValue());
	}

	public static boolean checkConfirmAccept() {
		clickConfirm();
		acceptAlter();
		return "Confirm确定".equals(SelfPage.txtResult().getValue());
	}

	public static boolean checkConfirmRefuse() {
		clickConfirm();
		refuseAlter();
		return "Confirm取消".equals(SelfPage.txtResult().getValue());
	}

	public static boolean checkAjax() {
		clickAjax();
		return BaseHome.driver.waitForElementValue(Find.byID("result"),
				"ajaxSuccess", 10);
	}

	public static boolean checkFrame(String value) {
		return value.equals(SelfPage.txtFrame().getValue());
	}

	public static void drag() {
		SelfPage.eleItem1().dragAndDropOn(SelfPage.eleDrop());
		// 利用循环把其它item也拖入
		String id = "item";
		for (int i = 2; i <= 6; i++) {
			String item = id + i;
			BaseHome.driver.findElement(Find.byID(item)).dragAndDropOn(
					SelfPage.eleDrop());
		}
	}
}
