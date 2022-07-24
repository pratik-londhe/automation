package testscripts.regression.teacherlogin.ExploreFeature.AdaptivePracticeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.AdaptivePracticeFeature;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.SchoolFeature;
import uipages.flexbook2feature.TeacherDashboardPage;

public class AssessmentContainerOfAdaptivePracticeFeature extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AssessmentContainerOfAdaptivePracticeFeature.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of Track Icon.")
    public void verifyFunctionalityOfTrackIcon(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Adaptive Practice' Container.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeContainer(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            adaptivePracticeFeature.clickOnAdaptivePracticeContainer();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSOG = "Presence of 'Subject Grade' link.";
            Assert.assertTrue(adaptivePracticeFeature.verifySubjectGradeLink(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            adaptivePracticeFeature.clickOnSubjectGradeLink();

            String assertTextVABA = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVABA);
            reportLog(assertTextVABA);

            String assertTextVNDD = "Presence of 'Track' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyTrackIcon(), assertFailurePreText + assertTextVNDD);
            reportLog(assertTextVNDD);

            adaptivePracticeFeature.clickOnTrackIcon();

            String assertTextVB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVB);
            reportLog(assertTextVB);

            String assertTextVPOG = "Presence of 'Concept' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyConceptLink(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of Concept Link Of Subject.")
    public void verifyFunctionalityOfConceptLink() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            adaptivePracticeFeature.clickOnConceptLink();

            String assertTextVCNDD = "Presence of 'Keep Practicing' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVAB = "Presence of 'Go To Next Concept' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyGotoNextConceptButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 26, description = "Verify Assign To Class And Customize Link are Available On Assignment Container Page.")
    public void verifyAssignToClassAndCustomizeLinkAreAvailable() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Assign To Class' link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAssignToClassLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVAB = "Presence of 'Customized' link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCustomizedLink(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality Of Close Icon and Verify it Redirects to the Subject Concept page.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Close' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCloseIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnCloseIcon();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSPOG = "Presence of 'Concept' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyConceptLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnConceptLink();

            String assertTextVEB = "Presence of 'Keep Practicing' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify Functionality Of 'Keep Practicing' Button.")
    public void verifyFunctionalityOfKeepPracticingButton() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            adaptivePracticeFeature.clickOnKeepPracticingButton();

            adaptivePracticeFeature.closeWalkthroughPopup();

            String assertTextVAB = "Presence of 'Stop For Now' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyStopForNowButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            adaptivePracticeFeature.clickOnStopForNowButton();

            String assertTextVCNDD = "Presence of 'Keep Practicing Button' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify Progress  level Are Shown on Concept link afterSolving Practice.")
    public void verifyProgressLevelPercentage() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Close' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCloseIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnCloseIcon();

            String assertTextVAB = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVA = "Presence of 'Progress Level' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyProgressLevelIcon(), assertFailurePreText + assertTextVA);
            reportLog(assertTextVA);

            String assertTextVSPOG = "Presence of 'Concept' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyConceptLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnConceptLink();

            String assertTextVEB = "Presence of 'Keep Practicing' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 33, description = "Verify Functionality Of Go TO Next Concept Button.")
    public void verifyFunctionalityOfGoToNextConceptButton() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Go To Next Concept' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyGotoNextConceptButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnGotoNextConceptButton();

            String assertTextVAB = "Presence of 'Start Practice' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyStartPracticingButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVA = "Presence of 'Close' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCloseIcon(), assertFailurePreText + assertTextVA);
            reportLog(assertTextVA);

            adaptivePracticeFeature.clickOnCloseIcon();

            String assertTextVABA = "Presence of 'Adaptive Practice' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAdaptivePracticeText(), assertFailurePreText + assertTextVABA);
            reportLog(assertTextVABA);

            String assertTextVSPOG = "Presence of 'Concept' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyConceptLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            adaptivePracticeFeature.clickOnConceptLink();

            String assertTextVEB = "Presence of 'Keep Practicing' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 35, description = "Verify Functionality Of Customize Button.")
    public void verifyFunctionalityOfCustomizedButton() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Customized' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCustomizedLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnCustomizedLink();

            String assertTextVAB = "Presence of 'Start Practice' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyBackButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 37, description = "Verify Functionality Of Back Button and verify it redirects to subject chapter Page.")
    public void verifyFunctionalityOfBackButton() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            adaptivePracticeFeature.clickOnBackButton();

            String assertTextVCNDD = "Presence of 'Customized' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCustomizedLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Keep Practicing' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyKeepPracticingButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 38, description = "Verify UI Page Of Assessment Container.")
    public void verifyUiPAgeOfAssessmentContainer() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Title' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyTitleText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            /*String assertTextVAB = "Presence of 'Ways To Learn' Text.";
            Assert.assertTrue(adaptivePracticeFeature.verifyWaysToLEarnText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);*/

            String assertTextVSPOG = "Presence of 'Go To Next Concept' Button.";
            Assert.assertTrue(adaptivePracticeFeature.verifyGotoNextConceptButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 39, description = "Verify Functionality Of Assign To Class Button.")
    public void verifyFunctionalityOfAssignToClass() {
        boolean result = true;
        try {
            AdaptivePracticeFeature adaptivePracticeFeature = new AdaptivePracticeFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Assign To Class' Link.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAssignToClassLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            adaptivePracticeFeature.clickOnAssignToClassLink();

            /*String assertTextVAB = "Presence of 'Ck12 Assign' icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyCk12AssignIcon(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            adaptivePracticeFeature.clickOnCk12AssignIcon();

            String assertTextVSPOG = "Presence of 'Assign To Class' Icon.";
            Assert.assertTrue(adaptivePracticeFeature.verifyAssignToClassIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}