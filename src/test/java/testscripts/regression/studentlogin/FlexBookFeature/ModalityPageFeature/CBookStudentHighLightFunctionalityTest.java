package testscripts.regression.studentlogin.FlexBookFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookStudentHighLightFunctionalityTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookStudentHighLightFunctionalityTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI page Of HighLight Feature")
    public void verifyFunctionalityOfHighlightButton(String email, String Password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            cBookPageStudent.clickOnStartCourseDetailButton();
            //new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept; link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

//            cBookModalityPage.clickOnNextConceptLink();
//
//            String assertTextVLPC = "Presence of 'Previous Concept' link.";
//            Assert.assertTrue(cBookModalityPage.verifyLinkOfPreviousConcept(), assertFailurePreText + assertTextVLPC);
//            reportLog("Student Successfully verify Previous Concept Link");

            String assertTextVHB = "Presence of 'Highlight' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyHighlightButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

            String assertTextVANB = "Presence of 'Add Note' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyAddNoteButton(), assertFailurePreText + assertTextVANB);
            reportLog(assertTextVANB);

            //cBookModalityPage.ScrollScreen();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Edit Items And Edit Colours' Icon After Highlight Some Text")
    public void verifyFunctionalityHighLightedText() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            String assertTextVTAH = "Presence of 'Yellow Shaded' text after highlighting.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyTextAfterHighlight(), assertFailurePreText + assertTextVTAH);
            reportLog(assertTextVTAH);

            cBookHighLightFunctionality.clickOnPageText();

            String assertTextVIC = "Presence of 'Colors' icon.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyIconOfColours(), assertFailurePreText + assertTextVIC);
            reportLog(assertTextVIC);

            String assertTextVET = "Presence of 'Edit' title button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyEditTitle(), assertFailurePreText + assertTextVET);
            reportLog(assertTextVET);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Edit Title' Button After Clicking On Highlighted Text")
    public void verifyFunctionalityOfAddNotesAnnotator() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            cBookHighLightFunctionality.clickOnEditTitle();

            String assertTextVCAB = "Presence of 'Cancel Annotation' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyCancelAnnotatorButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Cancel' Button After Clicking On Add Note Annotator")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            cBookHighLightFunctionality.clickOnCancelAnnotatorButton();

            String assertTextVTAH = "Presence of 'Yellow Shaded' text after highlighting.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyTextAfterHighlight(), assertFailurePreText + assertTextVTAH);
            reportLog(assertTextVTAH);

            cBookHighLightFunctionality.clickOnPageText();

            String assertTextVIC = "Presence of 'Colors' icon.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyIconOfColours(), assertFailurePreText + assertTextVIC);
            reportLog(assertTextVIC);

            String assertTextVET = "Presence of 'Edit' title button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyEditTitle(), assertFailurePreText + assertTextVET);
            reportLog(assertTextVET);

            cBookHighLightFunctionality.clickOnEditTitle();

            String assertTextVCAB = "Presence of 'Cancel Annotation' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyCancelAnnotatorButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality of 'Save' Button After Clicking On Add Note Annotator")
    public void verifyFunctionalityOfSaveButton() {
        boolean result = true;
        try {
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            String assertTextVSAB = "Presence of 'Save Annotation' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifySaveAnnotatorButton(), assertFailurePreText + assertTextVSAB);
            reportLog(assertTextVSAB);

            cBookHighLightFunctionality.clickOnSaveAnnotatorButton();

            String assertTextVTAH = "Presence of 'Yellow Shaded' text after highlighting.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyTextAfterHighlight(), assertFailurePreText + assertTextVTAH);
            reportLog(assertTextVTAH);

            new CBookLandingPage(webDriver, extentTest, extentReports).clickOnFeedBackIcon();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = " Verify Notes and Highlight button  is available inside Learning tools.")
    public void verifyNotesHighlightToolBarIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVLNC = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTI = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            String assertTextVHI = "Presence of 'Note And Highlight' icon.";
            Assert.assertTrue(openToolbarFeature.verifyNotesAndHighlightButton(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Functionality of 'Highlight' Icon On CourseBook Modality Toolbar")
    public void verifyFunctionalityOfHighlightIconInToolBar() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnNotesAndHighlightButton();

            String assertTextVHI = "Presence of 'Notes And Highlight' Text.";
            Assert.assertTrue(openToolbarFeature.verifyNotesAndHighlightText(), assertFailurePreText + assertTextVHI);
            reportLog(assertTextVHI);

            String assertTextVTHN = "Presence of 'Delete' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyDeleteIcon(), assertFailurePreText + assertTextVTHN);
            reportLog(assertTextVTHN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}