package testscripts.regression.geometryInteractive;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.geometryinteractive.ThreeDimensionsPage;

public class ThreeDimensionTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ZeroDimensionTest.class);
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

            Assert.assertTrue(threeDimensionsPage.beforeMouseHoverSolidInteractive(), "Failed to verify solid interactive is not highlighted before mouse hover.");
            extentTest.log(LogStatus.PASS, "User successfully verify that solid interactive is not highlighted before mouse hover.");
            logger.info("User successfully verify that solid interactive is not highlighted before mouse hover.");

            threeDimensionsPage.mouseHoverOnSolidInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse hover on solid interactive.");
            logger.info("User successfully done mouse hover on solid interactive.");

            Assert.assertTrue(threeDimensionsPage.afterMouseHoverSolidInteractive(), "Failed to verify solid interactive is highlighted");
            extentTest.log(LogStatus.PASS, "User successfully verify that solid interactive is highlighted after mouse hover.");
            logger.info("User successfully verify that solid interactive is highlighted after mouse hover.");

            threeDimensionsPage.mouseOutOnSolidInteractive();
            extentTest.log(LogStatus.PASS, "User successfully done mouse out on solid interactive.");
            logger.info("User successfully done mouse out on solid interactive.");

            threeDimensionsPage.extractJSLogs();
            extentTest.log(LogStatus.PASS, "User Successfully extracted the JS console logs.");
            logger.info("User Successfully extracted the JS console logs.");

            Assert.assertTrue(threeDimensionsPage.verifyTheLogs(),"Failed to verify the logs.");
            extentTest.log(LogStatus.PASS, "Event is successfully fired for an event.");
            logger.info("Event is successfully fired for an event.");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed test script.");
    }
}