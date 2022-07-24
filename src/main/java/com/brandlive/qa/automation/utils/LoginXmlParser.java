package com.brandlive.qa.automation.utils;

import java.io.InputStream;
import java.util.Map;

import cucumber.deps.com.thoughtworks.xstream.XStream;
import cucumber.deps.com.thoughtworks.xstream.io.xml.DomDriver;

public class LoginXmlParser extends Doer {

	//private static final String FOLDER_PATH = "src/main/resources/com/brandlive/qa/automation/properties";
	private static LoginXmlParser instance;
	private final Map<String, LoginInfo> blLogins;
	private String configFileName = null;


	private LoginXmlParser() {
		XStream xstream = loginStream();
		//this.configFileName = FOLDER_PATH + "/blLogins.xml";
		this.configFileName = "/blLogins.xml";
		log.debug("Parsing subscription file " + configFileName);
		InputStream is = LoginXmlParser.class.getResourceAsStream(configFileName);
		LoginCollectionInfo logins = (LoginCollectionInfo) xstream.fromXML(is);
		this.blLogins = logins.getLogins();
	}

	private XStream loginStream() {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("logins", LoginCollectionInfo.class);
		xstream.useAttributeFor(LoginCollectionInfo.class, "description");
		xstream.useAttributeFor(LoginInfo.class, "name");
		xstream.useAttributeFor(LoginInfo.class, "channelName");
		xstream.useAttributeFor(LoginInfo.class, "greenroomUrl");
		xstream.useAttributeFor(LoginInfo.class, "greenroomUser");
		xstream.useAttributeFor(LoginInfo.class, "greenroomPassword");
		xstream.useAttributeFor(LoginInfo.class, "greenroomRole");
		xstream.useAttributeFor(LoginInfo.class, "greenroomEntryMode");
		xstream.useAttributeFor(LoginInfo.class, "eventsUrl");
		xstream.useAttributeFor(LoginInfo.class, "eventsUser");
		xstream.useAttributeFor(LoginInfo.class, "eventsPassword");
		xstream.useAttributeFor(LoginInfo.class, "greenroomDBHost");
		xstream.useAttributeFor(LoginInfo.class, "greenroomDBPort");
		xstream.useAttributeFor(LoginInfo.class, "greenroomDBUser");
		xstream.useAttributeFor(LoginInfo.class, "greenroomDBPassword");
		xstream.useAttributeFor(LoginInfo.class, "greenroomDBName");
		xstream.useAttributeFor(LoginInfo.class, "eventsDBHost");
		xstream.useAttributeFor(LoginInfo.class, "eventsDBPort");
		xstream.useAttributeFor(LoginInfo.class, "eventsDBUser");
		xstream.useAttributeFor(LoginInfo.class, "eventsDBPassword");
		xstream.useAttributeFor(LoginInfo.class, "eventsDBName");
		xstream.alias("login", String.class);
		xstream.addImplicitMap(LoginCollectionInfo.class, "logins", "login", LoginInfo.class, "name");
		return xstream;
	}
	
	
	public static LoginXmlParser instance() {
	    if (instance == null) {
	      instance = new LoginXmlParser();
	    }
	    return LoginXmlParser.instance;
	}

	/**
	 * Retrieve test configuration record for a given key
	 * 
	 * @param name
	 *          unique handle
	 * @return test configuration record
	 * @throws RuntimeException
	 *           if no record with the given name can be retrieved
	 */
	public LoginInfo getLogin(String name) {
		LoginInfo loginInfo = null;
		loginInfo = blLogins.get(name);
		if (loginInfo == null) {
			skipScenario("An entry with name " + quote(name) + " could not be found in the test configuration!");
		}
		return loginInfo;
	}

}
