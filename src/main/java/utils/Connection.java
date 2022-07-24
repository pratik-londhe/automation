package utils;

import constants.Constants;
import environment.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.saucelabs.common.SauceOnDemandAuthentication;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Connection{
    private static final Logger logger = Logger.getLogger(Connection.class);
    public WebDriver webDriver;
    public AppiumDriver<WebElement> appiumDriver;
    protected String browserName;
    Properties configProperty = null;
    DesiredCapabilities desiredCapabilities = null;
    public ThreadLocal<String> sessionId = new ThreadLocal<String>();
    String sauceUserName = "ipsy-qa";
    String sauceAccessKey = "799f25a4-fe82-48de-a29b-3b8d2ca11e36";
    private static SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("ipsy-qa", "799f25a4-fe82-48de-a29b-3b8d2ca11e36");
    public static final ThreadLocal<WebDriver> remoteDriver = new ThreadLocal<WebDriver>();


    //Start browser
    public void startBrowser(String browser, String testName, boolean isGridExe) {
        browserName = browser;
        setWebDriver(browser, testName, isGridExe);
    }

    //Access URL
    public void accessURL(String url) {
        webDriver.get(url);
    }

    //Access URL
    public void accessMobileURL(String url) {
        appiumDriver.get(url);
    }
    //Stop browser
    public void stopBrowser() {
        if (!"firefox".equalsIgnoreCase(browserName) && webDriver != null)
            webDriver.quit();
        else {
            if (webDriver != null && appiumDriver != null) {
                webDriver.quit();
                appiumDriver.quit();
                setWebDriverToNull();
            }
        }
    }

    //Close browser
    public void closeBrowser() {
        webDriver.close();
    }

    //Return WebDriver
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    //Refresh browser
    public void refreshBrowser() {
        webDriver.navigate().refresh();
    }

    //Set WebDriver
    public void setWebDriver(String browser, String testName, boolean isGridExe) {
        switch (browser.toUpperCase()) {
            case "FIREFOX":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;
            case "CHROME":
                desiredCapabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                desiredCapabilities.setCapability("name", testName);
                break;
            case "SAFARI":
                desiredCapabilities = DesiredCapabilities.safari();
                break;
            default:
        }
        setWebDriverGrid(browser, isGridExe);
    }

    public void setWebDriverGrid(String browser, boolean isGridExe) {
        configProperty = PropertyReader.getConfigData();
        if (isGridExe) {
            boolean isCBTExe = Boolean.parseBoolean(configProperty.getProperty("isCBTExe"));
            boolean isSauceExe = Boolean.parseBoolean(configProperty.getProperty("isSauceLabExe"));
            boolean isZaleniumExe = Boolean.parseBoolean(configProperty.getProperty("isZaleniumExe"));
            if (isCBTExe) {
                try {
                    String cbtConnectString = "http://" + configProperty.getProperty("username") + ":" + configProperty.getProperty("authKey") + "@" + configProperty.getProperty("CBTHubAddress") + "/wd/hub";
                    logger.info("cbt connection string is" + cbtConnectString);
                    webDriver = new RemoteWebDriver(new URL(cbtConnectString), desiredCapabilities);
                } catch (MalformedURLException e) {
                    logger.info(e);
                }
            } else if (isSauceExe) {
                try {
                    configProperty = PropertyReader.getConfigData();
                    String ipaddress = configProperty.getProperty("ipaddress");
                    webDriver = new RemoteWebDriver(new URL("http://" + ipaddress + "/wd/hub/"), desiredCapabilities);
                } catch (MalformedURLException e) {
                    logger.info(e);
                }
            } else if (isZaleniumExe) {
                try {
                    webDriver = new RemoteWebDriver(new URL("http://" + configProperty.getProperty("zaleniumURL") + "/wd/hub"), desiredCapabilities);
                } catch (MalformedURLException e) {
                    logger.error(e);
                }
            }

        } else {
            switch (browser.toUpperCase()) {
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", getDriverPath(browser.toLowerCase()));
                    incognitoExecution(browserName);
                    headLessExecution(browserName);
                    webDriver = new FirefoxDriver(desiredCapabilities);
                    break;
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", getDriverPath(browser));
                    incognitoExecution(browserName);
                    headLessExecution(browserName);
                    webDriver = new ChromeDriver(desiredCapabilities);
                    break;
                case "SAFARI":
                    webDriver = new SafariDriver(desiredCapabilities);
                    break;
                case "IE":
                    incognitoExecution(browserName);
                    System.setProperty("webdriver.ie.driver", getDriverPath(browser));
                    webDriver = new InternetExplorerDriver(desiredCapabilities);
                    break;
                default:
                    logger.info("Invalid browser name : " + browser);
            }
        }
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    //Get driver path
    public String getDriverPath(String browserName) {
        browserName = browserName.toLowerCase();
        String osName = System.getProperty("os.name").toLowerCase();
        String driverPath = null;
        if (osName.contains("win")) {
            driverPath = System.getProperty(Constants.USER_DIR) + "/src/main/resources/drivers/win/" + browserName + "driver.exe";
        }
        if (osName.contains("linux")) {
            driverPath = System.getProperty(Constants.USER_DIR) + "/src/main/resources/drivers/linux/" + browserName + "driver";
        }
        if (osName.contains("mac")) {
            driverPath = System.getProperty(Constants.USER_DIR) + "/src/main/resources/drivers/mac/" + browserName + "driver";
        }
        return driverPath;
    }

    public void incognitoExecution(String browserName) {
        configProperty = PropertyReader.getConfigData();
        Boolean incognitoFlag = Boolean.valueOf(configProperty.getProperty("isIncognitoExe"));
        if (incognitoFlag) {
            switch (browserName.toUpperCase()) {
                case "FIREFOX":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private");
                    desiredCapabilities.setCapability("moz:firefoxOptions", firefoxOptions);
                    break;
                case "CHROME":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    break;
                case "SAFARI":
                    logger.info("Safari doesn't support to the Incognito execution");
                    break;
                case "IE":
                    desiredCapabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                    desiredCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                    break;
                default:
                    logger.info("Invalid browser name : " + browserName);
            }
        }
    }

    public void headLessExecution(String browserName) {
        configProperty = PropertyReader.getConfigData();
        Boolean headLessExe = Boolean.valueOf(configProperty.getProperty("isHeadLessExe"));
        if (headLessExe) {
            switch (browserName.toUpperCase()) {
                case "FIREFOX":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
                    break;
                case "CHROME":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    break;
                case "SAFARI":
                    logger.info("Safari doesn't support to the HeadLess execution");
                    break;
                case "IE":
                    logger.info("IE doesn't support to the HeadLess execution");
                    break;
                default:
                    logger.info("Invalid browser name : " + browserName);
            }
        }
    }

    public String getPlatform() {
        return configProperty.getProperty("platform");
    }

    public void setWebDriverToNull() {
        appiumDriver = null;
    }

    public void setAppiumDriver(String platformVersion,String platformName,String deviceName,String portNumber,String browser) throws MalformedURLException {
        configProperty = PropertyReader.getConfigData();
        if (platformName.equalsIgnoreCase("android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (configProperty.getProperty("appExecution").equalsIgnoreCase("true")) {
                capabilities.setCapability("appPackage", configProperty.getProperty("appPackage"));
                capabilities.setCapability("appActivity", configProperty.getProperty("appActivity"));
            } else {
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("platform", configProperty.getProperty("platform"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", false);
                capabilities.merge(chromeOptions);
            }
            capabilities.setCapability("platformVersion", platformVersion);
            //capabilities.setCapability("chromedriver-executable",".\\src\\main\\resources\\drivers\\mobile\\chromedriver.exe");
            //capabilities.setCapability("app", "./src/main/resources/apk/"+configProperty.getProperty("app"));
            //capabilities.setCapability("udid", configProperty.getProperty("udid"));
            capabilities.setCapability("platformName", System.getProperty("platformName"));
            //capabilities.setCapability("newCommandTimeout", configProperty.getProperty("newCommandTimeout"));
           // capabilities.setCapability("automationName", configProperty.getProperty("automationName"));
            capabilities.setCapability("deviceName", deviceName);
            //capabilities.setCapability("newCommandTimeout", 50000);
               // AndroidDriver driver = new AndroidDriver(new URL(configProperty.getProperty("ipLocal")), capabilities);
                //appiumDriver = driver;
            //remoteDriver.set(new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)), capabilities));
            appiumDriver = new AndroidDriver<WebElement>(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:"+portNumber+"/wd/hub", sauceUserName, sauceAccessKey)), capabilities);


        } else if (platformName.equalsIgnoreCase("ios")) {
            boolean useNewWDA = System.getProperty(CommandLineParameters.USE_NEW_WDA) != null
                    ? new Boolean(System.getProperty(CommandLineParameters.USE_NEW_WDA)) : false;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (configProperty.getProperty("appExecution").equalsIgnoreCase("true")) {
                capabilities.setCapability("bundleId", configProperty.getProperty("bundleId"));
            }
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("browserName", browser);
            //capabilities.setCapability("udid", configProperty.getProperty("udid"));
            capabilities.setCapability("platform", configProperty.getProperty("platform"));
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("showIOSLog", true);
           // capabilities.setCapability("automationName", configProperty.getProperty("automationName"));
            //capabilities.setCapability("newCommandTimeout", 50000);
            //capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
            //capabilities.setCapability("startIWDP", true);
            //capabilities.setCapability("useNewWDA", useNewWDA);
            //capabilities.setCapability("usePrebuiltWDA", true);
            //capabilities.setCapability("launchTimeout", "50000");
            //capabilities.setCapability("wdaLaunchTimeout", "50000");
            //capabilities.setCapability("wdaConnectionTimeout", "50000");
            //capabilities.setCapability("wdaStartupRetries", "4");
            //capabilities.setCapability("wdaStartupRetryInterval", "50000");
            //capabilities.setCapability("autoAcceptAlerts", "true");
            //capabilities.setCapability("unexpectedAlertBehaviour", "true");
            appiumDriver = new IOSDriver<WebElement>(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:"+portNumber+"/wd/hub", sauceUserName, sauceAccessKey)), capabilities);
        }
    }
}