package testscripts.regression.teacherlogin.FlexBookModalityFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class PracticePreviewFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(PracticePreviewFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";


    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Preview DropDown is Available in Practice widget modal.")
    public void verifyPreviewButtonISAvailable(String email, String password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

            cBookPageStudent.clickOnTheNextIcon();
            /*Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field ");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");*/

            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), "Test Script Field to verify Toc Icon");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Toc Icon");
            logger.info("Teacher Successfully verify Toc Icon");

            Assert.assertTrue(cBookModalityPage.verifyButtonViewPractice(), "Test Script Field to verify Button View Practice");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Button View Practice");
            logger.info("Teacher Successfully verify Button View Practice");

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            cBookModalityPage.clickOnButtonViewPractice();

            String assertTextVLPC = "Presence of 'Preview DropDown'.";
            Assert.assertTrue(practiceWidgetModal.verifyPreviewDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of Preview DropDown.")
    public void verifyFunctionalityOfPreviewDropDown() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnPreviewDropDown();

            String assertTextVLNC = "Presence of 'DownLoad' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyDownloadButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVLPC = "Presence of 'Customize' button.";
            Assert.assertTrue(practiceWidgetModal.verifyCustomizeButton(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of DownLoad Link.")
    public void verifyFunctionalityOfDownloadButton() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnDownloadButton();

            String assertTextVLNC = "Presence of 'PDF' Link.";
            Assert.assertTrue(practiceWidgetModal.verifyPDFLink(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVLPC = "Presence of 'HTML' Link.";
            Assert.assertTrue(practiceWidgetModal.verifyHTMLLink(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of PDf Format DownLoad link.")
    public void verifyFunctionalityOfPDFLink() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnPDFLink();

            String assertTextVLNC = "Presence of 'Get Answer Key' text.";
            Assert.assertTrue(practiceWidgetModal.verifyGetAnswerKeyText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVLPC = "Presence of 'Close ' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyCloseButton(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of Close PDF Format Download Link.")
    public void verifyFunctionalityOfClosePDFFormatLink() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnCloseButton();

            String assertTextVLPC = "Presence of 'Preview DropDown'.";
            Assert.assertTrue(practiceWidgetModal.verifyPreviewDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            practiceWidgetModal.clickOnPreviewDropDown();

            String assertTextVLNC = "Presence of 'DownLoad' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyDownloadButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            practiceWidgetModal.clickOnDownloadButton();

            String assertTextVLC = "Presence of 'PDF' Link.";
            Assert.assertTrue(practiceWidgetModal.verifyPDFLink(), assertFailurePreText + assertTextVLC);
            reportLog(assertTextVLC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of HTML Format Download Click.")
    public void verifyFunctionalityOfHTMLFormatLink() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnHTMLLink();

            String assertTextVLNC = "Presence of 'Get Answer Key' text.";
            Assert.assertTrue(practiceWidgetModal.verifyGetAnswerKeyText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVLPC = "Presence of 'Close ' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyCloseButton(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality Of Close HTML Format Download Link.")
    public void verifyFunctionalityOfCloseHTMLFormatLink() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            practiceWidgetModal.clickOnCloseButton();

            String assertTextVLPC = "Presence of 'Preview DropDown'.";
            Assert.assertTrue(practiceWidgetModal.verifyPreviewDropDown(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            practiceWidgetModal.clickOnPreviewDropDown();

            String assertTextVLNC = "Presence of 'DownLoad' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyDownloadButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of Customize Link.")
    public void verifyFunctionalityOfCustomizeLink() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);

            String assertTextVTCN = "Presence of 'Customize' button.";
            Assert.assertTrue(practiceWidgetModal.verifyCustomizeButton(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            practiceWidgetModal.clickOnCustomizeButton();

            String assertTextVLPC = "Presence of 'BAck' Button.";
            Assert.assertTrue(practiceWidgetModal.verifyBackButton(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Quiz page is getting Open When user click on customize button.")
    public void verifyQuizPageIsGettingOpen() {
        boolean result = true;
        try {
            PracticeWidgetModal practiceWidgetModal = new PracticeWidgetModal(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);

            cBookPageStudent.clickOnInsightPopUp();

            String assertTextVTCN = "Presence of 'Create Quiz Text'.";
            Assert.assertTrue(practiceWidgetModal.verifyCreateQuizText(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}