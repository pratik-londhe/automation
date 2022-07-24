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


public class EditQuizTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(EditQuizTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 13, dataProvider = "CK12DataProvider", description = "Verify  Functionality of 'Preview' Button After Creating Quiz")
    public void verifyFunctionalityOfPreviewButton(String email, String password) {
        String assignemetURL = "https://master.ck12.org/group-assignments/632826";
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(assignemetURL);
            String assertTextVCAB = "Presence of Create Assignment Button on the Assignment UI page";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
            createAnAssignment.clickOnIconCloseHeadsUp();

            String assertTextVCB = "Presence of Close Button";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVAQL = "Presence of Add Quiz Link";
            Assert.assertTrue(quizPage.verifyAddQuizLink(), assertFailurePreText + assertTextVAQL);
            reportLog(assertTextVAQL);

            quizPage.clickOnAddQuizLink();

            new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports).clickOnPoUP();

            String assertTextVCNQL = "Presence of Create New Quiz Link";
            Assert.assertTrue(quizPage.verifyCreateNewQuizLink(), assertFailurePreText + assertTextVCNQL);
            reportLog(assertTextVCNQL);

            quizPage.clickOnCreateNewQuizLink();

            String assertTextVBB = "Presence of Back Button";
            Assert.assertTrue(quizPage.verifyBackButton(), assertFailurePreText + assertTextVBB);
            reportLog(assertTextVBB);

            String assertTextVQPU = "Presence of Quiz Page UI Elements";
            Assert.assertTrue(quizPage.verifyQuizPageUI(), assertFailurePreText + assertTextVQPU);
            reportLog(assertTextVQPU);

            quizPage.enteredIntoTheQuizPageFrame();

            String title = "Quiz";

            quizPage.setValueInTitlePlaceHolder(title);

            String assertTextVAQI = "Presence of Add Question Set Icon";
            Assert.assertTrue(quizPage.verifyAddQuestionIcon(), assertFailurePreText + assertTextVAQI);
            reportLog(assertTextVAQI);

            quizPage.clickOnAddQuestionIcon();

            String assertTextVCCT = "Presence of Choose Concept Text";
            Assert.assertTrue(quizPage.verifyChooseConceptText(), assertFailurePreText + assertTextVCCT);
            reportLog(assertTextVCCT);

            String conceptText = "Algebra";

            quizPage.setValueInSearchConceptPlaceHolder(conceptText);
            quizPage.clickOnSearchIcon();

            String assertTextVCSI = "Presence of Close Search Icon";
            Assert.assertTrue(quizPage.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSI);
            reportLog(assertTextVCSI);

            String assertTextVCCTA = "Presence of Choose Concept Text";
            Assert.assertTrue(quizPage.verifyChooseConceptText(), assertFailurePreText + assertTextVCCTA);
            reportLog(assertTextVCCTA);

            quizPage.setValueInSearchConceptPlaceHolder(conceptText);
            quizPage.clickOnSearchIcon();

            String assertTextVCSIA = "Presence of Close Search Icon";
            Assert.assertTrue(quizPage.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSIA);
            reportLog(assertTextVCSIA);

            quizPage.clickOnSearchResultCheckBox();

            String assertTextVSB = "Presence of Select Button";
            Assert.assertTrue(quizPage.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            quizPage.clickOnSelectButton();
            quizPage.clickOnGotItButton();

            String assertTextVQSIA = "Question Set is Added In the Assignment";
            Assert.assertTrue(quizPage.verifyQuestionSetIsAdded(), assertFailurePreText + assertTextVQSIA);
            reportLog(assertTextVQSIA);

            String assertTextVCBA = "Presence of Create Button";
            Assert.assertTrue(quizPage.verifyCreateButton(), assertFailurePreText + assertTextVCBA);
            reportLog(assertTextVCBA);

            quizPage.clickOnCreateButton();

            String assertTextVPB = "Presence of Quiz Created Successfully Text ";
            Assert.assertTrue(quizPage.verifyQuizCreatedSuccessfullyText(), assertFailurePreText + assertTextVPB);
            reportLog(assertTextVPB);

            String assertTextVPBA = "Presence of Preview Button ";
            Assert.assertTrue(quizPage.verifyPreviewButton(), assertFailurePreText + assertTextVPBA);
            reportLog(assertTextVPBA);

            quizPage.clickOnPreviewButton();

            String assertTextVPT = "Presence of Preview Text On Preview Page ";
            Assert.assertTrue(quizPage.verifyPreviewText(), assertFailurePreText + assertTextVPT);
            reportLog(assertTextVPT);

            String assertTextVDT = "Presence of DeskTop Text On Preview Page ";
            Assert.assertTrue(quizPage.verifyDeskTopText(), assertFailurePreText + assertTextVDT);
            reportLog(assertTextVDT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify  Functionality of 'Back' Button Of Preview Page")
    public void verifyFunctionalityOfPreviewBackButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            quizPage.removeFromTheQuizPageFrame();
            quizPage.clickOnBackButton();

            String assertTextVBB = "Presence of Back Button";
            Assert.assertTrue(quizPage.verifyBackButton(), assertFailurePreText + assertTextVBB);
            reportLog(assertTextVBB);

            String assertTextVQPU = "Presence of Quiz Page UI Elements";
            Assert.assertTrue(quizPage.verifyQuizPageUI(), assertFailurePreText + assertTextVQPU);
            reportLog(assertTextVQPU);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify  Functionality of 'Update' Button Of Quiz Page After Creating Quiz")
    public void verifyFunctionalityOfUpdateButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            quizPage.enteredIntoTheQuizPageFrame();

            String assertTextVUB = "Presence of Update Button";
            Assert.assertTrue(quizPage.verifyUpdateButton(), assertFailurePreText + assertTextVUB);
            reportLog(assertTextVUB);

            quizPage.clickOnUpdateButton();

//            String assertTextVPB = "Presence of Quiz Updated Successfully Text ";
//            Assert.assertTrue(quizPage.verifyQuizCreatedSuccessfullyText(),assertFailurePreText + assertTextVPB);
//            reportLog(assertTextVPB);

            quizPage.clickOnCloseButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 16, description = "Verify  Functionality of 'Edit' Icon Of Question Set Quiz Page After Creating Quiz")
    public void verifyFunctionalityOfEditIcon() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            String assertTextVEI = "Presence of Edit Icon On Question Set";
            Assert.assertTrue(quizPage.verifyEditIcon(), assertFailurePreText + assertTextVEI);
            reportLog(assertTextVEI);

            quizPage.clickOnEditIcon();

            String assertTextVCB = "Presence of Cancel Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyCancelButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            String assertTextVSB = "Presence of Save Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify  Functionality of 'Add Question' Button On Edit Quiz Page")
    public void verifyFunctionalityOfAddQuestionButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            String assertTextVAQB = "Presence of Add Question Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyAddQuestionButton(), assertFailurePreText + assertTextVAQB);
            reportLog(assertTextVAQB);

            quizPage.clickOnAddQuestionButton();
            quizPage.removeFromTheQuizPageFrame();

            String assertTextVBTPI = "Presence of Back To Previous Page Icon";
            Assert.assertTrue(quizPage.verifyBackToPreviousPageIcon(), assertFailurePreText + assertTextVBTPI);
            reportLog(assertTextVBTPI);

            String assertTextVCNT = "Presence of Concept Name Text";
            Assert.assertTrue(quizPage.verifyConceptNameText(), assertFailurePreText + assertTextVCNT);
            reportLog(assertTextVCNT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify  Functionality of 'Back To Previous ' Icon On Edit Quiz Page")
    public void verifyFunctionalityOfBackToPreviousIcon() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            quizPage.clickOnBackToPreviousPageIcon();

            String assertTextVEQT = "Presence of Edit Quiz Text On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyEditQuizText(), assertFailurePreText + assertTextVEQT);
            reportLog(assertTextVEQT);

            quizPage.enteredIntoTheQuizPageFrame();

            String assertTextVAQB = "Presence of Add Question Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyAddQuestionButton(), assertFailurePreText + assertTextVAQB);
            reportLog(assertTextVAQB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify  Functionality of 'Cancel' Button Of Edit Quiz Page")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            String assertTextVCB = "Presence of Cancel Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyCancelButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            quizPage.clickOnCancelButton();

            String assertTextVEI = "Presence of Edit Icon On Question Set";
            Assert.assertTrue(quizPage.verifyEditIcon(), assertFailurePreText + assertTextVEI);
            reportLog(assertTextVEI);

            quizPage.clickOnEditIcon();

            String assertTextVCBB = "Presence of Cancel Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifyCancelButton(), assertFailurePreText + assertTextVCBB);
            reportLog(assertTextVCBB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 20, description = "Verify  Functionality of 'Save' Button of Edit Quiz Page")
    public void verifyFunctionalityOfSaveButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            String assertTextVSB = "Presence of Save Button On Edit Quiz Page";
            Assert.assertTrue(quizPage.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            quizPage.clickOnSaveButton();

            String assertTextVUB = "Presence of Update Button";
            Assert.assertTrue(quizPage.verifyUpdateButton(), assertFailurePreText + assertTextVUB);
            reportLog(assertTextVUB);

            quizPage.clickOnUpdateButton();

//            String assertTextVPB = "Presence of Quiz Updated Successfully Text ";
//            Assert.assertTrue(quizPage.verifyQuizCreatedSuccessfullyText(),assertFailurePreText + assertTextVPB);
//            reportLog(assertTextVPB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify  Functionality of 'Back To Assignment' Button of Edit Quiz Page")
    public void verifyFunctionalityOfBackToAssignmentButton() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver,extentTest,extentReports);

            String assertTextVBTA = "Presence of Back To Assignment Button";
            Assert.assertTrue(quizPage.verifyBackToAssignmentButton(), assertFailurePreText + assertTextVBTA);
            reportLog(assertTextVBTA);

            quizPage.clickOnBackToAssignmentButton();
            quizPage.removeFromTheQuizPageFrame();

           /* String assertTextVCNQL = "Presence of Create New Quiz Link";
            Assert.assertTrue(quizPage.verifyCreateNewQuizLink(), assertFailurePreText + assertTextVCNQL);
            reportLog(assertTextVCNQL);
*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
