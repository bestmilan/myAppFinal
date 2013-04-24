package com.wonders.service.issueFields;

import browser.common.IGenericWebDiv;
import browser.common.IGenericWebElementCollection;

import com.wonders.pagewrapper.issueFields.WikiHelpPage;

public class WikiHelpPageService {
	public static boolean checkLeftNavContent(){
		IGenericWebElementCollection<IGenericWebDiv> list = WikiHelpPage.divLeftNav();
		for(IGenericWebDiv div : list){
			if("Attachments".equals(div.getText())){
				return true;
			}
		}
		return false;
	}
}
