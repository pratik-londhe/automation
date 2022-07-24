package utils;

import com.mashape.unirest.http.exceptions.UnirestException;
import environment.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class Connection {
    private static final Logger logger = Logger.getLogger(Connection.class);
    private String browserName;
    public WebDriver webDriver;

    public String executionEnv = "";
    public String currentBrowser;
    private Properties configProperty = null;
    protected static List<String> logs = new ArrayList();

    public void startBrowser(String browser, boolean isCBT, boolean isZalenium, String testName, String buildVersion) {
        browserName = browser;
        setWebDriver(browser, isCBT, isZalenium, testName, buildVersion);
    }

    public void accessURL(String url) {
        webDriver.get(url);
    }

    public void stopBrowser() {
        if (!browserName.equalsIgnoreCase("firefox") && webDriver != null) webDriver.quit();
        else {
            if (webDriver != null) {
                webDriver.quit();
                setWebDriverToNull();
            }
        }
    }

    public void closeBrowser() {
        webDriver.close();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void refreshBrowser() {
        webDriver.navigate().refresh();
    }

    public void setWebDriver(String browser, boolean isCBT, boolean isZalenium, String testName, String buildVersion) {
        boolean cbtFlag = isCBT && ("SAFARI".equalsIgnoreCase(browser) || "EDGE".equalsIgnoreCase(browser));
        boolean zaleniumFlag = isZalenium && ("CHROME".equalsIgnoreCase(browser) || "FIREFOX".equalsIgnoreCase(browser));
        configProperty = PropertyReader.getConfigData();
        switch (browser.toUpperCase()) {
            case "SAFARI":
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability("name", testName);
                safariOptions.setCapability("build", buildVersion);
                safariOptions.setCapability("browserName", "Safari");
                safariOptions.setCapability("version", "11");
                safariOptions.setCapability("platform", "Mac OSX 10.13");
                safariOptions.setCapability("screenResolution", "1366x768");
                safariOptions.setCapability("record_video", "true");
                safariOptions.setCapability("record_network", "true");
                currentBrowser = "Safari";
                if (cbtFlag) {
                    try {
                        String cbtConnectString = "http://" + configProperty.getProperty("username") + ":" + configProperty.getProperty("authKey") + "@" + configProperty.getProperty("CBTHubAddress") + "/wd/hub";
                        logger.info("cbt connection string is" + cbtConnectString);

                        webDriver = new RemoteWebDriver(new URL(cbtConnectString), safariOptions);
                        browserMaximize();
                        executionEnv = "CBT";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else if (zaleniumFlag) {
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://" + configProperty.getProperty("zaleniumURL") + "/wd/hub"), safariOptions);
                        executionEnv = "Zalenium";
                        browserMaximize();
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else {
                    localExecution(browser);
                }
                break;
            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("name", testName);
                edgeOptions.setCapability("build", buildVersion);
                edgeOptions.setCapability("browserName", "MicrosoftEdge");
                edgeOptions.setCapability("version", "17");
                edgeOptions.setCapability("platform", "Windows 10");
                edgeOptions.setCapability("screenResolution", "1366x768");
                edgeOptions.setCapability("record_video", "true");
                edgeOptions.setCapability("record_network", "true");
                currentBrowser = "Edge";
                if (cbtFlag) {
                    try {
                        String cbtConnectString = "http://" + configProperty.getProperty("username") + ":" + configProperty.getProperty("authKey") + "@" + configProperty.getProperty("CBTHubAddress") + "/wd/hub";
                        logger.info("cbt connection string is" + cbtConnectString);

                        webDriver = new RemoteWebDriver(new URL(cbtConnectString), edgeOptions);
                        browserMaximize();
                        executionEnv = "CBT";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else if (zaleniumFlag) {
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://" + configProperty.getProperty("zaleniumURL") + "/wd/hub"), edgeOptions);
                        browserMaximize();
                        executionEnv = "Zalenium";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else {
                    localExecution(browser);
                }
                break;

            case "FIREFOX":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("name", testName);
                firefoxOptions.setCapability("build", buildVersion);
                currentBrowser = "FireFox";
                if (cbtFlag) {
                    try {
                        String cbtConnectString = "http://" + configProperty.getProperty("username") + ":" + configProperty.getProperty("authKey") + "@" + configProperty.getProperty("CBTHubAddress") + "/wd/hub";
                        logger.info("cbt connection string is" + cbtConnectString);

                        webDriver = new RemoteWebDriver(new URL(cbtConnectString), firefoxOptions);
                        browserMaximize();
                        executionEnv = "CBT";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else if (zaleniumFlag) {
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://" + configProperty.getProperty("zaleniumURL") + "/wd/hub"), firefoxOptions);
                        browserMaximize();
                        executionEnv = "Zalenium";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else {
                    localExecution(browser);
                }
                break;

            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                LoggingPreferences loggingPreferences = new LoggingPreferences();
                loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
                chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
                chromeOptions.setCapability("name", testName);
                chromeOptions.setCapability("build", buildVersion);
                currentBrowser = "Chrome";
                if (cbtFlag) {
                    try {
                        String cbtConnectString = "http://" + configProperty.getProperty("username") + ":" + configProperty.getProperty("authKey") + "@" + configProperty.getProperty("CBTHubAddress") + "/wd/hub";
                        logger.info("cbt connection string is" + cbtConnectString);

                        webDriver = new RemoteWebDriver(new URL(cbtConnectString), chromeOptions);
                        browserMaximize();
                        executionEnv = "CBT";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else if (zaleniumFlag) {
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://" + configProperty.getProperty("zaleniumURL") + "/wd/hub"), chromeOptions);
                        browserMaximize();
                        executionEnv = "Zalenium";
                    } catch (MalformedURLException e) {
                        logger.trace(e);
                    }
                } else {
                    localExecution(browser);
                }
                break;

            default:
                logger.info("No Browser Matched.");
        }
    }

    public void localExecution(String browser) {
        switch (browser.toUpperCase()) {
            case "SAFARI":
                webDriver = new SafariDriver();
                break;
            case "EDGE":
                System.setProperty("webdriver.edge.driver", getDriverPath(browser.toLowerCase()));
                webDriver = new EdgeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", getDriverPath(browser.toLowerCase()));
                webDriver = new FirefoxDriver();
                break;
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", getDriverPath(browser));
                webDriver = new ChromeDriver();
                break;
            default:
                logger.info("Invalid browser name : " + browser);

        }
        executionEnv = "Local";
        browserMaximize();
    }

    public void browserMaximize() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    public JsonNode setScore(String seleniumTestId, String score) throws UnirestException {
        // Mark a Selenium test as Pass/Fail
        HttpResponse<JsonNode> response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}").basicAuth(configProperty.getProperty("username"), configProperty.getProperty("authKey")).routeParam("seleniumTestId", seleniumTestId).field("action", "set_score").field("score", score).asJson();
        return response.getBody();
    }

    public void extractJSLogs() {
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            logs.add(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        Iterator<String> iterator = logs.iterator();
        while (iterator.hasNext()) {
            String log = iterator.next();
            new LogsTextFile().writeToTextFile(log);
        }
    }

    public String getVersion() {
        Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
        String browserVersion = cap.getVersion().toString();
        return browserVersion;
    }

    public String getDriverPath(String browserName) {
        browserName = browserName.toLowerCase();
        String osName = System.getProperty("os.name").toLowerCase();
        String driverPath = null;
        if (osName.contains("win")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/win/" + browserName + "driver.exe";
        }
        if (osName.contains("linux")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/linux/" + browserName + "driver";
        }
        if (osName.contains("mac")) {
            driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/mac/" + browserName + "driver";
        }
        return driverPath;
    }

    public void setWebDriverToNull() {
        webDriver = null;
    }
}