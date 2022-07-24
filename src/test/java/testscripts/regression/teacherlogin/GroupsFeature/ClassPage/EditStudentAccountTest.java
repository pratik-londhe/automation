package testscripts.regression.teacherlogin.GroupsFeature.ClassPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.EditStudentAccount;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.TeacherDashboardPage;

public class EditStudentAccountTest  extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(EditStudentAccountTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Teacher Can Edit Account if Teacher Is Creator of student account.")
    public void verifyEditAccountLinkIsVisible(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            String url = "https://master.ck12.org/group-members/632826";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'Add Student' Button";
            Assert.assertTrue(editStudentAccount.verifyAddStudentButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVODD = "Presence of 'Ellipsis ICon ' text.";
            Assert.assertTrue(editStudentAccount.verifySecondEllipsisIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.clickOnSecondEllipsisIcon();

            String assertTextVDD = "Presence of 'Edit Account ' Link.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountLink(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Teacher Can Not Edit Account If Teacher Is Not Creator Of student Account..")
    public void verifyTeacherCanNotEditAccount() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Ellipsis ICon ' text.";
            Assert.assertTrue(editStudentAccount.verifyFirstEllipsisIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.clickOnFirstEllipsisIcon();

            /*String assertTextVML = "Presence of Relative' Icon";
            Assert.assertTrue(editStudentAccount.verifyRelativeIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 5, description = "Verify Functionality Of Relative Icon of Anonymous Information .")
    public void verifyFunctionalityOfRelativeIcon() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            editStudentAccount.HoverOnRelativeIcon();

            String assertTextVODD = "Presence of 'This Action IS Only For Creator' text.";
            Assert.assertTrue(editStudentAccount.verifyThisActionISOnlyForCreatorText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'Ellipsis ICon ' text.";
            Assert.assertTrue(editStudentAccount.verifySecondEllipsisIcon(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            editStudentAccount.clickOnSecondEllipsisIcon();

            String assertTextVDD = "Presence of 'Edit Account ' Link.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountLink(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify UI Page Of Edit Account Page.")
    public void verifyUIPageOfEditAccount() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            editStudentAccount.clickOnEditAccountLink();

            String assertTextVODD = "Presence of 'Edit Account' text.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'Cancel ' Button.";
            Assert.assertTrue(editStudentAccount.verifyCancelButton(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Close Edit Account Icon.")
    public void verifyFunctionalityOfCloseEditAccountIcon() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of ' Close Edit Account' Icon.";
            Assert.assertTrue(editStudentAccount.verifyCloseEditAccountIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.clickOnCloseEditAccountIcon();

            String assertTextVOD = "Presence of 'Add Student ' Button.";
            Assert.assertTrue(editStudentAccount.verifyAddStudentButton(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            editStudentAccount.clickOnSecondEllipsisIcon();

            String assertTextVDD = "Presence of 'Edit Account ' Link.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountLink(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality OF USerName Icon.")
    public void verifyFunctionalityOfUserNameIcon() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            editStudentAccount.clickOnEditAccountLinkFirst();

            String assertTextVODD = "Presence of 'Edit Account' text.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountText(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            String assertTextVOD = "Presence of 'UserName ' Text.";
            Assert.assertTrue(editStudentAccount.verifyUserNameText(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            String assertTextVDD = "Presence of 'USerName Info ' Icon.";
            Assert.assertTrue(editStudentAccount.verifyUserNameInfoIcon(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            editStudentAccount.clickOnUserNameInfoIcon();

            String assertTextVML = "Presence of 'UserNAme Can Not Be Change' Text";
            Assert.assertTrue(editStudentAccount.verifyUserNameCanNotBeChangeText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Close Icon Of UserName Field.")
    public void verifyFunctionalityOfCloseUserNameIcon() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Close UserName Info' Icon.";
            Assert.assertTrue(editStudentAccount.verifyCloseUserNAmeInfoIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.clickOnCloseUserNameInfoIcon();

            String assertTextVDD = "Presence of 'Edit Account ' Text.";
            Assert.assertTrue(editStudentAccount.verifyEditAccountText(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            String assertTextVOD = "Presence of 'UserName ' Text.";
            Assert.assertTrue(editStudentAccount.verifyUserNameText(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Reset The Password Link.")
    public void verifyFunctionalityOfResetPassWordLink() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            String assertTextVODD = "Presence of 'Hidden' Icon.";
            Assert.assertTrue(editStudentAccount.verifyHiddenIcon(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.HoverOnHiddenIcon();

            String assertTextVDD = "Presence of 'ResetPassWordLink' Text.";
            Assert.assertTrue(editStudentAccount.verifyResetPasswordLink(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            editStudentAccount.clickOnResetPasswordLink();

            String assertTextVOD = "Presence of 'Discard Changes ' Link.";
            Assert.assertTrue(editStudentAccount.verifyDiscardChangesLink(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Discard Changes Link Of Password PlaceHolder.")
    public void verifyFunctionalityOfDiscardChangesLink() {
        boolean result = true;
        try {
            EditStudentAccount  editStudentAccount = new EditStudentAccount(webDriver,extentTest,extentReports);

            editStudentAccount.clickOnDiscardChangesLink();

            String assertTextVODD = "Presence of 'Update Password' Place Holder.";
            Assert.assertTrue(editStudentAccount.verifyUpdatePasswordPlaceHolder(), assertFailurePreText + assertTextVODD);
            reportLog(assertTextVODD);

            editStudentAccount.setValueInUpdatePasswordPlaceHolder();

            String assertTextVOD = "Presence of 'Discard Changes ' Link.";
            Assert.assertTrue(editStudentAccount.verifyDiscardChangesLink(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            editStudentAccount.clickOnDiscardChangesLink();

            String assertTextVDD = "Presence of 'Update Password' Place Holder.";
            Assert.assertTrue(editStudentAccount.verifyUpdatePasswordPlaceHolder(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}