package testscripts.regression.teacherlogin.FlexBookFeature.AssesmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AddPracticeInAssessmentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddPracticeInAssessmentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Add Assessment' tab is display if no Modality is added in the flex-book.")
    public void verifyAddAssessmentTabIsVisible(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String Url = "https://flexbooks-master.ck12.org/user:star/cbook/flexbook_1576740335479/r3/section/1.0/primary/lesson/entermodality1576740360155";
            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(Url);

            String assertTextVTPOG = "Presence Of 'Add Assessment' Button";
            Assert.assertTrue(assessmentFeature.verifyAddAssessmentButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Add Assessment' Tab of Modality Page")
    public void verifyFunctionalityOfAddAssessmentTab() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnAddAssessmentButton();

            String assertTextVTPOG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Cancel Report' Button";
            Assert.assertTrue(assessmentFeature.verifyCloseModalIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Close Modality Create' Icon.")
    public void verifyFunctionalityOfCloseModalIcon() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnCloseModalIcon();

            String assertTextVTPOG = "Presence Of 'Add Assessment' Button";
            Assert.assertTrue(assessmentFeature.verifyAddAssessmentButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnAddAssessmentButton();

            String assertTextVTPG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify 'Add Practice' and 'Add Quize' buttons are display on crete modality Modal.")
    public void verifyAddPracticeAndQuizButtonsAreVisible() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Add Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVTPG = "Presence Of 'Add Quiz' Button";
            Assert.assertTrue(assessmentFeature.verifyAddQuizButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Whats the Difference' Link.")
    public void verifyFunctionalityOfWhatsTheDifferenceLink() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Whats The Difference' Link";
            Assert.assertTrue(assessmentFeature.verifyWhatsTheDifferenceLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnWhatsTheDifferenceLink();

            String assertTextVTPG = "Presence Of 'Close What Difference' Button";
            Assert.assertTrue(assessmentFeature.verifyCloseWhatDifferenceButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVHI = "Presence Of 'quizzes' Text";
            Assert.assertTrue(assessmentFeature.verifyQuizzesText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVSO = "Presence Of 'Practice' Text.";
            Assert.assertTrue(assessmentFeature.verifyPracticeText(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'course modality whats the difference close' button.")
    public void verifyFunctionalityOfCloseButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            assessmentFeature.clickOnCloseWhatDifferenceButton();

            String assertTextVTPOG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVHI = "Presence Of 'Cancel Report' Button";
            Assert.assertTrue(assessmentFeature.verifyCloseModalIcon(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Add Practice' button.")
    public void verifyFunctionalityOfAddPracticeButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Add Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnAddPracticeButton();

//            String assertTextVTOG = "Presence Of 'Latest Version' Link";
//            Assert.assertTrue(assessmentFeature.verifyLatestVersionLink(), assertFailurePreText + assertTextVTOG);
//            reportLog(assertTextVTOG);

//            assessmentFeature.clickOnLatestVersionLink();

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
//            String assertTextVOG = "Presence Of 'Add Practice' Button";
//            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVOG);
//            reportLog(assertTextVOG);
//
//            assessmentFeature.clickOnAddPracticeButton();

            String assertTextVHI = "Presence Of 'Primary Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyPrimaryConceptText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVPG = "Presence Of 'Choose Concept' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseConceptButton(), assertFailurePreText + assertTextVPG);
            reportLog(assertTextVPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of 'Back Arrow' Icon.")
    public void verifyFunctionalityOfBackArrowIcon() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'BAck Arrow' Icon";
            Assert.assertTrue(assessmentFeature.verifyBackArrowIcon(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnBackArrowIcon();

            String assertTextVPOG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVTPO = "Presence Of 'Add Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

            assessmentFeature.clickOnAddPracticeButton();

            String assertTextVHI = "Presence Of 'Primary Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyPrimaryConceptText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Choose Concept' button.")
    public void verifyFunctionalityOfChooseConceptButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPG = "Presence Of 'Choose Concept' Button";
            Assert.assertTrue(assessmentFeature.verifyChooseConceptButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnChooseConceptButton();

            String assertTextVTPOG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of 'Search For Concept Close' Icon.")
    public void verifyFunctionalityOfSearchForConceptCloseIcon() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVPOG = "Presence Of 'Close Search' Icon";
            Assert.assertTrue(assessmentFeature.verifyCloseSearchIcon(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            assessmentFeature.clickOnCloseSearchIcon();

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

    @Test(priority = 21, description = "Verify Functionality Of Search Button With InValid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithInvalidData() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String placeholderText ="Ambrella";

            assessmentFeature.clickOnChooseConceptButton();

            String assertTextVTPOG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVPOG = "Presence Of 'Search' PlaceHolder";
            Assert.assertTrue(assessmentFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            assessmentFeature.setValueSearchPlaceHolder(placeholderText);

            String assertTextVTPG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnSearchButton();

            String assertTextVHI = "Presence Of 'Search Result For' Text";
            Assert.assertTrue(assessmentFeature.verifySearchResultForText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'No Data Found' Link.")
    public void verifyFunctionalityOfNoDataFoundLink() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'No Data Found' Link";
            Assert.assertTrue(assessmentFeature.verifyNoDataFoundLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnNoDataFoundLink();

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

    @Test(priority = 25, description = "Verify Functionality Of Search Button With Valid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithValidData() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String placeholderText ="You and the Environment";

            assessmentFeature.clickOnChooseConceptButton();

            String assertTextVTPOG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVPOG = "Presence Of 'Search' PlaceHolder";
            Assert.assertTrue(assessmentFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            assessmentFeature.setValueSearchPlaceHolder(placeholderText);

            String assertTextVTPG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            assessmentFeature.clickOnSearchButton();

            String assertTextVHI = "Presence Of 'Search Result For' Text";
            Assert.assertTrue(assessmentFeature.verifySearchResultForText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality Of Search Result Link.")
    public void verifyFunctionalityOfSearchResultLink() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Biology' Link";
            Assert.assertTrue(assessmentFeature.verifyBiologyLink(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnBiologyLink();

            String assertTextVPOG = "Presence Of 'Current Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyCurrentConceptText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVTPG = "Presence Of 'Save Concept' Button";
            Assert.assertTrue(assessmentFeature.verifySaveConceptButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify  Functionality 'Change Concept' button without saving any Concept.")
    public void verifyFunctionalityOfChangeConceptButton() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'Change Concept ' Button";
            Assert.assertTrue(assessmentFeature.verifyChangeConceptButton(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnChangeConceptButton();

            String assertTextVTPG = "Presence Of 'Search' Button";
            Assert.assertTrue(assessmentFeature.verifySearchButton(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            String assertTextVHI = "Presence Of 'Chemistry' Link";
            Assert.assertTrue(assessmentFeature.verifyChemistryLink(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            assessmentFeature.clickOnChemistryLink();

            String assertTextVPOG = "Presence Of 'Current Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyCurrentConceptText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify Functionality Of 'Back Arrow' Icon after Selecting Concept and Without Saving Concept.")
    public void verifyFunctionalityOfCBackArrowIconWithoutSavingConcept() {
        boolean result = true;
        try {
            AssessmentFeature assessmentFeature = new AssessmentFeature(webDriver,extentTest,extentReports);

            String assertTextVTPOG = "Presence Of 'BAck Arrow' Icon";
            Assert.assertTrue(assessmentFeature.verifyBackArrowIcon(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            assessmentFeature.clickOnBackArrowIcon();

            String assertTextVPOG = "Presence Of 'What Would Like To Add Text' Button";
            Assert.assertTrue(assessmentFeature.verifyWhatWouldLikeToAddText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVTPO = "Presence Of 'Add Practice' Button";
            Assert.assertTrue(assessmentFeature.verifyAddPracticeButton(), assertFailurePreText + assertTextVTPO);
            reportLog(assertTextVTPO);

            assessmentFeature.clickOnAddPracticeButton();

            String assertTextVHI = "Presence Of 'Primary Concept' Text";
            Assert.assertTrue(assessmentFeature.verifyPrimaryConceptText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTPG = "Not Presence Of 'Save Concept' Button";
            Assert.assertTrue(assessmentFeature.verifySaveConceptButtonIsNotAvailable(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}