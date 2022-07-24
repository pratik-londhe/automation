package testscripts.regression.teacherlogin.LibraryFeature.CreateNewQuestionFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.QuestionTypeFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class VariableAndProgressWrapperTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(VariableAndProgressWrapperTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify variable and Progress Link are Available On the Create Question Page.")
    public void verifyVariableAndProgressWrapper(String email, String password) {
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

            String assertTextVFTT = "Presence of 'Variable Link ' text";
            Assert.assertTrue(questionTypeFeature.verifyVariableLink(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Variable link.")
    public void verifyFunctionalityOfVariableWrapper() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnVariableLink();

            String assertTextVML = "Presence of 'Variable' Text";
            Assert.assertTrue(questionTypeFeature.verifyVariableText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify UI After Clicking On Variable Link.")
    public void verifyUIOfVariableWrapper() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Add Variable' Link";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVNL = "Presence of 'Close Variable Wrapper' icon";
            Assert.assertTrue(questionTypeFeature.verifyCloseVariableWrapperIcon(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of Close Variable Wrapper Icon.")
    public void verifyFunctionalityOfCloseVariableWrapperIcon() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCloseVariableWrapperIcon();

            String assertTextVFTT = "Presence of 'Variable Link ' text";
            Assert.assertTrue(questionTypeFeature.verifyVariableLink(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnVariableLink();

            String assertTextVNL = "Presence of 'Variable' Text";
            Assert.assertTrue(questionTypeFeature.verifyVariableText(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of Add variable link.")
    public void verifyFunctionalityOfAddVariableLink() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Add Variable' Link";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnAddVariableLink();

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify UI of Variable Modal after clicking on Add Variable link .")
    public void verifyUIOfAddVariableModal() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Cancel Modal ' button";
            Assert.assertTrue(questionTypeFeature.verifyCancelModalButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFTT = "Presence of 'Close Variable Modal' Icon";
            Assert.assertTrue(questionTypeFeature.verifyCloseVariableModalICon(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of close Icon of variable modal.")
    public void verifyFunctionalityOfCloseIconOfVariableModal() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCloseVariableModalICon();

            String assertTextVNL = "Presence of 'Variable' Text";
            Assert.assertTrue(questionTypeFeature.verifyVariableText(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

            String assertTextVML = "Presence of 'Add Variable' Link";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            questionTypeFeature.clickOnAddVariableLink();

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of Cancel Button of variable modal.")
    public void verifyFunctionalityOfCancelButtonOfVariableModal() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnCancelModalButton();

            String assertTextVNL = "Presence of 'Variable' Text";
            Assert.assertTrue(questionTypeFeature.verifyVariableText(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

            String assertTextVML = "Presence of 'Add Variable' Link";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Constant Variable Type is by default selected.")
    public void verifyConstantVariableTypeIsByDefaultSelected() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnAddVariableLink();

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            String assertTextVFT = "Presence of 'Constant Variable' Type Is ByDefault Selected.";
            Assert.assertTrue(questionTypeFeature.verifyConstantVariableTypeIsByDefaultSelected(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 18, description = "Verify Drag Icon IS present on the Add Variable Modal Page.")
    public void verifyDragIconOfVariableModal() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVNL = "Presence of 'Drag Variable' ICon";
            Assert.assertTrue(questionTypeFeature.verifyDragVariableICon(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of Add Button without giving variable name and value.")
    public void verifyFunctionalityOfAddButtonWithoutVariableNAmeAndValue() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnAddVariableButton();

            String assertTextVFT = "Presence of 'Error Message' Text.";
            Assert.assertTrue(questionTypeFeature.verifyErrorMsgText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality of Add Button with variable name and Without variable value.")
    public void verifyFunctionalityOfAddButtonWithVariableNameAndWithoutVariableValue() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.setValueInVariableNamePlaceHolder();

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnAddVariableButton();

            String assertTextVFT = "Presence of 'Error Message' Text.";
            Assert.assertTrue(questionTypeFeature.verifyErrorMsgText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality of Add Button with variable Value and Without variable name.")
    public void verifyFunctionalityOfAddButtonWithVariableValueAndWithoutVariableName() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.removeValueFromInVariableNamePlaceHolder();
            questionTypeFeature.setValueInVariableValuePlaceHolder();

            String assertTextVFTT = "Presence of 'Add Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyAddVariableButton(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnAddVariableButton();

            String assertTextVFT = "Presence of 'Error Message' Text.";
            Assert.assertTrue(questionTypeFeature.verifyErrorMsgText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality of Using array Variable Type.")
    public void verifyFunctionalityOfUsingArrayVariableType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'Using Array Variable Type' Button";
            Assert.assertTrue(questionTypeFeature.verifyUsingArrayVariableType(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnUsingArrayVariableTypen();

            String assertTextVFT = "Presence of 'Error Message' Text.";
            //Assert.assertTrue(questionTypeFeature.verifyEnterRuleText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality of Constant Variable Type.")
    public void verifyFunctionalityOfConstantVariableType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'Constant Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyConstantVariableType(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnConstantVariableTypen();

            String assertTextVFT = "Presence of 'Constant Value' Text.";
            Assert.assertTrue(questionTypeFeature.verifyConstantValueText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify Functionality Of Choose from Set Variable Type.")
    public void verifyFunctionalityOfChooseFromSetVariableType() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVFTT = "Presence of 'Constant Variable' Button";
            Assert.assertTrue(questionTypeFeature.verifyConstantVariableType(), assertFailurePreText + assertTextVFTT);
            reportLog(assertTextVFTT);

            questionTypeFeature.clickOnConstantVariableTypen();

//            String assertTextVFT = "Presence of 'Range' CheckBox.";
//            Assert.assertTrue(questionTypeFeature.verifyRangeCheckBox(), assertFailurePreText + assertTextVFT);
//            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 31, description = "Verify Functionality Of Range CheckBox.")
    public void verifyFunctionalityOfRangeCheckBox() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            questionTypeFeature.clickOnRangeCheckBox();

            String assertTextVFT = "Presence of 'With InterVal' text.";
            Assert.assertTrue(questionTypeFeature.verifyWithInterValText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 33, description = "Verify Functionality of List CheckBox. ")
    public void verifyFunctionalityOfListCheckBox() {
        boolean result = true;
        try {
            QuestionTypeFeature questionTypeFeature = new QuestionTypeFeature(webDriver, extentTest, extentReports);

            String assertTextVNL = "Presence of 'List' checkBox";
            Assert.assertTrue(questionTypeFeature.verifyListCheckBox(), assertFailurePreText + assertTextVNL);
            reportLog(assertTextVNL);

            questionTypeFeature.clickOnListCheckBox();

            String assertTextVFT = "Presence of 'Not Equal' text.";
            Assert.assertTrue(questionTypeFeature.verifyNotEqualToText(), assertFailurePreText + assertTextVFT);
            reportLog(assertTextVFT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}