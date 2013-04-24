package com.wonders.pagewrapper.base;

import java.util.Calendar;

import com.wonders.utils.BaseHome;

import browser.common.*;

public class DatePicker extends BaseHome {

	/* Elements Definitions */
	public static IGenericWebDiv lnkPreviousYear()
	{
		return driver.findDiv(Find.byText("«"));
	}
	
	public static IGenericWebDiv lnkPreviousMonth()
	{
		return driver.findDiv(Find.byText("‹"));
	}
	
	public static IGenericWebDiv lnkNextYear()
	{
		return driver.findDiv(Find.byText("»"));
	}
	
	public static IGenericWebDiv lnkNextMonth()
	{
		return driver.findDiv(Find.byText("›"));
	}
	
	public static void SetDateOfToday() {		
		driver.switchToFrame(1).findButton(Find.byID("dpTodayInput")).click();
		driver.switchToCurrentWindowDefault();
	}
	
	public static void ClearDate() {
		driver.switchToFrame(1).findButton(Find.byID("dpClearInput")).click();
		driver.switchToCurrentWindowDefault();
	}
	
	public static void AcceptDate() {
		driver.switchToFrame(1).findButton(Find.byID("dpOkInput")).click();
		driver.switchToCurrentWindowDefault();
	}
	
	/* DatePicker Methods */
	public static void SetDate(String sDate) {
		Calendar _calendar = Calendar.getInstance();
		
		int iCurrentYear = _calendar.get(Calendar.YEAR); 
		int iCurrentMonth = _calendar.get(Calendar.MONTH) + 1;
		
		String[] lDate = sDate.split("-");
	
		int iActualYear = Integer.parseInt(lDate[0]);
		int iActualMonth = Integer.parseInt(lDate[1]);
		int iActualDay = Integer.parseInt(lDate[2]);
		
		int _differenceOfYear = Math.abs(iActualYear - iCurrentYear);
		int _differenceOfMonth = Math.abs(iActualMonth - iCurrentMonth);
		
		if (iActualYear > iCurrentYear) {			
			for (int i = 0; i < _differenceOfYear; i++) {
				lnkNextYear().click();
			}
		}
		
		if (iActualYear < iCurrentYear) {			
			for (int i = 0; i < _differenceOfYear; i++) {
				lnkPreviousYear().click();
			}
		}
		
		if (iActualMonth > iCurrentMonth) {			
			for (int i = 0; i < _differenceOfMonth; i++) {
				lnkNextMonth().click();
			}
		}
		
		if (iActualMonth < iCurrentMonth) {			
			for (int i = 0; i < _differenceOfMonth; i++) {
				lnkPreviousMonth().click();
			}
		}
		
		driver.findElement(Find.byTagName("td")
				.addAttribute("text()", String.valueOf(iActualDay))).click();

		//driver.switchToCurrentWindowDefault();
		
	}
	
}
