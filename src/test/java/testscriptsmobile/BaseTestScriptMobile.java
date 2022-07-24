package testscriptsmobile;

import constants.Constants;
import environment.PropertyReader;
import reports.ExtentManager;
import utils.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.NoSuchElementException;

public class BaseTestScriptMobile {

    final static Logger logger = Logger.getLogger(BaseTestScriptMobile.class);
    private Connection connection;
    protected static Properties configProperty = null;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    protected String errorMessage;
    protected AppiumDriver appiumDriver;
    static int passedTestScript = 0;
    static int countPassedTestScript = 0;
    static int skipTestScript = 0;
    static int failedTestScript = 0;
    Instant startExeTime;
    Instant endExeTime;
    protected static List<String> listExeTime = new ArrayList();
    static Long sum = Long.valueOf(0);
    static String exeSuiteName;
    static int passTestScripts = 0;
    static int failedTestScripts = 0;
    static int skippedTestScripts = 0;
    protected static String currentMethodName;
    private String jenkinsBuildNumber;
    private static List<String> listFailedClasses = new ArrayList<>();
    static int executionCounter = Constants.INIT_COUNT;

    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    @BeforeSuite()
    public static void beforeSuite() throws IOException {
        logger.info("Executing @BeforeSuite code");
        configProperty = PropertyReader.getConfigData();
        new StartAppiumProgramatically().startServer();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        logger.info("Executing @BeforeTest code");
        //new LogsTextFile().createDirIfNotExist();
    }

    @Parameters({ "platformVersion", "platformName", "deviceName", "portNumber", "browser" })
    @BeforeClass(alwaysRun = true)
    public synchronized void beforeClass(String platformVersion,String platformName,String deviceName, String portNumber, String browser) throws MalformedURLException {
        startExeTime = Instant.now();
        connection = new Connection();
        connection.setAppiumDriver(platformVersion,platformName,deviceName,portNumber,browser);
        appiumDriver = connection.getAppiumDriver();
        connection.accessMobileURL("https://www.staging.ipsy.com/?stagepass=glamination");
        extentReports = ExtentManager.getReporter();
    }


    @DataProvider(name = "mobileTestDataProvider")
    public Iterator<Object[]> dataCK12(Method method) {
        logger.info("Initialized DataProvider");
        return new CSVReader().getData(this.getClass().getSimpleName(), this.getClass().toString(), method.getName());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        logger.info("Executing @BeforeMethod code");
        extentTest = extentReports.startTest(this.getClass().getSimpleName() + "_" + method.getName());
        extentTest.log(LogStatus.INFO, "Description : " + method.getAnnotation(Test.class).description());
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        logger.info("Executing @AfterMethod code");
        logger.info("Executing @AfterMethod code");
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            failedTestScripts++;
            String path = this.getClass().getName();
            if (!listFailedClasses.contains(path))
                listFailedClasses.add(path);
            extentTest.log(LogStatus.FAIL, "" + iTestResult.getThrowable());
            new TakeScreenshots().captureScreenshot(extentTest, appiumDriver);
        }
        if (iTestResult.getStatus() == ITestResult.SUCCESS)
            passTestScripts++;
        if (iTestResult.getStatus() == ITestResult.SKIP)
            skippedTestScripts++;

        extentReports.endTest(extentTest);
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
                    //new RunFailedTestSuite().testToRun();
                } else {
                    logger.info("Execution counter issue.");
                    //sendEmailAndClassExecutionDetails();
                }
            } else {
                //sendEmailAndClassExecutionDetails();
                logger.info("Sent mail of passed test scripts.");
            }
        } else {
            exeSuiteName = "Local";
            //sendEmailAndClassExecutionDetails();
        }
        appiumDriver.quit();
        new StartAppiumProgramatically().stopServer();
    }

    public void sendEmailAndClassExecutionDetails() {
        EmailUtils.sendEmail(passedTestScript, failedTestScript, skipTestScript, exeSuiteName, jenkinsBuildNumber);
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