package testscripts.regression.teacherlogin.ReportFeature.QuizFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;
import uipages.reports2feature.QuizPage;

public class VerifyStudentScoreAndDeleteClassTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CreateAndAssignQuizProdTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    private String score;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of ' Add New Quiz' Icon After Clicking on Create An Assignment Button ")
    public void verifyStudentScoreAndDeleteClass(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab  pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);
            AnswerKey answerKey = new AnswerKey(webDriver,extentTest,extentReports);
            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);
            CreateNewClassAndDeleteClass createNewClassAndDeleteClass = new CreateNewClassAndDeleteClass(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();
            pageMenuTab.clickOnClass();
            pageMenuTab.clickOnReportLink();

            answerKey.switchToChildWindow();
            extentTest.log(LogStatus.PASS, "Switched on the child window.");

            score = quizPage.getStudentScore();
            extentTest.log(LogStatus.PASS, "Student score is: " + score);

            answerKey.switchToParentWindow();
            extentTest.log(LogStatus.PASS, "Switched on the parent window.");

            classPage.clickOnSettingsOption();
            createNewClassAndDeleteClass.scrollIntoAssignment();

            Assert.assertTrue(classPage.verifyDeleteClassButton(), "Failed to verify Delete class button under Settings section.");
            extentTest.log(LogStatus.PASS, "Delete class button is displaying under Settings section.");
            logger.info("Delete class button is displaying under Settings section.");

            classPage.clickOnDeleteClassButton();

            createNewClassAndDeleteClass.clickOnDeleteButton();

            /*Assert.assertTrue(createNewClassAndDeleteClass.verifyClassIsNotPresentInList(), "Failed to verify Class Is Deleted");
            extentTest.log(LogStatus.PASS, "Successfully verify Class Is Deleted");
            logger.info("Teacher successfully verify Class Is Deleted");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of ' Add New Quiz' Icon After Clicking on Create An Assignment Button ")
    public void verifyDeleteQuiz() {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);

            cBookLandingPage.clickOnLinkLibraryProd();
            libraryPage.clickOnEllipsisIcon();
            libraryPage.clickOnArchive();
            libraryPage.clickOnOK();
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}