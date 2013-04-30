package com.wonders.service.base;
import org.springframework.beans.factory.annotation.Autowired;

import utils.Alter;
import browser.common.Find;
import browser.common.IGenericWebDriver;

import com.wonders.configuration.Config;
import com.wonders.pagewrapper.base.SelfPage;

public class SelfPageService {
	private IGenericWebDriver driver;
	@Autowired
	private SelfPage selfPage;
	public SelfPageService(IGenericWebDriver _driver){
		driver = _driver;
		selfPage = new SelfPage(_driver);
	}
	public void clickAlter() {
		selfPage.btnAlter().click();
	}

	public void clickAlterError() {
		selfPage.btnAlterError().click();
	}

	public void clickConfirm() {
		selfPage.btnConfirm().click();
	}

	public void clickAjax() {
		selfPage.btnAjax().click();
	}

	public void acceptAlter() {
		Alter alterWindow = new Alter(driver,
				Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithAcception();
	}

	public void refuseAlter() {
		Alter alterWindow = new Alter(driver,
				Config.getDefaultWaitedTime());
		alterWindow.WaitAlterWindowPresent();
		alterWindow.CloseAlterWindowWithRefuse();
	}

	public boolean checkAlter() {
		clickAlter();
		acceptAlter();
		return "测试Alter".equals(selfPage.txtResult().getValue());
	}

	public boolean checkAlterError() {
		clickAlterError();
		acceptAlter();
		return "测试Alter".equals(selfPage.txtResult().getValue());
	}

	public boolean checkConfirmAccept() {
		clickConfirm();
		acceptAlter();
		return "Confirm确定".equals(selfPage.txtResult().getValue());
	}

	public boolean checkConfirmRefuse() {
		clickConfirm();
		refuseAlter();
		return "Confirm取消".equals(selfPage.txtResult().getValue());
	}

	public boolean checkAjax() {
		clickAjax();
		return driver.waitForElementValue(Find.byID("result"),
				"ajaxSuccess", 10);
	}

	public boolean checkFrame(String value) {
		return value.equals(selfPage.txtFrame().getValue());
	}

	public void drag() {
		selfPage.eleItem1().dragAndDropOn(selfPage.eleDrop());
		// 利用循环把其它item也拖入
		String id = "item";
		for (int i = 2; i <= 6; i++) {
			String item = id + i;
			driver.findElement(Find.byID(item)).dragAndDropOn(
					selfPage.eleDrop());
		}
	}
}