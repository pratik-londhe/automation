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

public class TeacherAddMultipleStudentInClassTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherAddMultipleStudentInClassTest.class);

    public LoginPage loginPage;
    TeacherDashboardPage teacherDashboardPage;
    PageMenuTab pageMenuTab;
    public TeacherAddStudentInClass teacherAddStudentInClass;

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Functionality of 'Add Button' on Add Student PopUp ")
    public void verifyFunctionalityOfAddButton(String email, String Password) {
        boolean result = true;
        try {
            loginPage = new LoginPage(webDriver,extentTest, extentReports);
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);

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
            teacherAddStudentInClass.verifyAddStudentButton();
            teacherAddStudentInClass.studentBeforeAdded();
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();

            Assert.assertTrue(teacherAddStudentInClass.verifyAddButton(), "Failed to verify Add Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Add Button");
            logger.info("Teacher successfully Verify Add Button");

            teacherAddStudentInClass.clickOnAddButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyFirstName2(), "Failed to verify FirstName2 Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify FirstName2 Text");
            logger.info("Teacher successfully Verify FirstName2 Text");

            Assert.assertTrue(teacherAddStudentInClass.verifyUserName2(), "Failed to verify UserName2 Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify UserName2 Text");
            logger.info("Teacher successfully Verify UserName2 Text");

            Assert.assertTrue(teacherAddStudentInClass.verifyPassword2(), "Failed to verify Password2 Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify Password2 Text");
            logger.info("Teacher successfully Verify Password2 Text");

            Assert.assertTrue(teacherAddStudentInClass.verifyCrossBar(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "Successfully verify Cross Bar ");
            logger.info("Teacher successfully verify Cross Bar");

            teacherAddStudentInClass.clickOnCrossBar();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "verify Functionality of 'Create Button' After Giving All Student Invalid Information")
    public void verifyFunctionalityCreateButtonWithInvalidData() {
        boolean result = true;
        try {
            String firstName = "pra_";
            String userName = "pra_";
            String userName1 = "Pratik1";
            String pass = "Teacher1";

            teacherAddStudentInClass.verifyAddStudentButton();

            teacherAddStudentInClass.studentBeforeAdded();
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();

            Assert.assertTrue(teacherAddStudentInClass.verifyAddButton(), "Failed to verify Add Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Add Button");
            logger.info("Teacher successfully Verify Add Button");

            teacherAddStudentInClass.clickOnAddButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyFirstName2(), "Failed to verify FirstName2 Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify FirstName2 Text");
            logger.info("Teacher successfully Verify FirstName2 Text");

            teacherAddStudentInClass.setFirstName1(firstName);
            teacherAddStudentInClass.setDuplicateUniqueName1(userName1);
            teacherAddStudentInClass.setUserPassword1(pass);
            teacherAddStudentInClass.setFirstName2(firstName);
            teacherAddStudentInClass.setDuplicateUniqueName2(userName1);
            teacherAddStudentInClass.setUserPassword2(pass);
            teacherAddStudentInClass.clickOnCreate();

            Assert.assertTrue(teacherAddStudentInClass.verifyFixErrorsButton(), "Failed to verify Fix Error Button.");
            extentTest.log(LogStatus.PASS, "Successfully Verify Fix Error Button");
            logger.info("Teacher successfully Verify Fix Error Button");

            Assert.assertTrue(teacherAddStudentInClass.verifyErrorMessage(), "Failed to verify Error Message.");
            extentTest.log(LogStatus.PASS, "Successfully Verified Error Message");
            logger.info("Teacher successfully Verified Error Message");

            teacherAddStudentInClass.clickOnFixErrorsButton();

            teacherAddStudentInClass.setUniqueName1(userName);
            teacherAddStudentInClass.setUniqueName2(userName);
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

    @Test(priority = 7, description = "verify Functionality of 'Create Button' After Giving  Student Valid And Invalid Information")
    public void verifyFunctionalityCreateButtonWithValidAndInvalidData() {
        boolean result = true;
        try {
            String firstName = "pra_";
            String userName = "pra_";
            String userName1 = "Pratik1";
            String pass = "Teacher1";

            teacherAddStudentInClass.studentBeforeAdded();
            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();

            Assert.assertTrue(teacherAddStudentInClass.verifyAddButton(), "Failed to verify Add Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully Verify Add Button");
            logger.info("Teacher successfully Verify Add Button");

            teacherAddStudentInClass.clickOnAddButton();

            Assert.assertTrue(teacherAddStudentInClass.verifyFirstName2(), "Failed to verify FirstName2 Text");
            extentTest.log(LogStatus.PASS, "Successfully Verify FirstName2 Text");
            logger.info("Teacher successfully Verify FirstName2 Text");
            teacherAddStudentInClass.setFirstName1(firstName);
            teacherAddStudentInClass.setUniqueName1(userName);
            teacherAddStudentInClass.setUserPassword1(pass);
            teacherAddStudentInClass.setFirstName2(firstName);
            teacherAddStudentInClass.setDuplicateUniqueName2(userName1);
            teacherAddStudentInClass.setUserPassword2(pass);
            teacherAddStudentInClass.clickOnCreate();

            Assert.assertTrue(teacherAddStudentInClass.verifyFixErrorsButton(), "Failed to verify Fix Error Button.");
            extentTest.log(LogStatus.PASS, "Successfully Verify Fix Error Button");
            logger.info("Teacher successfully Verify Fix Error Button");

            Assert.assertTrue(teacherAddStudentInClass.verifyValidIcon(), "Failed to verify Valid Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Valid Icon");
            logger.info("Teacher successfully Verify Valid Icon");

            Assert.assertTrue(teacherAddStudentInClass.verifyInvalidIcon(), "Failed to verify Invalid Icon");
            extentTest.log(LogStatus.PASS, "Successfully Verify Invalid Icon");
            logger.info("Teacher successfully Verify Invalid Icon");

            Assert.assertTrue(teacherAddStudentInClass.verifyErrorMessage(), "Failed to verify Error Message.");
            extentTest.log(LogStatus.PASS, "Successfully Verified Error Message");
            logger.info("Teacher successfully Verified Error Message");

            teacherAddStudentInClass.clickOnFixErrorsButton();

            teacherAddStudentInClass.setUniqueName1(userName);
            teacherAddStudentInClass.clickOnCreate();
            teacherAddStudentInClass.clickOnViewReport();
            teacherAddStudentInClass.studentAfterAdded();

            Assert.assertTrue(teacherAddStudentInClass.verifyTheStudentInfo(), "Failed to verify Currently Added Student Information");
            extentTest.log(LogStatus.PASS, "Successfully Verified Currently Added Student Information");
            logger.info("Teacher successfully Verified Currently Added Student Information");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}