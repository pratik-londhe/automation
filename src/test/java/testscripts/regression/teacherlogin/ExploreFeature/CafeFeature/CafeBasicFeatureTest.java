package testscripts.regression.teacherlogin.ExploreFeature.CafeFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CafeBasicFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CafeBasicFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Cafe' container is present inside the explore.")
    public void verifyCafeContainerIsVisible(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            String assertTextVSPOG = "Teacher profile icon after logging in.";
            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Cafe' Container.";
            Assert.assertTrue(cafeFeature.verifyCafeLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Cafe' Container.")
    public void verifyFunctionalityOfAdaptivePracticeContainer() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnCafeLink();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify UI page of 'Cafe' Feature.")
    public void verifyUiPageOfCafe() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Ck12 Guideline' link.";
            Assert.assertTrue(cafeFeature.verifyCk12GuidelineLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Cafe' Text.";
            Assert.assertTrue(cafeFeature.verifyCafeText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify 'Take The Tour' Tab is Present in the Cafe UI.")
    public void verifyFunctionalityOfCk12Icon() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVAB = "Presence of 'Help Ask And Share' Text.";
            Assert.assertTrue(cafeFeature.verifyHelpAskAndShareText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Take The Tour' Tab.")
    public void verifyFunctionalityOfTakeTheTourTab() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnTakeTheTourTab();

            String assertTextVAB = "Presence of 'Take The Tour' button.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            String assertTextVSPOG = "Presence of 'Skip The Tour ' button.";
            Assert.assertTrue(cafeFeature.verifySkippTourButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Skip The Tour' Button.")
    public void verifyFunctionalityOfSkipTheTourButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnSkippTourButton();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeFeature.clickOnTakeTheTourTab();

            String assertTextVAB = "Presence of 'Take The Tour' button.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'Take The Tour' button.")
    public void verifyFunctionalityOfTakeTheTourButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnTakeTheTourButton();

            String assertTextVSPOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyContinueButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVAB = "Presence of 'Skip' button.";
            Assert.assertTrue(cafeFeature.verifySkipButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Skip' Button.")
    public void verifyFunctionalityOfSkipButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnSkipButton();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            cafeFeature.clickOnTakeTheTourTab();

            String assertTextVAB = "Presence of 'Take The Tour' button.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourButton(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            cafeFeature.clickOnTakeTheTourButton();

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyContinueButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Continue' Button.")
    public void verifyFunctionalityOfContinueButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnContinueButton();

            String assertTextVSOG = "Presence of 'Continue' button.";
            Assert.assertTrue(cafeFeature.verifyContinueButton(), assertFailurePreText + assertTextVSOG);
            reportLog(assertTextVSOG);

            cafeFeature.clickOnContinueButton();

            String assertTextVSPOG = "Presence of Done ' Tab.";
            Assert.assertTrue(cafeFeature.verifyDoneButton(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of 'Done' Button.")
    public void verifyFunctionalityOfDoneButton() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnDoneButton();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVAB = "Presence of 'Help Ask And Share' Text.";
            Assert.assertTrue(cafeFeature.verifyHelpAskAndShareText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify 'Ck12 Cafe Guidelines' Tab is Present in the Cafe UI.")
    public void verifyCafeGuidelineLinkIsPresentOnTheUI() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            String assertTextVSPOG = "Presence of 'Ck12 Guideline' link.";
            Assert.assertTrue(cafeFeature.verifyCk12GuidelineLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'Ck12 Cafe Guidelines' link.")
    public void verifyFunctionalityOfCafeGuidelineLink() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnCk12GuidelineLink();

            String assertTextVSPOG = "Presence of 'Ck12 Guideline' Text.";
            Assert.assertTrue(cafeFeature.verifyCafeGuideLineText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVAB = "Presence of 'Close Guideline ' Icon.";
            Assert.assertTrue(cafeFeature.verifyCloseGuidelineIcon(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify functionality of 'Close Guidelines'.")
    public void verifyFunctionalityOfCloseCafeGuidelineIcon() {
        boolean result = true;
        try {
            CafeFeature cafeFeature = new CafeFeature(webDriver, extentTest, extentReports);

            cafeFeature.clickOnCloseGuidelineIcon();

            String assertTextVSPOG = "Presence of 'Take The Tour ' Tab.";
            Assert.assertTrue(cafeFeature.verifyTakeTheTourTab(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVAB = "Presence of 'Help Ask And Share' Text.";
            Assert.assertTrue(cafeFeature.verifyHelpAskAndShareText(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}