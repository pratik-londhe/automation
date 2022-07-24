package testscripts.regression.InvalidTestCases;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class RecommendationParagraphFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(RecommendationParagraphFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";
    private RecommendationParagraphFeature recommendationParagraphFeature;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Indicator Ring' Icon Is Visible On FlexBook Modality Page.")
    public void verifyIndicatorRingIconIsVisible(String email, String password) {
        boolean result = true;
        try {
            recommendationParagraphFeature = new RecommendationParagraphFeature(webDriver,extentTest,extentReports);

            String url = "https://flexbooks-master.ck12.org/cbook/ck-12-biology-flexbook-2.0/section/1.1/primary/lesson/scientific-investigation-bio";

            new LoginPage(webDriver,extentTest, extentReports).studentLogin(email, password);

            String assertTextVSPOG = "Student profile icon after logging in.";
            Assert.assertTrue(new StudentDashBoardPage(webDriver,extentTest,extentReports).verifyStudentProfileOnGamma(), assertFailurePreText + assertTextVSPOG);
            reportLog(assertTextVSPOG);

            webDriver.navigate().to(url);
            recommendationParagraphFeature.scrollScreen();

            String assertTextVCNDD = "Presence of 'Indicator Ring' Icon.";
            Assert.assertTrue(recommendationParagraphFeature.verifyIndicatorRingIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Indicator Ring' Icon.")
    public void verifyFunctionalityIndicatorRingIcon() {
        boolean result = true;
        try {
            recommendationParagraphFeature.clickOnIndicatorRingIcon();

            String assertTextVCNDD = "Presence of 'Recommendation Paragraph' Text.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRecommendationParagraphText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            String assertTextVEB = "Presence of 'Missed Question Text' .";
            Assert.assertTrue(recommendationParagraphFeature.verifyMissedQuestionsText(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Ui Page Of'Recommendation Paragraph'.")
    public void verifyUIPageOfRecommendationParagraph() {
        boolean result = true;
        try {
            recommendationParagraphFeature.enterIntoParentFrame();

            String assertTextVCNDD = "Presence of 'Multiple Choice' Question.";
            Assert.assertTrue(recommendationParagraphFeature.verifyMultipleChoiceQuestion(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.removeFromFrame();

            String assertTextVEB = "Presence of 'Left Arrow' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyLeftArrowIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVAB = "Presence of 'Right Arrow' Icon.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRightArrowIcon(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Left Arrow' Icon Of Recommendation Paragraph Page.")
    public void verifyFunctionalityOfLeftArrowIcon() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Left Arrow' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyLeftArrowIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnLeftArrowIcon();

            String assertTextVCNDD = "Presence of 'Recommendation Paragraph' Text.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRecommendationParagraphText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.enterIntoChildFrame();

            String assertTextVAB = "Presence of 'Fill in the Blank' Question.";
            Assert.assertTrue(recommendationParagraphFeature.verifyFillInTheBlanksQuestion(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            recommendationParagraphFeature.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Right Arrow' Icon Of Recommendation Paragraph Page.")
    public void verifyFunctionalityOfRightArrowIcon() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Right Arrow' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyRightArrowIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnRightArrowIcon();

            String assertTextVCNDD = "Presence of 'Recommendation Paragraph' Text.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRecommendationParagraphText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.enterIntoParentFrame();

            String assertTextVAB = "Presence of 'Multiple Choice' Question.";
            Assert.assertTrue(recommendationParagraphFeature.verifyMultipleChoiceQuestion(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            recommendationParagraphFeature.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Second Question Dot ' and Verify Its navigate to Second Question.")
    public void verifyFunctionalityOfSecondQuestionDot() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Active Dot' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyActiveDot(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVNAD = "Presence of 'Non Active Dot' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyNonActiveDot(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

            recommendationParagraphFeature.clickOnNonActiveDot();

            String assertTextVCNDD = "Presence of 'Recommendation Paragraph' Text.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRecommendationParagraphText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.enterIntoChildFrame();

            String assertTextVAB = "Presence of 'Fill in the Blank' Question.";
            Assert.assertTrue(recommendationParagraphFeature.verifyFillInTheBlanksQuestion(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

            recommendationParagraphFeature.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of 'First Question Dot ' and Verify Its navigate to First Question.")
    public void verifyFunctionalityOfFirstQuestionDot() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Active Dot' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyActiveDot(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            String assertTextVNAD = "Presence of 'Non Active Dot' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyNonActiveDot(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

            recommendationParagraphFeature.clickOnNonActiveDot();

            String assertTextVCNDD = "Presence of 'Recommendation Paragraph' Text.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRecommendationParagraphText(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.enterIntoParentFrame();

            String assertTextVAB = "Presence of 'Multiple Choice' Question.";
            Assert.assertTrue(recommendationParagraphFeature.verifyMultipleChoiceQuestion(), assertFailurePreText + assertTextVAB);
            reportLog(assertTextVAB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality When Giving Right Answer Of Question.")
    public void verifyFunctionalityWhenGivingRightAnswerOfQuestion() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Option D'.";
            Assert.assertTrue(recommendationParagraphFeature.verifyOptionD(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnOptionD();

            String assertTextVNAD = "Presence of 'Check Mark ' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyCheckMarkIcon(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Try Again' Button After Giving Right Answer.")
    public void verifyFunctionalityTryAgainButtonAfterGivingRightAnswer() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Try Again' Button.";
            Assert.assertTrue(recommendationParagraphFeature.verifyTryAgainButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnTryAgainButton();

            String assertTextVNAD = "Presence of 'Check Mark ' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyOptionD(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

            String assertTextVCNDD = "Not Presence of 'CheckMark' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyCheckMarkIconIsNotPresent(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality When Giving Wrong Answer Of Question..")
    public void verifyFunctionalityWhenGivingWrongAnswerOfQuestion() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Right Arrow' Icon.";
            Assert.assertTrue(recommendationParagraphFeature.verifyRightArrowIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnRightArrowIcon();

            recommendationParagraphFeature.enterIntoChildFrame();

            String assertTextVNAD = "Presence of 'Check It ' Button .";
            Assert.assertTrue(recommendationParagraphFeature.verifyCheckItButton(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

            recommendationParagraphFeature.setValueInAnswerPlaceHolder();
            recommendationParagraphFeature.clickOnCheckItButton();

            String assertTextVCNDD = "Presence of 'Close' Icon .";
            Assert.assertTrue(recommendationParagraphFeature.verifyCloseIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of 'Try Again' Button After Giving Wrong Answer.")
    public void verifyFunctionalityTryAgainButtonWhenGivingWrongAnswerOfQuestion() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Try Again' Button.";
            Assert.assertTrue(recommendationParagraphFeature.verifyTryAgainButton(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnTryAgainButton();

            String assertTextVNAD = "Presence of 'Check It ' Button .";
            Assert.assertTrue(recommendationParagraphFeature.verifyCheckItButton(), assertFailurePreText + assertTextVNAD);
            reportLog(assertTextVNAD);

            String assertTextVCNDD = "Presence of 'Close' Icon Is Not Present.";
            Assert.assertTrue(recommendationParagraphFeature.verifyCloseIconIsNotPresent(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

            recommendationParagraphFeature.removeFromFrame();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'Question Modal Close' Icon Of Recommendation Page.")
    public void verifyFunctionalityQuestionModalCloseIcon() {
        boolean result = true;
        try {
            String assertTextVEB = "Presence of 'Question Modal Close ' Icon.";
            Assert.assertTrue(recommendationParagraphFeature.verifyQuestionModalCloseIcon(), assertFailurePreText + assertTextVEB);
            reportLog(assertTextVEB);

            recommendationParagraphFeature.clickOnQuestionModalCloseIcon();

            String assertTextVCNDD = "Presence of 'Indicator Ring' Icon.";
            Assert.assertTrue(recommendationParagraphFeature.verifyIndicatorRingIcon(), assertFailurePreText + assertTextVCNDD);
            reportLog(assertTextVCNDD);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}