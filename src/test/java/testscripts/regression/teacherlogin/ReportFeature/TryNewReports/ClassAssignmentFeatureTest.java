package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.AvailableAssignmentFeature;
import uipages.reports2feature.ClassAssignmentFeature;
import uipages.reports2feature.CreateAnAssignment;

public class ClassAssignmentFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ClassAssignmentFeatureTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the Functionality Of 'Assign' Button After Clicking on UnAssign link of Status DropDown")
    public void verifyFunctionalityOfAssignButton(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            String Url ="https://master.ck12.org/group-assignments/617042";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified Teacher User Profile.");
            extentTest.log(LogStatus.PASS, "Teacher Successfully logged in and verified profile icon.");
            logger.info("Teacher Successfully verify and verified icon as well");

            webDriver.navigate().to(Url);

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Create An Assignment Button");
            logger.info("User Successfully verified Create An Assignment Button");

            availableAssignmentFeature.clickOnAvailableAssignmentTab();

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Create An Assignment Button");
            logger.info("User Successfully verified Create An Assignment Button");

            Assert.assertTrue(classAssignmentFeature.verifyAssignAssignmentButton(), "Failed to verified Assign Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assign Button");
            logger.info("User Successfully verified Assign Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3,description = "Verify the Functionality Of 'Cancel' Button After Clicking on Assign Assignment Button")
    public void verifyFunctionalityOfCancelButton() {
        boolean result = true;
        try {
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            availableAssignmentFeature.getCountOfAssignmentBeforeCancel();
            classAssignmentFeature.clickOnAssignAssignmentButton();

            Assert.assertTrue(classAssignmentFeature.verifyCancelButton() ,"Failed to verified Cancel Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Button");
            logger.info("User Successfully verified Cancel Button");

            classAssignmentFeature.clickOnCancelButton();
            availableAssignmentFeature.getCountOfAssignmentAfterCancel();

            Assert.assertTrue(classAssignmentFeature.verifyAssignAssignmentButton(), "Failed to verified Assign Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assign Button");
            logger.info("User Successfully verified Assign Button");

            Assert.assertTrue(availableAssignmentFeature.verifyCountOfAssignmentAfterCancel() ,"Failed to verified Count Of Assignment After Cancel");
            extentTest.log(LogStatus.PASS, "User Successfully verified Count Of Assignment After Cancel");
            logger.info("User Successfully verified Count Of Assignment After Cancel");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5,description = "Verify the Functionality Of 'Due Date' PlaceHolder After Clicking on Assign Assignment Button")
    public void verifyFunctionalityOfDueDateButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.clickOnAssignAssignmentButton();

            Assert.assertTrue(classAssignmentFeature.verifyCancelButton() ,"Failed to verified Cancel Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Button");
            logger.info("User Successfully verified Cancel Button");

            Assert.assertTrue(classAssignmentFeature.verifyDueDatePlaceHolder(), "Failed to verified DueDate PlaceHolder");
            extentTest.log(LogStatus.PASS, "User Successfully verified DueDate PlaceHolder");
            logger.info("User Successfully verified DueDate PlaceHolder");

            classAssignmentFeature.SetValueInDueDatePlaceHolder();

            Assert.assertTrue(classAssignmentFeature.verifyAssignButton(), "Failed to verified Assign Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assign Button");
            logger.info("User Successfully verified Assign Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7,description = "Verify the Functionality Of 'Assign' Button After Clicking on Assign Assignment Button")
    public void verifyFunctionalityOfAssignButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.getTextOfAssignmentName();
            classAssignmentFeature.clickOnAssignButton();

            Assert.assertTrue(turnInFeature.verifyNoDueDateLink(), "Failed to verified No due Dropdown");
            extentTest.log(LogStatus.PASS, "User Successfully verified No due Dropdown");
            logger.info("User Successfully verified No due Dropdown");

            turnInFeature.clickOnNoDueDateLink();

            Assert.assertTrue(classAssignmentFeature.verifyAssignmentIsAvailableInTheClass(), "Failed to verified Assign Assignment Is Available In Class");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assign Assignment Is Available In Class");
            logger.info("User Successfully verified Assign Assignment Is Available In Class");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9,description = "Verify the Functionality Of 'Edit Title' Icon After Clicking on Assignment Name")
    public void verifyFunctionalityOfEditTitleButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);

            createAnAssignment.clickOnFirstAssignmentName();

            Assert.assertTrue(classAssignmentFeature.verifyInstructionText(), "Failed to verified Instruction Text");
            extentTest.log(LogStatus.PASS, "User Successfully verified Instruction Text");
            logger.info("User Successfully verified Instruction Text");

            Assert.assertTrue(classAssignmentFeature.verifyEditTitleIcon(), "Failed to verified Edit Title Icon");
            extentTest.log(LogStatus.PASS, "User Successfully verified Edit Title Icon");
            logger.info("User Successfully verified Edit Title Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11,description = "Verify the Functionality Of 'Description' PlaceHolder After Clicking on Edit Title Icon")
    public void verifyFunctionalityOfDescriptionPlaceHolder() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            String info="Important";

            classAssignmentFeature.clickOnEditTitleIcon();
            classAssignmentFeature.SetValueInInstructionPlaceHolder(info);
            classAssignmentFeature.clickOnEditTitleIcon();
            classAssignmentFeature.getTextOfDescription();

//            Assert.assertTrue(classAssignmentFeature.verifyDescriptionText(), "Failed to verified Description Text");
//            extentTest.log(LogStatus.PASS, "User Successfully verified Description Text");
//            logger.info("User Successfully verified Description Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13,description = "Verify the Functionality Of 'Edit ' Button After Clicking on Assignment Name")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.scrollUpScreen();

            Assert.assertTrue(classAssignmentFeature.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Edit Button");
            logger.info("User Successfully verified Edit Button");

            classAssignmentFeature.clickOnEditButton();

            Assert.assertTrue(classAssignmentFeature.verifyYesRemoveButton(), "Failed to verified Yes Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Yes Remove Button");
            logger.info("User Successfully verified Yes Remove Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 15,description = "Verify the Functionality Of 'Cancel Edit' Button After Clicking on Edit Button")
    public void verifyFunctionalityOfCancelEditButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            Assert.assertTrue(classAssignmentFeature.verifyCancelEditButton(), "Failed to verified Cancel Edit Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Edit Button");
            logger.info("User Successfully verified Cancel Edit Button");

            classAssignmentFeature.clickOnCancelEditButton();

            Assert.assertTrue(classAssignmentFeature.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Edit Button");
            logger.info("User Successfully verified Edit Button");

            classAssignmentFeature.clickOnEditButton();

            Assert.assertTrue(classAssignmentFeature.verifyContinueEditButton(), "Failed to verified Continue Edit Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Continue Edit Button");
            logger.info("User Successfully verified Continue Edit Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 17,description = "Verify the Functionality Of 'Continue Edit' Button After Clicking on Edit Button")
    public void verifyFunctionalityOfContinueEditButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);
            AssignAndCloseFeatureOnAssignment assignAndCloseFeatureOnAssignment = new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports);

            classAssignmentFeature.clickOnContinueEditButton();

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCloseButtonForClassAssignment(), "Failed to verified Close Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Close Button");
            logger.info("User Successfully verified Close Button");

            assignAndCloseFeatureOnAssignment.clickOnCloseButton();

            Assert.assertTrue(assignAndCloseFeatureOnAssignment.verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Create An Assignment Button");
            logger.info("User Successfully verified Create An Assignment Button");

            classAssignmentFeature.scrollUpScreen();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 19,description = "Verify the Functionality Of 'Undo Assign' Button After Clicking on Assignment")
    public void verifyFunctionalityOfUndoAssignButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.clickOnUndoAssignLink();

            Assert.assertTrue(classAssignmentFeature.verifyCancelRemoveButton(), "Failed to verified Cancel Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Cancel Remove Button");
            logger.info("User Successfully verified Cancel Remove Button");

            Assert.assertTrue(classAssignmentFeature.verifyYesRemoveButton(), "Failed to verified Yes Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Yes Remove Button");
            logger.info("User Successfully verified Yes Remove Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 21,description = "Verify the Functionality Of 'Cancel Undo Assign' Button After Clicking on Undo Assign Button")
    public void verifyFunctionalityOfCancelUndoAssignButton() {
        boolean result = true;
        try {
            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.clickOnCancelRemoveButton();

            Assert.assertTrue(classAssignmentFeature.verifyUndoAssignLink(), "Failed to verified Undo Assign Link");
            extentTest.log(LogStatus.PASS, "User Successfully verified Undo Assign Link");
            logger.info("User Successfully verified Undo Assign Link");

            classAssignmentFeature.clickOnUndoAssignLink();

            Assert.assertTrue(classAssignmentFeature.verifyYesRemoveButton(), "Failed to verified Yes Remove Button");
            extentTest.log(LogStatus.PASS, "User Successfully verify Yes Remove Button");
            logger.info("User Successfully verified Yes Remove Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 23,description = "Verify the Functionality Of 'Yes Undo Assign' Button After Clicking on Undo Assign Button")
    public void verifyFunctionalityOfYesUndoAssignButton() {
        boolean result = true;
        try {

            ClassAssignmentFeature classAssignmentFeature = new ClassAssignmentFeature(webDriver,extentTest,extentReports);
            AvailableAssignmentFeature availableAssignmentFeature = new AvailableAssignmentFeature(webDriver,extentTest,extentReports);

            classAssignmentFeature.getNameOfUndoAssignment();
            classAssignmentFeature.clickOnYesRemoveButton();

            Assert.assertTrue(new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports).verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            extentTest.log(LogStatus.PASS, "User Successfully verified Create An Assignment Button");
            logger.info("User Successfully verify verified An Assignment Button");

            availableAssignmentFeature.clickOnAvailableAssignmentTab();

            Assert.assertTrue(classAssignmentFeature.verifyAssignmentIsAvailableInTheAvailedClass(), "Failed to verified Assignment is Available in class");
            extentTest.log(LogStatus.PASS, "User Successfully verified Assignment is Available in class");
            logger.info("User Successfully verified Assignment is Available in class");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}