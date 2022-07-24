package testscriptsweb.loginfeature;

import com.relevantcodes.extentreports.LogStatus;
import constants.Constants;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testscriptsweb.BaseTestScriptWeb;
import uipages.pagecontrolweb.DashboardPage;
import uipages.pagecontrolweb.LoginPage;

public class LoginNegativeTests extends BaseTestScriptWeb {
    private static final Logger logger = Logger.getLogger(LoginTest.class);

    @Test(timeOut = Constants.TEST_TIME_OUT, description = "Verification of Login page")
    //To login on Application
    public void testLoginNegative() {
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        new LoginPage(webDriver).login(configProperty.getProperty("username"), configProperty.getProperty("password"));

        Assert.assertEquals(dashboardPage.isProfileDropDownVisible(), "User failed to identify the dashborad.");
        extentTest.log(LogStatus.PASS, configProperty.getProperty("isProfileDropDownVisible"));
        logger.info(configProperty.getProperty("isProfileDropDownVisible"));
    }
}
