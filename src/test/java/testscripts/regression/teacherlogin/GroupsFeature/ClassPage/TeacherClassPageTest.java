package testscripts.regression.teacherlogin.GroupsFeature.ClassPage;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.CreateAnAssignment;
import uipages.reports2feature.ReportsPageWithoutAssignmentTest;

public class TeacherClassPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TeacherClassPageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Home section on Class page.")
    public void verifyHomeSection(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver, extentTest, extentReports);
            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            reportLog( "User Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();

            Assert.assertTrue(new ClassPage(webDriver, extentTest, extentReports).verifyClassImage(), "Failed to verify class theme image on class page.");
            reportLog( "Class theme image is displaying on class page.");

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyHomeSection method : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'Assignment' Button On Teacher Class Page")
    public void verifyAssignmentSection() {
        boolean result = true;
        try {
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver, extentTest, extentReports);
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);

            teacherAddStudentInClass.clickOnOkButton();
            createAnAssignment.clickOnAssignmentButton();

            Assert.assertTrue(createAnAssignment.verifyClassAssignmentText(), "Failed to verify Class Assignment Text");
            reportLog( "Teacher Successfully verify Class Assignment Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Q & A' Button On Teacher Class Page")
    public void verifyQASection() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver, extentTest, extentReports);

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog( "Successfully Verify Q And A Button");

            teacherGroupDiscussionInClass.clickOnQAndAButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyHowDoesThisWorkLink(), "Failed to verify How Does this Work Link");
            reportLog( "Successfully Verify How Does this Work Link");

            teacherGroupDiscussionInClass.clickOnHowDoesThisWorkLink();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyOkShowMeButton(), "Failed to verify Show Me Noe Button");
            reportLog( "Successfully verify Show Me Noe Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyNoThanksButton(), "Failed to verify No Thanks Button");
            reportLog( "Successfully Verify No Thanks Button");

            teacherGroupDiscussionInClass.clickOnNoThanksButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog( "Successfully Verify Q And A Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Shared Resources' Button On Teacher Class Page")
    public void verifySharedResourcesSection() {
        boolean result = true;
        try {
            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifySharedResourcesOption(), "Failed to verify Shared Resources section on class page.");
            reportLog( "Shared Resources section is displaying on class page.");
            logger.info("Shared Resources section is displaying on class page.");

            classPage.clickOnSharedResourcesOption();

            Assert.assertTrue(new TeacherAddStudentInClass(webDriver, extentTest, extentReports).verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog( "Successfully Verified Home Icon");
            logger.info("Teacher successfully Verified Home Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Member' Button On Teacher Class Page")
    public void verifyMembersSection() {
        boolean result = true;
        try {
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver, extentTest, extentReports);
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver, extentTest, extentReports);

            Assert.assertTrue(teacherAddStudentInClass.verifyMemberButton(), "Failed to verify Member Button");
            reportLog( "Successfully Verify Member Button");
            logger.info("Teacher successfully Verified Member Button");

            teacherAddStudentInClass.clickOnMemberOption();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog( "Successfully Verify Q And A Button");
            logger.info("Teacher successfully Verified Q And A Button");

            teacherAddStudentInClass.verifyAddStudentButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Setting' Button On Teacher Class Page")
    public void verifySettingSection() {
        boolean result = true;
        try {
            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifySettingsOption(), "Failed to verify Settings section on class page.");
            reportLog( "Settings section is displaying on class page.");
            logger.info("Settings section is displaying on class page.");

            classPage.clickOnSettingsOption();

            Assert.assertTrue(classPage.verifyDeleteClassButton(), "Failed to verify Delete class button under Settings section.");
            reportLog( "Delete class button is displaying under Settings section.");
            logger.info("Delete class button is displaying under Settings section.");

            /*Assert.assertTrue(classPage.verifyClassCodeLabel(), "Failed to verify Class Code label under Settings section.");
            reportLog( "Class Code label is displaying under Settings section.");
            logger.info("Class Code label is displaying under Settings section.");

            Assert.assertTrue(classPage.verifyJoinClassLink(), "Failed to verify Class link text box under Settings section.");
            reportLog( "Class link text box displaying under Settings section.");
            logger.info("Class link text box displaying under Settings section.");*/
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }

    // @Test(priority = 7, description = "Verify the Functionality of 'Reports' Button On Teacher Class Page")
    public void verifyReportSection() {
        boolean result = true;
        try {
            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifyReportsOption(), "Failed to verify Reports section on class page.");
            reportLog( "Reports section is displaying on class page.");
            logger.info("Reports section is displaying on class page.");

            classPage.clickOnReportsOption();

            Assert.assertTrue(new ReportsPageWithoutAssignmentTest(webDriver, extentTest, extentReports).verifyCreateAssignmentButton(), "Failed to verify Home icon.");
            reportLog( "Presence of 'Create Assignment' button.");
            logger.info("Presence of 'Create Assignment' button.");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed" + errorMessage);
    }
}