package testscriptsweb;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import constants.Constants;
import environment.PropertyReader;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reports.ExtentManager;
import utils.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class BaseTestScriptWeb {
    private static final Logger logger = Logger.getLogger(BaseTestScriptWeb.class);
    private Connection connection;
    protected static Properties configProperty;
    private ExtentReports extentReports;
    public ExtentTest extentTest;
    protected WebDriver webDriver;
    private static String browserName;
    private static List<String> listFailedClasses = new ArrayList<>();
    static int executionCounter = Constants.INIT_COUNT;
    static int passTestScripts = 0;
    static int failedTestScripts = 0;
    static int skippedTestScripts = 0;
    static String exeSuiteName;
    private String jenkinsBuildNumber;
    protected AppiumDriver appiumDriver;

    public BaseTestScriptWeb() {
    }

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        logger.info("Executing @BeforeSuite code");
        configProperty = PropertyReader.getConfigData();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        logger.info("Executing @BeforeTest code");
        try {
            logger.info("Inside Before suite");

        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
    }

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional String browser) {
        logger.info("Executing @BeforeClass code");
        // Getting jenkins build logic.
        if (System.getenv("BUILD_NUMBER") == null) {
            String localMsg = "No Jenkins #ID";
            jenkinsBuildNumber = localMsg;
        } else {
            jenkinsBuildNumber = "Build #" + System.getenv("BUILD_NUMBER");
        }
        if (browser == null)
            browser = (String) configProperty.get("browserName");
        logger.info("Browser is:" + browser);
        connection = new Connection();
        connection.startBrowser(browser, this.getClass().getSimpleName(), Boolean.parseBoolean(configProperty.getProperty("isGridExe")));
        webDriver = connection.getWebDriver();
        connection.accessURL(configProperty.getProperty("url"));
        extentReports = ExtentManager.getReporter();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        logger.info("Executing @BeforeMethod code");
        extentTest = extentReports.startTest(this.getClass().getSimpleName() + "_" + method.getName());
        extentTest.log(LogStatus.INFO, "Description : " + method.getAnnotation(Test.class).description());
    }

    @DataProvider(name = "webTestDataProvider")
    public Iterator<Object[]> dataCS(Method method) {
        logger.info("Initialized DataProvider");
        return new CSVReader().getData(this.getClass().getSimpleName(), this.getClass().toString(), method.getName());
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult iTestResult) throws IOException {
        logger.info("Executing @AfterMethod code");
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            failedTestScripts++;
            String path = this.getClass().getName();
            if (!listFailedClasses.contains(path))
                listFailedClasses.add(path);
            extentTest.log(LogStatus.FAIL, "" + iTestResult.getThrowable());
            new TakeScreenshots().captureScreenshot(extentTest, webDriver);
        }
        if (iTestResult.getStatus() == ITestResult.SUCCESS)
            passTestScripts++;
        if (iTestResult.getStatus() == ITestResult.SKIP)
            skippedTestScripts++;

        extentReports.endTest(extentTest);
    }

    @AfterClass
    public void afterClass() {
        logger.info("Executing @AfterClass code");
        try {
            connection.stopBrowser();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        extentReports.flush();
    }

    @AfterTest
    public void afterTest() {
        logger.info("Executing @AfterTest code");
    }

    @AfterSuite
    public synchronized void afterSuite(ITestContext iTestContext) {
        logger.info("Executing @AfterSuite code");
        String suiteName = iTestContext.getCurrentXmlTest().getSuite().getFileName();
        if (suiteName.contains("sanity")) {
            exeSuiteName = "Sanity";
            if (!listFailedClasses.isEmpty()) {
                CreateFailedTestSuite.create(listFailedClasses, "failedSanitySuite.xml");
                if (executionCounter <= 0) {
                    executionCounter++;
                    /*passedTestScript = 0;
                    skipTestScript = 0;
                    listOfFailedTest.clear();
                    extentManager.extentReports = null;*/
                    logger.info("Re-running the failed test suite.");
                    new RunFailedTestSuite().testToRun();
                } else {
                    logger.info("Execution counter issue.");
                    sendEmailAndClassExecutionDetails();
                }
            } else {
                sendEmailAndClassExecutionDetails();
                logger.info("Sent mail of passed test scripts.");
            }
        } else {
            exeSuiteName = "Local";
            sendEmailAndClassExecutionDetails();
        }
    }

    public void sendEmailAndClassExecutionDetails() {
        EmailUtils.sendEmail(passTestScripts, failedTestScripts, skippedTestScripts, exeSuiteName, jenkinsBuildNumber);
    }

    public boolean handleException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
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
        logger.error("context", ex);
        return false;
    }
}