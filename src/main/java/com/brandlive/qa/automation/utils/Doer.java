package com.brandlive.qa.automation.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Doer extends Utility {

	  public Integer maximumWaitInSeconds() {
		  return Integer.parseInt(PropertiesParser.instance().get(PropertiesParser.MAX_WAIT));
	  }
	  
	  public Integer standardWaitInSeconds() {
		  return Integer.parseInt(PropertiesParser.instance().get(PropertiesParser.STANDARD_WAIT));
	  }
	  
	  public Integer shortWaitInSeconds() {
		  return Integer.parseInt(PropertiesParser.instance().get(PropertiesParser.SHORT_WAIT));
	  }
	  
	  public float sleep() {
	    return sleep(1);
	  }

	  protected float sleep(int unitInterval) {
	    int pollingIntervalInMs = unitInterval * Integer.parseInt(PropertiesParser.instance().get(PropertiesParser.POOLING_INTERVAL_IN_MS));
	    try {
	      log.trace("Wait " + pollingIntervalInMs / 1000.0 + secondOrSeconds(pollingIntervalInMs / 1000));
	      Thread.sleep(pollingIntervalInMs); // convert seconds to milliseconds
	    } catch (InterruptedException ie) {
	      // in case of interrupt, do nothing, just continue...
	    }
	    return pollingIntervalInMs / 1000.0f;
	  }
	  
	  protected String secondOrSeconds(float second) {
	    String secsText = " second";
	    if (second != 1) {
	      secsText += "s";
	    }
	    return secsText;
	  }

	  protected long secondsSince(Date startTime) {
	    return (new Date().getTime() - startTime.getTime()) / 1000;
	  }
	  
	  protected String afterWaitingFor(float second) {
	    return "After waiting for " + second + secondOrSeconds(second) + ": ";
	  }

	public String dateMethodForSGR() {
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("d MMM yyyy");
		LocalDate date = LocalDate.now();
		return FOMATTER.format(date);
	}

	public String timeFormatForSGR(String timeValue) {
		DateTimeFormatter FOMATTER = null;
		LocalTime time = null;
		if(timeValue.equalsIgnoreCase("StartTime")) {
			FOMATTER = DateTimeFormatter.ofPattern("h:mm a");
			time = LocalTime.now().plusMinutes(10);
			return FOMATTER.format(time);
		}else {
			FOMATTER = DateTimeFormatter.ofPattern("h:mm a");
			time = LocalTime.now().plusMinutes(25);
			return FOMATTER.format(time);
		}
	}
}
