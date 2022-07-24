package testscripts.regression.studentlogin.LibraryFeature.EditFlexBookFeature;

import org.apache.log4j.Logger;
import org.testng.Assert;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentCBookEditAndDraftFunctionalityTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentCBookEditAndDraftFunctionalityTest.class);

    //@Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify  Functionality of 'Edit' PlaceHolder After Saving Modality Name")
    public void verifyFunctionalityOfDetailsPlaceHolder(String email, String password) {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            String courseBookTitle = "FlexBook_";
            String modality = "EnterModality";
            String contents = "content_";

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for Create CBook Using ChapterTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

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

            Assert.assertTrue(createFlexBookPage.verifyFlexBookTitle(), "Failed to verified FlexBook Title");
            reportLog("Successfully  verified FlexBook Title");

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            reportLog("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            reportLog("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            reportLog("Successfully verified Keep As Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog("Successfully verified Finalize Draft Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 2, description = "verify Functionality of 'Discard Draft' Button After Entering Contents In Edit PlaceHolder")
    public void verifyFunctionalityOfDiscardDraft() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDiscardDraftButton(), "Failed to verified Discard Draft Button.");
            reportLog("Successfully verified Discard Draft Button.");

            courseBookCreateEditAssignDelete.clickOnDiscardDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPermanentlyDiscardButton(), "Failed to verified Permanently Discard Button.");
            reportLog("Successfully verified Permanently Discard Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepEditingButton(), "Failed to verified Keep Editing Button.");
            reportLog("Successfully verified  Keep Editing Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 3, description = "verify Functionality of 'Keep Editing' Button After Clicking OnDiscard Draft Button")
    public void verifyFunctionalityOfKeepEditing() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnKeepEditingButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog("Successfully verified Finalize Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDiscardDraftButton(), "Failed to verified Discard Draft Button.");
            reportLog("Successfully verified Discard Draft Button.");

            courseBookCreateEditAssignDelete.clickOnDiscardDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPermanentlyDiscardButton(), "Failed to verified Permanently Discard Button.");
            reportLog("Successfully verified Permanently Discard Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepEditingButton(), "Failed to verified Keep Editing Button.");
            reportLog("Successfully verified  Keep Editing Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 4, description = "verify Functionality of 'Permanently Discard' Button After Clicking OnDiscard Draft Button")
    public void verifyFunctionalityOfPermanentlyDiscardButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality";
            String contents = "content_";

            courseBookCreateEditAssignDelete.clickOnPermanentlyDiscardButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfContents();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), "Failed to verified Content List.");
            reportLog("Successfully verified Content List.");

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
            reportLog("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            reportLog("Successfully verified Keep As Draft Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 5, description = "verify Functionality of 'Keep As Draft' Button After Entering Contents In Edit PlaceHolder")
    public void verifyFunctionalityKeepDraftButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "EnterModality";
            String contents = "content_";

            courseBookCreateEditAssignDelete.clickOnKeepDraftButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfDraftText();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentListDraftCount(), "Failed to verified Content List.");
            reportLog("Successfully verified Content List.");

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
            reportLog("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            reportLog("Successfully verified Keep As Draft Button.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 6, description = "verify Functionality of 'Finalize Draft' Button After Entering Contents In Edit PlaceHolder")
    public void verifyFunctionalityFinalizeDraftButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog("Successfully verified Finalize Draft Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContinueEditingButton(), "Failed to verified Continue Editing Button.");
            reportLog("Successfully verified Continue Editing Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            reportLog("Successfully verified Finalize Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 7, description = "verify Functionality of 'Continue Editing' Button After Clicking On Keep Finalize Draft Button")
    public void verifyFunctionalityContinueEditingButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnContinueEditingButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            reportLog("Successfully verified Finalize Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            reportLog("Successfully verified Keep As Draft Button.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 8, description = "verify Functionality of 'Finalize ' Button After Clicking On Finalize Draft Button ")
    public void verifyFunctionalityFinalizeButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String contents = "content_";

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            reportLog("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();
            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContinueEditingButton(), "Failed to verified Continue Editing Button.");
            reportLog("Successfully verified Continue Editing Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            reportLog("Successfully verified Finalize Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeButton();

//            Assert.assertTrue(createFlexBookPage.verifyDetailsText(), "Failed to verified Details Of Content.");
//            reportLog("Successfully verified Details Of Content.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }
}