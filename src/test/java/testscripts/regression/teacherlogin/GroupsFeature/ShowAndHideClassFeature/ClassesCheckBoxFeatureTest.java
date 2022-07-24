package testscripts.regression.teacherlogin.GroupsFeature.ShowAndHideClassFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ClassesCheckBoxFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ClassesCheckBoxFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify All the classes Of Teacher Is Visible")
    public void verifyAllClassesIsVisible(String email, String password) {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver, extentTest, extentReports);
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            loginPage.teacherLogin(email, password);

            String assertTextVTPG = "Presence of Teacher account icon On Gamma";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPG);
            reportLog(assertTextVTPG);

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnClassesTab();

            String assertTextVCAC = "Presence All The Classes .";
            Assert.assertTrue(classesCheckBoxFeature.verifyTextOfClasses(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify CheckBox Of  Teacher is Member, Leader And Co-Teacher Are Available")
    public void verifyAllCheckBoxAreVisible() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVLd = "Presence Of Is Lead CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsLeadCheckBox(), assertFailurePreText + assertTextVLd);
            reportLog(assertTextVLd);

            String assertTextVCAC = "Presence Of Is Member CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsMemberCheckBox(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            String assertTextVCA = "Presence Of Is CoTeacher CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsCoTeacherCheckBox(), assertFailurePreText + assertTextVCA);
            reportLog(assertTextVCA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Classes when Teacher is Member, Leader And Co-Teacher")
    public void verifyClassesWhenTeacherIsMemberLeaderAndCoTeacher() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCA = "Presence Of Is Classes When Teacher Is Member , leader And Co-Teacher.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsMemberLeadAndCoTeacher(), assertFailurePreText + assertTextVCA);
            reportLog(assertTextVCA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 4, description = "Verify Classes when Teacher is Member And Leader")
    public void verifyClassesWhenTeacherIsMemberAndLeader() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVCA = "Presence Of Is CoTeacher CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsCoTeacherCheckBox(), assertFailurePreText + assertTextVCA);
            reportLog(assertTextVCA);

            classesCheckBoxFeature.clickOnIsCoTeacherCheckBox();
            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCAm = "Presence Of Is Classes When Teacher Is Member  And Lead.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsMemberAndLead(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Classes when Teacher is Member")
    public void verifyClassesWhenTeacherIsMember() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVLd = "Presence Of Is Lead CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsLeadCheckBox(), assertFailurePreText + assertTextVLd);
            reportLog(assertTextVLd);

            classesCheckBoxFeature.clickOnIsLeadCheckBox();
            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCAm = "Presence Of Is Classes When Teacher Is Member  And Lead.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsMember(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Classes Without Selecting Any CheckBox")
    public void verifyClassesWithoutCheckBox() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVCAC = "Presence Of Is Member CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsMemberCheckBox(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            classesCheckBoxFeature.clickOnIsMemberCheckBox();

            String assertTextVCAm = "Presence Of Don't Have Classes Text.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIDoNotHaveClassesText(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Classes when Teacher is Lead")
    public void verifyClassesWhenTeacherIsLead() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVLd = "Presence Of Is Lead CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsLeadCheckBox(), assertFailurePreText + assertTextVLd);
            reportLog(assertTextVLd);

            classesCheckBoxFeature.clickOnIsLeadCheckBox();
            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCAm = "Presence Of Is Classes When Teacher Is Member  And Lead.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsLead(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify Classes when Teacher is Lead And CoTeacher")
    public void verifyClassesWhenTeacherIsLeadAndCoTeacher() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVCA = "Presence Of Is CoTeacher CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsCoTeacherCheckBox(), assertFailurePreText + assertTextVCA);
            reportLog(assertTextVCA);

            classesCheckBoxFeature.clickOnIsCoTeacherCheckBox();
            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCAm = "Presence Of Is Classes When Teacher Is CoTeacher And Lead.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsLeadAndCoTeacher(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Classes when Teacher is CoTeacher")
    public void verifyClassesWhenTeacherIsCoTeacher() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVLd = "Presence Of Is Lead CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsLeadCheckBox(), assertFailurePreText + assertTextVLd);
            reportLog(assertTextVLd);

            classesCheckBoxFeature.clickOnIsLeadCheckBox();

            String assertTextVCAm = "Presence Of Don't Have Classes Text.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIDoNotHaveClassesText(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 10, description = "Verify Classes when Teacher is CoTeacher And Member")
    public void verifyClassesWhenTeacherIsCoTeacherAndMember() {
        boolean result = true;
        try {
            ClassesCheckBoxFeature classesCheckBoxFeature = new ClassesCheckBoxFeature(webDriver, extentTest, extentReports);

            String assertTextVCAC = "Presence Of Is Member CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsMemberCheckBox(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            classesCheckBoxFeature.clickOnIsMemberCheckBox();
            classesCheckBoxFeature.getCountOfClasses();

            String assertTextVCAm = "Presence Of Is Classes When Teacher Is CoTeacher And member.";
            Assert.assertTrue(classesCheckBoxFeature.verifyClassesWhenTeacherIsMemberAndCoTeacher(), assertFailurePreText + assertTextVCAm);
            reportLog(assertTextVCAm);

            String assertTextVLd = "Presence Of Is Lead CheckBox.";
            Assert.assertTrue(classesCheckBoxFeature.verifyIsLeadCheckBox(), assertFailurePreText + assertTextVLd);
            reportLog(assertTextVLd);

            classesCheckBoxFeature.clickOnIsLeadCheckBox();

            String assertTextVCA = "Presence All The Classes .";
            Assert.assertTrue(classesCheckBoxFeature.verifyTextOfClasses(), assertFailurePreText + assertTextVCA);
            reportLog(assertTextVCA);

        } catch (RuntimeException e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}