package testscripts.regression.geometryInteractive;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.geometryinteractive.ThreeDimensionsPage;

public class ExampleInteractiveTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ExampleInteractiveTest.class);
    private LoginPage loginPage;
    private ThreeDimensionsPage threeDimensionsPage;

    @Test(priority = 1, description = "Verify the behaviour of the POINT interactive.")
    public void exampleTwoInteractiveTest() {
        loginPage = new LoginPage(webDriver,extentTest, extentReports);
        threeDimensionsPage = new ThreeDimensionsPage(webDriver,extentTest,extentReports);
        boolean result = true;
        try {
            webDriver.navigate().to("https://flexbooks-preprod.ck12.org/user:chjlcg9kdgvhy2hlcitwcmvwb2r0zxn0dxnlckbjazeylm9yzw../cbook/my-interactive-flexbook/section/1.1/primary/lesson/the-three-dimensions-interactive-5326291");

            loginPage.login(configProperty.getProperty("prodUser"), configProperty.getProperty("prodPass"));
            loginPage.clickOnBtnSignIn();
            extentTest.log(LogStatus.PASS, "Prod user logged in successfully.");
            logger.info("Prod user logged in successfully.");

            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverPointInteractive(), "Failed to verify example Two POINT interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two PONT interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that example Two POINT interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnPointOfExampleInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on POINT interactive.");
            logger.info("User successfully done mouse hover on POINT interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverPointInteractive(), "Failed to verify POINT interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two POINT interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that example Two POINT interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnThreeDimInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Three Dimension interactive.");
            logger.info("User successfully done mouse out on Three dimension interactive.");

            threeDimensionsPage.extractJSLogs();
            extentTest.log(LogStatus.PASS, "User Successfully extracted the JS console logs.");
            logger.info("User Successfully extracted the JS console logs.");

            Assert.assertTrue(threeDimensionsPage.verifyTheLogs(), "Failed to verify the logs.");
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");

            threeDimensionsPage.clearLogs();
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed test script.");
    }

    @Test(priority = 2, description = "Verify the behaviour of the Line Segment interactive.")
    public void exampleThreeInteractiveTest() {
        loginPage = new LoginPage(webDriver,extentTest, extentReports);
        threeDimensionsPage = new ThreeDimensionsPage(webDriver,extentTest,extentReports);
        boolean result = true;
        try {
            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverLineSegInteractive(), "Failed to verify example Two POINT interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two Line Segment interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that example Two Line Segment interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnLineSegmentOfExampleInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Line Segment interactive.");
            logger.info("User successfully done mouse hover on Line Segment interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverLineSegInteractive(), "Failed to verify Line Segment interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two Line Segment interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that example Two Line Segment interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnThreeDimInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Three Dimension interactive.");
            logger.info("User successfully done mouse out on Three dimension interactive.");

            threeDimensionsPage.extractJSLogs();
            extentTest.log(LogStatus.PASS, "User Successfully extracted the JS console logs.");
            logger.info("User Successfully extracted the JS console logs.");

            Assert.assertTrue(threeDimensionsPage.verifyTheLogs(), "Failed to verify the logs.");
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");

            threeDimensionsPage.clearLogs();
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed test script.");
    }

    @Test(priority = 3, description = "Verify the behaviour of the Planes interactive.")
    public void exampleFourInteractiveTest() {
        loginPage = new LoginPage(webDriver,extentTest, extentReports);
        threeDimensionsPage = new ThreeDimensionsPage(webDriver,extentTest,extentReports);
        boolean result = true;
        try {
            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverLineSegInteractive(), "Failed to verify example Two Planes interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two Planes interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that example Two Planes interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnPlanesInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Planes interactive.");
            logger.info("User successfully done mouse hover on Planes interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverLineSegInteractive(), "Failed to verify Planes interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that example Two Planes interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that example Two Planes interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnThreeDimInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Three Dimension interactive.");
            logger.info("User successfully done mouse out on Three dimension interactive.");

            threeDimensionsPage.extractJSLogs();
            extentTest.log(LogStatus.PASS, "User Successfully extracted the JS console logs.");
            logger.info("User Successfully extracted the JS console logs.");

            Assert.assertTrue(threeDimensionsPage.verifyTheLogs(), "Failed to verify the logs.");
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");

            threeDimensionsPage.clearLogs();
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed test script.");
    }
}