package com.wonders.testcases.issueFields;

import org.testng.annotations.Test;

@Test(groups = { "project", "hard", "factory" })
public class TC_JIRA_ISSUE_006 {
	public int m_numberOfTime;

	public TC_JIRA_ISSUE_006(int numberOfTimes) {
		m_numberOfTime = numberOfTimes;
	}
	/**
	 * TODO: 
	 * @author: bluce
	 * @serialData: 2013-04-17
	 * @point: @factory
	 * @memo:
	 */
	@Test
	public void testServer() {
		System.out.println("result=" + m_numberOfTime);
	}
}
