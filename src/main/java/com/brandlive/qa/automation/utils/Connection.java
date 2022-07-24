package com.brandlive.qa.automation.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Connection extends Doer {
	
	  private static Connection instance;
	  private static WebDriver webDriver;
//	  private String loginKey = null;
	  
	  private static final int MIN_PORT = 7040;
	  private static final int MAX_PORT = 8040;
	  private static final int DEFAULT_PORT = 7045;
	  
	  private Connection() {
		log.info("Establishing webdriver connection...");
//		loginKey = PropertiesParser.instance().get(PropertiesParser.LOGIN_KEY);
	    webDriver = initializeWebDriver();
	  }
	  
	  public static Connection currentInstance() {
	    if (instance == null) {
	      instance = new Connection();
	    }
//	    instance.loginToGreenroom();
	    return instance;
	  }
	  
	  public WebDriver getWebDriver() {
	    return webDriver;
	  }
	  
	  public static void close() {
	    if (instance != null) {
	      instance.getWebDriver().quit();
	      instance = null;
	    }

	  }
	  
//	  private void loginToGreenroom() {
//		log.info("Log in to Greenroom...");
//	    LoginInfo login = LoginXmlParser.instance().getLogin(loginKey);
//	    log.debug("  login: " + login);
//	    String url = login.getUrl();
//	    String user = login.getUser();
//	    String password = login.getPassword();
//	    String greenroomRole = login.getGreenroomRole();
//	    if(greenroomRole.contains("Producer")) {
//		    String producerUrl = url.concat("/producer");
//		    instance.getWebDriver().get(producerUrl);
//		    LoginProcess loginToGR = new LoginProcess();
//	    	loginToGR.loginToGreenroomAsProducer(user, password);
//	    } else {
//	    	
//	    }
//	  }

	  private WebDriver initializeWebDriver() {
	    WebDriver webDriverObject = null;
	    //String webDriverName = PropertiesParser.instance().get(PropertiesParser.WEB_DRIVER);
	    String webDriverName = System.getProperty("browser");
	    Date startTime = new Date();
	    log.debug("The webdriver name is : "+webDriverName);
	    
	  if (webDriverName.equalsIgnoreCase("firefox")) {
        log.debug("Starting to initialize Firefox WebDriver.");     
        FirefoxOptions fxOptions = new FirefoxOptions();    
        //System.setProperty("webdriver.gecko.driver", getWebDriverPath("geckodriver"));
        WebDriverManager.firefoxdriver().setup();
        fxOptions.setCapability("marionette", true);
        fxOptions.setAcceptInsecureCerts(true);
        //fxOptions.setCapability(FirefoxDriver.PROFILE, createFirefoxProfile());
        //fxOptions.addArguments("use-fake-ui-for-media-stream");
        fxOptions.addPreference("permissions.default.notifications", 1);
        fxOptions.addPreference("permissions.default.geolocation", 1);
        fxOptions.addPreference("permissions.default.microphone", 1);
        fxOptions.addPreference("permissions.default.camera", 1);
        fxOptions.addPreference("media.navigator.streams.fake", true);

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        webDriverObject = new FirefoxDriver(fxOptions);        
        log.debug("Initialized Firefox WebDriver in " + secondsSince(startTime) + " seconds.");
        log.debug("Temp files will be written to: " + System.getProperty("java.io.tmpdir"));
        
        webDriverObject.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Dimension dimension = new Dimension(1328, 798);
        webDriverObject.manage().window().setSize(dimension);
      } else if (webDriverName.equalsIgnoreCase("chrome")) {
        //System.setProperty("webdriver.chrome.driver", getWebDriverPath("chromedriver"));
    	WebDriverManager.chromedriver().setup();
        log.debug("Initialized Chrome WebDriver in " + secondsSince(startTime) + " seconds.");
        ChromeOptions cmOptions = new ChromeOptions();
        HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
        HashMap<String, Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        contentSettings.put("notifications", 1);
        contentSettings.put("geolocation", 1);
        contentSettings.put("media_stream", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        cmOptions.setExperimentalOption("prefs", prefs);
//        cmOptions.addArguments("--use-fake-device-for-media-stream",
//        		"--use-fake-ui-for-media-stream", 
//        		"--use-file-for-fake-video-capture=src/main/resources/mjpeg/sample_640x360.mjpeg");
        cmOptions.addArguments("--use-fake-device-for-media-stream");
        cmOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cmOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        webDriverObject = new ChromeDriver(cmOptions);
        
        webDriverObject.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Dimension dimension = new Dimension(1328, 798);
		webDriverObject.manage().window().setSize(dimension);
        //webDriverObject.manage().window().maximize();

      } else if (webDriverName.toLowerCase().contains("remote")) {
        String remoteUrlString = PropertiesParser.instance().get("webDriver.remote");
        RemoteWebDriver remoteDriver = null;
        if (webDriverName.toLowerCase().contains("chrome")) {
        try {
          URL remoteHubUrl = new URL(remoteUrlString);
          ChromeOptions cmOptions = new ChromeOptions();
          cmOptions.addArguments("--use-fake-device-for-media-stream");
          cmOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
          cmOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//          RemoteWebDriver remoteDriver = new RemoteWebDriver(remoteHubUrl, DesiredCapabilities.chrome());
          remoteDriver = new RemoteWebDriver(remoteHubUrl, cmOptions);
          webDriverObject = new Augmenter().augment(remoteDriver);
        } catch (MalformedURLException e) {
          webDriverObject = null;
          reportError("Could not connect to webdriver at remote location: " + remoteUrlString);
        }
        }
        if (webDriverName.toLowerCase().contains("firefox")) {
        try {
            URL remoteHubUrl = new URL(remoteUrlString);
            FirefoxOptions fxOptions = new FirefoxOptions();    
            WebDriverManager.firefoxdriver().setup();
            fxOptions.setCapability("marionette", true);
            fxOptions.setAcceptInsecureCerts(true);
            //fxOptions.addArguments("use-fake-ui-for-media-stream");
            fxOptions.addPreference("permissions.default.notifications", 1);
            fxOptions.addPreference("permissions.default.geolocation", 1);
            fxOptions.addPreference("permissions.default.microphone", 1);
            fxOptions.addPreference("permissions.default.camera", 1);
            fxOptions.addPreference("media.navigator.streams.fake", true);
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
//            RemoteWebDriver remoteDriver = new RemoteWebDriver(remoteHubUrl, DesiredCapabilities.firefox());
            remoteDriver = new RemoteWebDriver(remoteHubUrl, fxOptions);
            webDriverObject = new Augmenter().augment(remoteDriver);
          } catch (MalformedURLException e) {
            webDriverObject = null;
            reportError("Could not connect to webdriver at remote location: " + remoteUrlString);
          }
        }
      } else {
        webDriverObject = null;
        reportError("Unknown value for webDriver property: " + webDriverName);
      }
      webDriverObject.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      Capabilities caps = ((RemoteWebDriver) webDriverObject).getCapabilities();
      log.info("Browser version : " + caps.getBrowserName() + " " + caps.getVersion());
	    
	    return webDriverObject;
	  }
	  
	  private String getWebDriverPath(String driverName) {
	    String driverFolder = new String();
	    if (SystemUtils.IS_OS_MAC) {
	      driverFolder = "drivers" + File.separator + "macos";
	    } else if (SystemUtils.IS_OS_LINUX) {
	      driverFolder = "drivers" + File.separator + "linux";
	    } else if (SystemUtils.IS_OS_WINDOWS) {
	      driverFolder = "drivers" + "/" + "windows";
	      driverName= driverName+".exe";
	    } else {
	      reportError("Unsupported OS");
	    }

	    ClassLoader classLoader = Connection.class.getClassLoader();
	    String filePath = driverFolder + "/" + driverName;
	    log.debug("File Path:" + filePath);
	    String url;
		try {
			url = URLDecoder.decode(classLoader.getResource(filePath).getFile(), "UTF-8");
			String home = URLDecoder.decode(classLoader.getResource(".").getFile(), "UTF-8");
			log.debug("Home URL:" + home);
		    log.debug("Driver URL:" + url);
		    File file = new File(url);
		    try {
		      if (!SystemUtils.IS_OS_WINDOWS) {
		        Set<PosixFilePermission> perms = new HashSet<>();
		        List<PosixFilePermission> driverPerms = Arrays.asList(PosixFilePermission.GROUP_EXECUTE, 
		        		PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_EXECUTE, PosixFilePermission.OTHERS_READ, 
		        		PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE);
		        perms.addAll(driverPerms);
		        Files.setPosixFilePermissions(Paths.get(url), perms);
		      }
		    } catch (UnsupportedOperationException e) {
		      log.warn("Driver could not be set as an executable");
		    } catch (IOException e) {
		      wrapFatalException(e, "The driver seems to have some issue.");
		    }
		    log.info("Using driver at:" + file.toString());
		    return file.toString();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    return null;
	  }
	  
//	  private FirefoxProfile createFirefoxProfile() {      
//	    FirefoxProfile firefoxProfile = new FirefoxProfile();
//	    firefoxProfile.setPreference("browser.download.folderList", 2);
//	    firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
//	    firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
//	    firefoxProfile.setPreference("dom.disable_beforeunload", true);  
//	    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, "
//	    		+ "application/vnd.ms-excel, text/csv, text/comma-separated-values, application/octet-stream");
//	    firefoxProfile.setPreference(FirefoxProfile.PORT_PREFERENCE, findAvailablePort());
//
//	    return firefoxProfile;
//	  }
//	  
//	  private int findAvailablePort() {
//	    for (int maxTryTimes = 0; maxTryTimes < 1000; maxTryTimes++) {
//	      int p = ThreadLocalRandom.current().nextInt(MIN_PORT, MAX_PORT + 1);
//	      if (portAvailable(p) && portAvailable(p - 1)) {
//	        log.debug("Port " + p + " is available!");
//	        return p;
//	      }
//	    }
//	    log.error("No port Available between " + MIN_PORT + " to " + MAX_PORT + "!");
//	    return DEFAULT_PORT;
//	  }
//	  
//	  private boolean portAvailable(int port) {
//	    log.debug("--------------Testing port " + port);
//	    Socket s = null;
//	    try {
//	      s = new Socket("localhost", port);
//	      // If the code makes it this far without an exception it means
//	      // something is using the port and has responded.
//	      log.debug("--------------Port " + port + " is not available");
//	      return false;
//	    } catch (IOException e) {
//	      log.debug("--------------Port " + port + " is available");
//	    } finally {
//	      if (s != null) {
//	        try {
//	          s.close();
//	        } catch (IOException e) {
//	          // do not throw
//	        }
//	      }
//	    }
//	    return true;
//	  }
}
