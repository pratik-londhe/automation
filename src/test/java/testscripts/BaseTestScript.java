package testscripts;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import environment.PropertyReader;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reports.ExtentManager;
import uipages.flexbook2feature.LoginPage;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.List;


/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class BaseTestScript {
    private final Logger logger = Logger.getLogger(getClass());

    private Connection connection;
    protected static Properties configProperty = null;
    private Map<String, String> environmentData;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    protected String errorMessage;
    protected WebDriver webDriver;
    static int passedTestScript = 0;
    static int countPassedTestScript = 0;
    static int skipTestScript = 0;
    static int failedTestScript = 0;
    static List<String> listOfFailedTest = new ArrayList();
    static private int executionCounter = 0;
    Instant startExeTime;
    Instant endExeTime;
    protected static List<String> listExeTime = new ArrayList();
    static Long sum = Long.valueOf(0);
    static String exeSuiteName;
    protected static String currentMethodName;
    private String jenkinsBuildNumber;
    private String testClassState;
    private String reRunClass;
    ExtentManager extentManager = new ExtentManager();
    public String assertFailurePreText = "Failed to verify: ";


    public BaseTestScript() {
    }

    @BeforeSuite()
    synchronized public void beforeSuite() {
        logger.info("Executing @BeforeSuite code");
        configProperty = PropertyReader.getConfigData();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        logger.info("Executing @BeforeTest code");
        new LogsTextFile().createDirIfNotExist();
    }


    @Parameters({"browser", "URL"})
    @BeforeClass(alwaysRun = true)
    public synchronized void beforeClass(@Optional String browser, @Optional String URL) {
        startExeTime = Instant.now();
        logger.info("Executing @BeforeClass code");
        if (browser == null) {
            browser = String.valueOf(configProperty.get("browserName"));
        }
        logger.info("Browser inside @BeforeClass method is" + browser);
        connection = new Connection();
        // Getting jenkins build logic.
        if (System.getenv("BUILD_NUMBER") == null) {
            String localMsg = "No Jenkins #ID";
            jenkinsBuildNumber = localMsg;
        } else {
            jenkinsBuildNumber = "Build #" + System.getenv("BUILD_NUMBER");
        }
        connection.startBrowser(browser, Boolean.parseBoolean(configProperty.getProperty("isCBT")), Boolean.parseBoolean(configProperty.getProperty("isZalenium")), this.getClass().getSimpleName() + " - " + jenkinsBuildNumber, configProperty.getProperty("buildVersion"));
        webDriver = connection.getWebDriver();
        if (URL == null) {
            URL = String.valueOf(configProperty.get("url"));

        }
        connection.accessURL(URL);
        webDriver.navigate().refresh();
       /* new LoginPage(webDriver, extentTest, extentReports).closeNotificationPopUP();
        new LoginPage(webDriver, extentTest, extentReports).closePiePopUP();*/
    }

    @BeforeMethod(alwaysRun = true)
    public synchronized void beforeMethod(Method method) {

        extentReports = extentManager.getReporter();
        String currentClassName = this.getClass().getSimpleName();
        currentMethodName = method.getName();
        String currentMethodDescription = method.getAnnotation(Test.class).description();
        logger.info("Executing @BeforeMethod code");
        logger.info("\n" + "\n" + "<---------------------------------------[Test Begins]--------------------------------------->" + "\n" + "Executing class: " + currentClassName + "\n" + "Executing method: " + currentMethodName + "\n" + "Executing Test Case: " + currentMethodDescription + "\n");
        extentTest = extentReports.startTest(currentMethodName);
        extentTest.log(LogStatus.INFO, "Description : " + currentMethodDescription);
    }

    @DataProvider(name = "CK12DataProvider")
    public Iterator<Object[]> dataCK12() {
        logger.info("Initialized DataProvider");
        return new CSVReader().getData(this.getClass().getSimpleName(), this.getClass().toString());
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        logger.info("Executing @AfterMethod code");
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            testClassState = "FAILED";
            reRunClass = "Yes";
            failedTestScript++; // Failed test scripts count.
           /* new GuiControl().openBrowserConsole();
            //Opening and closing browser console at run time for failed test scripts.
            new GuiControl().openBrowserConsole(); //Opening and closing browser console at run time for failed test scripts.
            */
            if ("Zalenium".equals(connection.executionEnv)) {
                if ("Chrome".equals(connection.currentBrowser)) {
                    new LogsTextFile().createNewFile(currentMethodName + ".log");
                    connection.extractJSLogs();
                    Cookie cookie = new Cookie("ZaleniumTestPassed", "false"); //Setting FAIL status on zalenium dashboard by passing value through cookies.
                    webDriver.manage().addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("ZaleniumTestPassed", "false"); //Setting FAIL status on zalenium dashboard by passing value through cookies.
                    webDriver.manage().addCookie(cookie);
                }
            } else {
                try {
                    connection.setScore(((RemoteWebDriver) webDriver).getSessionId().toString(), "fail"); //Setting FAIL status on CBT by passing session ID and score value.
                } catch (UnirestException urEx) {
                    logger.error(urEx);
                }
            }
            String path = this.getClass().getName();
            if (!listOfFailedTest.contains(path))
                listOfFailedTest.add(path); //Setting failed test script path for failed test scripts
            extentTest.log(LogStatus.FAIL, "" + iTestResult.getThrowable());
            new TakePhoto().captureScreenshot(extentTest, webDriver);
        }
        if (iTestResult.getStatus() == ITestResult.SUCCESS) {

            if ("Zalenium".equals(connection.executionEnv)) {
                if (listOfFailedTest.contains(iTestResult.getTestClass().getName())) {
                    passedTestScript++;
                } else {
                    testClassState = "PASSED";
                    reRunClass = "No";
                    Cookie cookie = new Cookie("ZaleniumTestPassed", "true"); //Setting PASS status on zalenium dashboard by passing value through cookies.
                    webDriver.manage().addCookie(cookie);
                    passedTestScript++;
                }

            } else {
                if (listOfFailedTest.contains(iTestResult.getTestClass().getName())) {
                    passedTestScript++;
                } else {
                    testClassState = "PASSED";
                    reRunClass = "No";
                    try {
                        connection.setScore(((RemoteWebDriver) webDriver).getSessionId().toString(), "pass"); //Setting FAIL status on CBT by passing session ID and score value.
                    } catch (UnirestException urEx) {
                        logger.error(urEx);
                    }
                    passedTestScript++;
                }
            }
        }
        if (iTestResult.getStatus() == ITestResult.SKIP) skipTestScript++;
        extentReports.endTest(extentTest);
        logger.info("\n" + "<---------------------------------------[Test Ends]--------------------------------------->" + "\n");
    }

    @AfterClass
    public synchronized void afterClass() {
        logger.info("Executing @AfterClass code");
        try {
            connection.stopBrowser();
        } catch (Exception ex) {
            logger.error(ex);
        }
        extentReports.flush();
        endExeTime = Instant.now();
        Long totalExeTime = Duration.between(startExeTime, endExeTime).toMillis() / 1000; // Getting execution time of each test class.
        sum = sum + totalExeTime;
        String strExeTime = String.format("%-13s %1s %-40s %1s %5s %5s %2s %11s %2s", this.connection.currentBrowser, "|", this.getClass().getSimpleName(), "|", testClassState, "|", reRunClass, "|", totalExeTime);
        listExeTime.add(strExeTime);
    }

    @AfterTest
    public void afterTest() {
        logger.info("Executing @AfterTest code");
    }

    @AfterSuite
    public synchronized void afterSuite(ITestContext iTestContext) {
        logger.info("Executing @AfterSuite code");
        String suiteName = iTestContext.getCurrentXmlTest().getSuite().getFileName();
        if (suiteName.contains("Production")) {
            exeSuiteName = "Production";
            sendEmailAndClassExecutionDetails();
            /*if (!listOfFailedTest.isEmpty()) {
                CreateFailedTestSuite.create(listOfFailedTest, "failedSanitySuite.xml", suiteName);
                if (executionCounter <= 0) {
                    executionCounter++;
                  *//*  passedTestScript = 0;
                    skipTestScript = 0;
                    listOfFailedTest.clear();
                    extentManager.extentReports = null;
                    logger.info("Re-running the failed test suite.");
                    new RunFailedTestSuite().testToRun();*//*
                } else {
                    logger.info("Execution counter issue.");
                    sendEmailAndClassExecutionDetails();
                }
            } else {
                sendEmailAndClassExecutionDetails();
                logger.info("Sent mail of passed test scripts.");
            }*/
        } /*else if (suiteName.contains("Production")) {
            exeSuiteName = "Production";
            sendEmailAndClassExecutionDetails();
        } else {
            exeSuiteName = "Local";
            sendEmailAndClassExecutionDetails();
        }*/
    }

    @Step("{0}")
    public void reportLog(String message) {
        String assertSuccessPreText = "Successfully verified: ";
        extentTest.log(LogStatus.PASS, assertSuccessPreText + message);
        logger.info(assertSuccessPreText + message);
    }

    public void sendEmailAndClassExecutionDetails() {
        EmailUtils.sendEmail(passedTestScript, failedTestScript, skipTestScript, connection.executionEnv, exeSuiteName, jenkinsBuildNumber);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Execution Time Details~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(String.format(String.format("%-13s %1s %-40s %1s %-10s %-1s %-10s %1s %-10s", "BROWSER NAME", "|", "CLASS NAME", "|", "STATUS", "|", "Re-Run Class", "|", "TIME(SEC)")));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (String listElement : listExeTime) {
            System.out.println(listElement);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("TOTAL EXECUTION TIME:" + sum);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void scrollByPixel(int pixelValue) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,"+ pixelValue +")");
    }

    public boolean handleException(Exception ex) {
        errorMessage = ex.getMessage();
        if (ex instanceof NoSuchElementException) {
            logger.info("No such element: " + errorMessage);
        } else if (ex instanceof ElementNotVisibleException) {
            logger.info("Element not visible: " + errorMessage);
        } else if (ex instanceof NoSuchFrameException) {
            logger.info("No such Frame: " + errorMessage);
        } else if (ex instanceof NoAlertPresentException) {
            logger.info("No Alert Present: " + errorMessage);
        } else if (ex instanceof NoSuchWindowException) {
            logger.info("No such Window");
        } else if (ex instanceof StaleElementReferenceException) {
            logger.info("Stale Element: " + errorMessage);
        } else if (ex instanceof WebDriverException) {
            logger.info("Web Driver Exception");
        }
        extentTest.log(LogStatus.FAIL, errorMessage);
        logger.error("contex", ex);
        return false;
    }
}