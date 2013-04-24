package com.wonders.utils;

import browser.common.Find;
import browser.common.IGenericWebButton;
import browser.common.IGenericWebElement;
import browser.common.IGenericWebSpan;

public class ChooseUnit extends BaseHome {
	private static final String ID_PREFIX = "treeDemo_";
	private static final String CHECKBOXID_SUFFIX = "_check";
	private static final String SWITCHID_SUFFIX = "_switch";
	private static final String UIID_SUFFIX = "_ul";
	private static final String CHECKBOX_UNCHECKED = "button chk checkbox_false_full";
 
	// first expansion
	
	public static IGenericWebElement ulFindFirstUl() {
		return driver.findElement(Find.byID("treeDemo"));
	}
	
	//find ul element
	public static IGenericWebElement ulFindElementByIdInParent(IGenericWebElement parentElement, String id) {
		return parentElement.findElement(Find.byID(id));
	}
	
	public static IGenericWebElement ulFindElementByNumInParent(IGenericWebElement parentElement, String num) {
		String ulId = getUlId(num);
		return ulFindElementByIdInParent(parentElement, ulId);
	}
		
	//find span
	public static IGenericWebSpan spanFindElementByTextInParent(IGenericWebElement parentElement, String text) {
		return parentElement.findSpan(Find.byText(text));
	}
	
	public static IGenericWebSpan spanFindElementByIdInParent(IGenericWebElement parentElement, String id) {
		return parentElement.findSpan(Find.byID(id));
	}
	
	//find button
	public static IGenericWebButton btnOk() {
		return driver.findButton(Find.byID("choiceOk"));
	}
	
	//method
	public static String findSpanElementNum(IGenericWebElement parentElement, String text) {
		IGenericWebElement spanElement = spanFindElementByTextInParent(parentElement, text);
		String id = spanElement.getAttribute("id");
		return id.substring(id.indexOf("_") + 1, id.lastIndexOf("_"));		
	}
	
	public static String getSwitchId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(SWITCHID_SUFFIX);
		return str.toString();
	}
	
	public static String getCheckBoxId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(CHECKBOXID_SUFFIX);
		return str.toString();
	}
	
	public static String getUlId(String num) {
		StringBuffer str = new StringBuffer(ID_PREFIX).append(num).append(UIID_SUFFIX);
		return str.toString();
	}
	
	public static void expansionSwitch(IGenericWebElement parentElement, String num) {
		String switchId = getSwitchId(num);
		IGenericWebSpan spanSwitch = spanFindElementByIdInParent(parentElement, switchId);
		if (spanSwitch.getAttribute("class").indexOf("close")!=-1) {
			spanSwitch.click();
		}
	}
	public static void clickCheckBox(IGenericWebElement parentElement, String num) {
		String chkId = getCheckBoxId(num);
		IGenericWebSpan spanChk = spanFindElementByIdInParent(parentElement, chkId);
		// 濡傛灉澶勪簬娌℃湁閫変腑鐘舵�
		if (CHECKBOX_UNCHECKED.equals(spanChk.getAttribute("class"))) {
			spanChk.click();
		}
	}
	
	//click switch and return ul element
	public static IGenericWebElement findUlElementAndClickSwitch(IGenericWebElement parentElement, String text) {
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
	public static void chkClick(IGenericWebElement parentElement, String text) {
		try {
			//鑾峰緱鍚嶇О瀵硅薄
			String num = findSpanElementNum(parentElement, text);
			clickCheckBox(parentElement, num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param units 锛氭満鏋勫悕绉帮紙澶氫釜鏈烘瀯鐢ㄥ垎鏁扮粍瀛樺偍锛�
	 * @param units 锛氭満鏋勫墠澧炲姞鎵�湁鐖惰妭鐐瑰悕绉帮紝鐢ㄢ�,鈥濆垎闅斻�锛堝锛氱淮鎶や繚闅滀腑蹇�缁煎悎鍔炲叕瀹わ級
	 */
	public static void setUnits(String[] units) {
		try {
			IGenericWebElement firstElement = ulFindFirstUl();
			for(int i = 0 ;i<units.length; i++){
				String[] choosedUnit = units[i].split(",");
				IGenericWebElement ulElement = firstElement;
				for(int j = 0;j<choosedUnit.length; j++){	
					if(j==(choosedUnit.length-1)){//鐩爣缁撶偣
						chkClick(ulElement, choosedUnit[j]);
					}else{//鐖剁粨鐐�
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
