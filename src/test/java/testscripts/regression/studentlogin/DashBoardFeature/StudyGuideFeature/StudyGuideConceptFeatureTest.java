package testscripts.regression.studentlogin.DashBoardFeature.StudyGuideFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import testscripts.regression.teacherlogin.ExploreFeature.AdaptivePracticeFeature.AdaptivePracticeFeatureTest;
import uipages.flexbook2feature.*;

public class StudyGuideConceptFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AdaptivePracticeFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify UI Page Of Page Container.")
    public void verifyUIPageOfPageContainer(String email, String password) {
        boolean result = true;
        try {
            SchoolFeature schoolFeature = new SchoolFeature(webDriver, extentTest, extentReports);
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            String assertTextVCNDD = "Presence of 'Header' Container.";
            Assert.assertTrue(schoolFeature.verifyHeaderContainer(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            schoolFeature.clickOnHeaderContainer();

            String assertTextVEB = "Presence of 'Study Guide' Container.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideLink(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            studyGuideFeature.clickOnStudyGuideLink();

            String assertTextVPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            studyGuideFeature.clickOnFirstBranchConceptLink();

            String assertTextVCDD = "Presence of 'Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            String assertTextVOG = "Presence of 'Landing Page ' Link.";
            Assert.assertTrue(studyGuideFeature.verifyLandingPageLink(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 3, description = "Verify Functionality Of Close Icon of Page Container.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Close' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseViewerIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnCloseViewerIcon();

            String assertTextVPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            studyGuideFeature.clickOnFirstBranchConceptLink();

            String assertTextVCDD = "Presence of 'Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Viewer tooltip Icon.")
    public void verifyFunctionalityOfToolTipIcon() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Tool Tip' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyToolTipLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnToolTipLink();




        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of Add To Library link.")
    public void verifyFunctionalityOfAddToLibraryLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Add To Library' link.";
            Assert.assertTrue(studyGuideFeature.verifyAddToLibraryLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnAddToLibraryLink();

            String assertTextVPOG = "Presence of 'Content' Text.";
            Assert.assertTrue(studyGuideFeature.verifyContentText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Ok Button Of Alert Modal.")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Ok' button.";
            Assert.assertTrue(studyGuideFeature.verifyOkButton(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnOkButton();

            String assertTextVCDD = "Presence of 'Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            String assertTextVCND = "Presence of 'Tool Tip' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyToolTipLink(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

//            studyGuideFeature.clickOnToolTipLink();

            /*String assertTextVPOG = "Presence of 'DownLoad' Link.";
            Assert.assertTrue(studyGuideFeature.verifyDownLoadLink(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);*/

            String assertTextVCD = "Presence of 'Add To Library' link.";
            Assert.assertTrue(studyGuideFeature.verifyAddToLibraryLink(), assertFailurePreText + assertTextVCD);
            reportLog(assertTextVCD);

            studyGuideFeature.clickOnAddToLibraryLink();

            String assertTextVOG = "Presence of 'Content' Text.";
            Assert.assertTrue(studyGuideFeature.verifyContentText(), assertFailurePreText + assertTextVOG);
            reportLog(assertTextVOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Close Icon Of Alert Modal.")
    public void verifyFunctionalityOfCloseIconOfAlertModal() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Close Alert Modal' Icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseAlertModalIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnCloseAlertModalIcon();

            String assertTextVCDD = "Presence of 'Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

//            String assertTextVDD = "Presence of 'Close' Icon.";
//            Assert.assertTrue(studyGuideFeature.verifyCloseViewerIcon(), assertFailurePreText + assertTextVDD);
//            reportLog(assertTextVDD);
//
//            studyGuideFeature.clickOnCloseViewerIcon();
//
//            String assertTextVPOG = "Presence of 'Study Guides' Text.";
//            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
//            reportLog(assertTextVPOG);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Appropriate concept page will open with 'Read and Video' modality type list and should view while opening modality in the page.")
    public void verifyFunctionalityOfConceptsLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            studyGuideFeature.navigateBack();

            String assertTextVCNDD = "Presence of 'Browse Concept' Link.";
            Assert.assertTrue(studyGuideFeature.verifyBrowseConceptLink(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnBrowseConceptLink();
            studyGuideFeature.enterInToFrame();

            /*String assertTextVCDD = "Presence of 'Modality Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify UI Page Of Content Area after Clicking On Concept Link.")
    public void verifyUiPageOfContentArea() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

//            String assertTextVCDD = "Presence of 'Read' Link.";
//            Assert.assertTrue(studyGuideFeature.verifyReadLink(), assertFailurePreText + assertTextVCDD);
//            reportLog(assertTextVCDD);

            String assertTextVCND = "Presence of 'Video' link.";
            Assert.assertTrue(studyGuideFeature.verifyVideoLink(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

            studyGuideFeature.removeFromFrame();

            String assertTextVCNDD = "Presence of 'Close Window Modal' icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseWindowModalIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Close Icon of Content Area.")
    public void verifyFunctionalityOfCloseWindowIcon() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            studyGuideFeature.clickOnCloseWindowModalIcon();

            String assertTextVPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            studyGuideFeature.clickOnBrowseConceptLink();
            studyGuideFeature.enterInToFrame();

            String assertTextVCDD = "Presence of 'Modality Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Video Link Of Container Page.")
    public void verifyFunctionalityOfVideoLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCND = "Presence of 'Video' link.";
            Assert.assertTrue(studyGuideFeature.verifyVideoLink(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

            studyGuideFeature.clickOnVideoLink();

            String assertTextVCDD = "Presence of 'Modality Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            String assertTextVCD = "Presence of 'Video' text.";
            Assert.assertTrue(studyGuideFeature.verifyVideoText(), assertFailurePreText + assertTextVCD);
            reportLog(assertTextVCD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of Read Link Of Container Page.")
    public void verifyFunctionalityOfReadLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCND = "Presence of 'Read' link.";
            Assert.assertTrue(studyGuideFeature.verifyReadLink(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

            studyGuideFeature.clickOnReadLink();

            String assertTextVCDD = "Presence of 'Modality Title' Text.";
            Assert.assertTrue(studyGuideFeature.verifyModalityTitleText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

            String assertTextVCD = "Presence of 'Read' text.";
            Assert.assertTrue(studyGuideFeature.verifyReadText(), assertFailurePreText + assertTextVCD);
            reportLog(assertTextVCD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of Standard InFo Link.")
    public void verifyFunctionalityOfStandardInfoLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            studyGuideFeature.removeFromFrame();

            String assertTextVCNDD = "Presence of 'Close Window Modal' icon.";
            Assert.assertTrue(studyGuideFeature.verifyCloseWindowModalIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnCloseWindowModalIcon();

            String assertTextVPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVCND = "Presence of 'Standard Info' Tab.";
            Assert.assertTrue(studyGuideFeature.verifyStandardInfoTab(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

            studyGuideFeature.clickOnStandardInfoTab();

            String assertTextVCDD = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVCDD);
            reportLog(assertTextVCDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 25, description = "Verify Functionality Of Sim Cover Tags Link.")
    public void verifyFunctionalityOfSimCoverLink() {
        boolean result = true;
        try {
            StudyGuideFeature studyGuideFeature = new StudyGuideFeature(webDriver, extentTest, extentReports);

            String assertTextVCNDD = "Presence of 'Standard Cover Tags'.";
            Assert.assertTrue(studyGuideFeature.verifyStandardCoverTag(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            studyGuideFeature.clickOnStandardCoverTag();

            String assertTextVPOG = "Presence of 'Study Guides' Text.";
            Assert.assertTrue(studyGuideFeature.verifyStudyGuideText(), assertFailurePreText + assertTextVPOG);
            reportLog(assertTextVPOG);

            String assertTextVCND = "Presence of 'Standard Info' Tab.";
            Assert.assertTrue(studyGuideFeature.verifyStandardView(), assertFailurePreText + assertTextVCND);
            reportLog(assertTextVCND);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Support button should display and work properly in study guide browse page.")
    public void verifySupportButtonIsAvailable() {
        boolean result = true;
        try {
            SupportFeature supportFeature = new SupportFeature(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of Support Button";
            Assert.assertTrue(supportFeature.verifySupportButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            supportFeature.clickOnSupportButton();
            supportFeature.enterInToParentFrameOfSupport();

            String assertTextVCNDD = "Presence of Support Text";
            Assert.assertTrue(supportFeature.verifySupportText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            supportFeature.removeFromParentFrameOfSupport();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}