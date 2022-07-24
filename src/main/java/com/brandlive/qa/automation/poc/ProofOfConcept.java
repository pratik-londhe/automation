package com.brandlive.qa.automation.poc;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProofOfConcept {

	
	public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to Greenroom automation...");
        WebDriver driver = null;
//        String browser = "chrome";
        String browser = "firefox";

        if(browser.equalsIgnoreCase("chrome")) {
            System.out.println("We are using Chrome browser.");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/macos/chromedriver");
            driver = new ChromeDriver(chromeOptions());
            driver.manage().window().maximize();
        } else {
            System.out.println("We are using Firefox browser.");
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/macos/geckodriver");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver(firefoxOptions());
            Dimension dimension = new Dimension(1400, 900);
            driver.manage().window().setSize(dimension);
        }
        
        // Events
        driver.get("https://admin.brandnot.live/login");
        wait(driver)
        		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")))
        		.sendKeys("Pradnyan.Bhilare@brandlive.com");
        wait(driver)
        		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
        		.sendKeys("Pbhilare123!");
        wait(driver)
        		.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='large action']")))
        		.click();
        wait(driver)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header//button[@class='small primary']")))
				.click();
        wait(driver)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//header//div[@class='tooltip active']//li[1]")))
				.click();
        wait(driver)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='modal-close']")))
				.click();
        wait(driver)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='avatar']")))
				.click();
        wait(driver)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button xsmall']")))
				.click();
        wait(driver)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='large action']")));

        // Greenroom
        driver.get("https://greenroom.brandlive-qa.com/producer");
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Email']")))
                .sendKeys("Pradnyan.Bhilare@brandlive.com");
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='onboarding producer']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='title events']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Password']")))
                .sendKeys("Pbhilare123!");
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='onboarding producer']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Brandlive QA II']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='join-button'])[1]")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='room-state-switch-button showtime']")))
                .click();
        Thread.sleep(5000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[1]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[2]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[3]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[4]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[5]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                //.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab noscroll active']//button[@class='transparent text-highlight']")))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right-drawer-button'])[6]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tab active']//button[@class='transparent text-highlight']")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-right']/div[@class='header-small-button'][1]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='meta-share-tabs']//button")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                . until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-right']/div[@class='header-small-button'][2]")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='meta-share-tabs']//button")))
                .click();
        Thread.sleep(2000);
        wait(driver)
                . until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-right']/div[@class='room-state-switch-button editing']")))
                .click();
        Thread.sleep(5000);
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='room-state-switch-button showtime']")));
        driver.get("https://greenroom.brandlive-qa.com/producer");
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Brandlive QA II']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='user avatar']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='avatar-option'][4]")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='dark']")))
                .click();
        wait(driver)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Email']")));
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Greenroom automation execution successfully completed.");
    }

    public static WebDriverWait wait(WebDriver chromeDriver) {
        return new WebDriverWait(chromeDriver, 20);
    }

    public static ChromeOptions chromeOptions() {
        HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
        HashMap<String, Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        contentSettings.put("notifications", 1);
        contentSettings.put("geolocation", 1);
        contentSettings.put("media_stream", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        ChromeOptions cmOptions = new ChromeOptions();
        cmOptions.setExperimentalOption("prefs", prefs);
//        cmOptions.addArguments("--use-fake-device-for-media-stream");
//        cmOptions.addArguments("--use-fake-ui-for-media-stream");
//        cmOptions.addArguments("--use-file-for-fake-video-capture=C:/sample_640x360.mjpeg");
        cmOptions.addArguments("--use-fake-device-for-media-stream",
                "--use-fake-ui-for-media-stream",
                "--use-file-for-fake-video-capture=src/main/resources/mjpeg/sample_640x360.mjpeg");
//        cmOptions.addArguments("disable-infobars");
//        cmOptions.addArguments("ignore-certificate-errors");
//        cmOptions.addArguments("ignore-urlfetcher-cert-requests");
//        cmOptions.addArguments("disable-user-media-security");
//        cmOptions.addArguments("always-authorize-plugins");
//        cmOptions.addArguments("--disable-web-security");
//        cmOptions.addArguments("--start-maximized");
//        cmOptions.addArguments("start-maximized");
        cmOptions.setCapability("CapabilityType.ACCEPT_SSL_CERTS", true);
        cmOptions.setCapability("CapabilityType.ACCEPT_INSECURE_CERTS", true);

        return cmOptions;
    }

    public static FirefoxOptions firefoxOptions() {

        FirefoxOptions fxOptions = new FirefoxOptions();
        fxOptions.setCapability("marionette", true);
        fxOptions.setAcceptInsecureCerts(true);
        fxOptions.addPreference("permission.default.notifications", 1);
        fxOptions.addPreference("permission.default.geolocation", 1);
        fxOptions.addPreference("permission.default.microphone", 1);
        fxOptions.addPreference("permission.default.camera", 1);
        fxOptions.addPreference("media.navigator.streams.fake", true);
//        fxOptions.addArguments("start-maximized");

        return fxOptions;
    }
}
