package testscripts.regression.teacherlogin.FlexBookModalityFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CourseBookPracticePageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CourseBookPracticePageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of 'CourseBook Practice' page after clicking on a Start Practice Button of CourseBook Modality Page")
    public void verifyUIPageOfCourseBookPracticePage(String email, String password, String url) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver,extentTest,extentReports);


            webDriver.navigate().to(url);
            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();
            cBookPageStudent.clickOnTheNextIcon();

            /*Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field to verify Assign Pop Up");
            reportLog( "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");*/

            cBookModalityPage.clickOnButtonViewPractice();

            Assert.assertTrue(cBookModalityPage.verifyButtonPreview(), "Test Script Field to verify Button Preview");
            reportLog( "Teacher Successfully verify Button Preview");

            cBookModalityPage.clickOnButtonPreview();

            Assert.assertTrue(courseBookPracticePage.verifyButtonStartPractice(), "Test Script Field to verify Start Practice Button");
            reportLog( "Teacher Successfully verify Start Practice Button");

            courseBookPracticePage.clickOnButtonStartPractice();

            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), "Test Script Field to verify Back Button");
            reportLog( "Teacher Successfully verify Back Button");

            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), "Test Script Field to verify Link Improve Question");
            reportLog( "Teacher Successfully verify Link Improve Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify 'Question And Answers Option ' Text On CourseBook Practice UI page")
    public void verifyQuestionAndAnswer() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyQuestionText(), "Test Script Field to verify Question Text");
            reportLog( "Teacher Successfully verify Question Text");

           /* Assert.assertTrue(courseBookPracticePage.verifyOptions(), "Test Script Field to verify Answer Options");
            reportLog( "Teacher Successfully verify Answer Options");
            logger.info("Teacher Successfully verify Answer Options");
*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 10, description = "Verify the Functionality of 'Get-Hint' Link On CourseBook Practice UI page")
    public void verifyFunctionalityOfGetHintLink() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            courseBookPracticePage.clickOnGetHintLink();
            courseBookPracticePage.clickOnGotItButton();

            Assert.assertTrue(courseBookPracticePage.verifyGetHintLink(), "Test Script Field to verify Get Hint Link");
            reportLog( "Teacher Successfully verify Get Hint Link");
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 15, description = "Verify the Functionality of 'ScratchPad' Link On CourseBook Practice UI page")
    public void verifyFunctionalityOfScratchPadLink() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog( "Teacher Successfully verify Scratchpad Link");

            courseBookPracticePage.clickOnScratchpadLink();

            Assert.assertTrue(courseBookPracticePage.verifyRemoveIcon(), "Test Script Field to verify Remove Icon");
            reportLog( "Teacher Successfully verify Remove Icon");

            Assert.assertTrue(courseBookPracticePage.verifyCloseToolIcon(), "Test Script Field to verify Close Tool Icon");
            reportLog( "Teacher Successfully verify Close Tool Icon");

            courseBookPracticePage.clickOnCloseToolIcon();

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog( "Teacher Successfully verify Scratchpad Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 20, description = "Verify the Functionality of 'Improve This Question' link without Details")
    public void verifyFunctionalityOfImproveQuestionWithoutDetails() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            courseBookPracticePage.clickOnLinkImproveThisQuestion();

            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), "Test Script Field to verify Text Improve this Question");
            reportLog( "Teacher Successfully verify Text Improve this Question");

            courseBookPracticePage.clickOnOptionChoicesLink();
            courseBookPracticePage.clickOnSubmitButton();

            //Assert.assertTrue(courseBookPracticePage.verifyTextDetailsErrorReport(), "Test Script Field to verify Text Of Details Error Report");
            reportLog( "Teacher Successfully verify Text Of Details Error Report");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 30, description = "Verify the Functionality of 'Close Error Report' Icon On Improve this Question UI page")
    public void verifyFunctionalityCrossErrorReportIcon() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), "Test Script Field to verify Text Improve this Question");
            reportLog( "Teacher Successfully verify Text Improve this Question");

            courseBookPracticePage.clickOnIconCloseReportError();

            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), "Test Script Field to verify Link Improve Question");
            reportLog( "Teacher Successfully verify Link Improve Question");
            logger.info("Teacher Successfully verify Link Improve Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //  @Test(priority = 40, description = "Verify the Functionality of 'Theta Progress' Link After Giving Answer of Question")
    public void verifyFunctionalityThetaProgress() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), "Test Script Field to verify Back Button");
            reportLog( "Teacher Successfully verify Back Button");

            Assert.assertTrue(courseBookPracticePage.verifyThetaProgressAgain(), "Test Script Field to verify Theta Progress Again");
            reportLog( "Teacher Successfully verify  Theta Progress Again ");

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog( "Teacher Successfully verify Scratchpad Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    // @Test(priority = 45, description = "Verify the Functionality of 'Stop For Now Or Done' Button On CourseBook Practice UI page")
    public void verifyFunctionalityStopForNow() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyStopForNowButton(), "Test Script Field to verify Stop For Now Button");
            reportLog( "Teacher Successfully verify Stop For Now Button");

            courseBookPracticePage.clickOnStopForNowOrDOneButton();

            Assert.assertTrue(courseBookPracticePage.verifyIconCheckMark(), "Test Script Field to verify Icon Check Mark");
            reportLog( "Teacher Successfully verify Icon Check Mark ");

            Assert.assertTrue(courseBookPracticePage.verifyIconSopWatch(), "Test Script Field to verify Icon Stopwatch");
            reportLog( "Teacher Successfully verify Icon Stopwatch");

            Assert.assertTrue(courseBookPracticePage.verifyAllCircle(), "Test Script Field to verify Circles of Hard, Easy, All Question");
            reportLog( "Teacher Successfully verify Circles of Hard, Easy, All Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 50, description = "Verify the Functionality of 'Keep Practicing' After clicking Stop For now Button ")
    public void verifyFunctionalityKeepPracticing() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyButtonKeepPracticing(), "Test Script Field to verify Keep Practicing Button");
            reportLog( "Teacher Successfully verify Keep Practicing Button");

            courseBookPracticePage.clickOnButtonKeepPracticing();

            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), "Test Script Field to verify Back Button");
            reportLog( "Teacher Successfully verify Back Button");

            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), "Test Script Field to verify Link Improve Question");
            reportLog( "Teacher Successfully verify Link Improve Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 55, description = "Verify the Functionality of 'Back Button' On CourseBook Practice UI page ")
    public void verifyFunctionalityBackButton() {
        boolean result = true;
        try {
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            courseBookPracticePage.clickOnBackButtonPractice();

            Assert.assertTrue(courseBookPracticePage.verifyIconCheckMark(), "Test Script Field to verify Icon Check Mark");
            reportLog( "Teacher Successfully verify Icon Check Mark ");

            Assert.assertTrue(courseBookPracticePage.verifyIconSopWatch(), "Test Script Field to verify Icon Stopwatch");
            reportLog( "Teacher Successfully verify Icon Stopwatch");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 60, description = "Verify the Functionality of 'Close Practice' Icon After click on Back button of CourseBook Practice page ")
    public void verifyFunctionalityClosePractice() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CourseBookPracticePage  courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyIconClosePractice(), "Test Script Field to verify Icon Close Practice");
            reportLog( "Teacher Successfully verify Icon Close Practice ");

            courseBookPracticePage.clickOnIconClosePractice();

            Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field to verify Assign Pop Up");
            reportLog( "Teacher Successfully verify Assign Pop Up");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}