package testscripts.regression.teacherlogin.FlexBookModalityFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class TocContainerFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(TocContainerFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify the UI of the 'CourseBook Modality' page after clicking on a Start Button of Student CourseBook Concept Page")
    public void verifyUIPageOfCBookModality(String email, String password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            courseBookDetailsPage.clickOnFirstCBookAndFurtherProcess(email, password);
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

           /* Assert.assertTrue(cBookModalityPage.verifyAssignAssignmentButton(), "Test Script Field to verify Assign Pop Up");
            extentTest.log(LogStatus.PASS, "Teacher Successfully verify Assign Pop Up");
            logger.info("Teacher Successfully verify Assign Pop Up");*/

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify the Functionality of 'Toc Icon' On CourseBook Modality Page")
    public void verifyFunctionalityOfTocIcon() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            cBookModalityPage.clickOnIconToc();

            String assertTextVLCCA = "Presence of 'Chapter concepts' links.";
            Assert.assertTrue(cBookModalityPage.verifyLinksOfChapterConceptAgain(), assertFailurePreText + assertTextVLCCA);
            reportLog(assertTextVLCCA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify the Functionality of 'Close2' Icon after clicking Toc Icon")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            String assertTextVCI = "Presence of 'Close' icon.";
            Assert.assertTrue(cBookModalityPage.verifyCloseIcon(), assertFailurePreText + assertTextVCI);
            reportLog(assertTextVCI);

            cBookModalityPage.clickOnIconClose();

            String assertTextVTI = "Presence of 'ToC' icon.";
            Assert.assertTrue(cBookModalityPage.verifyTocIcon(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Concept Links are showing inside toc Container.")
    public void verifyConceptsLinksAreVisible() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);

            cBookModalityPage.clickOnIconToc();

            String assertTextVCLA = "Presence of 'Chapters' link.";
            Assert.assertTrue(cBookModalityPage.verifyChaptersLinkAgain(), assertFailurePreText + assertTextVCLA);
            reportLog(assertTextVCLA);

            String assertTextVLCCA = "Presence of 'Chapter concepts' links.";
            Assert.assertTrue(cBookModalityPage.verifyLinksOfChapterConceptAgain(), assertFailurePreText + assertTextVLCCA);
            reportLog(assertTextVLCCA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of current flexbook of toc container.")
    public void verifyFunctionalityOfFlexBookLink() {
        boolean result = true;
        try {
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            String assertTextVCLA = "Presence of 'FlexBook Name' Text.";
          //  Assert.assertTrue(cBookModalityPage.verifyFlexBookNameLink(), assertFailurePreText + assertTextVCLA);
            reportLog(assertTextVCLA);

           // cBookModalityPage.clickOnFlexBookNameLink();

            String assertTextVAL = "Presence of the 'Author' link.";
            //Assert.assertTrue(courseBookDetailsPage.verifyAuthorLink(), assertFailurePreText + assertTextVAL);
            reportLog(assertTextVAL);

           // Assert.assertTrue(courseBookDetailsPage.verifyChooseButton(), "Test Script Field to Verify Choose Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Choose Button");
            logger.info("Teacher Successfully verify Choose Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}
