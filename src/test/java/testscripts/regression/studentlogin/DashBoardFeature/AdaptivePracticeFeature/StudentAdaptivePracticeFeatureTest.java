package testscripts.regression.studentlogin.DashBoardFeature.AdaptivePracticeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

/**
 * @author Yash Shrimali
 */
public class StudentAdaptivePracticeFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(StudentAdaptivePracticeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Adaptive Practice' Container Are Available inside the explore DropDown.")
    public void verifyUIOfGradeOneAdaptivePractice(String email, String password) {
        boolean result = true;
        try {
            StudentDashBoardPage studentDashBoardPage = new StudentDashBoardPage(webDriver,extentTest,extentReports);
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature=new AdaptivePracticeFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(studentDashBoardPage.verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Adaptive Practice' Container.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Adaptive Practice' Container.")
    public void verifyFunctionalityOfAdaptivePracticeContainer() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature=new AdaptivePracticeFeature(webDriver,extentTest,extentReports);

            adaptivePracticeFeature.clickOnAdaptivePracticeContainer();

            String assertTextVSPOG = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Browse Back' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyBrowseBackIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify UI Of the 'Grade 1' Adaptive Practice page.")
    public void verifyUIOfGradeOneAdaptivePractice() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature=new AdaptivePracticeFeature(webDriver,extentTest,extentReports);

            adaptivePracticeFeature.clickOnGradeOneLink();

            String assertTextVSPOG = "Presence of 'Subject' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVFCIGO = "Presence and boldness of text 'Addition and Subtraction to 20'  ";
            Assert.assertTrue(adaptivePracticeFeature.verifyfirstCategoryInGradeOne(), assertFailurePreText + assertTextVFCIGO);
            reportLog(assertTextVFCIGO);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
