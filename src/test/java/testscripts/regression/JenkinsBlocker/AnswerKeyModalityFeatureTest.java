package testscripts.regression.JenkinsBlocker;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class AnswerKeyModalityFeatureTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(AnswerKeyModalityFeatureTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    TeacherDashboardPage teacherDashboardPage;
    public CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete;
    public CreateFlexBookPage createFlexBookPage;
    private CreateNewModality createNewModality;
    private AnswerKey answerKey;
    private AddResourcesInModality addResourcesInModality;
    private CreatedReadModalityFeaturePage createdReadModalityFeaturePage;



    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify 'Answer Keys' modality type is available for teacher user.")
    public void verifyAnswerKeyModalityOptionIsPresent(String email, String password) {
        boolean result = true;
        try {
            teacherDashboardPage = new TeacherDashboardPage(webDriver,extentTest,extentReports);
            courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver,extentTest,extentReports);
            createFlexBookPage = new CreateFlexBookPage(webDriver,extentTest,extentReports);
            createNewModality = new CreateNewModality(webDriver,extentTest,extentReports);
            answerKey = new AnswerKey(webDriver,extentTest,extentReports);
            addResourcesInModality = new AddResourcesInModality(webDriver,extentTest,extentReports);
            createdReadModalityFeaturePage = new CreatedReadModalityFeaturePage(webDriver,extentTest,extentReports);

            String url="https://master.ck12.org/my/library/";

            new LoginPage(webDriver,extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

           webDriver.navigate().to(url);

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVML = "Presence of Modality link Inside Create New DropDown";
            Assert.assertTrue(createNewModality.verifyModalityLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createNewModality.clickOnModalityLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            String assertTextVMLA = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVMLA);
            reportLog(assertTextVMLA);

            String assertTextVRL = "Presence of Read Modality Type DropDown";
            Assert.assertTrue(createNewModality.verifyModalityTypeDropDown(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

            createNewModality.clickOnModalityTypeDropDown();

            String assertTextVRLL = "Presence of 'Answer Key' Modality Type Link";
            Assert.assertTrue(answerKey.verifyAnswerKeyModalityLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality Of 'Answer Key Modality Type'.")
    public void verifyFunctionalityOfAnswerLeyModalityType() {
        boolean result = true;
        try {
            answerKey.clickOnAnswerKeyModalityLink();

            String assertTextVSB = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            String assertTextVRL = "Presence of Read Modality Type DropDown";
            Assert.assertTrue(createNewModality.verifyModalityTypeDropDown(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Create New 'Answer Keys' modality type.")
    public void createNewAnswerKeyModality() {
        boolean result = true;
        try {
            String modality = "AnswerKey";

            createFlexBookPage.enterModalityName(modality);
            createNewModality.clickOnSaveButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Add Resources In Created 'Answer Key Type' Modality.")
    public void addResourcesInCreatedModality() {
        boolean result = true;
        try {
            String assertTextVRLLl = "Presence of 'Resources' Tab";
            Assert.assertTrue(addResourcesInModality.verifyResourcesTab(), assertFailurePreText + assertTextVRLLl);
            reportLog(assertTextVRLLl);

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

    @Test(priority = 9, description = "Verify Features For Created Answer Keys Modality.")
    public void verifyFeaturesForCreatedAnswerKey() {
        boolean result = true;
        try {
            String assertTextVRLL = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyKeepAsDraftButton(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            createdReadModalityFeaturePage.clickOnKeepAsDraftButton();

            String assertTextVFLL = "Presence of Keep As Draft Button";
            Assert.assertTrue(createdReadModalityFeaturePage.verifyFinalizeButton(), assertFailurePreText + assertTextVFLL);
            reportLog(assertTextVFLL);

            createdReadModalityFeaturePage.clickOnFinalizeButton();

            String assertTextVRL = "Presence of 'Share With Classes' Button.";
            Assert.assertTrue(answerKey.verifyShareWithClassesButton(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "verify 'Share To Class' feature for created modality.")
    public void verifyShareToClassFeatures() {
        boolean result = true;
        try {
            answerKey.clickOnShareWithClassesButton();

            String assertTextVRY = "Presence of Share Button";
            Assert.assertTrue(createNewModality.verifyShareButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVARY = "Presence of Share With Classes Text.";
            Assert.assertTrue(createNewModality.verifyShareWithClassesText(), assertFailurePreText + assertTextVARY);
            reportLog(assertTextVARY);

            createNewModality.clickOnClassNameCheckBox();
            createNewModality.clickOnShareButton();

            String assertTextVY = "Presence of Success Button";
            Assert.assertTrue(createNewModality.verifySuccessButton(), assertFailurePreText + assertTextVY);
            reportLog(assertTextVY);

            createNewModality.clickOnSuccessButton();

            String assertTextVRL = "Presence of 'Share With Classes' Button.";
            Assert.assertTrue(answerKey.verifyShareWithClassesButton(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "verify Functionality of 'Edit Draft' Button.")
    public void verifyFunctionalityOfEditDraftButton() {
        boolean result = true;
        try {
            String assertTextVRY = "Presence of 'Edit Draft' Button";
            Assert.assertTrue(answerKey.verifyEditDraftButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            answerKey.clickOnEditDraftButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Icon Of 'Answer' key is Disable. Now Teacher Cannot change Type Of Modality.")
    public void verifyTeacherCannotChangeTypeOfModality() {
        boolean result = true;
        try {
            String assertTextVRY = "Presence of 'Modality Type' Text.";
            Assert.assertTrue(answerKey.verifyModalityTypeText(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVR = "Presence of 'Disabled' Icon.";
            Assert.assertTrue(answerKey.verifyDisableIcon(), assertFailurePreText + assertTextVR);
            reportLog(assertTextVR);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Student Login Successfully to see Shared Resources In the Class.")
    public void verifyStudentLoginSuccessfully() {
        boolean result = true;
        try {
            LoginPage loginPage = new LoginPage(webDriver,extentTest, extentReports);
            CBookLandingPage cBookLandingPage = new CBookLandingPage(webDriver,extentTest,extentReports);
            TurnInFeature turnInFeature = new TurnInFeature(webDriver,extentTest,extentReports);

            String flexBookUrl = "https://flexbooks-qa-flash.ck12.org/flexbooks/";
            String email = "studentanswerkey+testuser@ck12.org";
            String pass = "fa1234";

            webDriver.navigate().to(flexBookUrl);

//            String assertTextVFO = "Presence of Try It Now Button.";
//            Assert.assertTrue(cBookLandingPage.verifyFlexBookLink(), assertFailurePreText + assertTextVFO);
//            reportLog(assertTextVFO);
//
//            cBookLandingPage.clickOnFlexBookLink();

            String assertTextVCAC = "Presence of Profile Icon.";
            Assert.assertTrue(turnInFeature.verifyProfileIcon(), assertFailurePreText + assertTextVCAC);
            reportLog(assertTextVCAC);

            turnInFeature.clickOnProfileIcon();

            String assertTextVSO = "Presence of Sign Out Link.";
            Assert.assertTrue(turnInFeature.verifyLinkSignOut(), assertFailurePreText + assertTextVSO);
            reportLog(assertTextVSO);

            turnInFeature.clickOnLinkSignOut();

            cBookLandingPage.clickOnSignInIcon();
            loginPage.login(email, pass);
            cBookLandingPage.clickOnSignInButton();

            String assertTextVSAI = "Presence of 'Student icon' after logging in.";
            Assert.assertTrue(turnInFeature.verifyStudentAccountIcon(), assertFailurePreText + assertTextVSAI);
            reportLog(assertTextVSAI);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify 'Answer Keys' modality type is also available for Student user.\n")
    public void verifyStudentCanAlsoCreateAnswerKeyModality() {
        boolean result = true;
        try {
            String modalityLink="https://qa-flash.ck12.org/new/concept/?returnTo=/my/library";

            webDriver.navigate().to(modalityLink);
            createFlexBookPage.clickOnGotItButtonPopUp();

            String assertTextVMLA = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVMLA);
            reportLog(assertTextVMLA);

            String assertTextVRL = "Presence of Read Modality Type DropDown";
            Assert.assertTrue(createNewModality.verifyModalityTypeDropDown(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

            createNewModality.clickOnModalityTypeDropDown();

            String assertTextVRLL = "Presence of 'Answer Key' Modality Type Link";
            Assert.assertTrue(answerKey.verifyAnswerKeyModalityLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify student can see 'answer key' modality type in class which are share by teacher.")
    public void verifyAnswerKeyModalityIsVisibleForTeacher() {
        boolean result = true;
        try {
            String url ="https://qa-flash.ck12.org/group-resources/215995";

            webDriver.navigate().to(url);

            String assertTextVRY = "Presence of 'Answer Key' Text.";
            Assert.assertTrue(answerKey.verifyAnswerKeyText(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVR = "Presence of 'Shared Resources' LInk.";
            Assert.assertTrue(answerKey.verifySharedResourcesLink(), assertFailurePreText + assertTextVR);
            reportLog(assertTextVR);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Student Cannot able to see shared resources which are added in Answer key modality type.")
    public void verifyStudentCannotSeeAnswerKeySharedResources() {
        boolean result = true;
        try {
            answerKey.clickOnSharedResourcesLink();
            answerKey.switchToChildWindow();

            String assertTextVRY = "Presence of 'Resources' Button.";
            Assert.assertTrue(answerKey.verifyResourcesButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            answerKey.clickOnResourcesButton();

            String assertTextVR = "Presence of 'No Resources' Text.";
            Assert.assertTrue(answerKey.verifyNoResourcesText(), assertFailurePreText + assertTextVR);
            reportLog(assertTextVR);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}