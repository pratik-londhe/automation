package testscripts.regression.studentlogin.FlexBookFeature.RecommendationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.RecommendationFeaturePage;
import uipages.flexbook2feature.StudentDashBoardPage;

public class RecommendationFeaturePageTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(RecommendationFeaturePageTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of Start Practicing button.")
    public void verifyFunctionalityOfStartPracticeButton(String email, String pass) {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);
            String url = "https://flexbooks-master.ck12.org/assessment/ui/?test/view/practice/biology/interdependence-of-living-things-Practice&contextArtifactID=5292077&contextArtifactDescendantIdentifier=1.6&courseContextID=5292077&referrer=course_practice_widget&ep=https://flexbooks-master.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.6/primary/lesson/interdependence-of-living-things-bio?assessment=open";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, pass);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new StudentDashBoardPage(webDriver, extentTest, extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'Start Practice' Button.";
            Assert.assertTrue(recommendationFeaturePage.verifyStartPracticeButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify UI page of recommendation.")
    public void verifyUIPageOfRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            recommendationFeaturePage.clickOnStartPracticeButton();

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyRecommendTitleText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Speech Bubble text is display on the recommendation page.")
    public void verifySpeechBubbleTextIsVisible() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Bubble Speech' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyBubbleSpeechIsDisplay(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Character Image' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyCharacterImage(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify functionality of Close icon of of recommendation page.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVOD = "Presence of 'Close Bubble' Icon.";
            Assert.assertTrue(recommendationFeaturePage.verifyCloseBubbleIcon(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            recommendationFeaturePage.clickOnCloseBubbleIcon();

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Not Presence of 'Bubble Speech' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyBubbleSpeechIsNotDisplay(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify recommendation for Read, Video , Real world are present.")
    public void verifyAllRecommendationArePresent() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Read Modality' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeRead(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Video Modality' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeVideo(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVOD = "Presence of 'Real World Modality' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeRealWorld(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Read Modality Type Recommendation.")
    public void verifyFunctionalityOfReadRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            recommendationFeaturePage.clickOnModalityTypeRead();
            recommendationFeaturePage.enteredIntoFrame();

            String assertTextVML = "Presence of 'Modality Title'.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTitleText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Modality Content'.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityContent(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            recommendationFeaturePage.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of Close icon of Read Recommendation Page.")
    public void verifyFunctionalityOfCloseReadIcon() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyCloseIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            recommendationFeaturePage.clickOnCloseIcon();

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Check icon on read recommendation  is visible after  completing the read practice.")
    public void verifyCheckIconOfReadRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyRecommendTitleText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVML = "Presence of 'Read CheckMark' Icon.";
            Assert.assertTrue(recommendationFeaturePage.verifyReadCheckMarkIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify return to practice link is visible after completing practice of any recommendation.")
    public void verifyReturnToPracticeButton() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyReturnToPracticeIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyUnlockedIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of Video Recommendation.")
    public void verifyFunctionalityOfVideoRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVML = "Presence of 'Video Modality ' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeVideo(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            recommendationFeaturePage.clickOnModalityTypeVideo();
            recommendationFeaturePage.enteredIntoFrame();

            String assertTextVL = "Presence of 'Modality Title'.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTitleText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            recommendationFeaturePage.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of Close icon of Video Recommendation Page.")
    public void verifyFunctionalityOfCloseVideoIcon() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyCloseIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            recommendationFeaturePage.clickOnCloseIcon();

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Check icon on read recommendation  is visible after  completing the Video practice.")
    public void verifyCheckIconOfVideoRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyRecommendTitleText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVML = "Presence of 'Video CheckMark' Icon.";
            Assert.assertTrue(recommendationFeaturePage.verifyVideoCheckMarkIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of Real World Recommendation.")
    public void verifyFunctionalityOfRealWorldRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVOD = "Presence of 'Real World Modality' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeRealWorld(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            recommendationFeaturePage.clickOnModalityTypeRealWorld();

            //
            recommendationFeaturePage.enteredIntoFrame();

            String assertTextVL = "Presence of 'Modality Title'.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTitleText(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            recommendationFeaturePage.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of Close icon of Real World Recommendation Page.")
    public void verifyFunctionalityOfCloseRealWorldIcon() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            /*String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyMultipleBrowserTabsPresent(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);*/

            recommendationFeaturePage.clickOnCloseIcon();

            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Check icon on read recommendation  is visible after  completing the Real World practice.")
    public void verifyCheckIconOfRealWorldRecommendation() {
        boolean result = true;
        try {
            RecommendationFeaturePage recommendationFeaturePage = new RecommendationFeaturePage(webDriver, extentTest, extentReports);

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyRecommendTitleText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVML = "Presence of 'Real World CheckMark' Icon.";
            Assert.assertTrue(recommendationFeaturePage.verifyRealWorldCheckMarkIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
