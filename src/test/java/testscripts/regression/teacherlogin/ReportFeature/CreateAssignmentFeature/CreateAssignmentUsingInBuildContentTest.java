package testscripts.regression.teacherlogin.ReportFeature.CreateAssignmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.PageMenuTab;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;
import uipages.reports2feature.CreateAssignmentHomePage;

public class CreateAssignmentUsingInBuildContentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CreateAssignmentUsingInBuildContentTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Home Page' Of Create Assignment")
    public void verifyFunctionalityOfHomePage(String email, String password) {
        String assignmentURL = "https://master.ck12.org/group-assignments/617417";
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(assignmentURL);
            String assertTextVCAB = "Presence of Create Assignment Button on the Assignment UI page";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
            createAnAssignment.clickOnIconCloseHeadsUp();

            String assertTextVCB = "Presence of Close Button";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVHT = "Presence of Home Text On Create Assignment Page";
            Assert.assertTrue(createAssignmentHomePage.verifyHomeText(), assertFailurePreText + assertTextVHT);
            reportLog(assertTextVHT);

            String assertTextVSTL = "Presence of Subject Title Link On Create Assignment Page";
            Assert.assertTrue(createAssignmentHomePage.verifySubjectTitleLink(), assertFailurePreText + assertTextVSTL);
            reportLog(assertTextVSTL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'Subject Title' Link  Of Create Assignment Home PAge")
    public void verifyFunctionalityOfSubjectTitleLink() {
        boolean result = true;
        try {
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            createAssignmentHomePage.getTextOfSubjectTitle();
            createAssignmentHomePage.clickOnSubjectTitle();

            String assertTextVCB = "Presence of Close Button";
            Assert.assertTrue(new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports).verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVTNT = "Presence of Topic NAme Text";
            Assert.assertTrue(createAssignmentHomePage.verifyTopicNameText(), assertFailurePreText + assertTextVTNT);
            reportLog(assertTextVTNT);

            createAssignmentHomePage.getTextOfBranchNameHeading();

            String assertTextVSSO = "Selected Subject Is get Opened After Click";
            Assert.assertTrue(createAssignmentHomePage.verifySelectedSubjectIsOpened(), assertFailurePreText + assertTextVSSO);
            reportLog(assertTextVSSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Branch Title' Link  Of Create Assignment Page")
    public void verifyFunctionalityOfBranchTitleLink() {
        boolean result = true;
        try {
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            createAssignmentHomePage.getTextOfBranchTitle();
            createAssignmentHomePage.clickOnBranchTitle();

            String assertTextVCB = "Presence of Close Button";
            Assert.assertTrue(new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports).verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVCNT = "Presence of Concept Name Text";
            Assert.assertTrue(createAssignmentHomePage.verifyConceptNameText(), assertFailurePreText + assertTextVCNT);
            reportLog(assertTextVCNT);

            createAssignmentHomePage.getTextOfConceptHeading();

            String assertTextVSSO = "Selected Branch Is get Opened After Click";
            Assert.assertTrue(createAssignmentHomePage.verifySelectedBranchIsOpened(), assertFailurePreText + assertTextVSSO);
            reportLog(assertTextVSSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify Functionality of 'Home Tab' Of Create Assignment Page")
    public void verifyFunctionalityOfHomeTab() {
        boolean result = true;
        try {
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            String assertTextVHT = "Presence of Home Text On Create Assignment Page";
            Assert.assertTrue(createAssignmentHomePage.verifyHomeText(), assertFailurePreText + assertTextVHT);
            reportLog(assertTextVHT);

            createAssignmentHomePage.clickOnHomeTab();

            String assertTextVSTL = "Presence of Subject Title Link On Create Assignment Page";
            Assert.assertTrue(createAssignmentHomePage.verifySubjectTitleLink(), assertFailurePreText + assertTextVSTL);
            reportLog(assertTextVSTL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Topic Tab' Of Create Assignment Page")
    public void verifyFunctionalityOfTopicTab() {
        boolean result = true;
        try {
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            String assertTextVTNT = "Presence of Topic NAme Text";
            Assert.assertTrue(createAssignmentHomePage.verifyTopicNameText(), assertFailurePreText + assertTextVTNT);
            reportLog(assertTextVTNT);

            createAssignmentHomePage.clickOnTopicTab();

            String assertTextVSTL = "Presence of Branch NAme Heading Test";
            Assert.assertTrue(createAssignmentHomePage.verifyBranchNameHeadingText(), assertFailurePreText + assertTextVSTL);
            reportLog(assertTextVSTL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality of 'Concept Tab' Of Create Assignment Pge")
    public void verifyFunctionalityOfConceptTab() {
        boolean result = true;
        try {
            CreateAssignmentHomePage createAssignmentHomePage = new CreateAssignmentHomePage(webDriver,extentTest,extentReports);

            String assertTextVCNT = "Presence of Concept Name Text";
            Assert.assertTrue(createAssignmentHomePage.verifyConceptNameText(), assertFailurePreText + assertTextVCNT);
            reportLog(assertTextVCNT);

            createAssignmentHomePage.clickOnConceptTab();

            String assertTextVCHT = "Presence of Concept Heading Text";
            Assert.assertTrue(createAssignmentHomePage.verifyConceptHeadingText(), assertFailurePreText + assertTextVCHT);
            reportLog(assertTextVCHT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}