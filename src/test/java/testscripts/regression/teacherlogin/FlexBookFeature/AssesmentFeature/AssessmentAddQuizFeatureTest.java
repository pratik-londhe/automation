package testscripts.regression.teacherlogin.FlexBookFeature.AssesmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AssessmentAddQuizFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AssessmentAddQuizFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of Add Button After Selecting Quiz.")
    public void verifyFunctionalityOfAddButtonAfterSelectingQuiz(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

            String courseBookTitle = "FlexBook_";
            String modality = "EnterModality";
            String contents = "content_";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog( "Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), "Failed to verified FlexBook2 Link.");
            reportLog("Successfully verified FlexBook2 Link.");

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();
            createFlexBookPage.enterCourseBookTitle(courseBookTitle);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            reportLog("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            reportLog("Successfully  New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            reportLog("Successfully verified Save Modality Button.");

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            reportLog("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            reportLog( "Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog( "Successfully verified Finalize Draft Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            reportLog("Successfully verified Finalize Button.");
            logger.info("Successfully verified Finalize Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeButton();

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

            assessmentFeature.clickOnAddQuizButton();

            String assertTextVTG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

            assessmentFeature.clickOnFirstQuiz();

            String assertTextVHIT = "Presence Of 'Save Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifySaveQuizButton(), assertFailurePreText + assertTextVHIT);
            reportLog(assertTextVHIT);

            assessmentFeature.clickOnSaveQuizButton();

            String assertTextVTTG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify UI of Quiz Modal.")
    public void verifyUIOfQuizModal() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

            assessmentFeature.clickOnViewQuiz();
            extentTest.log(LogStatus.PASS, "cliked on the View Quiz button.");

            String assertTextVPG = "Presence Of 'Created Quiz Modal' Icon";
            Assert.assertTrue(assessmentFeature.verifyCreatedQuizCloseModalIcon(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            String assertTextVTPG = "Presence Of 'Choose Different Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseDifferentQuizButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVTPOG = "Presence Of 'Switch To Practice' Button";
            Assert.assertTrue(assessmentFeature.verifySwitchToPracticeButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify View Quiz Button Is Display After Adding Quiz.")
    public void verifyViewQuizButtonIsDisplayAfterAddingQuiz() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

            assessmentFeature.clickOnCreatedQuizCloseModalIcon();

            String assertTextVPG = "Presence Of 'View Quiz' Button.";
            Assert.assertTrue(assessmentFeature.verifyViewQuizButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            assessmentFeature.clickOnViewQuizButton();

            String assertTextVTTG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Choose Different Quiz Button.")
    public void verifyFunctionalityOfChooseDifferentQuizButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

            String assertTextVTPG = "Presence Of 'Choose Different Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseDifferentQuizButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnChooseDifferentQuizButton();

            String assertTextVTG = "Presence Of 'Refresh' Button";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify User Can Not Add Same Quiz Again.")
    public void verifyUserCanNotAddSameConceptAgain() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

//            String assertTextVSO = "Enable Of 'Add' Button";
//            Assert.assertTrue(assessmentFeature.verifyAddButtonIsEnable(), assertFailurePreText + assertTextVSO);
//            reportLog(assertTextVSO);

            String assertTextVTPG = "Presence Of 'Back Quiz' Icon";
            Assert.assertTrue(assessmentFeature.verifyBackQuizIcon(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnBackQuizIcon();

            String assertTextVTTG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Switch To Practice Button.")
    public void verifyFunctionalityOfSwitchToPractice() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver, extentTest, extentReports);

            String assertTextVTG = "Presence Of 'Switch To Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifySwitchToPracticeButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

            assessmentFeature.clickOnSwitchToPracticeButton();

            String assertTextVHI = "Presence Of 'Primary Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyPrimaryConceptText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPG = "Presence Of 'Choose Concept' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseConceptButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}