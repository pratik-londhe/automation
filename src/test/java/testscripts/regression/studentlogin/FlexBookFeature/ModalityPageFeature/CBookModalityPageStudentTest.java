package testscripts.regression.studentlogin.FlexBookFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookModalityPageStudentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookModalityPageStudentTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of the 'CourseBook Modality' page after clicking on a Start Button of Student CourseBook Concept Page")
    public void verifyUIPageOfCBookModality(String email, String Password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            /*cBookPageStudent.clickOnStartCourseDetailButton();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();*/
            webDriver.navigate().to("https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-6-for-ccss-.%3a_/section/1.2/primary/lesson/pictures-of-ratios-math-6-ccss");

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Open' button is display in student Modality page.")
    public void verifyOpenToolbarIsVisible() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            String assertTextVLNC = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Open' button. ")
    public void verifyFunctionalityOfOpenToolbarButton() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver,extentTest,extentReports);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTI = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            String assertTextVLNC = "Presence of 'Close Toolbar' Button.";
            Assert.assertTrue(openToolbarFeature.verifyCloseToolbarButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            openToolbarFeature.clickOnCloseToolbarButton();

            String assertTextVTCN = "Presence of 'Open' Toolbar.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "Verify the Functionality of 'Start Practice' Button On CourseBook Modality Page")
    public void verifyFunctionalityOfStartPracticeButton() {
        boolean result = true;
        try {
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            String assertTextVSPB = "Presence of 'Start Practise' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartPracticeButton(), assertFailurePreText + assertTextVSPB);
            reportLog(assertTextVSPB);

            cBookPageStudent.clickOnStartPracticeButton();

            String assertTextVKPB = "Presence of 'Keep Practicing' button.";
            Assert.assertTrue(cBookPageStudent.verifyKeepPracticingButton(), assertFailurePreText + assertTextVKPB);
            reportLog(assertTextVKPB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 14, description = "Verify the Functionality of 'Next Concept' Link On CourseBook Modality Page")
    public void verifyFunctionalityOfNextConceptLink() {
        boolean result = true;
        try {
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);

            cBookPageStudent.getNameOfFirstConcept();
            cBookModalityPage.clickOnNextConceptLink();

            String assertTextVLPC = "Presence of 'Previous Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfPreviousConcept(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            cBookPageStudent.getNameOfSecondConcept();

            String assertTextVTCN = "Presence of 'Concept Name' text.";
            Assert.assertTrue(cBookPageStudent.verifyTextConceptName(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
    
    @Test(priority = 16, description = "Verify the Functionality of 'Previous Concept' Link On CourseBook Modality Page")
    public void verifyPreviousConceptLink() {
        boolean result = true;
        try {
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);

            cBookPageStudent.getNameOfSecondConcept();
            cBookModalityPage.clickOnPreviousConceptLink();

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            cBookPageStudent.getNameOfFirstConcept();

            String assertTextVTCN = "Presence of 'Concept Name' text.";
            Assert.assertTrue(cBookPageStudent.verifyTextConceptName(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}