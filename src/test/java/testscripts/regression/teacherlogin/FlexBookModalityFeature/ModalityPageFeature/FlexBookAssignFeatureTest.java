/*
package testscripts.regression.teacherlogin.FlexBookModalityFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class FlexBookAssignFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FlexBookAssignFeatureTest.class);
    public CourseBookDetailsPage courseBookDetailsPage;
    public CBookModalityPage cBookModalityPage;
    CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;
    private TurnInFeature turnInFeature;
    public CBookLandingPage cBookLandingPage;
    public CreateAnAssignment createAnAssignment;
    public TeacherAddStudentInClass teacherAddStudentInClass;
    public AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Verify the Functionality of 'Assign' On FlexBook Modality Page")
    public void verifyUIFunctionalityOfAssignButton(String email, String password) {
        boolean result = true;
        try {
            courseBookDetailsPage = new CourseBookDetailsPage(webDriver,extentTest,extentReports);
            cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);
            cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);
            teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);
            assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver,extentTest,extentReports).clickOnStart();

            */
/*Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field ");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");
*//*

            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), "Test Script Field to verify Toc Icon");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Toc Icon");
            logger.info("Teacher Successfully verify Toc Icon");

            cBookModalityPage.clickOnAssignBtn();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCk12ClassRoomIcon(), "Failed to verified Ck12 ClassRoom Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ck12 ClassRoom Icon.");
            logger.info("Successfully verified Ck12 ClassRoom Icon.");

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyGoogleClassRoomIcon(), "Failed to verified Google ClassRoom Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Google ClassRoom Icon.");
            logger.info("Successfully verified Google ClassRoom Icon.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'Ck12 ClassRoom' Icon  After Clicking On Assign Button.")
    public void verifyFunctionalityOfCk12ClassRoomIcon() {
        boolean result = true;
        try {
            new CBookModalityPage(webDriver,extentTest,extentReports).clickOnAssignBtn();
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

    @Test(priority = 3, description = "Verify Functionality of 'Class Name' CheckBox Without Giving Due Date")
    public void assignFromModalityPageEmptyDueDate() {
        boolean result = true;
        try {
            cBookModalityPage.selectClasses();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyDueDateText(), "Failed to verified Due Date Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Due Date Text.");
            logger.info("Successfully verified Due Date Text.");

            courseBookCreateEditAssignDelete.getDueDateText();

//            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyRequiredDueDateText(), "Failed to verified Required Due Date Text.");
//            extentTest.log(LogStatus.PASS, "Successfully verified Required Due Date Text.");
//            logger.info("Successfully verified Required Due Date Text.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify user not able to select start date beyond due date.")
    public void assignFromModalityPageUsingCk12DisabledStartDate() {
        boolean result = true;
        try {
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

    @Test(priority = 5, description = "Verify Functionality Of 'Classes' CheckBox After Selecting Due Date")
    public void verifyFunctionalityOfClassesCheckBox() {
        boolean result = true;
        try {
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);

            cBookOptionDropDownFeatures.clickOnShowAnswerContainer();

            Assert.assertTrue(cBookModalityPage.verifyClassCheckBox(), "Failed to verified Class CheckBox.");
            extentTest.log(LogStatus.PASS, " successfully verified Class CheckBox.");
            logger.info("successfully verified Class CheckBox.");

            Assert.assertTrue(cBookModalityPage.verifyCreateAssignmentButton(), "Failed to verified Create assignment Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Create assignment Button.");
            logger.info("Successfully verified Create assignment Button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality Of 'Create Assignment' Button After Selecting Class CheckBox.")
    public void verifyFunctionalityOfCreateAssignmentButton() {
        boolean result = true;
        try {
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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyAssignmentInStudentAcc method : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Got It' Button After Selecting Class CheckBox.")
    public void verifyFunctionalityOfGotItButton() {
        boolean result = true;
        try {
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

    @Test(priority = 8, description = "Verify Functionality Of 'Already Assign' Button is present After Assigning")
    public void verifyFunctionalityOfAlreadyAssign() {
        boolean result = true;
        try {
            cBookModalityPage.clickOnAssignBtn();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCk12ClassRoomIcon(), "Failed to verified Ck12 ClassRoom Icon.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ck12 ClassRoom Icon.");
            logger.info("Successfully verified Ck12 ClassRoom Icon.");

            courseBookCreateEditAssignDelete.clickOnCk12ClassRoomIcon();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyAssignToClassText(), "Failed to verified Assign To Class Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Assign To Class Text.");
            logger.info("Successfully verified Assign To Class Text.");

            Assert.assertTrue(turnInFeature.verifyAlreadyAssignText(), "Failed to verified Already Assign Text.");
            extentTest.log(LogStatus.PASS, "Successfully verified Assign To Class Text.");
            logger.info("Successfully verified Already Assign Text.");

            webDriver.navigate().refresh();
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Assignment Present In the Class")
    public void verifyAssignment() {
        boolean result = true;
        try {
            String url = "https://master.ck12.org/group-assignments/575381";

            webDriver.navigate().to(url);

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            extentTest.log(LogStatus.PASS, "Successfully Verified Home Icon");
            logger.info("Teacher successfully Verified Home Icon");

            createAnAssignment.clickOnAssignmentButton();

            Assert.assertTrue(createAnAssignment.verifyClassAssignmentText(), "Failed to verify Class Assignment Text");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Class Assignment Text");
            logger.info("Teacher Successfully verify Class Assignment Text");

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), "Failed to verify Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Create An Assignment Button");
            logger.info("User Successfully verify Create An Assignment Button");

            createAnAssignment.clickOnAssignmentName();
            createAnAssignment.scrollUpScreen();

            Assert.assertTrue(createAnAssignment.verifyDeleteAssignmentButton(), "Failed to verify Delete Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Delete Assignment Button");
            logger.info("User Successfully verify Delete Assignment Button");

            createAnAssignment.clickOnDeleteAssignmentButton();

            Assert.assertTrue(createAnAssignment.verifyYesDeleteAssignmentButton(), "Failed to verify Yes Delete Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Yes Delete Assignment Button");
            logger.info("User Successfully verify Yes Delete Assignment Button");

            createAnAssignment.clickOnYesDeleteAssignmentButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyAssignmentInStudentAcc method : " + errorMessage);
    }
}*/
