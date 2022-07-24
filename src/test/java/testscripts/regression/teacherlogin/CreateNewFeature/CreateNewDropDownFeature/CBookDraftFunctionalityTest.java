package testscripts.regression.teacherlogin.CreateNewFeature.CreateNewDropDownFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CBookDraftFunctionalityTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookDraftFunctionalityTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify  Functionality of 'Edit' PlaceHolder After Saving Modality Name")
    public void verifyFunctionalityOfDetailsPlaceHolder(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String courseBookTitle = "FlexBook_";
            String modality = "EnterModality";
            String contents = "content_";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFlexBook2Link(), "Failed to verified FlexBook2 Link.");
            extentTest.log(LogStatus.PASS, "Successfully verified FlexBook2 Link.");
            logger.info("Successfully verified FlexBook2 Link.");

            courseBookCreateEditAssignDelete.clickOnFlexBook2Link();
            createFlexBookPage.clickOnGotItButtonPopUp();
            createFlexBookPage.enterCourseBookTitle(courseBookTitle);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            /*Assert.assertTrue(createFlexBookPage.verifyFlexBookTitle(), "Failed to verified FlexBook Title");
            extentTest.log(LogStatus.PASS, "Successfully  verified FlexBook Title");
            logger.info("Successfully verified FlexBook Title");

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            extentTest.log(LogStatus.PASS, "Successfully  verified Details Tab");
            logger.info("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Keep As Draft Button.");
            logger.info("Successfully verified Keep As Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Draft Button.");
            logger.info("Successfully verified Finalize Draft Button.");*/

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

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDiscardDraftButton(), "Failed to verified Discard Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Discard Draft Button.");
            logger.info("Successfully verified Discard Draft Button.");

            courseBookCreateEditAssignDelete.clickOnDiscardDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPermanentlyDiscardButton(), "Failed to verified Permanently Discard Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Permanently Discard Button.");
            logger.info("Successfully verified Permanently Discard Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepEditingButton(), "Failed to verified Keep Editing Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified  Keep Editing Button.");
            logger.info("Successfully verified Keep Editing Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

   // @Test(priority = 3, description = "verify Functionality of 'Keep Editing' Button After Clicking OnDiscard Draft Button")
    public void verifyFunctionalityOfKeepEditing() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnKeepEditingButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Draft Button.");
            logger.info("Successfully verified Finalize Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDiscardDraftButton(), "Failed to verified Discard Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Discard Draft Button.");
            logger.info("Successfully verified Discard Draft Button.");

            courseBookCreateEditAssignDelete.clickOnDiscardDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyPermanentlyDiscardButton(), "Failed to verified Permanently Discard Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Permanently Discard Button.");
            logger.info("Successfully verified Permanently Discard Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepEditingButton(), "Failed to verified Keep Editing Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified  Keep Editing Button.");
            logger.info("Successfully verified Keep Editing Button.");

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
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            String modality = "EnterModality";
            String contents = "content_";

            courseBookCreateEditAssignDelete.clickOnPermanentlyDiscardButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfContents();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentList(), "Failed to verified Content List.");
            extentTest.log(LogStatus.PASS, "Successfully verified Content List.");
            logger.info("Successfully verified Content List.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            extentTest.log(LogStatus.PASS, "Successfully  verified Details Tab");
            logger.info("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Keep As Draft Button.");
            logger.info("Successfully verified Keep As Draft Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

   // @Test(priority = 5, description = "verify Functionality of 'Keep As Draft' Button After Entering Contents In Edit PlaceHolder")
    public void verifyFunctionalityKeepDraftButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            String modality = "EnterModality";
            String contents = "content_";

            courseBookCreateEditAssignDelete.clickOnKeepDraftButton();
            createFlexBookPage.clickOnGotItButtonPopUp();
            courseBookCreateEditAssignDelete.getCountOfDraftText();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContentListDraftCount(), "Failed to verified Content List.");
            extentTest.log(LogStatus.PASS, "Successfully verified Content List.");
            logger.info("Successfully verified Content List.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyNewReadLink(), "Failed to verified New Read Link.");
            extentTest.log(LogStatus.PASS, "Successfully  New Read Link.");
            logger.info("Successfully verified New Read Link.");

            courseBookCreateEditAssignDelete.clickOnNewReadLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            Assert.assertTrue(createFlexBookPage.verifySaveModalityButton(), "Failed to verified Save Modality Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Save Modality Button.");
            logger.info("Successfully verified Save Modality Button.");

            createFlexBookPage.enterModalityName(modality);
            createFlexBookPage.clickOnSaveModality();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            extentTest.log(LogStatus.PASS, "Successfully  verified Details Tab");
            logger.info("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Keep As Draft Button.");
            logger.info("Successfully verified Keep As Draft Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

   // @Test(priority = 6, description = "verify Functionality of 'Finalize Draft' Button After Entering Contents In Edit PlaceHolder")
    public void verifyFunctionalityFinalizeDraftButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Draft Button.");
            logger.info("Successfully verified Finalize Draft Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContinueEditingButton(), "Failed to verified Continue Editing Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Continue Editing Button.");
            logger.info("Successfully verified Continue Editing Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Button.");
            logger.info("Successfully verified Finalize Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 7, description = "verify Functionality of 'Continue Editing' Button After Clicking On Keep Finalize Draft Button")
    public void verifyFunctionalityContinueEditingButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            courseBookCreateEditAssignDelete.clickOnContinueEditingButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeDraftButton(), "Failed to verified Finalize Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Draft Button.");
            logger.info("Successfully verified Finalize Draft Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyKeepDraftButton(), "Failed to verified Keep As Draft Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Keep As Draft Button.");
            logger.info("Successfully verified Keep As Draft Button.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    //@Test(priority = 8, description = "verify Functionality of 'Finalize ' Button After Clicking On Finalize Draft Button ")
    public void verifyFunctionalityFinalizeButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);

            String contents = "content_";

            Assert.assertTrue(createFlexBookPage.verifyDetailsTab(), "Failed to verified Details Tab");
            extentTest.log(LogStatus.PASS, "Successfully  verified Details Tab");
            logger.info("Successfully  verified Details Tab");

            createFlexBookPage.clickOnDetailsTab();
            createFlexBookPage.enterDetailsForModality(contents);
            createFlexBookPage.clickOnLearningObjectivePlaceHolder();
            courseBookCreateEditAssignDelete.clickOnFinalizeDraftButton();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyContinueEditingButton(), "Failed to verified Continue Editing Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Continue Editing Button.");
            logger.info("Successfully verified Continue Editing Button.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyFinalizeButton(), "Failed to verified Finalize Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Finalize Button.");
            logger.info("Successfully verified Finalize Button.");

            courseBookCreateEditAssignDelete.clickOnFinalizeButton();

//            Assert.assertTrue(new CBookModalityPage(webDriver,extentTest,extentReports).verifyAssignBtn(), "Failed to verified Assign Button.");
//            extentTest.log(LogStatus.PASS, "Successfully verified Assign Button.");
//            logger.info("Successfully verified Assign Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }
}
