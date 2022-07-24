//package testscripts.regression.teacherlogin.ReportFeature.CreateAssignmentFeature;
//
//import com.relevantcodes.extentreports.LogStatus;
//import org.apache.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import testscripts.BaseTestScript;
//import uipages.flexbook2feature.*;
//import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
//import uipages.reports2feature.CreateAnAssignment;
//import uipages.reports2feature.QuizPage;
//
//public class QuizSortByFeatureTest extends BaseTestScript {
//    private static final Logger logger = Logger.getLogger(QuizSortByFeatureTest.class);
//    private String testCaseFailureText = "Test failed for method: ";
//    private String assertFailurePreText = "Failed to verify: ";
//    public String assertSuccessPreText = "Successfully verified: ";
//    AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment;
//    public LoginPage loginPage;
//    TeacherDashboardPage teacherDashboardPage;
//    PageMenuTab pageMenuTab;
//    CreateAnAssignment createAnAssignment;
//    private QuizPage quizPage;
//
//    private void reportLog(String assertText) {
//        extentTest.log(LogStatus.PASS, assertSuccessPreText + assertText);
//        logger.info(assertSuccessPreText + assertText);
//    }
//
//    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Sort By' DropDown On the Stored Quiz Page. ")
//    public void verifyFunctionalityOfSortByDropDown(String email, String password) {
//        boolean result = true;
//        try {
//
//            assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
//            loginPage = new LoginPage(webDriver,extentTest,extentReports);
//            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
//            pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
//            createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);
//            quizPage = new QuizPage(webDriver,extentTest,extentReports);
//
//            String Url = "https://master.ck12.org/group-assignments/617417";
//
//            loginPage.clickOnSignInLink();
//            loginPage.login(email, password);
//            loginPage.clickOnBtnSignIn();
//
//            String assertTextVTPOG = "Teacher profile icon after login";
//            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
//            reportLog(assertTextVTPOG);
//
//            webDriver.navigate().to(Url);
//
//            String assertTextVCAB = "Presence Of Create assignment button.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
//            reportLog(assertTextVCAB);
//
//            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
//            createAnAssignment.clickOnIconCloseHeadsUp();
//
//            String assertTextVCB = "Presence Of close button.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
//            reportLog(assertTextVCB);
//
//            String assertTextVAQL = "Presence of Add Quiz Link";
//            Assert.assertTrue(quizPage.verifyAddQuizLink(), assertFailurePreText + assertTextVAQL);
//            reportLog(assertTextVAQL);
//
//            quizPage.clickOnAddQuizLink();
//
//            String assertTextVCNQL = "Presence of Create New Quiz Link";
//            Assert.assertTrue(quizPage.verifyCreateNewQuizLink(), assertFailurePreText + assertTextVCNQL);
//            reportLog(assertTextVCNQL);
//
//            String assertTextVMRT = "Presence Of Most Recently Text.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyMostRecentlyText(), assertFailurePreText + assertTextVMRT);
//            reportLog(assertTextVMRT);
//
//
//            assignAndCloseFeatureOnAssignment.clickOnSortByIcon();
//
//            String assertTextVMRL = "Presence Of Most Recently Link.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyMostRecentlyLink(), assertFailurePreText + assertTextVMRL);
//            reportLog(assertTextVMRL);
//
//
//            String assertTextVDL = "Presence Of Descending Link.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyDescendingLink(), assertFailurePreText + assertTextVDL);
//            reportLog(assertTextVDL);
//
//        } catch (Exception e) {
//            result = handleException(e);
//        }
//        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
//    }
//
//    @Test(priority = 2, description = "Verify Functionality of 'Ascending' Link After Clicking On Sort By DropDown.")
//    public void verifyFunctionalityOfAscendingLink() {
//        boolean result = true;
//        try {
//            String assertTextVAL = "Presence Of Ascending Link.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyAscendingLink(), assertFailurePreText + assertTextVAL);
//            reportLog(assertTextVAL);
//
//            assignAndCloseFeatureOnAssignment.clickOnAscendingLink();
//            assignAndCloseFeatureOnAssignment.waitThread();
//
//            String assertTextVQIAO = "Ascending Order Quiz List";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyQuizIsInAscendingOrder(), assertFailurePreText + assertTextVQIAO);
//            reportLog(assertTextVQIAO);
//
//        } catch (Exception e) {
//            result = handleException(e);
//        }
//        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
//    }
//
//    @Test(priority = 3, description = "Verify Functionality of 'Descending' Link After Clicking On Sort By DropDown.")
//    public void verifyFunctionalityOfDescendingLink() {
//        boolean result = true;
//        try {
//            assignAndCloseFeatureOnAssignment.clickOnSortByIcon();
//
//            String assertTextVDL = "Presence Of Descending Link.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyDescendingLink(), assertFailurePreText + assertTextVDL);
//            reportLog(assertTextVDL);
//
//            assignAndCloseFeatureOnAssignment.clickOnDescendingLink();
//            assignAndCloseFeatureOnAssignment.waitThread();
//
//            String assertTextVQIDO = "Descending Order Quiz List";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyQuizIsInDescendingOrder(), assertFailurePreText + assertTextVQIDO);
//            reportLog(assertTextVQIDO);
//
//        } catch (Exception e) {
//            result = handleException(e);
//        }
//        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
//    }
//
//    @Test(priority = 4, description = "Verify Functionality of 'Most Recently Edited' Link After Clicking On Sort By DropDown.")
//    public void verifyFunctionalityOfMostRecentlyLink() {
//        boolean result = true;
//        try {
//            assignAndCloseFeatureOnAssignment.clickOnSortByIcon();
//
//            String assertTextVMRL = "Presence Of Most Recently Link.";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyMostRecentlyLink(), assertFailurePreText + assertTextVMRL);
//            reportLog(assertTextVMRL);
//
//            assignAndCloseFeatureOnAssignment.clickOnMostRecentlyLink();
//            assignAndCloseFeatureOnAssignment.waitThread();
//
//            String assertTextVQIDO = "Most Recently Edited Quiz List";
//            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyQuizIsInMostRecentlyEditedOrder(), assertFailurePreText + assertTextVQIDO);
//            reportLog(assertTextVQIDO);
//
//        } catch (Exception e) {
//            result = handleException(e);
//        }
//        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
//    }
//}
