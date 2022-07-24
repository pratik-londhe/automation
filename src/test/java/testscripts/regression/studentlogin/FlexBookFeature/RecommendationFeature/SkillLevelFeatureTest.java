/*
package testscripts.regression.studentlogin.FlexBookFeature.RecommendationFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.LoginPage;
import uipages.flexbook2feature.RecommendationFeaturePage;
import uipages.flexbook2feature.StudentDashBoardPage;

public class SkillLevelFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(SkillLevelFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";

    private RecommendationFeaturePage recommendationFeaturePage;

    private void reportLog(String assertText) {
        extentTest.log(LogStatus.PASS, assertSuccessPreText + assertText);
        logger.info(assertSuccessPreText + assertText);
    }

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Video is present after clicking on video recommendation.")
    public void verifyVideoIsVisibleInVideoRecommendation(String email, String pass) {
        boolean result = true;
        try {
            recommendationFeaturePage = new RecommendationFeaturePage(webDriver,extentTest,extentReports);
            String url = "https://flexbooks-master.ck12.org/assessment/ui/?test/view/practice/biology/characteristics-of-life-Practice&contextArtifactID=5292077&contextArtifactDescendantIdentifier=1.4&courseContextID=5292077&referrer=course_practice_widget&ep=https://flexbooks-master.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.4/primary/lesson/characteristics-of-life-bio?assessment=open";

            new LoginPage(webDriver,extentTest,extentReports).teacherLogin(email, pass);

            String assertTextVTPOG = "Student profile icon after login";
            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVTPOG);
            reportLog(assertTextVTPOG);

            webDriver.navigate().to(url);

            String assertTextVML = "Presence of 'Start Practice' Button.";
            Assert.assertTrue(recommendationFeaturePage.verifyStartPracticeButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            recommendationFeaturePage.clickOnStartPracticeButton();

            String assertTextVMLA = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVMLA);
            reportLog(assertTextVMLA);

            String assertTextVL = "Presence of 'Video Modality ' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeVideo(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

            recommendationFeaturePage.clickOnModalityTypeVideo();
            recommendationFeaturePage.enteredIntoFrame();

            String assertTextVLN = "Presence of 'Modality Title'.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTitleText(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            recommendationFeaturePage.removeFromFrame();

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyCloseIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            recommendationFeaturePage.clickOnCloseIcon();

            String assertTextVPL = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVPL);
            reportLog(assertTextVPL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 3, description = "Verify Video is present after clicking on Real World recommendation.")
    public void verifyVideoIsVisibleOfRealWorldRecommendation() {
        boolean result = true;
        try {

            String assertTextVOD = "Presence of 'Real World Modality' Type.";
            Assert.assertTrue(recommendationFeaturePage.verifyModalityTypeRealWorld(), assertFailurePreText + assertTextVOD);
            reportLog(assertTextVOD);

            recommendationFeaturePage.clickOnModalityTypeRealWorld();
            recommendationFeaturePage.enteredIntoFrame();

//            String assertTextVL = "Presence of 'Modality Title'.";
//            Assert.assertTrue(recommendationFeaturePage.verifyModalityTitleText(), assertFailurePreText + assertTextVL);
//            reportLog(assertTextVL);

            recommendationFeaturePage.removeFromFrame();

            String assertTextVM = "Presence of 'Recommend Title' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyCloseIcon(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            recommendationFeaturePage.clickOnCloseIcon();

            String assertTextVPL = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVPL);
            reportLog(assertTextVPL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 5, description = "Verify Functionality Of return to practice link.")
    public void verifyReturnToPracticeButton() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyReturnToPracticeIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            recommendationFeaturePage.clickOnReturnToPracticeIcon();

            String assertTextVM = "Presence of 'Skill Level' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLevelText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    //@Test(priority = 7, description = "Verify Skill Dial Image and skill LAbel are display..")
    public void verifySkillLevel() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Skill Dial Image'.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillDialImage(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVM = "Presence of 'Skill Label' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLabelText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 9, description = "Verify Functionality of skill level icon wrapper.")
    public void verifyFunctionalityOfSkillLevelWrapper() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Skill Dial Image'.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLevelWrapperIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            recommendationFeaturePage.clickOnSKillLevelWrapperIcon();

            String assertTextVM = "Presence of 'Skill Level' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLevelText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVMA = "Presence of 'Speech' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySpeechText(), assertFailurePreText + assertTextVMA);
            reportLog(assertTextVMA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 11, description = "Verify functionality of Ok button after clicking on skill level icon wrapper..")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of 'Ok' Button.";
            Assert.assertTrue(recommendationFeaturePage.verifyOkButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            recommendationFeaturePage.clickOnOkButton();

            String assertTextVM = "Presence of 'Skill Level' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLevelText(), assertFailurePreText + assertTextVM);
            reportLog(assertTextVM);

            String assertTextVMA = "Presence of 'Skill Label' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifySkillLabelText(), assertFailurePreText + assertTextVMA);
            reportLog(assertTextVMA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

   // @Test(priority = 13, description = "Verify Recommendation picture is display after giving answer of two wrong question.")
    public void verifyRecommendationPageIsDisplay() {
        boolean result = true;
        try {
            recommendationFeaturePage.giveTheAnswerOfQuestions();

            String assertTextVMLA = "Presence of 'We Recommend' Text.";
            Assert.assertTrue(recommendationFeaturePage.verifyWeRecommendText(), assertFailurePreText + assertTextVMLA);
            reportLog(assertTextVMLA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}*/
