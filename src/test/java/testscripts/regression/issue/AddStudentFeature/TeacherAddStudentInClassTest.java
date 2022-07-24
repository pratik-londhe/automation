package testscripts.regression.issue.AddStudentFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.PageMenuTab;
import uipages.flexbook2feature.TeacherAddStudentInClass;
import uipages.flexbook2feature.TeacherDashboardPage;

public class TeacherAddStudentInClassTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherAddStudentInClassTest.class);
    TeacherDashboardPage teacherDashboardPage;
    PageMenuTab pageMenuTab;
    public TeacherAddStudentInClass teacherAddStudentInClass;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Without Email' on Add Student PopUp ")
    public void addStudentWithoutEmail(String email, String password) {
        boolean result = true;
        try {
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            String tempFirstName = "A_testuser";
            String tempUniqueNameAgain = "Student_";
            String tempPass = "Teacher1";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();

            Assert.assertTrue(teacherAddStudentInClass.verifyMemberButton(), "Failed to verify Member Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify Member Button");
            logger.info("Teacher successfully Verified Member Button");

            teacherAddStudentInClass.clickOnOkButton();
            teacherAddStudentInClass.clickOnMemberOption();
            teacherAddStudentInClass.verifyAddStudentButton();
            teacherAddStudentInClass.studentBeforeAdded();
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();
            teacherAddStudentInClass.setFirstName(tempFirstName);
            teacherAddStudentInClass.setUniqueName(tempUniqueNameAgain);
            teacherAddStudentInClass.setUserPassword(tempPass);
            teacherAddStudentInClass.clickOnCreate();
            teacherAddStudentInClass.clickOnViewReport();
            teacherAddStudentInClass.verifyAddStudentButton();
            teacherAddStudentInClass.studentAfterAdded();

            Assert.assertTrue(teacherAddStudentInClass.verifyTheStudentInfo(), "Failed to verify Currently Added Student Information");
            extentTest.log(LogStatus.PASS, "Successfully Verified Currently Added Student Information");
            logger.info("Teacher successfully Verified Currently Added Student Information");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "verify Functionality of 'Without Email' on Add Student PopUp and Provide Duplicate Unique Name")
    public void addStudentWithoutEmailButDuplicateUniqueName() {
        boolean result = true;
        try {
            String tempFirstName = "A_testuser";
            String tempPass = "Teacher1";
            String tempUniqueName = "stud1";

            teacherAddStudentInClass.studentBeforeAdded();
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();
            teacherAddStudentInClass.setFirstName(tempFirstName);
            teacherAddStudentInClass.setDuplicateUniqueName(tempUniqueName);
            teacherAddStudentInClass.setUserPassword(tempPass);
            teacherAddStudentInClass.clickOnCreate();

            Assert.assertTrue(teacherAddStudentInClass.verifyFixErrorsButton(), "Failed to verify Fixx Error Button.");
            extentTest.log(LogStatus.PASS, "Successfully Verified Fix Error Button");
            logger.info("Teacher successfully Verified Fix Error Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Fix Errors' Button on Add Student Without Email Page")
    public void fixErrors() {
        boolean result = true;
        try {
            String tempUniqueNameAgain = "Adent_";

            teacherAddStudentInClass.clickOnFixErrorsButton();
            teacherAddStudentInClass.setUniqueName(tempUniqueNameAgain);
            teacherAddStudentInClass.clickOnCreate();
            teacherAddStudentInClass.clickOnViewReport();
            teacherAddStudentInClass.studentAfterAdded();
            teacherAddStudentInClass.verifyAddStudentButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyTheStudentInfo(), "Failed to verify Currently Added Student Information");
            extentTest.log(LogStatus.PASS, "Successfully Verified Currently Added Student Information");
            logger.info("Teacher successfully Verified Currently Added Student Information");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Cross Bar' of Add Student Pop Up")
    public void crossBarIconOfAddStudentPopUp() {
        boolean result = true;
        try {
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnFindExistingButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyCrossBar(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "Successfully verify Cross Bar ");
            logger.info("Teacher successfully verify Cross Bar");

            teacherAddStudentInClass.clickOnCrossBar();
            teacherAddStudentInClass.verifyAddStudentButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11, description = "verify functionality  of 'Already Member' Link on Find Existing Page")

    public void checkAlreadyMember() {
        boolean result = true;
        try {
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnFindExistingButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyCrossBar(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "Successfully verify Cross Bar ");
            logger.info("Teacher successfully verify Cross Bar");

            Assert.assertTrue(teacherAddStudentInClass.verifyAlreadyInLibrary(), "Failed to verify Already In Library Link");
            extentTest.log(LogStatus.PASS, "Successfully verify Already In Library Link");
            logger.info(" successfully verify Already In Library Link");

            teacherAddStudentInClass.clickOnCrossBar();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13, description = "verify Functionality of 'Add with Mail' Link on Add Student PopUp")
    public void addWithEmailAddress() {
        boolean result = true;
        try {
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddWithEmail();

            Assert.assertTrue(teacherAddStudentInClass.verifyEmailIcon(), "Failed to verify Email Student Tab");
            extentTest.log(LogStatus.PASS, "Successfully Verify Email Student Tab");
            logger.info("Teacher successfully  Verify Email Student Tab");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}