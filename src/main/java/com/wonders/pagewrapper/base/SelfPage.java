package com.wonders.pagewrapper.base;
import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebTextField;
@SuppressWarnings("unused")
public class SelfPage{
	private IGenericWebDriver driver;
	public SelfPage(IGenericWebDriver _driver) {
		driver = _driver;
	}
	public IGenericWebButton btnAlter(){
		return driver.findButton(Find.byValue("测试Alter"));
	}
	
	public IGenericWebButton btnAlterError(){
		return driver.findButton(Find.byValue("测试AlterError"));
	}
	
	public IGenericWebButton btnConfirm(){
		return driver.findButton(Find.byValue("测试Confirm"));
	}
	
	public IGenericWebTextField txtResult(){
		return driver.findTextField(Find.byID("result"));
	}
	
	public IGenericWebButton btnAjax(){
		return driver.findButton(Find.byValue("测试Ajax"));
	}
	
	public IGenericWebTextField txtFrame(){
		return driver.findTextField(Find.byID("frame"));
	}
	
	public IGenericWebElement eleItem1(){
		return driver.findDiv(Find.byID("item1"));
	}
	
	public IGenericWebElement eleDrop(){
		return driver.findDiv(Find.byID("drop"));
	} 
}