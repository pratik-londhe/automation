package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import testscripts.regression.studentlogin.GroupsFeature.JoinClassFeature.StudentClassPageTest;
import uipages.flexbook2feature.*;

public class ReportsTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ReportsTest.class);

    String student1;
    String student2;
    String student3;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Add Multiple Student' In The Class")
    public void AddThreeStudentInTheClass(String email, String Password) {
        boolean result = true;
        try {

            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

            String FirstName = "Student_+";
            String UserName = "testuser_";
            String Pass = "Student1";

            loginPage.clickOnSignInLink();
            loginPage.login(email, Password);
            loginPage.clickOnBtnSignIn();

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
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();

            Assert.assertTrue(teacherAddStudentInClass.verifyAddButton(), "Failed to verify Add Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Add Button");
            logger.info("Teacher successfully Verify Add Button");

            teacherAddStudentInClass.clickOnAddButton();
            teacherAddStudentInClass.clickOnAddButton();
            teacherAddStudentInClass.setFirstName1(FirstName);
            student1=teacherAddStudentInClass.setUniqueName1(UserName);
            teacherAddStudentInClass.setUserPassword1(Pass);
            teacherAddStudentInClass.setFirstName2(FirstName);
            student2=teacherAddStudentInClass.setUniqueName2(UserName);
            teacherAddStudentInClass.setUserPassword2(Pass);
           // teacherAddStudentInClass.setFirstName3(FirstName);
            //student3=teacherAddStudentInClass.setUniqueName3(UserName);
            //teacherAddStudentInClass.setUserPassword3(Pass);
            teacherAddStudentInClass.clickOnCreate();
            teacherAddStudentInClass.clickOnViewReport();
            teacherAddStudentInClass.studentAfterAdded();

            Assert.assertTrue(teacherAddStudentInClass.verifyTheStudentInfo(), "Failed to verify Currently Added Student Information");
            extentTest.log(LogStatus.PASS, "Successfully Verified Currently Added Student Information");
            logger.info("Teacher successfully Verified Currently Added Student Information");

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Home Icon");
            logger.info("Teacher successfully Verify Home Icon");

        } catch (Exception e) {
            result = handleException(e);

        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 2, description = "verify First Student Login Successfully")
    public void verifyFirstStudentLoginSuccessfully() {
        boolean result = true;
        try {

            String pass = "Pratikck12";

            //new SignOutPage(webDriver,extentTest,extentReports).teacherSignOut();
            new StudentClassPageTest().verifyHomeSection(student1,pass);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

   // @Test(priority = 3, description = "verify Assignment Is Visible For Newly Created First Student")
    public void verifyAssignmentIsVisibleForFirstStudent() {
        boolean result = true;
        try {

            new StudentClassPageTest().verifyAssignmentSection();
           // new StudentAssignmentPageTest().verifyFunctionalityOfAssignmentLink();

            } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    //@Test(priority = 4, description = "Student Solve  Assignment UpTo 30%")
    public void studentSolvingAssignmentUpTo30Percent() {
        boolean result = true;
        try {

            //new StudentAssignmentPageTest().verifyFunctionalityOfStartButton();
            //new StudentAssignmentPageTest().verifyFunctionalityOfStartPracticeButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
