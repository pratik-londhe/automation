package testscripts.regression.teacherlogin.CreateNewFeature.CreateNewDropDownFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CreateNewModalityBookTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CBookDraftFunctionalityTest.class);
    private String testCaseFailureText = "Test failed for method: ";
    private String assertFailurePreText = "Failed to verify: ";
    public String assertSuccessPreText = "Successfully verified: ";

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "verify Modality Option Is Available inside the Create New DropDown.")
    public void verifyModalityOptionIsPresent(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verified user profile for CreateCBookUsingModalityTest.");
            reportLog("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            reportLog("Successfully verified Create New DropDown");

            courseBookCreateEditAssignDelete.clickOnCreateNewDropDown();

            String assertTextVML = "Presence of Modality link Inside Create New DropDown";
            Assert.assertTrue(createNewModality.verifyModalityLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 3, description = "Verify 'Read' Modality Type Is Default Selected after clicking on 'Modality' Link Option.")
    public void verifyFunctionalityOfModalityLink() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createNewModality.clickOnModalityLink();
            createFlexBookPage.clickOnGotItButtonPopUp();

            String assertTextVML = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            String assertTextVRL = "Presence of Read Modality Type DropDown";
            Assert.assertTrue(createNewModality.verifyModalityTypeDropDown(), assertFailurePreText + assertTextVRL);
            reportLog(assertTextVRL);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality Of 'Modality Type' DropDown.")
    public void verifyFunctionalityOfModalityTypeDropDown() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnModalityTypeDropDown();

            String assertTextVRLL = "Presence of Read Modality Type Link";
            Assert.assertTrue(createNewModality.verifyReadLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            String assertTextVML = "Presence of Video Link";
            Assert.assertTrue(createNewModality.verifyVideoLink(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

            createNewModality.clickOnModalityTypeDropDown();

            String assertTextVSB = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality Of 'Go Back' Button.")
    public void verifyFunctionalityOfGoBackButton() {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createNewModality.clickOnGoBackButton();

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

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality Of 'Save Button' Without Editing Title.")
    public void verifyFunctionalitySaveButtonWithoutTitle() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnSaveButton();

            String assertTextVML = "Presence of Edit Title Button";
            Assert.assertTrue(createNewModality.verifyEditTitleButton(), assertFailurePreText + assertTextVML);
            reportLog(assertTextVML);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality Of 'Save Button' With Editing Title.")
    public void verifyFunctionalitySaveButtonWithTitle() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            String modality = "FlexBook";
            createNewModality.clickOnEditTitleButton();

            String assertTextVSB = "Presence of Save Button";
            Assert.assertTrue(createNewModality.verifySaveButton(), assertFailurePreText + assertTextVSB);
            reportLog(assertTextVSB);

            createFlexBookPage.enterModalityNameFlexBook(modality);
            createNewModality.clickOnSaveButton();

            Assert.assertTrue(createFlexBookPage.verifyGoBackModalityButton(), "Failed to verified Go Back Modality Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Go Back Modality Button");
            logger.info("Successfully  verified Go Back Modality Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 13, description = "Verify Read Type is Selected After Saving The Modality.")
    public void verifyReadTypeIsSelectedAfterSavingTheModality() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            String assertTextVRLL = "Presence of Read Modality Type Link";
            Assert.assertTrue(createNewModality.verifyReadLink(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            String assertTextVRY = "Presence of Are You Stuck button";
            Assert.assertTrue(createNewModality.verifyAreYouStuckButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 15, description = "Verify Functionality Of 'Are You Stuck' button.")
    public void verifyFunctionalityOfAreYouStuckButton() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnAreYouStuckButton();

            String assertTextVRLL = "Presence of Need Help Text";
            Assert.assertTrue(createNewModality.verifyNeedHelpText(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            String assertTextVRY = "Presence of CK12 Editing Text";
            Assert.assertTrue(createNewModality.verifyCK12EditingText(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 17, description = "Verify Functionality Of 'Close' Icon of Are You stuck Pop Up.")
    public void verifyFunctionalityOfCloseIcon() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            String assertTextVRLL = "Presence of Close Are You Stuck Icon";
            Assert.assertTrue(createNewModality.verifyCloseIcon(), assertFailurePreText + assertTextVRLL);
            reportLog(assertTextVRLL);

            createNewModality.clickOnCloseIcon();

            String assertTextVRY = "Presence of Are You Stuck button";
            Assert.assertTrue(createNewModality.verifyAreYouStuckButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 19, description = "Verify Functionality Of 'Go Back' Button Without Giving And Data.")
    public void verifyFunctionalityOfGoBackButtonWithoutGivingData() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);
            CreateFlexBookPage createFlexBookPage = new CreateFlexBookPage(webDriver, extentTest, extentReports);

            createFlexBookPage.clickOnGoBackButton();

            String assertTextVRY = "Presence of Assign To Class button";
            Assert.assertTrue(createNewModality.verifyAssignToClassButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVSRY = "Presence of Share With Classes button";
            Assert.assertTrue(createNewModality.verifyShareWithClassesButton(), assertFailurePreText + assertTextVSRY);
            reportLog(assertTextVSRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 21, description = "Verify Functionality Of 'Assign To Class Button' Of Modality PAge.")
    public void verifyFunctionalityOfAssignToClassButton() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnAssignToClassButton();

            String assertTextVRY = "Presence of CK12 ClassRoom Icon";
            Assert.assertTrue(createNewModality.verifyCK12ClassRoomIcon(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            webDriver.navigate().refresh();

            String assertTextVARY = "Presence of Assign To Class button";
            Assert.assertTrue(createNewModality.verifyAssignToClassButton(), assertFailurePreText + assertTextVARY);
            reportLog(assertTextVARY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 23, description = "Verify Functionality Of 'Share With Classes Button' Of Modality Page.")
    public void verifyFunctionalityOfShareWithClassesButton() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnShareWithClassesButton();

            String assertTextVRY = "Presence of Share Button";
            Assert.assertTrue(createNewModality.verifyShareButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVARY = "Presence of Share With Classes Text.";
            Assert.assertTrue(createNewModality.verifyShareWithClassesText(), assertFailurePreText + assertTextVARY);
            reportLog(assertTextVARY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 25, description = "Verify Functionality Of 'Share Button' Without Selecting Class.")
    public void verifyFunctionalityOfShareButtonWithoutClass() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnShareButton();

            String assertTextVRY = "Presence of Share Button";
            Assert.assertTrue(createNewModality.verifyShareButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            String assertTextVARY = "Presence of Please Select Classes Text.";
            Assert.assertTrue(createNewModality.verifyPleaseSelectClassesText(), assertFailurePreText + assertTextVARY);
            reportLog(assertTextVARY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 27, description = "Verify Functionality Of 'Share Button' after Selecting Class.")
    public void verifyFunctionalityOfShareButtonWithTheClass() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnClassNameCheckBox();
            createNewModality.clickOnShareButton();

            String assertTextVRY = "Presence of Success Button";
            Assert.assertTrue(createNewModality.verifySuccessButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createNewModality.clickOnSuccessButton();

            String assertTextVSRY = "Presence of Share With Classes button";
            Assert.assertTrue(createNewModality.verifyShareWithClassesButton(), assertFailurePreText + assertTextVSRY);
            reportLog(assertTextVSRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 29, description = "Verify Read Modality Is Showing Already In Library.")
    public void verifyReadModalityIsAlreadyInLibrary() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            String assertTextVRY = "Presence of Already In Library button";
            Assert.assertTrue(createNewModality.verifyAddToLibraryButton(), assertFailurePreText + assertTextVRY);
            reportLog(assertTextVRY);

            createNewModality.scrollToViewDetails();

            String assertTextVSRY = "Presence of Show Details DropDown";
            Assert.assertTrue(createNewModality.verifyShowDetailsDropDown(), assertFailurePreText + assertTextVSRY);
            reportLog(assertTextVSRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 31, description = "Verify Functionality oif Show details dropdown.")
    public void verifyFunctionalityOfShowDetailsDropDown() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnShowDetailsDropDown();

            String assertTextVSRY = "Presence of Hide Details DropDown";
            Assert.assertTrue(createNewModality.verifyHideDetailsDropDown(), assertFailurePreText + assertTextVSRY);
            reportLog(assertTextVSRY);

            String assertTextVDT = "Presence of Description In Details";
            Assert.assertTrue(createNewModality.verifyDescriptionText(), assertFailurePreText + assertTextVDT);
            reportLog(assertTextVDT);

            String assertTextVY = "Presence of Created dAte In details";
            Assert.assertTrue(createNewModality.verifyCreatedDateText(), assertFailurePreText + assertTextVY);
            reportLog(assertTextVY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }

    @Test(priority = 33, description = "Verify Functionality oif Hide details dropdown.")
    public void verifyFunctionalityOfHideDetailsDropDown() {
        boolean result = true;
        try {
            CreateNewModality createNewModality = new CreateNewModality(webDriver, extentTest, extentReports);

            createNewModality.clickOnHideDetailsDropDown();

            String assertTextVSRY = "Presence of Show Details DropDown";
            Assert.assertTrue(createNewModality.verifyShowDetailsDropDown(), assertFailurePreText + assertTextVSRY);
            reportLog(assertTextVSRY);

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, testCaseFailureText + currentMethodName + errorMessage);
    }
}