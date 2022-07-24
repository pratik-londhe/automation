package testscripts.regression.teacherlogin.LibraryFeature.TeacherLibraryFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CbookAssignFromModalityPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CbookAssignFromModalityPageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Assign' Button After Saving Modality Name")
    public void verifyFunctionalityOfAssign(String email, String password) {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String courseBookTitle = "FlexBook_";
            String modality = "EnterModality";
            String contents = "content_";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), "Failed to verify user profile for CbookAssignFromModalityPageTest.");
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

            /*Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAddContentOptions(), "Failed to verified Add Content DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Add Content DropDown.");
            logger.info("Successfully verified Add Content DropDown.");

            courseBookCreateEditAssignDelete.clickOnAddContentDropDown();*/

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

            courseBookCreateEditAssignDelete.clickOnFinalizeButton();
            cBookModalityPage.clickOnAssignBtn();
*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 2, description = "Verify Functionality of 'Ck12 ClassRoom' Icon  After Clicking On Assign Button.")
    public void verifyFunctionalityOfCk12ClassRoomIcon() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            new CBookModalityPage(webDriver, extentTest, extentReports).clickOnAssignBtn();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCk12ClassRoomIcon(), "Failed to verified Ck12 ClassRoom Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ck12 ClassRoom Icon.");
            logger.info("Successfully verified Ck12 ClassRoom Icon.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyGoogleClassRoomIcon(), "Failed to verified Google ClassRoom Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Google ClassRoom Icon.");
            logger.info("Successfully verified Google ClassRoom Icon.");

            courseBookCreateEditAssignDelete.clickOnCk12ClassRoomIcon();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAssignToClassText(), "Failed to verified Assign To Class Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Assign To Class Text.");
            logger.info("Successfully verified Assign To Class Text.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyStartDateText(), "Failed to verified Start Date Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Start Date Text.");
            logger.info("Successfully verified Start Date Text.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDueDateText(), "Failed to verified Due Date Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Due Date Text.");
            logger.info("Successfully verified Due Date Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 3, description = "Verify Empty Due date field validation while Assigning CBook concept from modality page using CK12 platform option.")
    public void assignFromModalityPageEmptyDueDate() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            cBookModalityPage.selectClasses();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDueDateText(), "Failed to verified Due Date Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Due Date Text.");
            logger.info("Successfully verified Due Date Text.");

            courseBookCreateEditAssignDelete.getDueDateText();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyRequiredDueDateText(), "Failed to verified Required Due Date Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Required Due Date Text.");
            logger.info("Successfully verified Required Due Date Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 4, description = "Verify user not able to select start date beyond due date.")
    public void assignFromModalityPageUsingCk12DisabledStartDate() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            courseBookCreateEditAssignDelete.clickOnDueDatePlaceHolder();
            cBookModalityPage.selectDueDate();
            courseBookCreateEditAssignDelete.clickOnStartDatePlaceHolder();

            Assert.assertTrue(cBookModalityPage.verifyDisabledStartDate(), "Failed to verify disabled start date.");
            extentTest.log(LogStatus.PASS, "Start date displaying disabled beyond due date.");
            logger.info("Start date displaying disabled beyond due date.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 5, description = "Verify Functionality Of 'Classes' CheckBox After Selecting Due Date")
    public void verifyFunctionalityOfClassesCheckBox() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyShowAnswerButton(), "Failed to verified Show Answer Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Show Answer Button.");
            logger.info("Successfully verified Show Answer Button.");

            courseBookCreateEditAssignDelete.clickOnShowAnswerButton();

            Assert.assertTrue(cBookModalityPage.verifyClassCheckBox(), "Failed to verified Class CheckBox.");
            extentTest.log(LogStatus.PASS, " successfully verified Class CheckBox.");
            logger.info("successfully verified Class CheckBox.");

            // cBookModalityPage.selectClasses();

            Assert.assertTrue(cBookModalityPage.verifyCreateAssignmentButton(), "Failed to verified Create assignment Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Create assignment Button.");
            logger.info("Successfully verified Create assignment Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 6, description = "Verify Functionality Of 'Create Assignment' Button After Selecting Class CheckBox.")
    public void verifyFunctionalityOfCreateAssignmentButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyEditTitleIcon(), "Failed to verified Edit Title Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Edit Title Icon.");
            logger.info("Successfully verified Edit Title Icon.");

            courseBookCreateEditAssignDelete.clickOnEditTitleIcon();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyTitleText(), "Failed to verified Title Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Title Text.");
            logger.info("Successfully verified Title Text.");

            courseBookCreateEditAssignDelete.getValueOfTitleText();

            Assert.assertTrue(cBookModalityPage.verifyCreateAssignmentButton(), "Failed to verified Create assignment Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Create assignment Button.");
            logger.info("Successfully verified Create assignment Button.");

            cBookModalityPage.clickOnCreateAssignment();

//            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyTitleNameAfterAssign(), "Failed to verified Title Name After Assign.");
//            extentTest.log(LogStatus.PASS, "Successfully verified Title Name After Assign.");
//            logger.info("Successfully verified Title Name After Assign.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyAssignmentInStudentAcc method : " + errorMessage);
    }

    //@Test(priority = 7, description = "Verify Functionality Of 'Got It' Button After Selecting Class CheckBox.")
    public void verifyFunctionalityOfGotItButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyGotItButton(), "Failed to verified Got It Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Got It Button.");
            logger.info("Successfully verified Got It Button.");

            courseBookCreateEditAssignDelete.clickOnGotItButton();

            Assert.assertTrue(cBookModalityPage.verifyAssignBtn(), "Failed to verified Assign Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Assign Button.");
            logger.info("Successfully verified Assign Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyAssignmentInStudentAcc method : " + errorMessage);
    }
}