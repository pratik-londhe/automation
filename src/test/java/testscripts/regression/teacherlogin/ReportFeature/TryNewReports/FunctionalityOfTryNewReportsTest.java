package testscripts.regression.teacherlogin.ReportFeature.TryNewReports;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;
import uipages.reports2feature.TryNewReportsPage;

public class FunctionalityOfTryNewReportsTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FunctionalityOfTryNewReportsTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    TeacherDashboardPage teacherDashboardPage;
    PageMenuTab pageMenuTab;
    public TeacherAddStudentInClass teacherAddStudentInClass;
    private ClassPage classPage;
    public TryNewReportsPage tryNewReportsPage;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify The Try New Report Button.")
    public void verifyTheTryNewReportsButton(String email, String password) {
        boolean result = true;
        try {
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            pageMenuTab = new PageMenuTab(webDriver,extentTest,extentReports);
            teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver,extentTest,extentReports);
            classPage = new ClassPage(webDriver,extentTest,extentReports);
            tryNewReportsPage =  new TryNewReportsPage(webDriver,extentTest,extentReports);
            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            String assertTextVTPOG = "Teacher profile icon after login";
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            pageMenuTab.clickOnClassesTab();
            teacherAddStudentInClass.clickOnClassNameIcon();
            classPage.clickOnReportsOption();
            classPage.handleMultipleWindows();

            String assertTextVCB = "Presence Of Create Assignment Button";
            Assert.assertTrue(tryNewReportsPage.verifyCreateAssignment(), assertFailurePreText + assertTextVCB);
            reportLog(assertTextVCB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the New Report page.")
    public void verifyTheNewReportPage() {
        boolean result = true;
        try {
            String assertTextVNRP = "Presence Of Class Name on the new report page";
            Assert.assertTrue(tryNewReportsPage.verifyClassNameOnNewReportPage(), assertFailurePreText + assertTextVNRP);
            reportLog(assertTextVNRP);

            String assertTextVCI = "Presence Of CSV Icon on the new report page";
            Assert.assertTrue(tryNewReportsPage.verifyCsvIcon(), assertFailurePreText + assertTextVCI);
            reportLog(assertTextVCI);

            String assertTextVHM = "Presence Of Heat Map Check Box on the new report page";
            Assert.assertTrue(tryNewReportsPage.verifyHeatMapCheckBox(), assertFailurePreText + assertTextVHM);
            reportLog(assertTextVHM);

            String assertTextVRRL = "Presence Of Read Report Link on the new report page.";
            Assert.assertTrue(tryNewReportsPage.verifyReadReportLink(), assertFailurePreText + assertTextVRRL);
            reportLog(assertTextVRRL);

            String assertTextVTNR = "Presence Of Report Table on New Report on the new report page";
            Assert.assertTrue(tryNewReportsPage.verifyTableOnNewReport(), assertFailurePreText + assertTextVTNR);
            reportLog(assertTextVTNR);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}