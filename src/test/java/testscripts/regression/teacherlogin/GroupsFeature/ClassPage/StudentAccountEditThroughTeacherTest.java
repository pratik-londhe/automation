package testscripts.regression.teacherlogin.GroupsFeature.ClassPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class StudentAccountEditThroughTeacherTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentAccountEditThroughTeacherTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'More Option DropDown' Icon On UI Page of Teacher Members")
    public void verifyFunctionalityOfMoreOptionDropDown(String email, String password) {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            reportLog( "User Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();

            Assert.assertTrue(teacherAddStudentInClass.verifyMemberButton(), "Failed to verify Member Button");
            reportLog( "Successfully Verify Member Button");

            teacherAddStudentInClass.clickOnOkButton();
            teacherAddStudentInClass.clickOnMemberOption();
            studentAccountEditThroughTeacher.clickOnIconMoreOption();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkViewReports(), "Failed to verify Link View Reports");
            reportLog( "Teacher successfully Verify Link View Reports");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkEditAccount(), "Failed to verify Link Edit Account");
            reportLog( "Teacher Successfully Verify Link Edit Account");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkRemove(), "Failed to verify Link Remove");
            reportLog( "Successfully Verify Link Remove");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Edit Account' Link link After clicking More option DropDown Of Teacher Members UI Page")
    public void verifyFunctionalityEditAccounts() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.clickOnLinkEditAccount();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifySaveButton(), "Failed to verify Save Button");
            reportLog( "Teacher successfully Verify Save Button");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyCloseEditAccountIcon(), "Failed to verify Close Icon");
            reportLog( "Teacher Successfully Verify Close Icon");

            studentAccountEditThroughTeacher.clickOnIconCloseEditAccount();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMoreOptionDropDown(), "Failed to verify More Option DropDown");
            reportLog( "Teacher Successfully Verify More Option DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Cancel' Button Of Edit Member Account UI page")
    public void verifyFunctionalityCancelButtonOfEditAccount() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.getNameOfMemberBefore();
            studentAccountEditThroughTeacher.clickOnIconMoreOption();
            studentAccountEditThroughTeacher.clickOnLinkEditAccount();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifySaveButton(), "Failed to verify Save Button");
            reportLog( "Teacher successfully Verify Save Button");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyCancelEditAccountButton(), "Failed to verify Cancel Button of Edit Account ");
            reportLog( "Teacher successfully Verify Cancel Button of Edit Account");

            studentAccountEditThroughTeacher.clickOnButtonCancel();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMoreOptionDropDown(), "Failed to verify More Option DropDown");
            reportLog( "Teacher Successfully Verify More Option DropDown");

            studentAccountEditThroughTeacher.getNameOfMemberAfter();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyNamesAfterCancelButton(), "Failed to verify Names of Member  After Cancelling Edit Account ");
            reportLog( "Teacher Successfully Verify Names of Member  After Cancelling Edit Account");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Discard Changes' After Updating FirstName of Edit Account UI Page")
    public void verifyFunctionalityDiscardChange() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);

            String updateName = "Aestuser_";

            studentAccountEditThroughTeacher.getNameOfMemberBefore();
            studentAccountEditThroughTeacher.clickOnIconMoreOption();
            studentAccountEditThroughTeacher.clickOnLinkEditAccount();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifySaveButton(), "Failed to verify Save Button");
            reportLog( "Teacher successfully Verify Save Button");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyTxtUpdateFirstName(), "Failed to verify Update FirstName Box");
            reportLog( "Teacher successfully Verify Update FirstName Box");

            studentAccountEditThroughTeacher.getFirstNameBeforeEdit();
            studentAccountEditThroughTeacher.clickOnTextUpdateFirstName(updateName);

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkDiscardChanges(), "Failed to verify Link Discard Change");
            reportLog( "Teacher Successfully Verify Link Discard Change");

            studentAccountEditThroughTeacher.clickOnLinkDiscardChanges();
            studentAccountEditThroughTeacher.getFirstNameAfterEdit();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyFirstNameAfterDiscardChange(), "Failed to verify FirstName value after Discard Change");
            reportLog( "Teacher Successfully Verify FirstName value after Discard Change");

            studentAccountEditThroughTeacher.clickOnTextUpdateFirstName(updateName);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of 'Save Button' After Updating Invalid Password of Edit Account UI Page")
    public void verifyFunctionalityInvalidPassword() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);

            String updatePass = "Tea";

            studentAccountEditThroughTeacher.hoverIconInfoPassword();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkRestPassword(), "Failed to verify Reset Password Link");
            reportLog( "Teacher successfully Verify Reset Password Link");

            studentAccountEditThroughTeacher.clickOnLinkResetPassword();
            studentAccountEditThroughTeacher.clickOnTextUpdatePassword(updatePass);
            studentAccountEditThroughTeacher.clickOnSaveButton();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyTextErrorPassword(), "Failed to verify Error Password Text");
            reportLog( "Teacher successfully Verify Error Password Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Show Password And Hide Password' Link After clicking Reset Password Link of Edit Account UI Page")
    public void verifyFunctionalityShowAndHidePassword() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.clickOnShowPasswordLink();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyHidePasswordLink(), "Failed to verify Hide Password Link");
            reportLog( "Teacher Successfully Verify Hide Password Link");

            studentAccountEditThroughTeacher.clickOnHidePasswordLink();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyShowPasswordLink(), "Failed to verify Show Password Link");
            reportLog( "Teacher Successfully Verify Show Password Link");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Save Button' After Updating Valid Password of Edit Account UI Page")
    public void verifyFunctionalityValidPassword() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);

            String updatePass1 = "Tea";

            studentAccountEditThroughTeacher.clickOnTextUpdatePasswordAgain(updatePass1);
            studentAccountEditThroughTeacher.clickOnShowPasswordLink();
            studentAccountEditThroughTeacher.clickOnHidePasswordLink();
            studentAccountEditThroughTeacher.clickOnSaveButton();

            Assert.assertTrue(studentAccountEditThroughTeacher.VerifyUserNameAfterSave(), "Failed to verify Class Leader Text");
            reportLog( "Teacher Successfully Verify Class Leader Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality of 'Remove Student' link After clicking More option DropDown Of Teacher Members UI Page")
    public void verifyFunctionalityRemoveMemberLink() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.clickOnIconMoreOption();
            studentAccountEditThroughTeacher.clickOnLinkRemoveStudent();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyTextRemoveStudent(), "Failed to verify Text Delete Member");
            reportLog( "Teacher successfully Verify Text Delete Member");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyCloseRemoveIcon(), "Failed to verify Close Remove Member Icon");
            reportLog( "Teacher Successfully Verify Close Remove Member Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyRemoveButton(), "Failed to verify Delete Member Button");
            reportLog( "Teacher Successfully Verify Delete Member Button");

            studentAccountEditThroughTeacher.clickOnCloseRemoveButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMoreOptionDropDown(), "Failed to verify More Option DropDown");
            reportLog( "Teacher Successfully Verify More Option DropDown");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Cancel' Button Of Remove Member UI page")
    public void verifyFunctionalityCancelButton() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.getCountOfMemberBefore();
            studentAccountEditThroughTeacher.clickOnIconMoreOption();
            studentAccountEditThroughTeacher.clickOnLinkRemoveStudent();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyCancelButton(), "Failed to verify Cancel Button ");
            reportLog( "Teacher successfully Verify Cancel Button");

            studentAccountEditThroughTeacher.clickOnCancelButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMoreOptionDropDown(), "Failed to verify More Option DropDown");
            reportLog( "Teacher Successfully Verify More Option DropDown");

            studentAccountEditThroughTeacher.getCountOfMemberAfter();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMembersCountAfterCancel(), "Failed to verify Count of After Cancelling Remove Member");
            reportLog( "Teacher Successfully Verify Count of After Cancelling Remove Member");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality of 'Remove' Button Of Remove Member UI page")
    public void verifyFunctionalityOfRemoveMemberButton() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.getCountOfMemberBefore();
            studentAccountEditThroughTeacher.clickOnIconMoreOption();
            studentAccountEditThroughTeacher.clickOnLinkRemoveStudent();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyRemoveButton(), "Failed to verify Remove Button ");
            reportLog( "Teacher successfully Verify Remove Button");

            studentAccountEditThroughTeacher.clickOnDeleteStudentButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMoreOptionDropDown(), "Failed to verify More Option DropDown");
            reportLog( "Teacher Successfully Verify More Option DropDown");

            studentAccountEditThroughTeacher.getCountOfMemberAfter();

            Assert.assertTrue(studentAccountEditThroughTeacher.verifyMembersCountAfterRemoveMember(), "Failed to verify Count of After Remove Member");
            reportLog( "Teacher Successfully Verify Count of After Remove Member");

            studentAccountEditThroughTeacher.RemoveStudentRepeated();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality of 'View Reports' Link After clicking More option DropDown Of Teacher Members UI Page")
    public void verifyFunctionalityViewReports() {
        boolean result = true;
        try {
            StudentAccountEditThroughTeacher studentAccountEditThroughTeacher = new StudentAccountEditThroughTeacher(webDriver,extentTest,extentReports);

            studentAccountEditThroughTeacher.clickOnIconMoreOption();

           /* Assert.assertTrue(studentAccountEditThroughTeacher.verifyLinkViewReports(), "Failed to verify Link View Reports");
            reportLog( "Teacher successfully Verify Link View Reports");

            studentAccountEditThroughTeacher.clickOnLinkViewReports();
*/
//            Assert.assertTrue(new ReportsPageWithoutAssignmentTest(webDriver,extentTest,extentReports).verifyCreateAssignmentButton(), "Failed to verify Home icon.");
//            reportLog( "Presence of 'Create Assignment' button.");
//            logger.info("Presence of 'Create Assignment' button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}