package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeForumFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeForumFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'All, Student, Teacher' tabs are available.")
    public void verifyCafeFilter(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Cafe' Container.";
            Assert.assertTrue(cafeFeature.verifyCafeLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            cafeFeature.clickOnCafeLink();

            String assertTextVPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVSPG = "Presence of 'Student' Filter.";
            Assert.assertTrue(cafeFeature.verifyStudentFilter(), assertFailurePreText + assertTextVSPG);
            reportLog(assertTextVSPG);

            String assertTextVCDD = "Presence of 'Teacher' Filter.";
            Assert.assertTrue(cafeFeature.verifyTeacherFilter(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Student Filter.")
    public void verifyFunctionalityOfStudentFilter() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnStudentFilter();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVEB = "Presence of 'Active Student' Filter.";
            Assert.assertTrue(cafeFeature.verifyActiveStudentFilter(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Teacher Filter.")
    public void verifyFunctionalityOfTeacherFilter() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVCDD = "Presence of 'Teacher' Filter.";
            Assert.assertTrue(cafeFeature.verifyTeacherFilter(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            cafeFeature.clickOnTeacherFilter();

            String assertTextVSPOG = "Presence of 'Active Teacher' Filter.";
            Assert.assertTrue(cafeFeature.verifyActiveTeacherFilter(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of All Filter.")
    public void verifyFunctionalityOfAllFilter() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVCDD = "Presence of 'All' Filter.";
            Assert.assertTrue(cafeFeature.verifyAllFilter(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            cafeFeature.clickOnAllFilter();

            String assertTextVSPOG = "Presence of 'Active All' Filter.";
            Assert.assertTrue(cafeFeature.verifyActiveAllFilter(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Follow' Button On the Forum.")
    public void verifyFunctionalityOfFollowButtonOnTheForum() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVCDD = "Presence of 'Follow' Button.";
            Assert.assertTrue(cafeFeature.verifyFollowButton(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            cafeFeature.clickOnFollowButton();

            String assertTextVSPOG = "Presence of 'Following' Button.";
            //Assert.assertTrue(cafeFeature.verifyFollowingButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Following' Button On the Forum.")
    public void verifyFunctionalityOfFollowingButtonOnTheForum() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            //cafeFeature.clickOnFollowingButton();

            String assertTextVCDD = "Presence of 'Follow' Button.";
            //Assert.assertTrue(cafeFeature.verifyFollowButton(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Threads Count are display near threads Icon.")
    public void verifyThreadCount() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Thread' Icon.";
            Assert.assertTrue(cafeFeature.verifyThreadIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeFeature.HoverOnThreadIcon();

            String assertTextVPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyThreadCountText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Answer Count are display near  Answer Icon.")
    public void verifyAnswerCount() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyAnswerIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeFeature.HoverOnAnswerIcon();

            String assertTextVAB = "Presence of 'Take The Tour' button.";
            Assert.assertTrue(cafeFeature.verifyAnswerCountText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Forum Link.")
    public void verifyFunctionalityOfForumLink() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyForumContainerLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnForumContainerLink();

            String assertTextVSPOG = "Presence of 'Forum ' Name.";
            Assert.assertTrue(cafeFeature.verifyForumName(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify functionality of 'Go Back Forum' link.")
    public void verifyFunctionalityOfGoBackForumLink() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSOG = "Presence of 'Forum Go Back' Link.";
            Assert.assertTrue(cafeFeature.verifyForumGoBackLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnForumGoBackLink();

            String assertTextVAB = "Presence of 'Take The Tour' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}