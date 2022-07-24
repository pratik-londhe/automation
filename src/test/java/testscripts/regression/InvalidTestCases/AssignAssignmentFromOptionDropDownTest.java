package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class AssignAssignmentFromOptionDropDownTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AssignAssignmentFromOptionDropDownTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    private CoTeacherFeature coTeacherFeature;
    private CBookOptionDropDownFeatures cBookOptionDropDownFeatures;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Assign To Class Container Is Available Inside The Option DropDown'")
    public void verifyAssignToClassIsAvailable(String email, String password) {
        boolean result = true;
        try {
            cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver,extentTest,extentReports);
            coTeacherFeature = new CoTeacherFeature(webDriver,extentTest,extentReports);

            String url="https://flexbooks-master.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/scientific-investigation-bio";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver,extentTest,extentReports).verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            webDriver.navigate().to(url);

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyOptionsDropDown(), "Test Script Field to verify Options DropDown");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Options DropDown");
            logger.info("Teacher Successfully verify Options DropDown");

            cBookOptionDropDownFeatures.clickOnOptionsDropDown();

            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAddToFlexBookButton(), "Test Script Field to verify Add To FlexBook Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Add To FlexBook Button");
            logger.info("Teacher Successfully verify Add To FlexBook Button");

            String assertTextVSCB = "Presence of 'Assign To Class' button Of Option DropDown.";
            Assert.assertTrue(coTeacherFeature.verifyAssignButtonOfOptionDropDown(), assertFailurePreText + assertTextVSCB);
            reportLog(assertTextVSCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Assign To Class' Button After Clicking Options DropDown")
    public void verifyFunctionalityOfAssignToClassButton() {
        boolean result = true;
        try {
            coTeacherFeature.clickOnAssignButtonOfOptionDropDown();

            String assertTextVLNC = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(coTeacherFeature.verifyCk12ImageIcon(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            coTeacherFeature.clickOnCk12ImageIcon();

            String assertTextVLC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 5, description = "Verify Teacher Can Select 'Show Answer' Container before choosing class. ")
    public void verifyFunctionalitySendButtonWithInValidEmail() {
        boolean result = true;
        try {
            String assertTextVLNC = "Presence of 'Show Answer' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyShowAnswerText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            cBookOptionDropDownFeatures.getInitialColourBeforeSelectingShowAnswer();
            cBookOptionDropDownFeatures.clickOnShowAnswerContainer();

            String assertTextVLC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            String assertTextVC = "Presence of 'Show Answer' Is selected.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyShowAnswerIsSelected(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 7, description = "Verify All The Classes Are Present In the List Of Class Name. ")
    public void verifyAllClassesAreAvailable() {
        boolean result = true;
        try {
            String assertTextVLC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            cBookOptionDropDownFeatures.getCountOfClasses();

            String assertTextVC = "Presence of 'All Classes'.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAllClassesArePresent(), assertFailurePreText + assertTextVC);
            reportLog(assertTextVC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 9, description = "ClassName CheckBox is get selected when teacher select Due Date. ")
    public void verifyClassNAmeCheckBox() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver,extentTest,extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);

            courseBookCreateEditAssignDelete.clickOnDueDatePlaceHolder();
            cBookModalityPage.selectDueDate();

            String assertTextVLC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            String assertTextVLNC = "Presence of 'Assign Assignment Button Is Visible'.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAssignAssignmentButtonIsVisible(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 11, description = "Verify Assign Button is getting disable when className CheckBox is not selected but Due date is selected. ")
    public void verifyFunctionalityWhenClassNameCheckBoxIsNotSelected() {
        boolean result = true;
        try {
            String assertTextVLC = "Presence of 'CheckMark' Icon.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyCheckMarkIcon(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            cBookOptionDropDownFeatures.clickOnCheckMarkIcon();

            String assertTextVLNC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVL = "Presence of 'Class Name' CheckBox.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyClassNameCheckBox(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 12, description = "Verify Functionality Of ClassName CheckBox When Due Date Selected.")
    public void verifyFunctionalityOfClassNameCheckBox() {
        boolean result = true;
        try {
            String assertTextVLC = "Presence of 'Class Name' CheckBox.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyClassNameCheckBox(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

            cBookOptionDropDownFeatures.clickOnClassNameCheckBox();

            String assertTextVLNC = "Presence of 'Choose Classes' Text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyChooseClassesText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVNC = "Presence of 'Assign Assignment Button Is Visible'.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyAssignAssignmentButtonIsVisible(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 13, description = "Verify Assignment is assign through Option dropdown Of FlexBook Modality Page.")
    public void verifyAssignmentIsAssign() {
        boolean result = true;
        try {
            cBookOptionDropDownFeatures.clickOnAssignAssignmentButton();

            Assert.assertTrue(new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports).verifyGotItButton(), "Failed to verified Got It Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Got It Button.");
            logger.info("Successfully verified Got It Button.");

            new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports).clickOnGotItButton();

            Assert.assertTrue(new CBookModalityPage(webDriver,extentTest,extentReports).verifyAssignBtn(), "Failed to verified Assign Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Assign Button.");
            logger.info("Successfully verified Assign Button.");


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }

    @Test(priority = 15, description = "VVerify Assignment is Present In Assignment list And Delete Assignment.")
    public void verifyAssignmentInAssignmentList() {
        boolean result = true;
        try {
            CreateAnAssignment createAnAssignment =new CreateAnAssignment(webDriver,extentTest,extentReports);

            String url = "https://qa-flash.ck12.org/group-assignments/215307";

            webDriver.navigate().to(url);

            Assert.assertTrue(createAnAssignment.verifyClassAssignmentText(), "Failed to verify Class Assignment Text");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Class Assignment Text");
            logger.info("Teacher Successfully verify Class Assignment Text");

            Assert.assertTrue(new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports).verifyCreateAssignmentButton(), "Failed to verify Create An Assignment Button");
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

            Assert.assertTrue(createAnAssignment.verifyClassAssignmentText(), "Failed to verify Class Assignment Text");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Class Assignment Text");
            logger.info("Teacher Successfully verify Class Assignment Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Failed To Verify" + errorMessage);
    }
}