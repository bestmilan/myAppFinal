package com.wonders.service.issueFields;

import browser.common.Find;

import com.wonders.pagewrapper.base.DatePicker;
import com.wonders.pagewrapper.issueFields.CreateIssueFields;
import com.wonders.utils.BaseHome;
import com.wonders.utils.DateManage;
import com.wonders.utils.GetAccessory;
import com.wonders.utils.RandomManage;


public class CreateIssueFieldsService {
	public static String setIssueData(){
		String randomId = RandomManage.getRandom();
		CreateIssueFields.txtSummary().typeText("Summary_" + randomId);
		CreateIssueFields.selPriority().findOption(Find.byTextContains("Blocker")).select();
		setDueDate();  
		CreateIssueFields.txtrEnvironment().typeText("Environment_" + randomId);
		CreateIssueFields.txtrDescription().typeText("Description_" + randomId);
		CreateIssueFields.eleAttachement().sendKeys(GetAccessory.getFilePath("test.png"));
		BaseHome.waitForComplete();
		if(CreateIssueFields.checkUploadSuccess("test.png")==true){
			CreateIssueFields.btnCreateIssueSubmit().click();
		}		
		return "Summary_" + randomId;
	}
	public static String setIssueDataThread(){
		String randomId = RandomManage.getRandom();
		CreateIssueFields.txtSummary().typeText("Summary_" + randomId);
		CreateIssueFields.selPriority().findOption(Find.byTextContains("Blocker")).select(); 
		CreateIssueFields.txtrEnvironment().typeText("Environment_" + randomId);
		CreateIssueFields.txtrDescription().typeText("Description_" + randomId);
		/*CreateIssueFields.eleAttachement().sendKeys(GetAccessory.getFilePath("test.png"));
		BaseHome.waitForComplete();
		if(CreateIssueFields.checkUploadSuccess("test.png")==true){
			
		}	*/	
		CreateIssueFields.btnCreateIssueSubmit().click();
		return "Summary_" + randomId;
	}
	public static void setDueDate(){
		CreateIssueFields.btnSelDueDate().click();
		BaseHome.waitForComplete();
		DatePicker.SetDate(DateManage.getDate(1, "MONTH"));
	}
	
	public static void clickCancelIssueFields(){
		CreateIssueFields.lnkCancel().click();
	}
	
	public static boolean checkCloseIssueFieldsSuccessFully(){
		clickCancelIssueFields();
		BaseHome.waitForComplete();
		return CreateIssueFields.divIssueSetupFields().isDisplayed();
	}
	
	public static void closeIssueFields(){
		clickCancelIssueFields();
		BaseHome.waitForComplete();
	}
	
	public static void showWikiHelp(){
		CreateIssueFields.lnkViewHelp().click();
		BaseHome.waitForComplete();
	}
	public static void showLocalHelp(){
		CreateIssueFields.imgLocalHelp().click();
		BaseHome.waitForComplete();
	}
	
}
