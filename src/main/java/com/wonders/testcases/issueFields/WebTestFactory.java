package com.wonders.testcases.issueFields;

import org.testng.annotations.Factory;

public class WebTestFactory {
	@Factory
	public Object[] createItances() {
		Object[] result = new Object[3];
		for (int i = 0; i < 3; i++) {
			result[i] = new TC_JIRA_ISSUE_006(i * 10);			
		}
		return result;
	}
}
