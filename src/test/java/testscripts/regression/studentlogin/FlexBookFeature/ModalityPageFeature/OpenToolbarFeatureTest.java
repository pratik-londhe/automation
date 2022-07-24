package testscripts.regression.studentlogin.FlexBookFeature.ModalityPageFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class OpenToolbarFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(OpenToolbarFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    private String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of 'Toolbar' Close button.")
    public void verifyFunctionalityOfCloseOpenToolbarIcon(String email, String Password) {
        boolean result = true;
        try {
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);
            CBookModalityPage cBookModalityPage = new CBookModalityPage(webDriver, extentTest, extentReports);
            CBookPageStudent cBookPageStudent = new CBookPageStudent(webDriver, extentTest, extentReports);
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            cBookPageStudent.clickOnTryItNowPopUp(email, Password);
            courseBookDetailsPage.clickOnFirstFlexBook();

            String assertTextVSCDB = "Presence of 'Start Course Details' button.";
            Assert.assertTrue(cBookPageStudent.verifyStartCourseDetailsButton(), assertFailurePreText + assertTextVSCDB);
            reportLog(assertTextVSCDB);

            cBookPageStudent.clickOnStartCourseDetailButton();
            new CBookPrimaryConceptPage(webDriver, extentTest, extentReports).clickOnStart();

            String assertTextVLNC = "Presence of 'Next Concept' link.";
            Assert.assertTrue(cBookModalityPage.verifyLinkOfNextConcept(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLN = "Presence of 'Close Toolbar' Button.";
            Assert.assertTrue(openToolbarFeature.verifyCloseToolbarButton(), assertFailurePreText + assertTextVLN);
            reportLog(assertTextVLN);

            openToolbarFeature.clickOnCloseToolbarButton();

            String assertTextVTCN = "Presence of 'Open' Toolbar.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Learning Tools, Action, More Categary are available.")
    public void verifyAvailableCategary() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnOpenButton();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLPC = "Presence of 'Learning Tool' Text.";
            Assert.assertTrue(openToolbarFeature.verifyLearningToolText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Action' Text.";
            Assert.assertTrue(openToolbarFeature.verifyActionText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify related content is available inside Learning tools.")
    public void verifyRelatedContentButtonIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVTCN = "Presence of 'More' text.";
            Assert.assertTrue(openToolbarFeature.verifyMoreText(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            String assertTextVTIA = "Presence of 'Related Content' Button.";
            Assert.assertTrue(openToolbarFeature.verifyRelatedContentButton(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Related Content' button. ")
    public void verifyFunctionalityOfRelatedContentButtonIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnRelatedContentButton();

            String assertTextVTCN = "Presence of 'Related Content' text.";
            Assert.assertTrue(openToolbarFeature.verifyRelatedContentText(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            String assertTextVTIA = "Presence of 'No Content' Text.";
            Assert.assertTrue(openToolbarFeature.verifyNoContentText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 8, description = "Verify the Functionality of 'Down Arrow Icon' On CourseBook Modality Toolbar")
    public void verifyFunctionalityOfBackIcon() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVTCN = "Presence of BAck' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyBackIcon(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            openToolbarFeature.clickOnBackIcon();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);


            String assertTextVLPC = "Presence of 'Learning Tool' Text.";
            Assert.assertTrue(openToolbarFeature.verifyLearningToolText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Action' Text.";
            Assert.assertTrue(openToolbarFeature.verifyActionText(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);


        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify resources is available inside Learning tools.")
    public void verifyResourcesButtonIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVLPC = "Presence of 'Learning Tool' Text.";
            Assert.assertTrue(openToolbarFeature.verifyLearningToolText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Resources' Button.";
            Assert.assertTrue(openToolbarFeature.verifyResourcesButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify the Functionality of ' Resources' Icon On CourseBook Modality Page.")
    public void verifyFunctionalityOfResourcesButton() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnResourcesButton();

            String assertTextVLPC = "Presence of 'Resources' Text.";
            Assert.assertTrue(openToolbarFeature.verifyResourcesText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVTCN = "Presence of BAck' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyBackIcon(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

            openToolbarFeature.clickOnBackIcon();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify setting are available inside More categary.")
    public void verifySettingButtonIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            String assertTextVLPC = "Presence of 'Learning Tool' Text.";
            Assert.assertTrue(openToolbarFeature.verifyLearningToolText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Setting' Button.";
            Assert.assertTrue(openToolbarFeature.verifySettingButton(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify the Functionality of 'Settings' Icon On CourseBook Modality Page.")
    public void verifyFunctionalityOfSettingButton() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnSettingButton();

            String assertTextVLPC = "Presence of 'Setting' Text.";
            Assert.assertTrue(openToolbarFeature.verifySettingText(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

            String assertTextVLNC = "Presence of 'Font Size' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyFontSizeIcon(), assertFailurePreText + assertTextVLNC);
            reportLog(assertTextVLNC);

            String assertTextVTCN = "Presence of BAck' Icon.";
            Assert.assertTrue(openToolbarFeature.verifyBackIcon(), assertFailurePreText + assertTextVTCN);
            reportLog(assertTextVTCN);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Details button is available inside More categary.")
    public void verifyDetailsButtonIsVisible() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnBackIcon();

            String assertTextVTIA = "Presence of 'Toolbar' Text.";
            Assert.assertTrue(openToolbarFeature.verifyToolbarText(), assertFailurePreText + assertTextVTIA);
            reportLog(assertTextVTIA);

            String assertTextVLPC = "Presence of 'Details' Button.";
            Assert.assertTrue(openToolbarFeature.verifyDetailsButton(), assertFailurePreText + assertTextVLPC);
            reportLog(assertTextVLPC);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of Details button .")
    public void verifyFunctionalityOfDetailsButton() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);
            CourseBookDetailsPage courseBookDetailsPage = new CourseBookDetailsPage(webDriver, extentTest, extentReports);

            openToolbarFeature.clickOnDetailsButton();

            /*String assertTextVET = "Presence of 'Editor' text.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyEditorText(), assertFailurePreText + assertTextVET);
            reportLog(assertTextVET);*/

            String assertTextVGT = "Presence of 'Grade' text.";
            Assert.assertTrue(courseBookDetailsPage.verifyGradeText(), assertFailurePreText + assertTextVGT);
            reportLog(assertTextVGT);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify the Functionality of 'Back To Page' Link On CourseBook Details Page")
    public void verifyFunctionalityBackToPageLink() {
        boolean result = true;
        try {
            OpenToolbarFeature openToolbarFeature = new OpenToolbarFeature(webDriver, extentTest, extentReports);
            CBookOptionDropDownFeatures cBookOptionDropDownFeatures = new CBookOptionDropDownFeatures(webDriver, extentTest, extentReports);

            String assertTextVBPB = "Presence of 'Back to Page' button.";
            Assert.assertTrue(cBookOptionDropDownFeatures.verifyBackToPageButton(), assertFailurePreText + assertTextVBPB);
            reportLog(assertTextVBPB);

            cBookOptionDropDownFeatures.clickOnBackToPageButton();

            String assertTextVTI = "Presence of 'Open' Button.";
            Assert.assertTrue(openToolbarFeature.verifyOpenButton(), assertFailurePreText + assertTextVTI);
            reportLog(assertTextVTI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}