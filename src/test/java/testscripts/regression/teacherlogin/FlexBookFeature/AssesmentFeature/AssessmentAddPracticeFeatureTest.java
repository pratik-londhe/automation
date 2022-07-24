package testscripts.regression.teacherlogin.FlexBookFeature.AssesmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AssessmentAddPracticeFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AssessmentAddPracticeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Create New FlexBook Without Adding Modality")
    public void createNewModality(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String courseBookTitle = "FlexBook_";
            String modality = "EnterModality";
            String contents = "content_";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

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
            logger.info("Successfully verified Save Modality Button.");

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            reportLog("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            reportLog("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog("Successfully verified Finalize Draft Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            reportLog("Successfully verified Finalize Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeButton();

            String assertTextVTPOG = "Presence Of 'Add Assessment' Button";
            Assert.assertTrue(assessmentFeature.verifyAddAssessmentButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Change Concept And Save Concept Buttons Are Display After Selecting Concept.")
    public void verifyChangeAndSaveConceptsButtonsAreDisplay() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String placeholderText = "You and the Environment";

            assessmentFeature.clickOnAddAssessmentButton();

            String assertTextVTPG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVTPOG = "Presence Of 'Add Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnAddPracticeButton();

            String assertTextVHI = "Presence Of 'Primary Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyPrimaryConceptText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTTG = "Presence Of 'Choose Concept' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseConceptButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

            assessmentFeature.clickOnChooseConceptButton();

            String assertTextVTG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

            String assertTextVPOG = "Presence Of 'Search' PlaceHolder";
            Assert.assertTrue(assessmentFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            assessmentFeature.setValueSearchPlaceHolder(placeholderText);

            String assertTextVT = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVT);
            reportLog(assertTextVT);

            assessmentFeature.clickOnSearchButton();

            String assertTextVI = "Presence Of 'Search Result For' Text";
            Assert.assertTrue(assessmentFeature.verifySearchResultForText(), assertFailurePreText + assertTextVI);
            reportLog(assertTextVI);

            String assertTextVG = "Presence Of 'Biology' Link";
            Assert.assertTrue(assessmentFeature.verifyBiologyLink(), assertFailurePreText + assertTextVG);
            reportLog(assertTextVG);

            assessmentFeature.clickOnBiologyLink();

            String assertTextVOG = "Presence Of 'Current Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyCurrentConceptText(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

            String assertTextVTPO = "Presence Of 'Change Concept ' Button";
            Assert.assertTrue(assessmentFeature.verifyChangeConceptButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Save Practice button After Selecting Concept.")
    public void verifyFunctionalityOfSaveConceptsButtons() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVPG = "Presence Of 'Save Concept' Button";
            Assert.assertTrue(assessmentFeature.verifySaveConceptButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            assessmentFeature.clickOnSaveConceptButton();

            String assertTextVTPG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify UI of Practice Modal.")
    public void verifyUIOfPracticeModal() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnViewQuiz();
            extentTest.log(LogStatus.PASS, "cliked on the View Quiz button.");

            String assertTextVPG = "Presence Of 'Estimated Time' Text";
            Assert.assertTrue(assessmentFeature.verifyEstimatedTimeText(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            String assertTextVTPG = "Presence Of 'Choose Different Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseDifferentPracticeButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVTPOG = "Presence Of 'Switch To Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifySwitchToQuizButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify View Practice Button Is Display After Adding Practice.")
    public void verifyViewPracticeButtonIsDisplayAfterAddingPractice() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVHI = "Presence Of 'Created Close Modal' Button";
            Assert.assertTrue(assessmentFeature.verifyCreatedModalityCloseModalIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            assessmentFeature.clickOnCreatedModalityCloseModalIcon();

            String assertTextVPG = "Presence Of 'View Practice' Button.";
            Assert.assertTrue(assessmentFeature.verifyViewPracticeButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

            assessmentFeature.clickOnViewPracticeButton();

            String assertTextVTTG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Choose Another Practice Button.")
    public void verifyFunctionalityOfChooseDifferentPracticeButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'Choose Different Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseDifferentPracticeButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnChooseDifferentPracticeButton();

            String assertTextVOG = "Presence Of 'Current Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyCurrentConceptText(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify User Can Not Add Same Concept Again.")
    public void verifyUserCanNotAddSameConceptAgain() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPO = "Presence Of 'Change Concept ' Button";
            Assert.assertTrue(assessmentFeature.verifyChangeConceptButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

            String assertTextVTPG = "Presence Of 'Save' Button";
            Assert.assertTrue(assessmentFeature.verifySaveButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify  Functionality Change Concept button.")
    public void verifyFunctionalityOfChangeConceptButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String subValue = "Chemistry";
            assessmentFeature.clickOnChangeConceptButton();

            String assertTextVTG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

            assessmentFeature.setValueSearchPlaceHolder(subValue);
            extentTest.log(LogStatus.PASS, "Entered the Chemistry value");

            assessmentFeature.clickOnSearchButton();
            extentTest.log(LogStatus.PASS, "Clicked on the Search Button.");

            Thread.sleep(15000);

            String assertTextVG = "Presence Of 'Chemistry' Link";
            Assert.assertTrue(assessmentFeature.verifyChemistryLink(), assertFailurePreText + assertTextVG);
            reportLog(assertTextVG);

            assessmentFeature.clickOnChemistryLink();

            String assertTextVOG = "Presence Of 'Current Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyCurrentConceptText(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

            String assertTextVTPO = "Presence Of 'Save Concept ' Button";
            Assert.assertTrue(assessmentFeature.verifySaveConceptButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

            assessmentFeature.clickOnSaveConceptButton();

            String assertTextVTTG = "Presence Of 'Preview' Button";
            Assert.assertTrue(assessmentFeature.verifyPreviewButton(), assertFailurePreText + assertTextVTTG);
            reportLog(assertTextVTTG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Switch To Quiz Button.")
    public void verifyFunctionalityOfSwitchToQuiz() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnViewQuiz();
            extentTest.log(LogStatus.PASS,"Clicked on the View Practice Button");

            String assertTextVTG = "Presence Of 'Switch To Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifySwitchToQuizButton(), assertFailurePreText + assertTextVTG);
            reportLog(assertTextVTG);

            assessmentFeature.clickOnSwitchToQuizButton();

            String assertTextVG = "Presence Of 'Chemistry' Link";
            Assert.assertTrue(assessmentFeature.verifyRefreshButton(), assertFailurePreText + assertTextVG);
            reportLog(assertTextVG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}