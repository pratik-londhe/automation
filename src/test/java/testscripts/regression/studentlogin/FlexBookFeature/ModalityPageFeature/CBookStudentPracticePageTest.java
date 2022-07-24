package testscripts.regression.studentlogin.FlexBookFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookStudentPracticePageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookStudentPracticePageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of 'CourseBook Practice' page after clicking on a Start Practice Button of CourseBook Modality Page")
    public void verifyUIPageOfCBookPracticePage(String email, String Password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            webDriver.navigate().to("https://flexbooks-master.ck12.org/cbook/ck-12-interactive-middle-school-math-8-for-ccss/section/1.3/primary/lesson/properties-of-reflections-math-8-ccss-student-edition-msm8-ccss");
            //cBookPageStudent.clickOnStartCourseDetailButton();
            //new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            cBookModalityPage.clickOnNextConceptLink();

            String assertTextVSPB = "Presence of 'Start Practise' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartPracticeButton(), assertFailurePreText + assertTextVSPB);
            reportLog(assertTextVSPB);

            cBookPageStudent.clickOnStartPracticeButton();

            String assertTextVKPB = "Presence of 'Keep Practicing' button.";
            Assert.assertTrue(cBookPageStudent.verifyKeepPracticingButton(), assertFailurePreText + assertTextVKPB);
            reportLog(assertTextVKPB);

            cBookPageStudent.clickOnKeepPracticingButton();

            String assertTextVBSP = "Presence of 'Start Practice' button.";
            Assert.assertTrue(courseBookPracticePage.verifyButtonStartPractice(), assertFailurePreText + assertTextVBSP);
            reportLog(assertTextVBSP);

            courseBookPracticePage.clickOnButtonStartPractice();

            String assertTextVBB = "Presence of Back Button";
            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), assertFailurePreText + assertTextVBB);
            reportLog(assertTextVBB);

            String assertTextVLIQ = "Presence of 'Improve Question' link.";
            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), assertFailurePreText + assertTextVLIQ);
            reportLog(assertTextVLIQ);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify 'Question And Answers Option ' Text On CourseBook Practice UI page")
    public void verifyQuestionAndTheirAnswersOption() {
        boolean result = true;
        try {
//            String assertTextVQT = "Presence of 'Question' text.";
//            Assert.assertTrue(courseBookPracticePage.verifyQuestionText(), assertFailurePreText + assertTextVQT);
//            reportLog(assertTextVQT);

//            Assert.assertTrue(courseBookPracticePage.verifyOptions(), "Test Script Field to verify Answer Options");
//            reportLog("Teacher Successfully verify Answer Options");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Get-Hint' Link On CourseBook Practice UI page")
    public void verifyFunctionalityOfGetHintLink() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            courseBookPracticePage.clickOnGetHintLink();
            courseBookPracticePage.clickOnGotItButton();

            String assertTextVGHL = "Presence of ''Get Hint' link.";
            Assert.assertTrue(courseBookPracticePage.verifyGetHintLink(), assertFailurePreText + assertTextVGHL);
            reportLog(assertTextVGHL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'ScratchPad' Link On CourseBook Practice UI page")
    public void verifyFunctionalityOfScratchPadLink() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            String assertTextVSL = "Presence of 'Scratchpad' link.";
            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

            courseBookPracticePage.clickOnScratchpadLink();

            String assertTextVRI = "Presence of 'Remove' icon.";
            Assert.assertTrue(courseBookPracticePage.verifyRemoveIcon(), assertFailurePreText + assertTextVRI);
            reportLog(assertTextVRI);

            String assertTextVCTI = "Presence of 'Close Tool' icon.";
            Assert.assertTrue(courseBookPracticePage.verifyCloseToolIcon(), assertFailurePreText + assertTextVCTI);
            reportLog(assertTextVCTI);

            courseBookPracticePage.clickOnCloseToolIcon();

            String assertTextVSLA = "Presence of 'Scratchpad' link.";
            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), assertFailurePreText + assertTextVSLA);
            reportLog(assertTextVSLA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Improve This Question' link without Details")
    public void verifyFunctionalityOfImproveQuestionWithoutDetails() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            courseBookPracticePage.clickOnLinkImproveThisQuestion();

            String assertTextVTITQ = "Presence of 'Improve this question' text.";
            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), assertFailurePreText + assertTextVTITQ);
            reportLog(assertTextVTITQ);

            /*courseBookPracticePage.clickOnOptionChoicesLink();
            courseBookPracticePage.clickOnSubmitButton();

            String assertTextVTDER = "Presence of 'Details error report' text.";
            Assert.assertTrue(courseBookPracticePage.verifyTextDetailsErrorReport(), assertFailurePreText + assertTextVTDER);
            reportLog(assertTextVTDER);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Close Error Report' Icon On Improve this Question UI page")
    public void verifyFunctionalityCrossErrorReportIcon() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            String assertTextVTITQ = "Presence of 'Improve this question' text.";
            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), assertFailurePreText + assertTextVTITQ);
            reportLog(assertTextVTITQ);

            courseBookPracticePage.clickOnIconCloseReportError();

            String assertTextVLIQ = "Presence of 'Improve Question' link.";
            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), assertFailurePreText + assertTextVLIQ);
            reportLog(assertTextVLIQ);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 7, description = "Verify the Functionality of 'Theta Progress' Link After Giving Answer of Question")
    public void functionalityThetaProgress() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            String assertTextVTPA = "Presence of 'Theta progress again' element.";
            Assert.assertTrue(courseBookPracticePage.verifyThetaProgressAgain(), assertFailurePreText + assertTextVTPA);
            reportLog(assertTextVTPA);

            String assertTextVSL = "Presence of 'Scratchpad' link.";
            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), assertFailurePreText + assertTextVSL);
            reportLog(assertTextVSL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Stop For Now Or Done' Button On CourseBook Practice UI page")
    public void verifyFunctionalityStopForNowOrDoneButton() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            String assertTextVSFNB = "Presence of 'Stop for now' button.";
            Assert.assertTrue(courseBookPracticePage.verifyStopForNowButton(), assertFailurePreText + assertTextVSFNB);
            reportLog(assertTextVSFNB);

            //courseBookPracticePage.clickOnStopForNowOrDOneButton();

//            String assertTextVICM = "Presence of 'Check mark' icon.";
//            Assert.assertTrue(courseBookPracticePage.verifyIconCheckMark(), assertFailurePreText + assertTextVICM);
//            reportLog(assertTextVICM);
//
//            String assertTextVISW = "Presence of 'Stopwatch' icon.";
//            Assert.assertTrue(courseBookPracticePage.verifyIconSopWatch(), assertFailurePreText + assertTextVISW);
//            reportLog(assertTextVISW);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality of 'Keep Practicing' After clicking Stop For now Button")
    public void verifyFunctionalityKeepPracticingButton() {
        boolean result = true;
        try {
            /*String assertTextVBKP = "Presence of 'Keep Practicing' button.";
            Assert.assertTrue(courseBookPracticePage.verifyButtonKeepPracticing(), assertFailurePreText + assertTextVBKP);
            reportLog(assertTextVBKP);

            courseBookPracticePage.clickOnButtonKeepPracticing();

            String assertTextVBB = "Presence of Back Button";
            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), assertFailurePreText + assertTextVBB);
            reportLog(assertTextVBB);

            String assertTextVLIQ = "Presence of 'Improve Question' link.";
            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), assertFailurePreText + assertTextVLIQ);
            reportLog(assertTextVLIQ);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 10 , description = "Verify the Functionality of 'Back Button' On CourseBook Practice UI page ")
    public void functionalityBackButton() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);

            courseBookPracticePage.clickOnBackButtonPractice();

            String assertTextVICM = "Presence of 'Check mark' icon.";
            Assert.assertTrue(courseBookPracticePage.verifyIconCheckMark(), assertFailurePreText + assertTextVICM);
            reportLog(assertTextVICM);

            String assertTextVISW = "Presence of 'Stopwatch' icon.";
            Assert.assertTrue(courseBookPracticePage.verifyIconSopWatch(), assertFailurePreText + assertTextVISW);
            reportLog(assertTextVISW);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    // @Test(priority = 11 , description = "Verify the Functionality of 'Close Practice' Icon After click on Back button of CourseBook Practice page")
    public void verifyFunctionalityOfClosePracticeIcon() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);

            String assertTextVICP = "Presence of 'Close Practice' icon.";
            Assert.assertTrue(courseBookPracticePage.verifyIconClosePractice(), assertFailurePreText + assertTextVICP);
            reportLog(assertTextVICP);

            courseBookPracticePage.clickOnIconClosePractice();

            String assertTextVSPB = "Presence of 'Start Practice' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartPracticeButton(), assertFailurePreText + assertTextVSPB);
            reportLog(assertTextVSPB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}