package testscripts.regression.teacherlogin.LibraryFeature.TeacherLibraryFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * Created by pratik.londhe on 8/24/2018.
 */
public class VerifyCBookOptionTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(VerifyCBookOptionTest.class);

    @Test(dataProvider = "CK12DataProvider", description = "Verify the FlexBook 2.0 option under Create New drop down.")
    public void teacherLogin(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify user profile in teacherLogin method.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(libraryPage.isFlexBookOptionVisible(), "Failed to verify FlexBook2.0 option.");
            extentTest.log(LogStatus.PASS, "Successfully verified the FlexBook 2.0 option under Create New drop down.");
            logger.info("Successfully verified the FlexBook 2.0 option under Create New drop down.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for teacherLogin method." + errorMessage);
    }
}