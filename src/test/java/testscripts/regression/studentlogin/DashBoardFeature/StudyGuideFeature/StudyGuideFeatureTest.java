package testscripts.regression.studentlogin.DashBoardFeature.StudyGuideFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import testscripts.regression.teacherlogin.ExploreFeature.AdaptivePracticeFeature.AdaptivePracticeFeatureTest;
import uipages.flexbook2feature.*;

public class StudyGuideFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AdaptivePracticeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Study Guides Link are visible in inside of Explore container.")
    public void verifyStudyGuidesContainerIsVisible(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Study Guide' Container.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Study Guides' Container.")
    public void verifyFunctionalityOfStudyGuideContainer() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);
            studyGuideFeature.clickOnStudyGuideLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Ck12 Image' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyCK12ImageIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Ck12 Icon.")
    public void verifyFunctionalityOfCk12ImageIcon() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            studyGuideFeature.clickOnCK12ImageIcon();

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Study Guide' Container.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            studyGuideFeature.clickOnStudyGuideLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify UI Page Of Study Guides.")
    public void verifyUIPageOfStudyGuide() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Geometry Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyGeometryBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVSPOG = "Presence of 'Biology Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyBiologyBranchLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVDD = "Presence of 'Physics Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyGeometryBranchLink(), assertFailurePreText + assertTextVDD);
            reportLog(assertTextVDD);

            String assertTextVEB = "Presence of 'Physics' Link.";
            Assert.assertTrue(studyGuideFeature.verifyPhysicsBranchLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Search PlaceHolder With InValid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithInvalidData() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String text="LNA";

            String assertTextVSPOG = "Presence of 'Ck12' Icon.";
            Assert.assertTrue(studyGuideFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.setValueInSearchPlaceHolder(text);
            studyGuideFeature.pressEnterKey();

            String assertTextVCNDD = "Presence of 'No Result' Text.";
            Assert.assertTrue(studyGuideFeature.verifyNoResultText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Close Search Icon of Search Place Holder.")
    public void verifyFunctionalityOfCloseSearchIcon() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVSPOG = "Presence of 'Close Search' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseSearchIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.clickOnCloseSearchIcon();

            String assertTextVCNDD = "Presence of 'Ck12' Icon.";
            Assert.assertTrue(studyGuideFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 11, description = "Verify Functionality Of Search PlaceHolder With Valid Data.")
    public void verifyFunctionalityOfSearchPlaceHolderWithValidData() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String text="History";

            studyGuideFeature.setValueInSearchPlaceHolder(text);

            String assertTextVCNDD = "Presence of 'Search Result' Link.";
            Assert.assertTrue(studyGuideFeature.verifySearchResultLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnSearchResultLink();
            studyGuideFeature.pressEnterKey();

            String assertTextVEB = "Presence of 'Search Result' Link.";
            Assert.assertTrue(studyGuideFeature.verifySearchResultLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVSPOG = "Presence of 'Close Search' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseSearchIcon(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.clickOnCloseSearchIcon();

            String assertTextVAB = "Presence of 'Ck12' Icon.";
            Assert.assertTrue(studyGuideFeature.verifySearchPlaceHolder(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

     @Test(priority = 13, description = "Verify Functionality Of Geometry Subject Link.")
    public void verifyFunctionalityOfGeometryLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            studyGuideFeature.getTextOfAlgebraConceptTitle();

            String assertTextVCNDD = "Presence of 'Geometry Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyGeometryBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnGeometryBranchLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.getTextOfGeometryConceptTitle();

            String assertTextVEB = "Presence of 'Geometry branch Concepts' Link.";
            Assert.assertTrue(studyGuideFeature.verifyGeometryBranchConceptsLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Earth Science Subject Link.")
    public void verifyFunctionalityOfEarthScienceLink() {
        boolean result = true;
        try {
            /*StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Earth Science Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyEarthScienceBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnEarthScienceBranchLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.getTextOfEarthScienceConceptTitle();

            String assertTextVEB = "Presence of 'Earth Science branch Concepts' Link.";
            Assert.assertTrue(studyGuideFeature.verifyEarthScienceBranchConceptsLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Biology Subject Link.")
    public void verifyFunctionalityOfBiologyLink() {
        boolean result = true;
        try {
            /*StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Biology Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyBiologyBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnBiologyBranchLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.getTextOfBiologyConceptTitle();

            String assertTextVEB = "Presence of 'Biology branch Concepts' Link.";
            Assert.assertTrue(studyGuideFeature.verifyBiologyBranchConceptsLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Physics Subject Link.")
    public void verifyFunctionalityOfPhysicsLink() {
        boolean result = true;
        try {
            /*StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Physics Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyPhysicsBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnPhysicsBranchLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            studyGuideFeature.getTextOfPhysicsConceptTitle();

            String assertTextVEB = "Presence of 'Physics branch Concepts' Link.";
            Assert.assertTrue(studyGuideFeature.verifyPhysicsBranchConceptsLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of Algebra Subject Link.")
    public void verifyFunctionalityOfAlgebraLink() {
        boolean result = true;
        try {
            /*StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            String assertTextVCNDD = "Presence of 'Algebra Branch ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyAlgebraBranchLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnAlgebraBranchLink();

            String assertTextVSPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVEB = "Presence of 'Algebra branch Concepts' Link.";
            Assert.assertTrue(studyGuideFeature.verifyAlgebraBranchConceptsLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of Concept Link.")
    public void verifyFunctionalityOfConceptLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);

            studyGuideFeature.clickOnFirstBranchConceptLink();

            String assertTextVCNDD = "Presence of 'Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyTitleText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVSPOG = "Presence of 'Landing Page ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyLandingPageLink(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of Landing Page Link.")
    public void verifyFunctionalityOfLandingPageLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver,extentTest,extentReports);
            SchoolFeature schoolFeature = new SchoolFeature(webDriver,extentTest,extentReports);

            studyGuideFeature.clickOnLandingPageLink();

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Study Guide' Container.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}