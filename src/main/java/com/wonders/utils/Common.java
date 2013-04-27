package com.wonders.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

import browser.common.IGenericWebDriver;

import com.wonders.configuration.Config;

public class Common{

	/* Other Methods */
	public static void CloseWarningMessageWithAcception(IGenericWebDriver driver) {
		driver.switchToAlertWindow().accept();
	}
 
	public static void CloseWarningMessageWithAcception(String sMessage,
			boolean bIsEqual, IGenericWebDriver driver) {

		if (bIsEqual) {
			if (driver.switchToAlertWindow().getText().equals(sMessage)) {
				CloseWarningMessageWithAcception(driver);
			}
		}

		if (!bIsEqual) {
			if (driver.switchToAlertWindow().getText().contains(sMessage)) {
				CloseWarningMessageWithAcception(driver);
			}
		}

	}

	@SuppressWarnings("static-access")
	public static void sleep(int time) {
		try {
			Thread.currentThread().sleep(1000 * time);//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String genPurpose(Object obj, String purpose) {
		return obj.getClass().getSimpleName() + "(" + purpose + ")";
	}

	public static String getIEDriver() {
		return Common.class.getResource("../../../IEDriverServer.exe")
				.getFile();
	}

	public static String getChromeDriver() {
		return Common.class.getResource("../../../chromedriver.exe")
				.getFile();
	}
	
	public static String getFireFoxDriver() {
		return Config.getFirefoxPath();
	}
	
	public static String dealObj(HSSFCell obj){
		if(null!=obj){
			if(Cell.CELL_TYPE_NUMERIC==obj.getCellType()){
				return obj.toString().substring(0, obj.toString().indexOf("."));
			}else{
				return obj.toString();
			}			
		}else{
			return "";
		}
	}

	public static String dealObj(Cell obj){
		if(null!=obj){
			if(Cell.CELL_TYPE_NUMERIC==obj.getCellType()){
				return obj.toString().substring(0, obj.toString().indexOf("."));
			}else{
				return obj.toString();
			}			
		}else{
			return "";
		}
	}
}
