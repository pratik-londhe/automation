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

public class QuizPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(QuizPageTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of ' Add New Quiz' Icon After Clicking on Create An Assignment Button ")
    public void verifyFunctionalityOfAddNewQuizLink(String email, String password) {
        String assignementURl = "https://master.ck12.org/group-assignments/632826";
        boolean result = true;
        try {
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver, extentTest, extentReports);
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver, extentTest, extentReports);
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(assignementURl);
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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify  Functionality of 'Create New Quiz' Button After Clicking On Add New Quiz Link")
    public void verifyFunctionalityOfCreateNewQuiz() {
        boolean result = true;
        try {

            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify  Functionality of 'Back' Button After Clicking On Create New Quiz Link")
    public void verifyFunctionalityOfBackButton() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            quizPage.clickOnBackButton();

            String assertTextVAQL = "Presence of Add Quiz Link";
            Assert.assertTrue(quizPage.verifyAddQuizLink(), assertFailurePreText + assertTextVAQL);
            reportLog(assertTextVAQL);

            quizPage.clickOnAddQuizLink();

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify  Functionality of 'Create' Button Without Making Quiz")
    public void verifyFunctionalityOfCreateButton() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            quizPage.enteredIntoTheQuizPageFrame();

            String assertTextVCB = "Presence of Create Button";
            Assert.assertTrue(quizPage.verifyCreateButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            quizPage.clickOnCreateButton();

            String assertTextVAI = "Presence of Alert Icon";
            Assert.assertTrue(quizPage.verifyAlertIcon(), assertFailurePreText + assertTextVAI);
            reportLog(assertTextVAI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify  Functionality of 'Create' Button After Giving Only Valid Title")
    public void verifyFunctionalityOfCreateButtonWithTitle() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            String title = "Quiz";

            quizPage.setValueInTitlePlaceHolder(title);

            String assertTextVCB = "Presence of Create Button";
            Assert.assertTrue(quizPage.verifyCreateButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            quizPage.clickOnCreateButton();

            String assertTextVAI = "Presence of Alert Icon";
            Assert.assertTrue(quizPage.verifyAlertIcon(), assertFailurePreText + assertTextVAI);
            reportLog(assertTextVAI);

            String assertTextVQRT = "Presence of Question Required Text";
            Assert.assertTrue(quizPage.verifyQuestionRequiredText(), assertFailurePreText + assertTextVQRT);
            reportLog(assertTextVQRT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify  Functionality of 'Add Question Set' Icon Of Quiz Page")
    public void verifyFunctionalityOfAddQuestionSetIcon() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            String assertTextVAQI = "Presence of Add Question Set Icon";
            Assert.assertTrue(quizPage.verifyAddQuestionIcon(), assertFailurePreText + assertTextVAQI);
            reportLog(assertTextVAQI);

            quizPage.clickOnAddQuestionIcon();

            String assertTextVCCT = "Presence of Choose Concept Text";
            Assert.assertTrue(quizPage.verifyChooseConceptText(), assertFailurePreText + assertTextVCCT);
            reportLog(assertTextVCCT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify  Functionality of 'Search Concept' Icon With Valid Concept Name")
    public void verifyFunctionalityOfSearchIcon() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            String conceptText = "Algebra";

            quizPage.setValueInSearchConceptPlaceHolder(conceptText);
            quizPage.clickOnSearchIcon();

            String assertTextVCSI = "Presence of Close Search Icon";
            Assert.assertTrue(quizPage.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSI);
            reportLog(assertTextVCSI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify  Functionality of 'Close Search Concept' Icon After clicking on Search Icon")
    public void verifyFunctionalityOfCloseSearchIcon() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            quizPage.clickOnCloseSearchIcon();

            String assertTextVCCT = "Presence of Choose Concept Text";
            Assert.assertTrue(quizPage.verifyChooseConceptText(), assertFailurePreText + assertTextVCCT);
            reportLog(assertTextVCCT);

            String assertTextVSI = "Presence of Search Icon";
            Assert.assertTrue(quizPage.verifySearchIcon(), assertFailurePreText + assertTextVSI);
            reportLog(assertTextVSI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify  Functionality of 'Content' CheckBox After searching Concept Through  Search Icon")
    public void verifyFunctionalityOfContentCheckBox() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            String conceptText = "Algebra";

            quizPage.setValueInSearchConceptPlaceHolder(conceptText);
            quizPage.clickOnSearchIcon();

            String assertTextVCSI = "Presence of Close Search Icon";
            Assert.assertTrue(quizPage.verifyCloseSearchIcon(), assertFailurePreText + assertTextVCSI);
            reportLog(assertTextVCSI);

            quizPage.clickOnSearchResultCheckBox();

            String assertTextVSB = "Presence of Select Button";
            Assert.assertTrue(quizPage.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify  Functionality of 'Select' Button after selecting content CheckBox")
    public void verifyFunctionalityOfSelectButton() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            quizPage.getConceptText();
            quizPage.clickOnSelectButton();
            quizPage.clickOnGotItButton();

            String assertTextVQSIA = "Question Set is Added In the Assignment";
            Assert.assertTrue(quizPage.verifyQuestionSetIsAdded(), assertFailurePreText + assertTextVQSIA);
            reportLog(assertTextVQSIA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify  Functionality of 'Remove' Icon of Question Set")
    public void verifyFunctionalityOfSelectRemoveIcon() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

            String assertTextVRI = "Presence of Remove Icon On Question Set";
            Assert.assertTrue(quizPage.verifyRemoveIcon(), assertFailurePreText + assertTextVRI);
            reportLog(assertTextVRI);

            quizPage.clickOnRemoveIcon();

            String assertTextVQSIR = "Question Set is Remove In the Assignment";
            Assert.assertTrue(quizPage.verifyQuestionSetIsRemove(), assertFailurePreText + assertTextVQSIR);
            reportLog(assertTextVQSIR);

            String assertTextVAQI = "Presence of Add Question Set Icon";
            Assert.assertTrue(quizPage.verifyAddQuestionIcon(), assertFailurePreText + assertTextVAQI);
            reportLog(assertTextVAQI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify  Functionality of 'Create' Button With All Valid Data")
    public void verifyFunctionalityOfCreate() {
        boolean result = true;
        try {
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);

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

            quizPage.clickOnSearchResultCheckBox();

            String assertTextVSB = "Presence of Select Button";
            Assert.assertTrue(quizPage.verifySelectButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            quizPage.clickOnSelectButton();
            quizPage.clickOnGotItButton();

            String assertTextVQSIA = "Question Set is Added In the Assignment";
            Assert.assertTrue(quizPage.verifyQuestionSetIsAdded(), assertFailurePreText + assertTextVQSIA);
            reportLog(assertTextVQSIA);

            String assertTextVCB = "Presence of Create Button";
            Assert.assertTrue(quizPage.verifyCreateButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            quizPage.clickOnCreateButton();

            String assertTextVPBA = "Presence of Preview Button ";
            Assert.assertTrue(quizPage.verifyPreviewButton(), assertFailurePreText + assertTextVPBA);
            reportLog(assertTextVPBA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}