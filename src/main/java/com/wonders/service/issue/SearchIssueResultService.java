package com.wonders.service.issue;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import browser.common.IGenericWebDriver;

import com.wonders.dao.issueFields.IssueFieldsSearchDao;
import com.wonders.pagewrapper.issue.CreateIssueFields;
import com.wonders.pagewrapper.issue.SearchIssue;

@Service
public class SearchIssueResultService {
	private SearchIssue searchIssue;
	@Resource
	private IssueFieldsSearchDao dao;
	@Autowired
	private CreateIssueFields createIssueFields;
	public SearchIssueResultService(IGenericWebDriver _driver){
		searchIssue = new SearchIssue(_driver);
	}
	public void setDao(IssueFieldsSearchDao dao) {
		this.dao = dao;
	}
	public boolean checkSearchResultCount(String blockType, String block, String status, String reporter, String days){
		try{
			String resultCount = String.valueOf(dao.returnCount(blockType, block, status, reporter, days));
			if("0".equals(resultCount)){
				return searchIssue.eleNoSearchResult().isExist();
			}else{
				if(resultCount.equals(searchIssue.eleResultsCountTotal().getText())){
					return checheSearchResultInList(blockType, block, status, reporter, days);
				}else{
					return false;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean checheSearchResultInList(String blockType, String block, String status, String reporter, String days){
		if(block.equals(searchIssue.tblclIssueCell(1, 2).getText())&&
				reporter.equals(searchIssue.tblclIssueCell(1, 4).getText())||
				status.equals(searchIssue.tblclIssueCell(1, 6).getText())){
			return true;
		}
		return false;
	}
	

}
