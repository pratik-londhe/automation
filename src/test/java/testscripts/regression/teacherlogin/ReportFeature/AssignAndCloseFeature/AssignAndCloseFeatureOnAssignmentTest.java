package testscripts.regression.teacherlogin.ReportFeature.AssignAndCloseFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class AssignAndCloseFeatureOnAssignmentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AssignAndCloseFeatureOnAssignmentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of ' Create An Assignment' Button After Clicking on Assignment Link ")
    public void verifyUIPage(String email, String password) {
        String assignmentURL = "https://master.ck12.org/group-assignments/575381";
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(assignmentURL);

            String assertTextVCAB = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
            createAnAssignment.clickOnIconCloseHeadsUp();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVAb = "Presence Of assign button";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyAssignButton(), assertFailurePreText + assertTextVAb);
            reportLog(assertTextVAb);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify  Functionality of 'Close' Button After Clicking On Create An Assignment Button")
    public void verifyFunctionalityOfCloseButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            assignAndCloseFeatureOnAssignment.clickOnCloseButton();

            String assertTextVCAB = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify  Functionality of 'Back' Icon After Clicking On Create An Assignment Button")
    public void verifyFunctionalityOfBackButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String assertTextVPBB = "Presence Of Back button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyBackIcon(), assertFailurePreText + assertTextVPBB);
            reportLog(assertTextVPBB);

            assignAndCloseFeatureOnAssignment.clickOnBackIcon();

            String assertTextVCAB = "Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Search' Button After Clicking on Create An Assignment Button")
    public void verifyFunctionalityOfSearchButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String assertTextVSI = "Presence Of Search Icon.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifySearchIcon(), assertFailurePreText + assertTextVSI);
            reportLog(assertTextVSI);

            assignAndCloseFeatureOnAssignment.clickOnSearchIcon();

            String assertTextVCSI = "Presence Of Close Search Icon.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSI);
            reportLog(assertTextVCSI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Search ' Button Without Entering Keyword")
    public void verifyFunctionalityOfSearchButtonWithoutKeyword() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            assignAndCloseFeatureOnAssignment.clickOnSearchPlaceHolder();

            String assertTextVSB = "Presence Of Search button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifySearchButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            assignAndCloseFeatureOnAssignment.clickOnSearchButton();

            String assertTextVSBA = "Presence Of Search button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifySearchButton(), assertFailurePreText + assertTextVSBA);
            reportLog(assertTextVSBA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Search ' Button After Entering Keyword")
    public void verifyFunctionalityOfSearchButtonAfterKeyword() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String text = "Algebra Expressions with Fraction Bars";

            assignAndCloseFeatureOnAssignment.clickOnSearchPlaceHolder();
            assignAndCloseFeatureOnAssignment.setValueInSearchPlaceHolder(text);
            assignAndCloseFeatureOnAssignment.clickOnSearchButton();

            String assertTextVSBA = "Presence Of Search button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifySearchButton(), assertFailurePreText + assertTextVSBA);
            reportLog(assertTextVSBA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Close Search ' Button After Clicking OnSearch Icon")
    public void verifyFunctionalityOfCloseSearchButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String assertTextVCSI = "Presence Of Close Search Icon.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSI);
            reportLog(assertTextVCSI);

            assignAndCloseFeatureOnAssignment.clickOnCloseSearchIcon();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Assign' Button After Clicking on Create An Assignment Button")
    public void verifyFunctionalityOfAssignButton() {
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            String assertTextVSB = "Presence Of Search Button";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyAssignButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}