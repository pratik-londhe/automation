package testscripts.regression.teacherlogin.ReportFeature.CreateAssignmentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class SaveAndDeleteAssignmentText extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SaveAndDeleteAssignmentText.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality Of 'Save' Button After Selecting Assignment")
    public void verifyFunctionalityOfSaveButton(String email, String password) {
        String assignmenURl = "https://master.ck12.org/group-assignments/617412";
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver, extentTest, extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver, extentTest, extentReports);
            Reports reports = new Reports(webDriver, extentTest, extentReports);
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            pageMenuTab.clickOnClassesTab();
            webDriver.navigate().to(assignmenURl);

            String assertTextVCAB = "Presence Of Create assignment button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            assignAndCloseFeatureOnAssignment.clickOnCreateAssignmentButton();
            createAnAssignment.clickOnIconCloseHeadsUp();

            String assertTextVCB = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            createAnAssignment.clickOnJoinPlusButton();

            String assertTextVCBA = "Presence Of close button.";
            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButton(), assertFailurePreText + assertTextVCBA);
            reportLog(assertTextVCBA);

            reports.clickOnFirstAssignmentCheckBox();

            String assertTextVSBB = "Presence Of Save Button.";
            Assert.assertTrue(reports.verifySaveButton(), assertFailurePreText + assertTextVSBB);
            reportLog(assertTextVSBB);

            reports.clickOnSaveButton();

            Assert.assertTrue(saveAndDeleteAssignment.verifySaveAssignmentButton(), "Failed to verify Save Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Save Assignment Button");
            logger.info("User Successfully verify Save Assignment Button");

            Assert.assertTrue(saveAndDeleteAssignment.verifyNameAssignmentText(), "Failed to verify Name Assignment Text");
            extentTest.log(LogStatus.PASS, "User Successfully verify Name Assignment Text");
            logger.info("User Successfully verify Name Assignment Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality Of 'Cancel Assignment' Button Clicking On Save Button")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            Reports reports = new Reports(webDriver, extentTest, extentReports);
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver, extentTest, extentReports);

            Assert.assertTrue(saveAndDeleteAssignment.verifyCancelAssignmentButton(), "Failed to verify Cancel Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Cancel Assignment Button");
            logger.info("User Successfully verify Cancel Assignment Button");

            saveAndDeleteAssignment.clickOnCancelAssignmentButton();

            String assertTextVSBB = "Presence Of Save Button.";
            Assert.assertTrue(reports.verifySaveButton(), assertFailurePreText + assertTextVSBB);
            reportLog(assertTextVSBB);

            reports.clickOnSaveButton();

            Assert.assertTrue(saveAndDeleteAssignment.verifySaveAssignmentButton(), "Failed to verify Save Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Save Assignment Button");
            logger.info("User Successfully verify Save Assignment Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality Of 'Save Assignment' Button Without Giving Assignment Name")
    public void verifyFunctionalityOfSaveButtonWithoutName() {
        boolean result = true;
        try {
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver, extentTest, extentReports);

            saveAndDeleteAssignment.clickOnSaveAssignmentButton();

            Assert.assertTrue(saveAndDeleteAssignment.verifySaveAssignmentButton(), "Failed to verify Save Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Save Assignment Button");
            logger.info("User Successfully verify Save Assignment Button");

            Assert.assertTrue(saveAndDeleteAssignment.verifyErrorText(), "Failed to verify Error Text");
            extentTest.log(LogStatus.PASS, "User Successfully verify Error Text");
            logger.info("User Successfully verify Error Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality Of 'Class Name' CheckBox After Clicking On Save Button")
    public void verifyFunctionalityOfClassNameCheckBox() {
        boolean result = true;
        try {
            Reports reports = new Reports(webDriver, extentTest, extentReports);

            Assert.assertTrue(reports.verifyClassNameCheckBox(), "Failed to verify ClassName CheckBox");
            extentTest.log(LogStatus.PASS, "User Successfully verify ClassName CheckBox");
            logger.info("User Successfully verify ClassName CheckBox");

            reports.clickOnClassNameCheckBox();

            Assert.assertTrue(reports.verifySaveAssignmentButton(), "Failed to verify Save Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Save Assignment Button");
            logger.info("User Successfully verify Save Assignment Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify the Functionality Of 'Save Assignment' Button With Assignment Name")
    public void verifyFunctionalityOfSaveButtonWithValidName() {
        boolean result = true;
        try {
            Reports reports = new Reports(webDriver, extentTest, extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver, extentTest, extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver, extentTest, extentReports);

            String name = "A";

            createAnAssignment.setAssignmentName(name);
            reports.clickOnSaveAssignmentButton();

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), "Failed to verify Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Create An Assignment Button");
            logger.info("User Successfully verify Create An Assignment Button");

            Assert.assertTrue(createAnAssignment.verifyNoDueDateIcon(), "Failed to verify No Due Date Icon");
            extentTest.log(LogStatus.PASS, "User Successfully verify No Due Date Icon");
            logger.info("User Successfully verify No Due Date Icon");

            createAnAssignment.clickOnNoDueDateIcon();

            Assert.assertTrue(createAnAssignment.verifyAssignmentIsAvailableInClass(), "Failed to verify Assignment Name in Class");
            extentTest.log(LogStatus.PASS, "User Successfully verify Assignment Name in Class");
            logger.info("User Successfully verify Assignment Name in Class");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Functionality Of 'No Due Date' Icon After Assigning Assignment to class")
    public void verifyFunctionalityOfNoDueDateIcon() {
        boolean result = true;
        try {
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver, extentTest, extentReports);
            SaveAndDeleteAssignment saveAndDeleteAssignment = new SaveAndDeleteAssignment(webDriver, extentTest, extentReports);

            createAnAssignment.clickOnFirstAssignmentName();

            Assert.assertTrue(saveAndDeleteAssignment.verifyUndoAssignLink(), "Failed to verify Undo Assignment Link");
            extentTest.log(LogStatus.PASS, "User Successfully verify Undo Assignment Link");
            logger.info("User Successfully verify Undo Assignment Link");

            createAnAssignment.scrollUpScreen();

            Assert.assertTrue(createAnAssignment.verifyDeleteAssignmentButton(), "Failed to verify Delete Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Delete Assignment Button");
            logger.info("User Successfully verify Delete Assignment Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify the Functionality of 'Delete Assignment' Button After clicking on Assignment Name")
    public void verifyFunctionalityOfDeleteAssignmentButton() {
        boolean result = true;
        try {
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver, extentTest, extentReports);

            createAnAssignment.getCountOfAssignmentBefore();
            createAnAssignment.clickOnDeleteAssignmentButton();

            Assert.assertTrue(createAnAssignment.verifyYesDeleteAssignmentButton(), "Failed to verify Yes Delete Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Yes Delete Assignment Button");
            logger.info("User Successfully verify Yes Delete Assignment Button");

            createAnAssignment.clickOnYesDeleteAssignmentButton();

            Assert.assertTrue(createAnAssignment.verifyClassAssignmentText(), "Failed to verify Class Assignment Text");
            extentTest.log(LogStatus.PASS, "User Successfully verify Class Assignment Text");
            logger.info("User Successfully verify  Class Assignment Text");

            Assert.assertTrue(createAnAssignment.verifyNoDueDateIcon(), "Failed to verify No Due Date Icon");
            extentTest.log(LogStatus.PASS, "User Successfully verify No Due Date Icon");
            logger.info("User Successfully verify No Due Date Icon");

            createAnAssignment.clickOnNoDueDateIcon();
            createAnAssignment.getCountOfAssignmentAfter();

            Assert.assertTrue(createAnAssignment.verifyCountOfAssignmentAfterDelete(), "Failed to verify Count Of Assignment Name After Delete Assignment");
            extentTest.log(LogStatus.PASS, "User Successfully verify Count Of Assignment Name After Delete Assignment");
            logger.info("User Successfully verify Count Of Assignment Name After Delete Assignment");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}