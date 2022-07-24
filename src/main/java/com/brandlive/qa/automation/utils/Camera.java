package com.brandlive.qa.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.log4j.Logger;

public class Camera {

    private static final Logger log = Logger.getLogger(String.valueOf(Camera.class));

    public static byte[] takeScreenShot() {
        log.info("Capturing Screenshot...");
        if(Base.webDriver!=null)
        	return ((TakesScreenshot) Base.webDriver).getScreenshotAs(OutputType.BYTES);
        
        return null;
    }
}
