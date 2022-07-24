package testscripts.regression.JenkinsBlocker;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AddResourcesInModalityFlexBookTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AddResourcesInModalityFlexBookTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    TeacherDashboardPage teacherDashboardPage;
    public CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;
    public CreateFlexBookPage createFlexBookPage;
    private CreatedReadModalityFeaturePage createdReadModalityFeaturePage;
    private AddResourcesInModality addResourcesInModality;
    private CreateNewModality createNewModality;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality Of Resources Tab After Saving The Read Modality FlexBook")
    public void verifyFunctionalityOfResourcesTab(String email, String password) {
        boolean result = true;
        try {
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver,extentTest,extentReports);
            addResourcesInModality = new AddResourcesInModality(webDriver,extentTest,extentReports);
            createNewModality = new CreateNewModality(webDriver,extentTest,extentReports);

            String modality = "FlexBook";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver,extentTest,extentReports).clickOnLibraryTab();

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

            createFlexBookPage.enterModalityName(modality);
            createNewModality.clickOnSaveButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

            String assertTextVRLL = "Presence of Read Modality Type Link";
            Assert.assertTrue(createNewModality.verifyReadLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            String assertTextVRLLl = "Presence of 'Resources' Tab";
            Assert.assertTrue(addResourcesInModality.verifyResourcesTab(), assertFailurePreText + assertTextVRLLl);
            reportLog(assertTextVRLLl);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Upload Files' Button to add resources And Verify File Is Uploaded Successfully.")
    public void verifyFunctionalityOfUploadFilesButton() {
        boolean result = true;
        try {
            addResourcesInModality.clickOnResourcesTab();

            String assertTextVFLL = "Presence of 'Upload Files' Button";
            Assert.assertTrue(addResourcesInModality.verifyUploadFilesButton(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

            addResourcesInModality.setPathOfFile();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyUploadedFilesAreVisible(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of Remove Uploaded File.")
    public void verifyFunctionalityOfRemoveUploadedFile() {
        boolean result = true;
        try {
            String assertTextVFLL = "Presence of 'Remove File' Icon";
            Assert.assertTrue(addResourcesInModality.verifyCloseIcon(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

            addResourcesInModality.clickOnCloseIcon();

            String assertTextVFL = "Presence of 'Cancel' Button";
            Assert.assertTrue(addResourcesInModality.verifyCancelButton(), assertFailurePreText + assertTextVFL);
            reportLog(assertTextVFL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 6, description = "Verify Functionality Of 'Remove' Button after Clicking On close Icon.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            String assertTextVFL = "Presence of 'Remove' Button";
            Assert.assertTrue(addResourcesInModality.verifyRemoveButton(), assertFailurePreText + assertTextVFL);
            reportLog(assertTextVFL);

            addResourcesInModality.clickOnRemoveButton();

            String assertTextVL = "Presence of 'Upload Files' Button";
            Assert.assertTrue(addResourcesInModality.verifyUploadFilesButton(), assertFailurePreText + assertTextVL);
            reportLog(assertTextVL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Uploaded File is ByDefault Private.")
    public void verifyFileIsPrivate() {
        boolean result = true;
        try {
            addResourcesInModality.setPathOfFile();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyUploadedFilesAreVisible(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFLL = "Presence of 'Make Public' Link";
            Assert.assertTrue(addResourcesInModality.verifyMakePublicLink(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Edit' Icon Of Uploaded File.")
    public void verifyFunctionalityOfCancelEditResourcesButton() {
        boolean result = true;
        try {
            String assertTextVML = "Presence of Edit Icon";
            Assert.assertTrue(addResourcesInModality.verifyEditIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            addResourcesInModality.clickOnEditIcon();

            String assertTextVEL = "Presence of Edit Resources Text";
            Assert.assertTrue(addResourcesInModality.verifyEditResourcesText(), assertFailurePreText + assertTextVEL);
            reportLog(assertTextVEL);

            String assertTextVOEL = "Published CheckBox Is Selected";
            Assert.assertTrue(addResourcesInModality.verifyPublishedCheckBox(), assertFailurePreText + assertTextVOEL);
            reportLog(assertTextVOEL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Save' button without giving Description when published CheckBox Is Selected")
    public void verifySaveButtonWithoutDescription() {
        boolean result = true;
        try {
            String description = "";
            addResourcesInModality.removeDescriptionText(description);
            addResourcesInModality.clickOnPublishedCheckBox();
            addResourcesInModality.clickOnSaveButton();

            String assertTextVML = "Presence of Edit Resources Text";
            Assert.assertTrue(addResourcesInModality.verifyEditResourcesText(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVEL = "Presence of Please Enter Description Text";
            Assert.assertTrue(addResourcesInModality.verifyPleaseEnterDescriptionText(), assertFailurePreText + assertTextVEL);
            reportLog(assertTextVEL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Save' button After Giving Description.")
    public void verifySaveButtonWithDescription() {
        boolean result = true;
        try {
            String description = "Make Public";
            addResourcesInModality.enterDescriptionText(description);

            String assertTextVLL = "Presence of Cancel Edit Resources Button";
            Assert.assertTrue(addResourcesInModality.verifySaveButton(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            addResourcesInModality.clickOnSaveButton();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyUploadedFilesAreVisible(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Uploaded File Is Became Public File Successfully.")
    public void verifyPublicFile() {
        boolean result = true;
        try {
            String assertTextVFLL = "Presence of 'Make Public' Link";
            Assert.assertTrue(addResourcesInModality.verifyMakePublicLink(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

            String assertTextVML = "Presence of Edit Icon";
            Assert.assertTrue(addResourcesInModality.verifyEditIcon(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            addResourcesInModality.clickOnEditIcon();

            String assertTextVEL = "Presence of Edit Resources Text";
            Assert.assertTrue(addResourcesInModality.verifyEditResourcesText(), assertFailurePreText + assertTextVEL);
            reportLog(assertTextVEL);

            String assertTextVPL = "Published CheckBox Is Selected";
            Assert.assertTrue(addResourcesInModality.verifyPublishedCheckBox(), assertFailurePreText + assertTextVPL);
            reportLog(assertTextVPL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality of 'Save' button without giving Description when published CheckBox Is Not Selected")
    public void verifyFunctionalityOfSaveButton() {
        boolean result = true;
        try {
            String description = "";
            addResourcesInModality.clickOnPublishedCheckBox();
            addResourcesInModality.removeDescriptionText(description);

            String assertTextVLL = "Presence of Cancel Edit Resources Button";
            Assert.assertTrue(addResourcesInModality.verifySaveButton(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

            addResourcesInModality.clickOnSaveButton();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyUploadedFilesAreVisible(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

        @Test(priority = 19, description = "Verify Functionality Of 'Make Public Link' After Uploading File.")
    public void verifyFunctionalityOfMakePublicLink() {
        boolean result = true;
        try {
            addResourcesInModality.clickOnMakePublicLink();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyEditResourcesButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVFLL = "Presence of 'Make Public' Link";
            Assert.assertTrue(addResourcesInModality.verifyCancelEditButton(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of 'Edit Resources ' Button of Edit Resources Pop Up.")
    public void verifyFunctionalityOfEditResourcesButton() {
        boolean result = true;
        try {
            addResourcesInModality.clickOnEditResourcesButton();

            String assertTextVEL = "Presence of Edit Resources Text";
            Assert.assertTrue(addResourcesInModality.verifyEditResourcesText(), assertFailurePreText + assertTextVEL);
            reportLog(assertTextVEL);

            String assertTextVLL = "Presence of Cancel Edit Resources Button";
            Assert.assertTrue(addResourcesInModality.verifySaveButton(), assertFailurePreText + assertTextVLL);
            reportLog(assertTextVLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'Cancel Edit Resources ' Button of Edit Resources Pop Up.")
    public void verifyFunctionalityOfCancelResourcesButton() {
        boolean result = true;
        try {
            String assertTextVEL = "Presence of Cancel Edit Resources Text";
            Assert.assertTrue(addResourcesInModality.verifyCancelEditResourcesButton(), assertFailurePreText + assertTextVEL);
            reportLog(assertTextVEL);

            addResourcesInModality.clickOnCancelEditResourcesButton();

            String assertTextVML = "Presence of Uploaded File Are Visible";
            Assert.assertTrue(addResourcesInModality.verifyUploadedFilesAreVisible(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}