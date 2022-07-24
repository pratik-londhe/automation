package com.brandlive.qa.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.Set;

import static com.brandlive.qa.automation.utils.Base.webDriver;

public class Browser extends Doer {

    public void switchToTheChildWindow(int winNumber) {
        log.info("Handle the new child window");
        String parent = webDriver.getWindowHandle(); // Get parent window details
        Set<String> windows = webDriver.getWindowHandles(); // Get all Parent + Child window details
        log.info("The parent windows is:" + parent);
        log.info("The multiple windows are:" + windows);

        ArrayList<String> allWindows = new ArrayList<String>(windows);
        webDriver.switchTo().window(allWindows.get(winNumber));
    }

    public void switchToNextWindow() {
        log.info("Switch to the new window");
        Set<String> handles = webDriver.getWindowHandles();
        if (handles.size() > 1) {
            String[] listHandles = handles.toArray(new String[handles.size()]);
            for (int i = 1; i < handles.size(); i++) {
                webDriver.switchTo().window(listHandles[i]);
            }
        }
    }

    public void switchToPreviousWindow() {
        log.info("Switch to the previous window");
        Set<String> handles = webDriver.getWindowHandles();
        if (handles.size() > 1) {
            String[] listHandles = handles.toArray(new String[handles.size()]);
            for (int i = handles.size() - 1; i >= handles.size() - 1; i--) {
                webDriver.switchTo().window(listHandles[i]);
                //webDriver.close();
                webDriver.switchTo().window(listHandles[i - 1]);
            }
        }
    }

    public void switchToMainWindow() {
        log.info("Switch to the main window");
        Set<String> handles = webDriver.getWindowHandles();
        if (handles.size() > 1) {
            String[] listHandles = handles.toArray(new String[handles.size()]);
            for (int i = handles.size() - 1; i > 0; i--) {
                webDriver.switchTo().window(listHandles[i]);
                webDriver.close();
            }
            webDriver.switchTo().window(listHandles[0]);
        }
    }

    public void openNewWindowTab() {
        log.info("Open the new tab in the browser");
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.open()");
    }

    public void closeCurrentWindowAndSwitchToPreviousWindow() {
        log.info("Switch to the previous window");
        Set<String> handles = webDriver.getWindowHandles();
        if (handles.size() > 1) {
            String[] listHandles = handles.toArray(new String[handles.size()]);
            for (int i = handles.size() - 1; i >= handles.size() - 1; i--) {
                webDriver.switchTo().window(listHandles[i]);
                webDriver.close();
                webDriver.switchTo().window(listHandles[i - 1]);
            }
        }
    }

    public boolean getBrowserConsoleLogs() {
        String errorType="ERROR";
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for(LogEntry logEntry: logEntries) {
            log.info(logEntry.getLevel() + " - " + logEntry.getMessage());
            String errorLogType = logEntry.getLevel().toString();
            log.info("The console error LogType is:" +errorLogType);
            String errorMessage = logEntry.getMessage();
            log.info("The error message is: "+ errorMessage);
            if (errorLogType.equals(errorType)) {
                if (errorMessage.contains("500") || errorMessage.contains("400")) {
                    log.info("Error LogType is: "+errorLogType  +   "Console Error Message:" +errorMessage);
                    return false;
                }
            }
        }
        return true;
    }

    public void refreshBrowserWindow() {
        log.info("Refresh browser window.");
        webDriver.navigate().refresh();
    }
}
