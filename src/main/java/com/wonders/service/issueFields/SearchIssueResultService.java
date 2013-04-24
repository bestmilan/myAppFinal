package com.wonders.service.issueFields;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wonders.dao.issueFields.IssueFieldsSearchDao;
import com.wonders.pagewrapper.issueFields.SearchIssue;

@Service
public class SearchIssueResultService {
	@Resource
	private IssueFieldsSearchDao dao;

	public void setDao(IssueFieldsSearchDao dao) {
		this.dao = dao;
	}

	public boolean checkSearchResultCount(String blockType, String block, String status, String reporter, String days){
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
	}
	
	public boolean checheSearchResultInList(String blockType, String block, String status, String reporter, String days){
		if(block.equals(SearchIssue.tblclIssueCell(1, 2).getText())&&
				reporter.equals(SearchIssue.tblclIssueCell(1, 4).getText())||
				status.equals(SearchIssue.tblclIssueCell(1, 6).getText())){
			return true;
		}
		return false;
	}
	

}
