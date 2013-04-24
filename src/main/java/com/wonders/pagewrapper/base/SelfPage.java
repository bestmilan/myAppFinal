package com.wonders.pagewrapper.base;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDiv;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebTextField;

import com.wonders.utils.BaseHome;

public class SelfPage extends BaseHome{
	public static IGenericWebButton btnAlter(){
		return driver.findButton(Find.byValue("测试Alter"));
	}
	
	public static IGenericWebButton btnAlterError(){
		return driver.findButton(Find.byValue("测试AlterError"));
	}
	
	public static IGenericWebButton btnConfirm(){
		return driver.findButton(Find.byValue("测试Confirm"));
	}
	
	public static IGenericWebTextField txtResult(){
		return driver.findTextField(Find.byID("result"));
	}
	
	public static IGenericWebButton btnAjax(){
		return driver.findButton(Find.byValue("测试Ajax"));
	}
	
	public static IGenericWebTextField txtFrame(){
		return driver.findTextField(Find.byID("frame"));
	}
	
	public static IGenericWebElement eleItem1(){
		return driver.findDiv(Find.byID("item1"));
	}
	
	public static IGenericWebElement eleDrop(){
		return driver.findDiv(Find.byID("drop"));
	} 
}
