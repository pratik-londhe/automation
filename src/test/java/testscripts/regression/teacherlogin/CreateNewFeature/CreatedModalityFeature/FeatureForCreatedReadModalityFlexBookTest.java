package testscripts.regression.teacherlogin.CreateNewFeature.CreatedModalityFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class FeatureForCreatedReadModalityFlexBookTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(FeatureForCreatedReadModalityFlexBookTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify data in Edit tab is displayed in created Modality Page")
    public void verifyDataInEdit(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            String modality = "FlexBook";

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVML = "Presence of Modality link Inside Create New DropDown";
            Assert.assertTrue(createNewModality.verifyModalityLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createNewModality.clickOnModalityLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            String assertTextVSB = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            createFlexBookPage.enterModalityNameFlexBook(modality);
            createNewModality.clickOnSaveButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            String assertTextVRLL = "Presence of Read Modality Type Link";
            Assert.assertTrue(createNewModality.verifyReadLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Finalize Draft' Button After Entering Data In Edit PlaceHolder")
    public void verifyFunctionalityOfKeepDraftButton() {
        CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String description = "Data";

            createdReadModalityFeaturePage.enteredInToParentFrame();
            createdReadModalityFeaturePage.enterDataInEditPlaceHolder(description);
            createdReadModalityFeaturePage.removeFromFrame();

            String assertTextVRLL = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyKeepAsDraftButton(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            createdReadModalityFeaturePage.clickOnKeepAsDraftButton();

            String assertTextVFLL = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFinalizeButton(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

            createdReadModalityFeaturePage.clickOnFinalizeButton();

            String assertTextVRY = "Presence of Assign To Class button";
            Assert.assertTrue(createNewModality.verifyAssignToClassButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "verify Functionality of 'Add To FlexBook' button.")
    public void verifyFunctionalityOfAddToFlexBookButton() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnAddToFlexBookButton();

            Assert.assertTrue(createdReadModalityFeaturePage.verifyOkButton(), "Test Script Field to Verify Okay Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Okay Button");
            logger.info("Teacher Successfully  Verify Okay Button");

            Assert.assertTrue(createdReadModalityFeaturePage.verifyCancelButton(), "Test Script Field to Verify Cancel Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Cancel Button");
            logger.info("Teacher Successfully  Verify Cancel Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Cancel' button of Add To FlexBook Pop Up.")
    public void verifyFunctionalityOfCancelButton() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnCancelButton();

            String assertTextVRY = "Presence of Add To FlexBook Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createdReadModalityFeaturePage.clickOnAddToFlexBookButton();

            Assert.assertTrue(createdReadModalityFeaturePage.verifyOkButton(), "Test Script Field to Verify Okay Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Okay Button");
            logger.info("Teacher Successfully  Verify Okay Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "verify Functionality of 'OK' button of Add To FlexBook Pop Up Without Selecting Any FlexBook.")
    public void verifyFunctionalityOfOKButtonWithoutFlexBook() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnOkButton();

            String assertTextVRY = "Presence of Error Text";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyErrorText(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createdReadModalityFeaturePage.clickOnOkButtonOfErrorPopUp();

            Assert.assertTrue(createdReadModalityFeaturePage.verifyOkButton(), "Test Script Field to Verify Okay Button");
            extentTest.log(LogStatus.PASS, "Teacher Successfully  Verify Okay Button");
            logger.info("Teacher Successfully  Verify Okay Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "verify Functionality of 'Create New FlexBook' button of Add To FlexBook Pop Up.")
    public void verifyFunctionalityOfCreateNewFlexBook() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String assertTextVPI = "Presence of Plus Icon";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyPlusIcon(), assertFailurePreText + assertTextVPI);
            reportLog(assertTextVPI);

            createdReadModalityFeaturePage.clickOnPlusIcon();

            String assertTextVRY = "Presence of Error Text";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFlexBookVersionDropDown(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "verify Functionality of 'FlexBook Second Version' link of Create FlexBook Pop Up.")
    public void verifyFunctionalityOfNewFlexBook() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnFlexBookVersionDropDown();

            String assertTextVPI = "Presence of FlexBook Second Version Link";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFlexBookSecondVersionLink(), assertFailurePreText + assertTextVPI);
            reportLog(assertTextVPI);

            createdReadModalityFeaturePage.clickOnFlexBookSecondVersionLink();

            String assertTextVRY = "Verify Second Version Of FlexBook Is Selected";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFlexBookSecondVersionIsSelected(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "verify Functionality of 'OK' button of Add To FlexBook Pop Up After Selecting  FlexBook.")
    public void verifyFunctionalityOfOKButtonWithFlexBook() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String flexBookName = "FlexBook_";
            createdReadModalityFeaturePage.setNameInPlaceHolder(flexBookName);

            String assertTextVRY = "Presence of Error Text";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyOkButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createdReadModalityFeaturePage.clickOnOkButton();

            String assertTextVAFB = "Presence of Add To FlexBook Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyAddToFlexBookButton(), assertFailurePreText + assertTextVAFB);
            reportLog(assertTextVAFB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "verify Functionality of 'Notes / Highlight' button.")
    public void verifyFunctionalityOfNotesHighlightButton() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String assertTextVRY = "Verify Notes And Highlight Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyHighlightAndNotesButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createdReadModalityFeaturePage.clickOnHighlightAndNotesButton();

            String assertTextVDY = "Presence of 'Notes / Highlight' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyNotesHighlightText(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            String assertTextVTH = "Presence of 'Highlight' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyHighlightText(), assertFailurePreText + assertTextVTH);
            reportLog(assertTextVTH);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "verify Functionality of 'Publish' button.")
    public void verifyFunctionalityOfPublishButton() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            String assertTextVRY = "Verify Publish Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyPublishLink(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createdReadModalityFeaturePage.clickOnPublishLink();

            String assertTextVDY = "Presence of 'Notes / Highlight' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyPublishButton(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "verify Functionality of 'Publish' button without selecting Contribution Type.")
    public void verifyFunctionalityOfPublishButtonWithoutContentType() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnPublishButton();

            String assertTextVRY = "Verify Contribution Type Error Message Text";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyContributionTypeErrorMessageText(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVDY = "Presence of Ck12 Contribution Type CheckBox.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyCk12ContributionTypeCheckBox(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "verify Functionality of 'Publish' button After selecting Contribution Type.")
    public void verifyFunctionalityOfPublishButtonAfterSelectingContentType() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnCk12ContributionTypeCheckBox();

            String assertTextVDY = "Presence of 'Notes / Highlight' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyPublishButton(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            createdReadModalityFeaturePage.clickOnPublishButton();

            String assertTextVMY = "Presence of Modality Publish Text.";
            //Assert.assertTrue(createdReadModalityFeaturePage.verifyModalityPublishedText(), assertFailurePreText + assertTextVMY);
            reportLog(assertTextVMY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}