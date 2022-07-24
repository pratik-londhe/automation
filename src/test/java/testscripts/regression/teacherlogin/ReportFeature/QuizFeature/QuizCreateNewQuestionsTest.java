package testscripts.regression.teacherlogin.ReportFeature.QuizFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LibraryPage;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.PageMenuTab;
import uipages.flexbook2feature.TeacherDashboardPage;
import uipages.reports2feature.CreateAnAssignment;
import uipages.reports2feature.CreateNewQuestionsPage;
import uipages.reports2feature.QuizPage;

public class QuizCreateNewQuestionsTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(QuizPageTest.class);

    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    public LoginPage loginPage;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify options in Question Type DropDown")
    public void verifyQuestionTypeDropDown(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            QuizPage quizPage = new QuizPage(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            loginPage.clickOnSignInLink();
            loginPage.login(email, password);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnLibraryTab();
            libraryPage.clickOnCreateNewDrpDwnBtn();
            libraryPage.clickOnLinkQuiz();
            quizPage.enteredIntoTheQuizPageFrame();
            quizPage.clickOnAddQuestionIcon();
            quizPage.clickOnCreateNewQuestionsIcon();
            quizPage.removeFromTheQuizPageFrame();

            String assertTextVCTDD = "Presence of question type drop down.";
            Assert.assertTrue(createNewQuestionsPage.verifyTheQuestionsTypeDropDown(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVCTDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality Of View More Link")
    public void verifyFunctionalityOfViewMoreLink() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.clickOnViewMoreLink();

            String assertTextVCTDD = "Presence of source text.";
            Assert.assertTrue(createNewQuestionsPage.verifySourceText(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVCTDD);

            String assertTextVFCL = "Presence of flexBox control link.";
            Assert.assertTrue(createNewQuestionsPage.verifyFlexBoxControlLink(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVFCL);

            String assertTextVLT = "Presence of language text.";
            Assert.assertTrue(createNewQuestionsPage.verifyLanguageText(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVLT);

            String assertTextVST = "Presence of search text.";
            Assert.assertTrue(createNewQuestionsPage.verifySearchText(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVST);

            String assertTextVLDD = "Presence of licenced text.";
            Assert.assertTrue(createNewQuestionsPage.verifyLicencedDropDown(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVLDD);

            String assertTextVAT = "Presence of author text.";
            Assert.assertTrue(createNewQuestionsPage.verifyAuthorText(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVAT);

            String assertTextVCOT = "Presence of created on text.";
            Assert.assertTrue(createNewQuestionsPage.verifyCreatedOnText(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVCOT);

            String assertTextVRB = "Presence of role button.";
            Assert.assertTrue(createNewQuestionsPage.verifyRoleBtn(), assertFailurePreText + assertTextVCTDD);
            reportLog(assertTextVRB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of View less Link")
    public void verifyFunctionalityOfViewLessLink() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.clickOnViewLessLink();

            String assertTextVLF = "View less functionality.";
            Assert.assertTrue(createNewQuestionsPage.verifyViewLessFunctionality(), assertFailurePreText + assertTextVLF);
            reportLog(assertTextVLF);

            String assertTextVCT = "Presence of concepts text.";
            Assert.assertTrue(createNewQuestionsPage.verifyConceptsText(), assertFailurePreText + assertTextVCT);
            reportLog(assertTextVCT);

            String assertTextVGT = "Presence of grades text.";
            Assert.assertTrue(createNewQuestionsPage.verifyGradesText(), assertFailurePreText + assertTextVGT);
            reportLog(assertTextVGT);

            String assertTextVTS = "Presence of standards text.";
            Assert.assertTrue(createNewQuestionsPage.verifyTextStandards(), assertFailurePreText + assertTextVTS);
            reportLog(assertTextVTS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify Functionality Of Add Button Without role value")
    public void verifyAddButtonWithoutRoleValue() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.clickOnViewMoreLink();
            createNewQuestionsPage.clickOnAddRoleBtn();
            createNewQuestionsPage.clickOnAddRoleValueBtn();

            String assertTextVTS = "Presence of error message of a role.";
            Assert.assertTrue(createNewQuestionsPage.verifyTheErrorMessage(), assertFailurePreText + assertTextVTS);
            reportLog(assertTextVTS);

            createNewQuestionsPage.acceptTheErrorPopUp();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Add Button with role value")
    public void verifyAddButtonWithRoleValue() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.enterCreditValueOfRole();
            createNewQuestionsPage.clickOnAddRoleValueBtn();

            String assertTextVTS = "Entered credit value of a role.";
            Assert.assertTrue(createNewQuestionsPage.verifyEnteredCreditValueOfRole(), assertFailurePreText + assertTextVTS);
            reportLog(assertTextVTS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality Of Add Button with role value")
    public void verifyCancelBtnOfTranslator() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.clickOnAddRoleBtn();
            createNewQuestionsPage.clickOnCancelBtnOfTranslator();

            String assertTextVTS = "Functionality of cancel button of translator.";
            Assert.assertTrue(createNewQuestionsPage.verifyFunctionalityOfCancelButton(), assertFailurePreText + assertTextVTS);
            reportLog(assertTextVTS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Add Button with role value")
    public void verifySubmitBtnWithoutQuestion() {
        boolean result = true;
        try {
            CreateNewQuestionsPage createNewQuestionsPage = new CreateNewQuestionsPage(webDriver, extentTest, extentReports);

            createNewQuestionsPage.clickOnSubmitButton();

            String assertTextVTS = "Functionality of submit button without question.";
            Assert.assertTrue(createNewQuestionsPage.verifyQuestionErrorMsg(), assertFailurePreText + assertTextVTS);
            reportLog(assertTextVTS);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}