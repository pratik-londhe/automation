package testscripts.regression.teacherlogin.LibraryFeature.CreateNewQuestionFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class QuestionTypeFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(QuestionTypeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Create New Question Link IS Available For Teacher User Only")
    public void verifyCreateNEwQuestionLink(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to("https://master.ck12.org/create/exercise/test/?referrer=my_content&title=My%20Quizzes&user=dgvhy2hlcjeyk3rlc3r1c2vyqgnrmtiub3jn");

            questionTypeFeature.clickOnAddQues();

            String assertTextVML = "Presence of 'Create NEw Question' Link";
            Assert.assertTrue(questionTypeFeature.verifyCreateNewQuestionLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Create New Question' link.")
    public void verifyFunctionalityOfCreateNewQuestionLink() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCreateNewQuestionLink();

            String assertTextVML = "Presence of 'New Question' icon";
            Assert.assertTrue(questionTypeFeature.verifyNewQuestionIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Question Type' text";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeText(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVT = "Presence of 'Multiple Choice First Option'  Link";
            Assert.assertTrue(questionTypeFeature.verifyMultipleChoiceOptionFirst(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Question type' dropDown.")
    public void verifyFunctionalityOfQuestionTypeDropDown() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Multiple Choice'  Link";
            Assert.assertTrue(questionTypeFeature.verifyMultipleChoiceLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVT = "Presence of 'Select All'  Link";
            Assert.assertTrue(questionTypeFeature.verifySelectAllLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

            String assertTextVTT = "Presence of 'True False' Link";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseLink(), assertFailurePreText + assertTextVTT);
            reportLog(assertTextVTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'TRue False  ' Question Type Link.")
    public void verifyFunctionalityOfTrueFalseQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVT = "Presence of 'True False'  Link";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

            questionTypeFeature.clickOnTrueFalseLink();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVTA = "Presence of 'True False'  Link";
            Assert.assertTrue(questionTypeFeature.verifySelectAllLink(), assertFailurePreText + assertTextVTA);
            reportLog(assertTextVTA);

            questionTypeFeature.clickOnSelectAllLink();

           /* String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);*/

            String assertTextVML = "Presence of 'Multiple Choice'  Link";
            Assert.assertTrue(questionTypeFeature.verifyCancelButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of 'Cancel ' Button while changing Question Type.")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCancelButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVT = "Presence of 'True False'  Link";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

            questionTypeFeature.clickOnTrueFalseLink();

            /*String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);*/

            /*String assertTextVTT = "Presence of 'Close Modal ICon' Link";
            Assert.assertTrue(questionTypeFeature.verifyCloseModalIcon(), assertFailurePreText + assertTextVTT);
            reportLog(assertTextVTT);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify Functionality of 'Close Modal ' icon while changing Question Type.")
    public void verifyFunctionalityOfCloseModalIcon() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCloseModalIcon();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVML = "Presence of 'True False'  Question Type";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseQuestionTypeIsSelected(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVT = "Presence of 'True False'  Link";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

            questionTypeFeature.clickOnTrueFalseLink();

          /*  String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Ok ' Button while changing Question Type.")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVML = "Presence of 'True False'  Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyTrueFalseQuestionTypeIsSelected(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Multiple Choice ' Question Type Link.")
    public void verifyFunctionalityOfMultipleChoiceQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Multiple Choice'  Link";
            Assert.assertTrue(questionTypeFeature.verifyMultipleChoiceLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnMultipleChoiceLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Multiple Choice' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyMultipleChoiceQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of 'Select All' Question Type Link.")
    public void verifyFunctionalityOfSelectAllQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'True False'  Link";
            Assert.assertTrue(questionTypeFeature.verifySelectAllLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnSelectAllLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Select All' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifySelectAllQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Short Answer' Question Type Link.")
    public void verifyFunctionalityOfShortAnswerQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Short Answer'  Link";
            Assert.assertTrue(questionTypeFeature.verifyShortAnswerLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnShortAnswerLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Short Answer' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyShortAnswerQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of 'Fill In The Blanks' Question Type Link.")
    public void verifyFunctionalityOfFillInTheBlanksQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Fill In The Blanks'  Link";
            Assert.assertTrue(questionTypeFeature.verifyFillInTheBlanksLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnFillInTheBlanksLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Fill In The Blanks' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyFillBlanksQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality of 'Drag And Drop' Question Type Link.")
    public void verifyFunctionalityOfDragAndDropQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Drag And Drop'  Link";
            Assert.assertTrue(questionTypeFeature.verifyDragAndDropLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnDragAndDropLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Drag And Drop' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyDragDropQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality of 'HighLight' Question Type Link.")
    public void verifyFunctionalityOfHighlightQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'HighLight'  Link";
            Assert.assertTrue(questionTypeFeature.verifyHighLightLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnHighLightLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'HighLight' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyHighLightQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality of 'Discussion' Question Type Link.")
    public void verifyFunctionalityOfDiscussionQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Discussion'  Link";
            Assert.assertTrue(questionTypeFeature.verifyDiscussionLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnDiscussionLink();

            String assertTextVFT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyOkButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.clickOnOkButton();

            String assertTextVAT = "Presence of 'Question Type' DropDown.";
            Assert.assertTrue(questionTypeFeature.verifyQuestionTypeDropDown(), assertFailurePreText + assertTextVAT);
            reportLog(assertTextVAT);

            String assertTextVL = "Presence of 'Discussion' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyDiscussionQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Change Modal Is Comes even we select to change Same Question Type")
    public void verifyFunctionalityOfSameQuestionType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnQuestionTypeDropDown();

            String assertTextVML = "Presence of 'Discussion'  Link";
            Assert.assertTrue(questionTypeFeature.verifyDiscussionLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnDiscussionLink();

            String assertTextVL = "Presence of 'Discussion' Question Type Is Selected";
            Assert.assertTrue(questionTypeFeature.verifyDiscussionQuestionTypeIsSelected(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}