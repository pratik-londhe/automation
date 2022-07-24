package com.brandlive.qa.automation.utils;

import java.util.Properties;

public class PropertiesParser extends Utility {
	
	  // public constants for property keys to be used by all clients
	  public static final String LOGIN_KEY = "loginKey";
	  public static final String MAX_WAIT = "maximumWaitInSeconds";
	  public static final String STANDARD_WAIT = "standardWaitInSeconds";
	  public static final String SHORT_WAIT = "shortWaitInSeconds";
	  public static final String POOLING_INTERVAL_IN_MS= "pollingIntervalInMs";
	  public static final String WEB_DRIVER = "webDriver";
	  public static final String WEB_DRIVER_PATH = "webDriverPath";
	  public static final String TZ_OFFSET_BRANDLIVE = "brandliveTimeZoneGmtOffSet";
	  public static final String TZ_OFFSET_LOCAL = "localTimeZoneGmtOffSet";
	  public static final String REUSE_BRANDLIVE_LOGIN = "reuse_brandlive_login";
	  
	  // internal constants
	  //private static final String FOLDER_PATH = "com/brandlive/qa/automation/properties/";
	  //private static final String FOLDER_PATH = "src/main/resources/com/brandlive/qa/automation/properties/";
	  //private static final String PROPERTIES_FILE = FOLDER_PATH + "brandliveQA.properties";
	  private static final String PROPERTIES_FILE = "/brandliveQA.properties";
	  private static PropertiesParser instance;
	  private static Properties properties = new Properties();

	  private PropertiesParser() {
	    try {
	      log.info("StepDefs java class (cucumber supportive class) is a starting point of any test.\n"
	      		+ "StepDefs java class makes an instance of PropertiesParser class through BrandliveScubscription\n"
	      		+ "and BrandliveSubscription pass LoginKey to LoginXmlParser class to get test subscription instance.");	
	      log.debug("Loading properties file " + PROPERTIES_FILE);
	      properties.load(PropertiesParser.class.getResourceAsStream(PROPERTIES_FILE));
	    } catch (Exception e) {
	      wrapFatalException(e, "Could not load test configuration file " + quote(PROPERTIES_FILE));
	    }
	  }

	  public static PropertiesParser instance() {
	    if (instance == null) {
	      instance = new PropertiesParser();
	    }
	    return PropertiesParser.instance;
	  }

	  public String get(String key) {
	    if (properties.containsKey(key)) {
	      return properties.getProperty(key);
	    }
	    log.warn("Property " + quote(key) + " not defined in " + quote(PROPERTIES_FILE));
	    return null;
	  }

}
