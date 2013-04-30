package com.wonders.service.issue;
import org.springframework.beans.factory.annotation.Autowired;

import browser.common.Find;
import browser.common.IGenericWebDriver;

import com.wonders.core.BaseHome;
import com.wonders.pagewrapper.base.DatePicker;
import com.wonders.pagewrapper.issue.CreateIssueFields;
import com.wonders.utils.DateManage;
import com.wonders.utils.GetAccessory;
import com.wonders.utils.RandomManage;

public class CreateIssueFieldsService {
	private IGenericWebDriver driver;
	private DatePicker datePicker;
	@Autowired
	private CreateIssueFields createIssueFields;
	public CreateIssueFieldsService(IGenericWebDriver _driver){
		driver = _driver;
		createIssueFields = new CreateIssueFields(_driver);
		datePicker = new DatePicker(_driver);
	}
	public String setIssueData(){
		String randomId = RandomManage.getRandom();
		createIssueFields.txtSummary().typeText("Summary_" + randomId);
		createIssueFields.selPriority().findOption(Find.byTextContains("Blocker")).select();
		setDueDate();  
		createIssueFields.txtrEnvironment().typeText("Environment_" + randomId);
		createIssueFields.txtrDescription().typeText("Description_" + randomId);
		createIssueFields.eleAttachement().sendKeys(GetAccessory.getFilePath("test.png"));
		driver.waitForComplete();
		if(createIssueFields.checkUploadSuccess("test.png")==true){
			createIssueFields.btnCreateIssueSubmit().click();
		}		
		return "Summary_" + randomId;
	}
	public String setIssueDataThread(){
		String randomId = RandomManage.getRandom();
		createIssueFields.txtSummary().typeText("Summary_" + randomId);
		createIssueFields.selPriority().findOption(Find.byTextContains("Blocker")).select(); 
		createIssueFields.txtrEnvironment().typeText("Environment_" + randomId);
		createIssueFields.txtrDescription().typeText("Description_" + randomId);
		/*CreateIssueFields.eleAttachement().sendKeys(GetAccessory.getFilePath("test.png"));
		BaseHome.waitForComplete();
		if(CreateIssueFields.checkUploadSuccess("test.png")==true){
			
		}	*/	
		createIssueFields.btnCreateIssueSubmit().click();
		return "Summary_" + randomId;
	}
	public void setDueDate(){
		createIssueFields.btnSelDueDate().click();
		driver.waitForComplete();
		datePicker.SetDate(DateManage.getDate(1, "MONTH"));
	}
	
	public void clickCancelIssueFields(){
		createIssueFields.lnkCancel().click();
	}
	
	public boolean checkCloseIssueFieldsSuccessFully(){
		clickCancelIssueFields();
		driver.waitForComplete();
		return createIssueFields.divIssueSetupFields().isDisplayed();
	}
	
	public void closeIssueFields(){
		clickCancelIssueFields();
		driver.waitForComplete();
	}
	
	public void showWikiHelp(){
		createIssueFields.lnkViewHelp().click();
		driver.waitForComplete();
	}
	public void showLocalHelp(){
		createIssueFields.imgLocalHelp().click();
		driver.waitForComplete();
	}
}