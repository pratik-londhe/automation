package testscripts.regression.teacherlogin.FlexBookFeature.AssesmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.AssessmentFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class AddQuizInAssessmentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddQuizInAssessmentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Add Quiz' button is display After Clicking On the 'Add Assessment' button.")
    public void verifyAddQuizButtonIsVisible(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String Url = "https://flexbooks-master.ck12.org/user:star/cbook/flexbook_1576740335479/r3/section/1.0/primary/lesson/entermodality1576740360155";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            reportLog("User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(Url);

            String assertTextVTPOG = "Presence Of 'Add Assessment' Button";
            Assert.assertTrue(assessmentFeature.verifyAddAssessmentButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnAddAssessmentButton();

            String assertTextVTPG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVHI = "Presence Of 'Add Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyAddQuizButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Add Quiz' button.")
    public void verifyFunctionalityOfAddQuizButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnAddQuizButton();

//            String assertTextVTPOG = "Presence Of 'Latest Version' Link";
//            Assert.assertTrue(assessmentFeature.verifyLatestVersionLink(), assertFailurePreText + assertTextVTPOG);
//            reportLog(assertTextVTPOG);
//
//            assessmentFeature.clickOnLatestVersionLink();
//
//            String assertTextVPOG = "Presence Of 'Add Assessment' Button";
//            Assert.assertTrue(assessmentFeature.verifyAddAssessmentButton(), assertFailurePreText + assertTextVPOG);
//            reportLog(assertTextVPOG);
//
//            assessmentFeature.clickOnAddAssessmentButton();
//
//            String assertTextVTPG = "Presence Of 'What Would Like To Add Text' Button";
//            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPG);
//            reportLog(assertTextVTPG);
//
//            String assertTextVHI = "Presence Of 'Add Quiz' Button";
//            Assert.assertTrue(assessmentFeature.verifyAddQuizButton(), assertFailurePreText + assertTextVHI);
//            reportLog(assertTextVHI);

            assessmentFeature.clickOnAddQuizButton();

            String assertTextVTPO = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

            String assertTextVPG = "Presence Of 'Back Quiz' Icon";
            Assert.assertTrue(assessmentFeature.verifyBackQuizIcon(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Back Arrow Of Quiz' Icon.")
    public void verifyFunctionalityOfBackArrowQuizIcon() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnBackQuizIcon();

            String assertTextVTPG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVHI = "Presence Of 'Add Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyAddQuizButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Already created Quizzes List is Display. ")
    public void verifyQuizListIsDisplay() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnAddQuizButton();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVTPG = "Presence Of 'Close What Difference' Button";
            Assert.assertTrue(assessmentFeature.verifyListOfQuiz(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Add Button is Enable until Selecting Any Quiz.")
    public void verifyAddButtonIsEnable() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Enable Of 'Add' Button";
            Assert.assertTrue(assessmentFeature.verifyAddButtonIsEnable(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnFirstQuiz();

            String assertTextVHI = "Presence Of 'Save Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifySaveQuizButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Back Quiz' Icon After Selecting Quiz From List. ")
    public void verifyQuizIsNotSelectedAfterClickingOnBackIcon () {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'Back Quiz' Icon";
            Assert.assertTrue(assessmentFeature.verifyBackQuizIcon(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnBackQuizIcon();

            String assertTextVTP = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTP);
            reportLog(assertTextVTP);

            String assertTextVHI = "Presence Of 'Add Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyAddQuizButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            assessmentFeature.clickOnAddQuizButton();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVSO = "Enable Of 'Add' Button";
            Assert.assertTrue(assessmentFeature.verifyAddButtonIsEnable(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify List Of Quiz is display By default order of Most Recently Modified Quiz.")
    public void verifyByDefaultMostRecentlyModifiedQuizIsSelected() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'DropDown Selected Value'";
            Assert.assertTrue(assessmentFeature.verifyDropDownSelectedValue(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVPOG = "Presence Of 'Most Recently Edited' DropDown Value";
            Assert.assertTrue(assessmentFeature.verifyDropDownSelectedValueIsMostRecentlyEdited(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of DropDown Container Icon.")
    public void verifyFunctionalityDropDownContainerIcon() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'DropDown Container' Icon";
            Assert.assertTrue(assessmentFeature.verifyDropDownContainerIcon(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnDropDownContainerIcon();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVSO = "Presence Of 'Most Recently Edited' Link";
            Assert.assertTrue(assessmentFeature.verifyMostRecentlyEditedLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Alphabetical Quiz List Link.")
    public void verifyFunctionalityOfAlphabeticallyLink() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVPOG = "Presence Of 'Alphabetically' Link";
            Assert.assertTrue(assessmentFeature.verifyAlphabeticalLink(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            assessmentFeature.getTextOfFirstLinkBeforeSelectingAlphabetically();
            assessmentFeature.clickOnAlphabeticalLink();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Alphabetically DropDown' Value";
            Assert.assertTrue(assessmentFeature.verifyDropDownSelectedValueIsAlphabetically(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPG = "List Of Quiz Is Updated Alphabetically";
            Assert.assertTrue(assessmentFeature.verifyQuizListIsUpdatedAlphabetically(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Refresh Button.")
    public void verifyFunctionalityOfSRefreshButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnRefreshButton();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Recently Edited DropDown' Value";
            Assert.assertTrue(assessmentFeature.verifyDropDownSelectedValueIsMostRecentlyEdited(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify 'Create New Quiz' Tab is available on Quiz Modal. ")
    public void verifyCreateNewQuiz() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'DropDown Container' Icon";
            Assert.assertTrue(assessmentFeature.verifyDropDownContainerIcon(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnDropDownContainerIcon();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVSO = "Presence Of 'Alphabetical' Link";
            Assert.assertTrue(assessmentFeature.verifyAlphabeticalLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            assessmentFeature.clickOnAlphabeticalLink();

            String assertTextVHI = "Presence Of 'Create New Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyCreateNewQuizButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of Most Recently Modified Quiz List Link.")
    public void verifyFunctionalityOfMostRecentlyEditedLink() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'DropDown Container' Icon";
            Assert.assertTrue(assessmentFeature.verifyDropDownContainerIcon(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnDropDownContainerIcon();

            String assertTextVTPOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVSO = "Presence Of 'Most Recently Edited' Link";
            Assert.assertTrue(assessmentFeature.verifyMostRecentlyEditedLink(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            assessmentFeature.getTextOfFirstLinkBeforeSelectingRecentlyEdited();
            assessmentFeature.clickOnMostRecentlyEditedLink();

            String assertTextVOG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

            String assertTextVHI = "Presence Of 'Recently Edited DropDown' Value";
            Assert.assertTrue(assessmentFeature.verifyDropDownSelectedValueIsMostRecentlyEdited(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVPOG = "List Of Quiz Is Updated Recently Edited";
            Assert.assertTrue(assessmentFeature.verifyQuizListIsUpdatedRecentlyEdited(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}