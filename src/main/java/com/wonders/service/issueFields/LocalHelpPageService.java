package com.wonders.service.issueFields;

import com.wonders.pagewrapper.issueFields.LocalHelpPage;

public class LocalHelpPageService {
	public static boolean checkLocalHelpContent() {
		return "Logging Work and Time Tracking".equals(LocalHelpPage
				.h1LocalHelpContent().getText());
	}
}
