package com.wonders.service.issue;
import org.springframework.beans.factory.annotation.Autowired;
import browser.common.IGenericWebDriver;
import com.wonders.pagewrapper.issue.LocalHelpPage;

public class LocalHelpPageService {
	private IGenericWebDriver driver;
	@Autowired
	private LocalHelpPage localHelpPage;
	public LocalHelpPageService(IGenericWebDriver _driver){
		driver = _driver;
		localHelpPage = new LocalHelpPage(_driver);
	}
	public boolean checkLocalHelpContent() {
		return "Logging Work and Time Tracking".equals(localHelpPage
				.h1LocalHelpContent().getText());
	}
}