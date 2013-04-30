package com.wonders.service.issue;
import org.springframework.beans.factory.annotation.Autowired;

import browser.common.IGenericWebDiv;
import browser.common.IGenericWebDriver;
import browser.common.IGenericWebElementCollection;

import com.wonders.pagewrapper.issue.WikiHelpPage;

public class WikiHelpPageService {
	private IGenericWebDriver driver;
	@Autowired
	private WikiHelpPage wikiHelpPage;
	public WikiHelpPageService(IGenericWebDriver _driver){
		driver = _driver;
		wikiHelpPage = new WikiHelpPage(_driver);
	}

	public boolean checkLeftNavContent(){
		IGenericWebElementCollection<IGenericWebDiv> list = wikiHelpPage.divLeftNav();
		for(IGenericWebDiv div : list){
			if("Attachments".equals(div.getText())){
				return true;
			}
		}
		return false;
	}
}