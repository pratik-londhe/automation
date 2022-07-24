package testscripts.regression.teacherlogin.ReportFeature.QuizFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class AttemptAnAssignmentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AttemptAnAssignmentTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment;
    public LoginPage loginPage;
    TeacherDashboardPage teacherDashboardPage;
    PageMenuTab pageMenuTab;
    CreateAnAssignment createAnAssignment;
    private static String username;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of ' Add New Quiz' Icon After Clicking on Create An Assignment Button ")
    public synchronized void attemptAnAssignment(String email, String password, String stuPassword) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            EditStudentAccount editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();
            pageMenuTab.clickOnClass();
            pageMenuTab.clickOnMemberTab();
            editStudentAccount.clickOnFirstEllipsisIcon();
            editStudentAccount.clickOnEditAccountLink();
            username = editStudentAccount.getStudUsername();
            signOutPage.clickOnUserProfileIcon();
            signOutPage.clickOnSignOut();
            loginPage.studentLogin(username, stuPassword);

            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for StudentSignOutTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");
            try {
                pageMenuTab.clickOnClassName();
                pageMenuTab.clickOnAssignmentTab();
                pageMenuTab.clickOnAssignmentContainer();
                pageMenuTab.clickOnStartAssignment();
                pageMenuTab.clickOnStartPractice();
                pageMenuTab.attemptAssignmentAndSubmitScore();
            } catch (Exception e) {
                logger.info(e);
                pageMenuTab.clickOnStartAssignment();
                pageMenuTab.clickOnStartPractice();
                pageMenuTab.attemptAssignmentAndSubmitScore();
            }
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}