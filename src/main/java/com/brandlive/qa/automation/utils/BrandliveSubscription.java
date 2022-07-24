package com.brandlive.qa.automation.utils;

public class BrandliveSubscription extends Doer {
	
	private String loginKey = null;
	private String channelName = null;
	private String greenroomRole = null;
	private String greenroomUser = null;
	private String greenroomPassword = null;
	private String greenroomUrl = null;
	private String greenroomEntryMode = null;
	private String eventsUrl = null;
	private String eventsUser = null;
	private String eventsPassword = null;
	
	public BrandliveSubscription() {
		loginKey = PropertiesParser.instance().get(PropertiesParser.LOGIN_KEY);
		logConfiguration();
	}
	
	private void logConfiguration() {
		log.debug("LoginKey: " + loginKey);
		log.debug("LoginInfo: " + getLoginInfo());
		log.debug("Channel Name: " + channelName);
		log.debug("Greenroom User: " + greenroomUser);
		log.debug("Greenroom Password: " + greenroomPassword);
		log.debug("Greenroom Url: " + greenroomUrl);
		log.debug("Greenroom Role: " + greenroomRole);
		log.debug("Greenroom Mode: " + greenroomEntryMode);
		log.debug("Events User: " + eventsUser);
		log.debug("Events Password: " + eventsPassword);
		log.debug("Events Url: " + eventsUrl);
	}
	
	private LoginInfo getLoginInfo() {
		log.debug("Parsing subscription XML file...");
		LoginInfo loginInfo = LoginXmlParser.instance().getLogin(loginKey);
		setSubscriptionDetails(loginInfo);
		return loginInfo;
	}
	
	private void setSubscriptionDetails(LoginInfo loginInfo) {
		this.channelName = loginInfo.getChannelName();
		this.greenroomRole = loginInfo.getGreenroomRole();
		this.greenroomUser = loginInfo.getGreenroomUser();
		this.greenroomPassword = loginInfo.getGreenroomPassword();
		this.greenroomUrl = loginInfo.getGreenroomUrl();
		this.greenroomEntryMode = loginInfo.getGreenroomEntryMode();
		this.eventsUrl = loginInfo.getEventsUrl();
		this.eventsUser = loginInfo.getEventsUser();
		this.eventsPassword = loginInfo.getEventsPassword();
	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getGreenroomRole() {
		return greenroomRole;
	}

	public void setGreenroomRole(String greenroomRole) {
		this.greenroomRole = greenroomRole;
	}

	public String getGreenroomUser() {
		return greenroomUser;
	}

	public void setGreenroomUser(String greenroomUser) {
		this.greenroomUser = greenroomUser;
	}
	
	public String getGreenroomPassword() {
		return greenroomPassword;
	}

	public void setGreenroomPassword(String greenroomPassword) {
		this.greenroomPassword = greenroomPassword;
	}
	
	public String getGreenroomUrl() {
		return greenroomUrl;
	}

	public void setGreenroomUrl(String greenroomUrl) {
		this.greenroomUrl = greenroomUrl;
	}
	
	public String getGreenroomEntryMode() {
		return greenroomEntryMode;
	}

	public void setGreenroomEntryMode(String greenroomEntryMode) {
		this.greenroomEntryMode = greenroomEntryMode;
	}

	public String getEventsUser() {
		return eventsUser;
	}

	public void setEventsUser(String eventsUser) {
		this.eventsUser = eventsUser;
	}
	
	public String getEventsPassword() {
		return eventsPassword;
	}

	public void setEventsPassword(String eventsPassword) {
		this.eventsPassword = eventsPassword;
	}
	
	public String getEventsUrl() {
		return eventsUrl;
	}

	public void setEventsUrl(String eventsUrl) {
		this.eventsUrl = eventsUrl;
	}
}
