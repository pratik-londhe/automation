package testscripts.regression.teacherlogin.LibraryFeature.CreateNewQuestionFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.CreateNewQuestion;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.QuestionTypeFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class ProgressWrapperTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ProgressWrapperTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";




    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Progress Wrapper Is available on create new Question UI Page.")
    public void verifyProgressWrapperIsAvailable(String email, String password) {
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

            questionTypeFeature.clickOnCreateNewQuestionLink();

            String assertTextVNL = "Presence of 'New Question' icon";
            Assert.assertTrue(questionTypeFeature.verifyNewQuestionIcon(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

            String assertTextVT = "Presence of 'Progress'  Link";
            Assert.assertTrue(questionTypeFeature.verifyProgressLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "verify Progress is showing 0% when no question is created.")
    public void verifyProgressPercentageBeforeQuestion() {
        boolean result = true;
        try {
            CreateNewQuestion createNewQuestion = new CreateNewQuestion(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Progress Percentage Before Creating Question' Text";
            Assert.assertTrue(createNewQuestion.verifyProgressPercentageBeforeCreatingQuestion(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Progress link.")
    public void verifyFunctionalityOfProgressPercentageLink() {
        boolean result = true;
        try {
            CreateNewQuestion createNewQuestion = new CreateNewQuestion(webDriver, extentTest, extentReports);
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnProgressLink();

            String assertTextVML = "Presence of 'Question And Answer' Text";
            Assert.assertTrue(createNewQuestion.verifyQuestionAndAnswerText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVNL = "Presence of 'Feedback And Hint' Text";
            Assert.assertTrue(createNewQuestion.verifyFeedbackAndHintText(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify UI Elements of Progress Wrapper Modal.")
    public void verifyUIElementsOfProgressWrapperModal() {
        boolean result = true;
        try {
            CreateNewQuestion createNewQuestion = new CreateNewQuestion(webDriver, extentTest, extentReports);
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnProgressLink();

            String assertTextVML = "Presence of 'Remember' Text";
            Assert.assertTrue(createNewQuestion.verifyRememberText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVNL = "Presence of 'Close Progress Wrapper' Icon";
            Assert.assertTrue(createNewQuestion.verifyCloseProgressWrapperIcon(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of Close Progress Wrapper.")
    public void verifyFunctionalityOFCloseProgressWrapperIcon() {
        boolean result = true;
        try {
            CreateNewQuestion createNewQuestion = new CreateNewQuestion(webDriver, extentTest, extentReports);
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            createNewQuestion.clickOnCloseProgressWrapperIcon();

            String assertTextVT = "Presence of 'Progress'  Link";
            Assert.assertTrue(questionTypeFeature.verifyProgressLink(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of Add Button with variable name variable value.")
    public void verifyCrestedNewQuestion() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'Variable Link ' text";
            Assert.assertTrue(questionTypeFeature.verifyVariableLink(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnVariableLink();

            String assertTextVML = "Presence of 'Variable' Text";
            Assert.assertTrue(questionTypeFeature.verifyVariableText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnAddVariableLink();

            String assertTextVFT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

            questionTypeFeature.setValueInVariableNamePlaceHolder();
            questionTypeFeature.setValueInVariableValuePlaceHolder();
//            questionTypeFeature.clickOnAddVariableButton();
//
//            String assertTextVT = "Presence of 'Progress'  Link";
//            Assert.assertTrue(questionTypeFeature.verifyProgressLink(), assertFailurePreText + assertTextVT);
//            reportLog(assertTextVT);
//
//
//            String assertTextVNL = "Presence of 'Close Progress Wrapper' Icon";
//            Assert.assertTrue(createNewQuestion.verifyCloseProgressWrapperIcon(), assertFailurePreText + assertTextVNL);
//            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
