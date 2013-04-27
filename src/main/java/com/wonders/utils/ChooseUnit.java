package com.wonders.utils;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebSpan;

public class ChooseUnit{
	private IGenericWebDriver driver;	
	private static final String ID_PREFIX = "treeDemo_";
	private static final String CHECKBOXID_SUFFIX = "_check";
	private static final String SWITCHID_SUFFIX = "_switch";
	private static final String UIID_SUFFIX = "_ul";
	private static final String CHECKBOX_UNCHECKED = "button chk checkbox_false_full";
 
	public ChooseUnit(IGenericWebDriver driverBase){
		driver = driverBase;
	}
	// first expansion
	
	public IGenericWebElement ulFindFirstUl() {
		return driver.findElement(Find.byID("treeDemo"));
	}
	
	//find ul element
	public IGenericWebElement ulFindElementByIdInParent(IGenericWebElement parentElement, String id) {
		return parentElement.findElement(Find.byID(id));
	}
	
	public IGenericWebElement ulFindElementByNumInParent(IGenericWebElement parentElement, String num) {
		String ulId = getUlId(num);
		return ulFindElementByIdInParent(parentElement, ulId);
	}
		
	//find span
	public IGenericWebSpan spanFindElementByTextInParent(IGenericWebElement parentElement, String text) {
		return parentElement.findSpan(Find.byText(text));
	}
	
	public IGenericWebSpan spanFindElementByIdInParent(IGenericWebElement parentElement, String id) {
		return parentElement.findSpan(Find.byID(id));
	}
	
	//find button
	public IGenericWebButton btnOk() {
		return driver.findButton(Find.byID("choiceOk"));
	}
	
	//method
	public String findSpanElementNum(IGenericWebElement parentElement, String text) {
		IGenericWebElement spanElement = spanFindElementByTextInParent(parentElement, text);
		String id = spanElement.getAttribute("id");
		return id.substring(id.indexOf("_") + 1, id.lastIndexOf("_"));		
	}
	
	public String getSwitchId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(SWITCHID_SUFFIX);
		return str.toString();
	}
	
	public String getCheckBoxId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(CHECKBOXID_SUFFIX);
		return str.toString();
	}
	
	public String getUlId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(UIID_SUFFIX);
		return str.toString();
	}
	
	public void expansionSwitch(IGenericWebElement parentElement, String num) {
		String switchId = getSwitchId(num);
		IGenericWebSpan spanSwitch = spanFindElementByIdInParent(parentElement, switchId);
		if (spanSwitch.getAttribute("class").indexOf("close")!=-1) {
			spanSwitch.click();
		}
	}
	public void clickCheckBox(IGenericWebElement parentElement, String num) {
		String chkId = getCheckBoxId(num);
		IGenericWebSpan spanChk = spanFindElementByIdInParent(parentElement, chkId);
		if (CHECKBOX_UNCHECKED.equals(spanChk.getAttribute("class"))) {
			spanChk.click();
		}
	}
	
	//click switch and return ul element
	public IGenericWebElement findUlElementAndClickSwitch(IGenericWebElement parentElement, String text) {
		try {
			String num = findSpanElementNum(parentElement, text);
			expansionSwitch(parentElement, num);			
			return ulFindElementByNumInParent(parentElement, num);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//click checkbox 
	public void chkClick(IGenericWebElement parentElement, String text) {
		try {
			//
			String num = findSpanElementNum(parentElement, text);
			clickCheckBox(parentElement, num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param units 
	 * @param units 
	 */
	public void setUnits(String[] units) {
		try {
			IGenericWebElement firstElement = ulFindFirstUl();
			for(int i = 0 ;i<units.length; i++){
				String[] choosedUnit = units[i].split(",");
				IGenericWebElement ulElement = firstElement;
				for(int j = 0;j<choosedUnit.length; j++){	
					if(j==(choosedUnit.length-1)){//
						chkClick(ulElement, choosedUnit[j]);
					}else{//
						ulElement = findUlElementAndClickSwitch(ulElement, choosedUnit[j]);
					}
				}
			}
			btnOk().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
