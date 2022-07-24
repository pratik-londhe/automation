package testscripts.regression.teacherlogin.GroupsFeature.CoTeacherFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AddCoTeacherInClassTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddCoTeacherInClassTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Plus' DropDown After Clicking On Classes Tab")
    public void verifyFunctionalityOfPlusDropDown(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            pageMenuTab.clickOnClassesTab();

            String assertTextVPD = "Presence of Plus DropDown";
            Assert.assertTrue(addCoTeacherInClass.verifyPlusDropDown(), assertFailurePreText + assertTextVPD);
            reportLog(assertTextVPD);

            addCoTeacherInClass.clickOnPlusDropDown();

            String assertTextVJCB = "Presence of Join Class Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinClassButton(), assertFailurePreText + assertTextVJCB);
            reportLog(assertTextVJCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'Join Class' Button After Clicking Plus DropDown")
    public void verifyFunctionalityJoinClassButton() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.clickOnJoinClassButton();

            String assertTextVJB = "Presence of Join  Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinButton(), assertFailurePreText + assertTextVJB);
            reportLog(assertTextVJB);

            String assertTextVCB = "Presence of Close Button";
            Assert.assertTrue(addCoTeacherInClass.verifyCloseButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            addCoTeacherInClass.clickOnCloseButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Cancel Join' Button After Clicking Join Class Button")
    public void verifyFunctionalityCancelJoinButton() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.getCountOfTotalNumberOfClassBefore();
            addCoTeacherInClass.clickOnJoinClassButton();

            String assertTextVJB = "Presence of Join  Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinButton(), assertFailurePreText + assertTextVJB);
            reportLog(assertTextVJB);

            String assertTextVJCB = "Presence of Join cancel Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinCancelButton(), assertFailurePreText + assertTextVJCB);
            reportLog(assertTextVJCB);

            addCoTeacherInClass.clickOnJoinCancelButton();

            addCoTeacherInClass.getCountOfTotalNumberOfClassAfter();

            String assertTextVCOCAC = "Count Of Classes After Clicking On Cancel Button";
            Assert.assertTrue(addCoTeacherInClass.verifyCountOfClassesAfterCancel(), assertFailurePreText + assertTextVCOCAC);
            reportLog(assertTextVCOCAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "verify Functionality of 'Join' Button With Invalid Class Code")
    public void verifyFunctionalityJoinButtonWithInvalidCode() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            String classCode = "vnji";

            addCoTeacherInClass.getCountOfTotalNumberOfClassBefore();
            addCoTeacherInClass.clickOnJoinClassButton();

            String assertTextVJB = "Presence of Join  Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinButton(), assertFailurePreText + assertTextVJB);
            reportLog(assertTextVJB);

            addCoTeacherInClass.clickOnJoinButton();

            String assertTextVET = "Error Text After Clicking On Join Button Without Giving Class Code";
            Assert.assertTrue(addCoTeacherInClass.verifyErrorText(), assertFailurePreText + assertTextVET);
            reportLog(assertTextVET);

            String assertTextVJBA = "Presence of Join  Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinButton(), assertFailurePreText + assertTextVJBA);
            reportLog(assertTextVJBA);

            addCoTeacherInClass.clickOnClassCodePlaceHolder(classCode);
            addCoTeacherInClass.clickOnJoinButton();

            String assertTextVJCB = "Presence of Join cancel Button";
            Assert.assertTrue(addCoTeacherInClass.verifyJoinCancelButton(), assertFailurePreText + assertTextVJCB);
            reportLog(assertTextVJCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Join' Button With Valid Class Code")
    public void verifyFunctionalityJoinButtonWithValidCode() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            String classCodeGamma = "vuyhq";
            String classCodeCk12 = "8dpef";
            String gammaUrl = "https://master.ck12.org/my/dashboard-new/groups/";
            String url = webDriver.getCurrentUrl();
            if (url.equalsIgnoreCase(gammaUrl)) {
                addCoTeacherInClass.clickOnClassCodePlaceHolder(classCodeGamma);
            } else {
                addCoTeacherInClass.clickOnClassCodePlaceHolder(classCodeCk12);
            }

            addCoTeacherInClass.clickOnJoinButton();
            addCoTeacherInClass.getCountOfTotalNumberOfClassAfter();

            String assertTextVCOCAJ = "Count Of Classes After Clicking On Join Button";
            Assert.assertTrue(addCoTeacherInClass.verifyCountOfClassesAfterJoin(), assertFailurePreText + assertTextVCOCAJ);
            reportLog(assertTextVCOCAJ);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "verify Teacher Is Now Become member Of Class")
    public void verifyFunctionalityClasses() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            SignOutPage signOutPage = new SignOutPage(webDriver,extentTest,extentReports);
            LoginPage loginPage = new LoginPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            String email = "teacher100+testuser@ck12.org";
            String pass = "fa1234";

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            addCoTeacherInClass.getTextOfTeacherName();
            signOutPage.clickOnUserProfileIcon();

            String assertTextVSO = "Presence of Sign Out Link After Clicking On Account Icon";
            Assert.assertTrue(signOutPage.verifySignOut(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            signOutPage.clickOnSignOut();

            loginPage.clickOnSignInLink();
            loginPage.login(email, pass);
            loginPage.clickOnBtnSignIn();

            String assertTextVTPGS = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPGS);
            reportLog(assertTextVTPGS);

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();

            String assertTextVMB = "Presence of Member Button Of Class UI Page";
            Assert.assertTrue(teacherAddStudentInClass.verifyMemberButton(), assertFailurePreText + assertTextVMB);
            reportLog(assertTextVMB);

            teacherAddStudentInClass.clickOnOkButton();
            teacherAddStudentInClass.clickOnMemberOption();

            String assertTextVTT = "Presence of Teacher Name Text";
            Assert.assertTrue(addCoTeacherInClass.verifyTeachersText(), assertFailurePreText + assertTextVTT);
            reportLog(assertTextVTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "verify Functionality of 'How Do Add CoTeacher' link  on Group Member page")
    public void verifyFunctionalityOfHowAddCoTeacherLink() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

            addCoTeacherInClass.clickOnHoWToAddCoTeacherLink();

            String assertTextVOB = "Presence of Ok Button.";
            Assert.assertTrue(addCoTeacherInClass.verifyOkButton(), assertFailurePreText + assertTextVOB);
            reportLog(assertTextVOB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "verify Functionality of 'Ok Button' After clicking How To Add CoTeacher link")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.clickOnOkButton();

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = " ")
    public void verifyFunctionalityOfMoreDropDown() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.scrollScreen();
            addCoTeacherInClass.clickOnMoreOptionDropDown();

            String assertTextVMKTL = "Presence of Make Co-Teacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyMakeCoTeacherLink(), assertFailurePreText + assertTextVMKTL);
            reportLog(assertTextVMKTL);

            String assertTextVRFCL = "Presence of Remove From Class link";
            Assert.assertTrue(addCoTeacherInClass.verifyRemoveFromClassLink(), assertFailurePreText + assertTextVRFCL);
            reportLog(assertTextVRFCL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "verify Functionality of 'Making CoTeacher' Link After Clicking More Option DropDown")
    public void verifyFunctionalityMakeCoTeacherLink() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.clickOnMakeCoTeacherLink();

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

            addCoTeacherInClass.clickOnMoreOptionDropDown();

            String assertTextVRCTL = "Presence of Remove Co-Teacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyRemoveCoTeacherLink(), assertFailurePreText + assertTextVRCTL);
            reportLog(assertTextVRCTL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "verify Functionality of 'Removing CoTeacher' Link After Clicking More Option DropDown")
    public void verifyFunctionalityRemovingCoTeacherLink() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.clickOnRemoveCoTeacherLink();

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

            String assertTextVTT = "Presence of Teachers Name Text";
            Assert.assertTrue(addCoTeacherInClass.verifyTeachersText(), assertFailurePreText + assertTextVTT);
            reportLog(assertTextVTT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 12, description = "verify Functionality of 'Cancel Removing CoTeacher From Class' Button After Clicking Remove From Class link")
    public void verifyFunctionalityCancel() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.getCountOfTotalMembersInClassBefore();
            addCoTeacherInClass.clickOnMoreOptionDropDown();
            addCoTeacherInClass.clickOnRemoveFromClassLink();

            String assertTextVRB = "Presence of Remove Button";
            Assert.assertTrue(addCoTeacherInClass.verifyRemoveButton(), assertFailurePreText + assertTextVRB);
            reportLog(assertTextVRB);

            String assertTextVCB = "Presence of Cancel Button";
            Assert.assertTrue(addCoTeacherInClass.verifyCancelButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            addCoTeacherInClass.clickOnCancelButton();

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

            addCoTeacherInClass.getCountOfTotalMembersInClassAfter();

            String assertTextVCOMAC = "Count Of Member After Clicking On Cancel Button Of Remove Co-Teacher Pop Up";
            Assert.assertTrue(addCoTeacherInClass.verifyCountOfMembersAfterCancel(), assertFailurePreText + assertTextVCOMAC);
            reportLog(assertTextVCOMAC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "verify Functionality of 'Remove CoTeacher From Class' Button After Clicking Remove From Class link")
    public void verifyFunctionalityRemove() {
        boolean result = true;
        try {
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver,extentTest,extentReports);

            addCoTeacherInClass.getCountOfTotalMembersInClassBefore();

            String assertTextVHTACL = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACL);
            reportLog(assertTextVHTACL);

            addCoTeacherInClass.clickOnMoreOptionDropDown();
            addCoTeacherInClass.clickOnRemoveFromClassLink();

            String assertTextVRB = "Presence of Remove Button";
            Assert.assertTrue(addCoTeacherInClass.verifyRemoveButton(), assertFailurePreText + assertTextVRB);
            reportLog(assertTextVRB);

            String assertTextVCB = "Presence of Cancel Button";
            Assert.assertTrue(addCoTeacherInClass.verifyCancelButton(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

            addCoTeacherInClass.clickOnRemoveButton();

            String assertTextVHTACLA = "Presence of How To Add CoTeacher link";
            Assert.assertTrue(addCoTeacherInClass.verifyLinkHowToAddCoTeacher(), assertFailurePreText + assertTextVHTACLA);
            reportLog(assertTextVHTACLA);

            addCoTeacherInClass.getCountOfTotalMembersInClassAfter();

            String assertTextVCOMAR = "Count Of Member After Clicking On Remove Button Of Remove Co-Teacher Pop Up";
            Assert.assertTrue(addCoTeacherInClass.verifyCountOfMembersAfterRemove(), assertFailurePreText + assertTextVCOMAR);
            reportLog(assertTextVCOMAR);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}