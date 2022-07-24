package testscripts.regression.studentlogin.GroupsFeature.NonLoginUserFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;

public class UserCBookLandingPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(UserCBookLandingPageTest.class);

    @Test(priority = 1, description = "Verify the functionality of 'Get Started' button on CourseBook landing page")
    public void verifyFunctionalityOfGetStartedButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
          
            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnGetStarted();

            Assert.assertTrue(cBookLandingPage.verifyLinksAfterGetStarted(), "Failed to verify FlexBooks After Get Started");
            reportLog("User Successfully Verify FlexBooks After Get Started");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the functionality of 'Browse Physics' button on CourseBook landing page")
    public void verifyFunctionalityOfBrowsePhysicsButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(cBookLandingPage.verifyBrowsePhysicsTab(), "Failed to verify Browse Physics Button");
            reportLog("User Successfully Verify Browse Physics Button");

            cBookLandingPage.clickOnBrowsePhysicsTab();

            Assert.assertTrue(cBookLandingPage.verifySubjectTab(), "Failed to verify Subject Dropdown");
            reportLog("User Successfully Verify Subject Dropdown");

            Assert.assertTrue(cBookLandingPage.verifyGradeTab(), "Failed to verify Grade DropDown");
            reportLog("User Successfully Verify Grade DropDown");

            Assert.assertTrue(cBookLandingPage.verifySearchFlexBookButton(), "Failed to verify Search FlexBook Button");
            reportLog("User Successfully Verify Subject Tab Search FlexBook Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 6, description = "Verify the functionality of 'Search FlexBook' Button After Clicking On Browse Physics Button.")
    public void verifyFunctionalityOfSearchFlexBookButton() {
        boolean result = true;
        try {
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnSearchFlexBookButton();
            cBookLandingPage.getCountFlexBooks();

            Assert.assertTrue(cBookLandingPage.verifySubjectDropDown(), "Failed to verify Subject Dropdown");
            reportLog("User Successfully Verify Subject Dropdown");

            Assert.assertTrue(cBookLandingPage.verifyGradeDropDown(), "Failed to verify Grade Dropdown");
            reportLog("User Successfully Verify Grade Dropdown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}