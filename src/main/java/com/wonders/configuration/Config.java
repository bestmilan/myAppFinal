package com.wonders.configuration;

import java.io.File;

import utils.AppConfig;

public class Config {
	
	static AppConfig config;  
	
	/* Read app.config file */
	static {
		config = new AppConfig(new File("app.config"));
	}
	
	public static int getDefaultWaitedTime() {
		return Integer.parseInt(config.getProperty("DEFAULT_WAITED_TIME"));
	}
	
	/* Get current browser */
	public static String getBrowser() {
		return config.getProperty("Browser");
	}
	
	/* Get launched URL */
	public static String getLaunchUrl() {
		return config.getProperty("URL");
	}
	
	/* Get JiraMainTile */
	public static String getJiraMainTile() {
		return config.getProperty("JiraMainTile");
	}
	
	/* Get JiraLogoutTile */
	public static String getJiraLogoutTile() {
		return config.getProperty("JiraLogoutTile");
	}
	/* Get ScreenPath */
	public static String getScreenPath() {
		return config.getProperty("ScreenPath");
	}
	
	/* Get AttachementFile */
	public static String getAttachementFile() {
		return config.getProperty("AttachementFile");
	}
	
	/* Get User */
	public static String getUser() {
		return config.getProperty("User");
	}
	
	/* Get Password */
	public static String getPassword() {
		return config.getProperty("Password");
	}
	
	/* Get FIREFOX_PATH */
	public static String getFirefoxPath() {
		return config.getProperty("FIREFOX_PATH");
	}
}
