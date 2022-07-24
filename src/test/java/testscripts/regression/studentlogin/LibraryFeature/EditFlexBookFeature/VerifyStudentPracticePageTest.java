package testscripts.regression.studentlogin.LibraryFeature.EditFlexBookFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.*;
import uipages.flexbook2feature.*;

public class VerifyStudentPracticePageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(VerifyStudentPracticePageTest.class);

    private BasePage basePage = new BasePage(webDriver,extentTest,extentReports);
    private final long timestamp = basePage.currentTimeStamp();
    CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
    public LibraryPage libraryPage;
    public CreateFlexBookPage createFlexBookPage;
    public CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;
    private CourseBookPracticePage courseBookPracticePage;
    private CBookPageStudent cBookPageStudent;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Start Practice button on modality page.")
    public void verifyStartPracticeButtonTest(String email, String password, String flxBookTitle, String searchConceptText) {
        boolean result = true;
        try {
            LibraryPage libraryPage = new LibraryPage(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent (webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for VerifyStudentPracticePageTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            libraryPage.clickOnLinkFlexBook();
            createFlexBookPage.clickOnGotItButtonPopUp();
            createFlexBookPage.enterCourseBookTitle(flxBookTitle + timestamp);
            //createFlexBookPage.clickOnAddContentBtn();
            createFlexBookPage.selectSearchCK12Option();
            createFlexBookPage.enterConceptAddLibrary(searchConceptText);
            createFlexBookPage.clickOnSearchButton();
            createFlexBookPage.selectConceptFromList();
            createFlexBookPage.clickOnAddConceptToFlexbook();
            createFlexBookPage.clickOnSaveBtn();
            new CourseDetailsPage(webDriver,extentTest,extentReports).clickOnConceptWithoutParentChapter();
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            /*Assert.assertTrue(cBookPageStudent.verifyStartPracticeButton(), "Failed to verify Presence of 'Start Practicing' button.");
            reportLog("Presence of 'Start Practicing' button.");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyStartPracticeButton method : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Practice tunnel page visibility.")
    public void verifyPracticeTunnelPage() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent (webDriver,extentTest,extentReports);

            new CBookPageStudent(webDriver,extentTest,extentReports).clickOnStartPracticeButton();

            Assert.assertTrue(cBookPageStudent.verifyKeepPracticingButton(), "Failed to verify Presence of 'Keep Practicing' button.");
            reportLog("Presence of 'Keep Practicing' button.");

            cBookPageStudent.clickOnKeepPracticingButton();

            courseBookPracticePage.verifyConfidentModelPopup();

            courseBookPracticePage.closeNewPracticeTunnelWalkthrough();

            Assert.assertTrue(courseBookPracticePage.verifyBackButtonPractice(), "Failed to verify back arrow icon in practice tunnel page.");
            reportLog("Back arrow icon is displaying in practice tunnel page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyPracticeTunnelPage method : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'ScratchPad' Link On CourseBook Practice UI page")
    public void verifyFunctionalityOfScratchPadLink() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog("Teacher Successfully verify Scratchpad Link");

            courseBookPracticePage.clickOnScratchpadLink();

            Assert.assertTrue(courseBookPracticePage.verifyRemoveIcon(), "Test Script Field to verify Remove Icon");
            reportLog("Teacher Successfully verify Remove Icon");

            Assert.assertTrue(courseBookPracticePage.verifyCloseToolIcon(), "Test Script Field to verify Close Tool Icon");
            reportLog("Teacher Successfully verify Close Tool Icon");

            courseBookPracticePage.clickOnCloseToolIcon();

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog("Teacher Successfully verify Scratchpad Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Improve This Question' link without Details")
    public void verifyFunctionalityOfImproveQuestionWithoutDetails() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            courseBookPracticePage.clickOnLinkImproveThisQuestion();

            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), "Test Script Field to verify Text Improve this Question");
            reportLog("Teacher Successfully verify Text Improve this Question");

            /*courseBookPracticePage.clickOnSubmitButton();

            Assert.assertTrue(courseBookPracticePage.verifyTextDetailsErrorReport(), "Test Script Field to verify Text Of Details Error Report");
            reportLog("Teacher Successfully verify Text Of Details Error Report");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Close Error Report' Icon On Improve this Question UI page")
    public void verifyFunctionalityCrossErrorReportIcon() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            //courseBookPracticePage.clickOnLinkImproveThisQuestion();

            Assert.assertTrue(courseBookPracticePage.verifyTextImproveThisQuestion(), "Test Script Field to verify Text Improve this Question");
            reportLog("Teacher Successfully verify Text Improve this Question");

            courseBookPracticePage.clickOnIconCloseReportError();

            Assert.assertTrue(courseBookPracticePage.verifyLinkImproveQuestion(), "Test Script Field to verify Link Improve Question");
            reportLog("Teacher Successfully verify Link Improve Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

   // @Test(priority = 7, description = "Verify the Functionality of 'Theta Progress' Link After Giving Answer of Question")
    public void verifyFunctionalityThetaProgress() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyBackButton(), "Test Script Field to verify Back Button");
            reportLog("Teacher Successfully verify Back Button");

            Assert.assertTrue(courseBookPracticePage.verifyThetaProgressAgain(), "Test Script Field to verify Theta Progress Again");
            reportLog("Teacher Successfully verify  Theta Progress Again ");

            Assert.assertTrue(courseBookPracticePage.verifyScratchpadLink(), "Test Script Field to verify Scratchpad Link");
            reportLog("Teacher Successfully verify Scratchpad Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Stop For Now Or Done' Button On CourseBook Practice UI page")
    public void verifyFunctionalityStopForNow() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent (webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyStopForNowButton(), "Test Script Field to verify Stop For Now Button");
            reportLog("Teacher Successfully verify Stop For Now Button");

            courseBookPracticePage.clickOnStopForNowOrDOneButton();


            Assert.assertTrue(cBookPageStudent.verifyKeepPracticingButton(), "Failed to verify Presence of 'Keep Practicing' button.");
            reportLog("Presence of 'Keep Practicing' button.");

//            Assert.assertTrue(courseBookPracticePage.verifyIconCheckMark(), "Test Script Field to verify Icon Check Mark");
//            reportLog("Teacher Successfully verify Icon Check Mark ");

//            Assert.assertTrue(courseBookPracticePage.verifyIconSopWatch(), "Test Script Field to verify Icon Stopwatch");
//            reportLog("Teacher Successfully verify Icon Stopwatch");
//
//            Assert.assertTrue(courseBookPracticePage.verifyAllCircle(), "Test Script Field to verify Circles of Hard, Easy, All Question");
//            reportLog("Teacher Successfully verify Circles of Hard, Easy, All Question");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 9, description = "Verify Start Practicing button gets changed to Keep Practicing on starting practice inside widget.")
    public void verifyKeepPracticingButton() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookPracticePage.verifyButtonKeepPracticing(), "Failed to verify Keep Practicing button.");
            reportLog("Keep Practicing button is displaying.");

            courseBookPracticePage.clickOnButtonKeepPracticing();

            Assert.assertTrue(courseBookPracticePage.verifyStopForNowButton(), "Failed to verify stop for now link on practice tunnel page.");
            reportLog("Stop for now link is displaying on practice tunnel page.");

            Assert.assertTrue(courseBookPracticePage.verifyBackButtonPractice(), "Failed to verify back arrow icon in practice tunnel page.");
            reportLog("Back arrow icon is displaying in practice tunnel page.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyKeepPracticingButton method : " + errorMessage);
    }

   // @Test(priority = 10, description = "Verify Start Practice button gets changed to Continue Practice on starting practice.")
    public void verifyClosePractice() {
        boolean result = true;
        try {
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent (webDriver,extentTest,extentReports);

            courseBookPracticePage.clickOnBackButtonPractice();
            courseBookPracticePage.clickOnIconClosePractice();

            Assert.assertTrue(cBookPageStudent.verifyStartPracticeButton(), "Failed to verify Presence of 'Start Practicing' button.");
            reportLog("Presence of 'Start Practicing' button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyClosePractice method : " + errorMessage);
    }

   // @Test(priority = 11, description = "Verify Start Practice button gets changed to Continue Practice on starting practice.")
    public void verifyContinuePracticeButton() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CourseBookPracticePage courseBookPracticePage = new CourseBookPracticePage(webDriver,extentTest,extentReports);

            cBookModalityPage.clickOnContinuePractice();

            Assert.assertTrue(courseBookPracticePage.verifyButtonKeepPracticing(), "Failed to verify Keep Practice button.");
            reportLog("Keep Practicing button is displaying.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyContinuePracticeButton method : " + errorMessage);
    }
}