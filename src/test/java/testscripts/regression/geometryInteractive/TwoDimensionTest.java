package testscripts.regression.geometryInteractive;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.geometryinteractive.ThreeDimensionsPage;

public class TwoDimensionTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TwoDimensionTest.class);
    private LoginPage loginPage;
    private ThreeDimensionsPage threeDimensionsPage;

    @Test(priority = 1, description = "Verify the behaviour of the Shape interactive.")
    public void verifyShapeInteractiveTest() {
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

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverShapeInteractive(), "Failed to verify POINT interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that Shape interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that Shape interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnShapeInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Shape interactive.");
            logger.info("User successfully done mouse hover on Shape interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverShareInteractive(), "Failed to verify Shape interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that Shape interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that Shape interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnShapeInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Shape interactive.");
            logger.info("User successfully done mouse out on Shape interactive.");

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

    @Test(priority = 2, description = "Verify the behaviour of the Length and Width interactive.")
    public void verifyLengthWidthInteractiveTest() {
        boolean result = true;
        try {
            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverLengthWidthInteractive(), "Failed to verify Length and Width interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that Length and Width interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that Length and Width interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnLengthWidthInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Length and Width interactive.");
            logger.info("User successfully done mouse hover on Length and Width interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverLengthWidthInteractive(), "Failed to verify Length and Width interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that Length and Width interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that Length and Width interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnShapeInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Length and Width interactive.");
            logger.info("User successfully done mouse out on Length and Width interactive.");

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

    @Test(priority = 3, description = "Verify the behaviour of the Rectangular Co-ordinate interactive.")
    public void verifyRectangularCoordinateInteractiveTest() {
        boolean result = true;
        try {
            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverRectCoordinateInteractive(), "Failed to verify Length and Width interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnRectCoordinateInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Rect Coordinate interactive.");
            logger.info("User successfully done mouse hover on Rect Coordinate interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverRectCoordinateInteractive(), "Failed to verify Rect Coordinate interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that Rect Coordinate interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that Rect Coordinate interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnShapeInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on Rect Coordinate interactive.");
            logger.info("User successfully done mouse out on Rect Coordinate interactive.");

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

    @Test(priority = 4, description = "Verify the behaviour of the XY Co-ordinate interactive.")
    public void verifyXYCoordinateInteractiveTest() {
        boolean result = true;
        try {
            threeDimensionsPage.clearConsole();
            extentTest.log(LogStatus.PASS, "User successfully cleared the console.");
            logger.info("User successfully cleared the console.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverXYCoordinateInteractive(), "Failed to verify Length and Width interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnXCoordinateInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on X Coordinate interactive.");
            logger.info("User successfully done mouse hover on X Coordinate interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverXYCoordinateInteractive(), "Failed to verify Rect Coordinate interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that XY Coordinate interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that XY Coordinate interactive is highlighted after mouse hover.");

 
            threeDimensionsPage.mouseOutOnCoordinateInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on XY Coordinate interactive.");
            logger.info("User successfully done mouse out on XY Coordinate interactive.");

            threeDimensionsPage.extractJSLogs();
            extentTest.log(LogStatus.PASS, "User Successfully extracted the JS console logs.");
            logger.info("User Successfully extracted the JS console logs.");

            Assert.assertTrue(threeDimensionsPage.verifyTheLogs(), "Failed to verify the logs.");
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");

            threeDimensionsPage.clearLogs();
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverXYCoordinateInteractive(), "Failed to verify Length and Width interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that Rect Coordinate interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnYCoordinateInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on Y Coordinate interactive.");
            logger.info("User successfully done mouse hover on Y Coordinate interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverXYCoordinateInteractive(), "Failed to verify Rect Coordinate interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that XY Coordinate interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that XY Coordinate interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnCoordinateInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on XY Coordinate interactive.");
            logger.info("User successfully done mouse out on XY Coordinate interactive.");

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