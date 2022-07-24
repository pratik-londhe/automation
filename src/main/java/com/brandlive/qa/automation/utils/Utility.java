package com.brandlive.qa.automation.utils;

import org.apache.log4j.Logger;

abstract class Utility {
	
	protected final Logger log = Logger.getLogger(getClass());
	
	  /**
	   * Report newly discovered exception. For errors triggered by a dependency,
	   * use {@link wrapException} method!
	   * 
	   * @param errorMsg
	   */
	  protected void reportError(String errorMsg) {
	    log.error(errorMsg);
	    throw new RuntimeException(errorMsg);
	  }

	  /**
	   * Report a warning about a condition, which may not be a reason to fail the
	   * current test.
	   */
	  protected void reportWarning(String warningMsg) {
	    log.warn(warningMsg);
	    throw new RuntimeException(warningMsg);
	  }

	  /**
	   * Report that a condition required to run the test is not met. Rather than
	   * reporting test failure, this will signal Cucumber framework (and its callers)
	   * that the current scenario could not be run, and the subsequent steps in this
	   * scenario will be skipped.
	   */
	  protected void skipScenario(String reasonMsg) {
	    log.error(reasonMsg);
	    throw new RuntimeException(reasonMsg);
	  }

	  /**
	   * Report that a condition required to run the test is not met, as indicated by
	   * an exception passed as parameter. 
	   * 
	   * Rather than reporting test failure, this will signal Cucumber framework (and its callers)
	   * that the current scenario could not be run, and the subsequent steps in this
	   * scenario will be skipped.
	   */
	  protected void skipScenario(Throwable t, String reasonMsg) {
	    log.error(reasonMsg);
	    throw new RuntimeException(reasonMsg, t);
	  }

	  /**
	   * Throw exception wrapping original exception that will cause current test to
	   * fail with an additional error message that should better explain what has
	   * gone wrong than the message in the original exception.
	   * 
	   * @param t
	   *          lower level exception
	   * @param errorMsg
	   *          higher level error message
	   * @throws RuntimeException
	   */
	  protected void wrapFatalException(Throwable t, String errorMsg) {
	    log.error(errorMsg);
	    throw new RuntimeException(errorMsg, t);
	  }
	  
	  protected void printCallStack(Throwable t) {
	    for (StackTraceElement ste : t.getStackTrace()) {
	      log.error(ste);
	    }
	    Throwable cause = t.getCause();
	    if (cause != null) {
	      log.error("  caused by");
	      printCallStack(cause);
	    }
	  }

	  public static String quote(String text) {
	    return "'" + text + "'";
	  }
	  
	  public static String quote(Boolean bool) {
	    if (bool) {
	      return "'true'";
	    } else {
	      return "'false'";
	    }
	  }

	  public static String quote(Integer integer) {
	    return quote(integer.toString());
	  }
}
