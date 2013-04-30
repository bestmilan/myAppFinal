package com.wonders.service.issue;

import org.springframework.beans.factory.annotation.Autowired;

import browser.common.IGenericWebDriver;

import com.wonders.pagewrapper.issue.CreateIssueFields;
import com.wonders.pagewrapper.issue.SearchIssue;


public class SearchIssueResultService {
	private IGenericWebDriver driver;
	private SearchIssue searchIssue;
	@Autowired
	private CreateIssueFields createIssueFields;
	public SearchIssueResultService(IGenericWebDriver _driver){
		driver = _driver;
		searchIssue = new SearchIssue(_driver);
	}
	
	/*public boolean checkSearchResultCount(String blockType, String block, String status, String reporter, String days){
		try{
			String resultCount = String.valueOf(dao.returnCount(blockType, block, status, reporter, days));
			if("0".equals(resultCount)){
				return SearchIssue.eleNoSearchResult().isExist();
			}else{
				if(resultCount.equals(SearchIssue.eleResultsCountTotal().getText())){
					return checheSearchResultInList(blockType, block, status, reporter, days);
				}else{
					return false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}*/
	
	public boolean checheSearchResultInList(String blockType, String block, String status, String reporter, String days){
		if(block.equals(searchIssue.tblclIssueCell(1, 2).getText())&&
				reporter.equals(searchIssue.tblclIssueCell(1, 4).getText())||
				status.equals(searchIssue.tblclIssueCell(1, 6).getText())){
			return true;
		}
		return false;
	}
	

}
