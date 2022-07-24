package testscripts.regression.studentlogin.GroupsFeature.JoinClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.AssignAndCloseFeatureOnAssignment;
import uipages.reports2feature.CreateAnAssignment;

public class StudentClassPageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentClassPageTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Home section on Class page.")
    public void verifyHomeSection(String email, String password) {
        boolean result = true;
        try {
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), "Failed to verify user profile for Student Login Test.");
            reportLog("Student Successfully logged in and verified profile icon.");

            pageMenuTab.clickOnClassesTab();
            studentMemberPage.clickOnClassName();

            Assert.assertTrue(teacherAddStudentInClass.verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog("Successfully Verified Home Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed for verifyHomeSection method : " + errorMessage);
    }

    //@Test(priority = 2, description = "Verify the Functionality of 'Assignment' Button On Student Class Page")
    public void verifyAssignmentSection() {
        boolean result = true;
        try {
            CreateAnAssignment createAnAssignment = new CreateAnAssignment(webDriver,extentTest,extentReports);

            createAnAssignment.clickOnAssignmentButton();

//            Assert.assertTrue(studentMemberPage.verifyStartDateText(), "Failed to verify Start Date Text");
//            reportLog("Teacher Successfully verify Start Date Text");

            Assert.assertTrue(new AssignAndCloseFeatureOnAssignment(webDriver,extentTest,extentReports).verifyCreateAssignmentButton(), "Failed to verified Create An Assignment Button");
            reportLog("User Successfully verified Create An Assignment Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Reports' Button On Student Class Page")
    public void verifyReportSection() {
        boolean result = true;
        try {

            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifyReportsOption(), "Failed to verify Reports section on class page.");
            reportLog("Reports section is displaying on class page.");

            classPage.clickOnReportsOption();

//            Assert.assertTrue(studentMemberPage.verifyTitleText(), "Failed to verify Title Text");
//            reportLog("Successfully Verify Title Text");
//
//            Assert.assertTrue(studentMemberPage.verifyLatestAssignmentScoresText(), "Failed to verify Latest Assignment Scores Text");
//            reportLog("Successfully Latest Assignment Scores Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed" + errorMessage);
    }

    @Test(priority = 4, description = "Verify the Functionality of 'Q & A' Button On Student Class Page")
    public void verifyQASection() {
        boolean result = true;
        try {
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog("Successfully Verify Q And A Button");

            teacherGroupDiscussionInClass.clickOnQAndAButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyHowDoesThisWorkLink(), "Failed to verify How Does this Work Link");
            reportLog("Successfully Verify How Does this Work Link");

            teacherGroupDiscussionInClass.clickOnHowDoesThisWorkLink();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyOkShowMeButton(), "Failed to verify Show Me Noe Button");
            reportLog("Successfully verify Show Me Noe Button");

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyNoThanksButton(), "Failed to verify No Thanks Button");
            reportLog("Successfully Verify No Thanks Button");

            teacherGroupDiscussionInClass.clickOnNoThanksButton();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog("Successfully Verify Q And A Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed  : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify the Functionality of 'Shared Resources' Button On Student Class Page")
    public void verifySharedResourcesSection() {
        boolean result = true;
        try {
            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifySharedResourcesOption(), "Failed to verify Shared Resources section on class page.");
            reportLog("Shared Resources section is displaying on class page.");

            classPage.clickOnSharedResourcesOption();

            Assert.assertTrue(new TeacherAddStudentInClass(webDriver,extentTest,extentReports).verifyHomeIcon(), "Failed to verify Home icon.");
            reportLog("Successfully Verified Home Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }

    @Test(priority = 6, description = "Verify the Functionality of 'Member' Button On Student Class Page")
    public void verifyMembersSection() {
        boolean result = true;
        try {

            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver,extentTest,extentReports);
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(teacherAddStudentInClass.verifyMemberButton(), "Failed to verify Member Button");
            reportLog("Successfully Verify Member Button");

            teacherAddStudentInClass.clickOnMemberOption();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            reportLog("Successfully Verify Q And A Button");

            Assert.assertTrue(studentMemberPage.verifyClassAdminText(), "Failed to verify Class Admin Text");
            reportLog("Successfully Verify Class Admin Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }

    @Test(priority = 7, description = "Verify the Functionality of 'Setting' Button On Student Class Page")
    public void verifySettingSection() {
        boolean result = true;
        try {

            ClassPage classPage = new ClassPage(webDriver,extentTest,extentReports);
            StudentMemberPage studentMemberPage = new StudentMemberPage(webDriver,extentTest,extentReports);

            Assert.assertTrue(classPage.verifySettingsOption(), "Failed to verify Settings section on class page.");
            reportLog("Settings section is displaying on class page.");

            classPage.clickOnSettingsOption();

            Assert.assertTrue(studentMemberPage.verifyEmailNotificationText(), "Failed to verify Email Notification Text.");
            reportLog("Successfully Verify Email Notification Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed " + errorMessage);
    }
}