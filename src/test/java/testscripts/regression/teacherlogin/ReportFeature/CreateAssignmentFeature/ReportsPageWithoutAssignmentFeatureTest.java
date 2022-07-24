package testscripts.regression.teacherlogin.ReportFeature.CreateAssignmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CBookLandingPage;
import uipages.flexbook2feature.LoginPage;
import uipages.reports2feature.ReportsPageWithoutAssignmentTest;

public class ReportsPageWithoutAssignmentFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ReportsPageWithoutAssignmentFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify UI Page Of Reports Page When Assignment is not Assigned in class.")
    public void verifyUIPageOfReportsPage(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver, extentTest, extentReports);
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            cBookLandingPage.clickOnFlexBookLink();
            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, password);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Teacher icon' after logging in.";
            Assert.assertTrue(cBookLandingPage.verifyTeacherAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assignmentURL = "https://master.ck12.org/class/575381/reports/";

            webDriver.navigate().to(assignmentURL);

            String assertTextVCAB = "Presence of 'Create Assignment' button.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'How To Read Reports Link'.")
    public void verifyFunctionalityOfHowToReadReportsLinks() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVSAI = "Presence of 'How To Read Reports' link.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyHowToReadReportsLink(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            reportsPageWithoutAssignmentTest.clickOnHowToReadReportsLink();

            String assertTextVCAC = "Presence of 'How To Read Reports' Text.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyHowToReadReportsText(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Part Of Ck12 Reports' Tutorial.")
    public void verifyPartOfCk12ReportsTutorial() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVCAB = "Presence of 'PArt Of Ck12 Reports' Text.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyPartOfCk12ReportsText(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            String assertTextVSAI = "Presence of 'PArt Of Ck12 Tutorial' Table.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyPartOfCk12TutorialTable(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify 'How Modality Scored' Tutorial.")
    public void verifyHowModalityScoredTutorial() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVCAB = "Presence of 'How Modality Scored' Text.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyHowModalityScoredText(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            String assertTextVSAI = "Presence of 'Modality Type' row.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyModalityTypeRow(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

            String assertTextVCAC = "Presence of 'Goal And Action' row.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyGoalAndActionRow(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVCC = "Presence of 'Status' row.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyStatusRow(), assertFailurePreText + assertTextVCC);
            reportLog(assertTextVCC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify 'Heat Map' Tutorial.")
    public void verifyHeatMapTutorial() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVCAB = "Presence of 'Different Colour Meaning' Text.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyDifferentColourMeaningText(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            String assertTextVSAI = "Presence of 'Heat Map' text.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyHeatMapText(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Close Reports Tutorial' Icon.")
    public void verifyFunctionalityOfCloseReportsTutorialIcon() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVCAC = "Presence of 'Close Reports Tutorial' Icon.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyCloseReportsTutorialIcon(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            reportsPageWithoutAssignmentTest.clickOnCloseReportsTutorialIcon();

//            String assertTextVSAI = "Presence of New Reports Text.";
//            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyNewReportsText(), assertFailurePreText + assertTextVSAI);
//            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Header Component' Icon.")
    public void verifyFunctionalityOfHeaderComponentIcon() {
        boolean result = true;
        try {
            ReportsPageWithoutAssignmentTest reportsPageWithoutAssignmentTest = new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports);

            String assertTextVCAC = "Presence of 'Header Component' Icon.";
            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyHeaderComponentIcon(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            reportsPageWithoutAssignmentTest.clickOnHeaderComponentIcon();

//            String assertTextVSAI = "Presence of New Reports Text.";
//            Assert.assertTrue(reportsPageWithoutAssignmentTest.verifyNewReportsText(), assertFailurePreText + assertTextVSAI);
//            reportLog(assertTextVSAI);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}