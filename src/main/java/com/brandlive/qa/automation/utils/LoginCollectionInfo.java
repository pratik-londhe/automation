package com.brandlive.qa.automation.utils;

import java.util.Map;

public class LoginCollectionInfo {
	
	  private String description;
	  Map<String, LoginInfo> logins;

	  public Map<String, LoginInfo> getLogins() {
	    return logins;
	  }

	  public String getDescription() {
	    return description;
	  }

	  @Override
	  public String toString() {
	    return "LoginCollection [description=" + description + ", logins=" + logins + "]";
	  }

}
