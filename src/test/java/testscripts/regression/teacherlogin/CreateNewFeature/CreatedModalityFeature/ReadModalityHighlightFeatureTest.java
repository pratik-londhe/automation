package testscripts.regression.teacherlogin.CreateNewFeature.CreatedModalityFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ReadModalityHighlightFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ReadModalityHighlightFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of 'Keep As Draft' Button After Entering Data In Edit PlaceHolder.")
    public void verifyDataInEdit(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

            String modality = "FlexBook";
            String description = "Data";

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

            createdReadModalityFeaturePage.clickOnBoldTag();
            createdReadModalityFeaturePage.enteredInToParentFrame();
            createdReadModalityFeaturePage.enterDataInEditPlaceHolder(description);
            createdReadModalityFeaturePage.removeFromFrame();

            String assertTextVRLLl = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyKeepAsDraftButton(), assertFailurePreText + assertTextVRLLl);
            reportLog(assertTextVRLLl);

            createdReadModalityFeaturePage.clickOnKeepAsDraftButton();

            String assertTextVFLL = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFinalizeButton(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 2, description = "Verify Highlighted Data Is Shown In the Notes / Highlight Section")
    public void verifyHighlightedData() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            createdReadModalityFeaturePage.clickOnFinalizeButton();

            String assertTextVRY = "Presence of Assign To Class button";
            Assert.assertTrue(createNewModality.verifyAssignToClassButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVHB = "Presence of 'Highlight' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyHighlightButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

            cBookHighLightFunctionality.clickOnHighLightButton();
            createdReadModalityFeaturePage.clickForHighlightText();

            //String assertTextVDY = "Presence of Highlighted Data In Highlight And Notes Section";
            //Assert.assertTrue(createdReadModalityFeaturePage.verifyHighlightedDataPresentInNotesAndHighlightSection(), assertFailurePreText + assertTextVDY);
            //reportLog(assertTextVDY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "verify Noted Data Is Shown In the Notes / Highlight Section")
    public void verifyNotedDataAreShownInHighlightAndNotesSection() {
        boolean result = true;
        try {
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);
            CBookHighLightFunctionality cBookHighLightFunctionality = new CBookHighLightFunctionality(webDriver, extentTest, extentReports);

            String addNote = "Important";

            String assertTextVHB = "Presence of 'Add note' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyAddNoteButton(), assertFailurePreText + assertTextVHB);
            reportLog(assertTextVHB);

            cBookHighLightFunctionality.clickOnAddNotesButton();
            createdReadModalityFeaturePage.clickForAddNoteInText();

            /*String assertTextVCAB = "Presence of 'Cancel Annotation' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifyCancelAnnotatorButton(), assertFailurePreText + assertTextVCAB);
            reportLog(assertTextVCAB);

            createdReadModalityFeaturePage.enterDataInAddNotePlaceHolder(addNote);

            String assertTextVCABS = "Presence of 'Save Annotation' button.";
            Assert.assertTrue(cBookHighLightFunctionality.verifySaveAnnotatorButton(), assertFailurePreText + assertTextVCABS);
            reportLog(assertTextVCABS);

            cBookHighLightFunctionality.clickOnSaveAnnotatorButton();

            String assertTextVDY = "Presence of Noted Data In Highlight And Notes Section";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyNotedDataPresentInNotesAndHighlightSection(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "verify Functionality of 'Delete' icon of Note/highlight content.")
    public void verifyFunctionalityOfDeleteIcon() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);
        boolean result = true;
        try {
            String assertTextVDY = "Presence of 'Delete' Icon.";
            //Assert.assertTrue(createdReadModalityFeaturePage.verifyDeleteIcon(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            //createdReadModalityFeaturePage.clickOnDeleteIcon();

            String assertTextVNY = "Presence of 'Notes / Highlight' text.";
            //Assert.assertTrue(createdReadModalityFeaturePage.verifyNotesHighlightText(), assertFailurePreText + assertTextVNY);
            reportLog(assertTextVNY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Show Resources' DropDown.")
    public void verifyFunctionalityOfShowResourcesDropDown() {
        CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

        boolean result = true;
        try {
            createdReadModalityFeaturePage.clickOnShowResourcesDropDown();

            String assertTextVDY = "Presence of 'Hide Resources' DropDown.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyHideResourcesDropDown(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            String assertTextVNY = "Presence of 'No Resources Content ' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyNoResourcesText(), assertFailurePreText + assertTextVNY);
            reportLog(assertTextVNY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "verify Functionality of 'Hide Resources' DropDown.")
    public void verifyFunctionalityOfHideResourcesDropDown() {
        boolean result = true;
        try {
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

            createdReadModalityFeaturePage.clickOnHideResourcesDropDown();

            String assertTextVDY = "Presence of 'Show Resources' DropDown.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyShowResourcesDropDown(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            String assertTextVNY = "Presence of ' Resources  ' button.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyResourcesButton(), assertFailurePreText + assertTextVNY);
            reportLog(assertTextVNY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "verify Functionality of ' Resources' Button.")
    public void verifyFunctionalityOfResourcesButton() {
        boolean result = true;
        try {
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);

            createdReadModalityFeaturePage.clickOnResourcesButton();

            String assertTextVDY = "Presence of 'Hide Resources' DropDown.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyHideResourcesDropDown(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            String assertTextVNY = "Presence of 'No Resources Content ' text.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyNoResourcesText(), assertFailurePreText + assertTextVNY);
            reportLog(assertTextVNY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "verify Functionality of ' Edit' Button.")
    public void verifyFunctionalityOfEditButton() {
        boolean result = true;
        try {
            CreatedReadModalityFeaturePage createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String assertTextVDY = "Presence of 'Edit' Button.";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyEditButton(), assertFailurePreText + assertTextVDY);
            reportLog(assertTextVDY);

            createdReadModalityFeaturePage.clickOnEditButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}