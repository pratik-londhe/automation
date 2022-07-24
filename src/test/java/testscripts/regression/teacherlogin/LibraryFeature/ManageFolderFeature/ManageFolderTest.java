package testscripts.regression.teacherlogin.LibraryFeature.ManageFolderFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class ManageFolderTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(ManageFolderTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Manage Folder' DropDown After Clicking On Library Tab")
    public void verifyFunctionalityOfManageFolder(String email, String password) {
        boolean result = true;
        try {
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            Assert.assertTrue(new TeacherDashboardPage(webDriver, extentTest, extentReports).verifyTeacherProfileOnGamma(), "Failed to verify user profile for CbookAssignFromModalityPageTest.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully logged in and verified profile icon.");

            new PageMenuTab(webDriver, extentTest, extentReports).clickOnLibraryTab();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown");
            logger.info("Successfully verified Create New DropDown");

            new ViewArchivedAndRestoreCBook(webDriver, extentTest, extentReports).clickOnCheckBox();

            Assert.assertTrue(manageFolder.verifyManageFolderButton(), "Failed to verified Manage Folder DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Manage Folder DropDown");
            logger.info("Successfully verified Manage Folder DropDown");

            manageFolder.clickOnManageFolderButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Create' Button Without Giving Folder Name")
    public void verifyFunctionalityOfCreateButton() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            Assert.assertTrue(manageFolder.verifyCreateButton(), "Failed to verified Create Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Create Button");
            logger.info("Successfully verified Create Button");

            manageFolder.clickOnCreateButton();

            Assert.assertTrue(manageFolder.verifyErrorText(), "Failed to verified Error Text");
            extentTest.log(LogStatus.PASS, "Successfully verified Error Text");
            logger.info("Successfully verifiedError Text");

            Assert.assertTrue(manageFolder.verifyOkButton(), "Failed to verified Ok Button");
            extentTest.log(LogStatus.PASS, "Successfully verified  Ok Button");
            logger.info("Successfully verified Ok Button");

            manageFolder.clickOnOkButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Create' Button After Giving Folder Name")
    public void verifyFunctionalityOfCreateButtonAfterFolderName() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            String name = "Basid";

            Assert.assertTrue(manageFolder.verifyManageFolderButton(), "Failed to verified Manage Folder DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Manage Folder DropDown");
            logger.info("Successfully verified Manage Folder DropDown");

            manageFolder.clickOnManageFolderButton();
            manageFolder.getCountOfFolderBefore();
            manageFolder.setValueInFolderNamePlaceHolder(name);
            manageFolder.clickOnCreateButton();
            manageFolder.getCountOfFolderAfter();

            Assert.assertTrue(manageFolder.verifyNewFolderIsAddedInList(), "Failed to verified NewFolder Is Added In list");
            extentTest.log(LogStatus.PASS, "Successfully verified NewFolder Is Added In list");
            logger.info("Successfully verifiedNewFolder Is Added In list");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 7, description = "Verify Functionality of 'Create' Button After Giving Duplicate Folder Name")
    public void verifyFunctionalityOfCreateButtonAfterDuplicateFolderName() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            String name = "Basid";

            Assert.assertTrue(manageFolder.verifyManageFolderButton(), "Failed to verified Manage Folder DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Manage Folder DropDown");
            logger.info("Successfully verified Manage Folder DropDown");

            manageFolder.getCountOfFolderBefore();
            manageFolder.setValueInFolderNamePlaceHolder(name);
            manageFolder.clickOnCreateButton();

            Assert.assertTrue(manageFolder.verifyErrorText(), "Failed to verified Error Text");
            extentTest.log(LogStatus.PASS, "Successfully verified Error Text");
            logger.info("Successfully verifiedError Text");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 8, description = "Verify Functionality of 'Ok' Button After Clicking On Create Button")
    public void verifyFunctionalityOfOkButton() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            Assert.assertTrue(manageFolder.verifyOkButton(), "Failed to verified Ok Button");
            extentTest.log(LogStatus.PASS, "Successfully verified  Ok Button");
            logger.info("Successfully verified Ok Button");

            manageFolder.clickOnOkButton();

            Assert.assertTrue(manageFolder.verifyManageFolderButton(), "Failed to verified Manage Folder DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Manage Folder DropDown");
            logger.info("Successfully verified Manage Folder DropDown");

            manageFolder.clickOnManageFolderButton();
            manageFolder.getCountOfFolderAfter();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 9, description = "Verify Functionality of 'FolderName' CheckBox After Clicking On Manage Folder DropDown")
    public void verifyFunctionalityOfFolderNameCheckBox() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            manageFolder.clickOnMathematicsCheckBox();

            Assert.assertTrue(manageFolder.verifyOkApplyFolderButton(), "Failed to verified Apply Folder Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Apply Folder Button");
            logger.info("Successfully verified Apply Folder Button");

            manageFolder.clickOnApplyFolderButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 10, description = "Verify Functionality of 'Apply Folder' Button After Selecting Folder Name")
    public void verifyFunctionalityOfApplyFolder() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            manageFolder.clickOnOkButton();

//            Assert.assertTrue(manageFolder.verifyLabelText(), "Failed to verified Label Text");
//            extentTest.log(LogStatus.PASS, "Successfully verified Label Text");
//            logger.info("Successfully verified Label Text");

            new ViewArchivedAndRestoreCBook(webDriver, extentTest, extentReports).clickOnCheckBox();

            Assert.assertTrue(manageFolder.verifyManageFolderButton(), "Failed to verified Manage Folder DropDown");
            extentTest.log(LogStatus.PASS, "Successfully verified Manage Folder DropDown");
            logger.info("Successfully verified Manage Folder DropDown");

            manageFolder.clickOnManageFolderButton();

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 11, description = "Verify Functionality of 'Apply Multiple Folders' On FlexBook")
    public void verifyFunctionalityOfApplyMultipleFolder() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);
            LibraryPage libraryPage = new LibraryPage(webDriver, extentTest, extentReports);
            CourseBookCreateEditAssignDelete courseBookCreateEditAssignDelete = new CourseBookCreateEditAssignDelete(webDriver, extentTest, extentReports);

            manageFolder.clickOnScienceCheckBox();
            manageFolder.clickOnApplyFolderButton();
            manageFolder.clickOnOkButton();
            manageFolder.getCountOfLabelText();

           /* Assert.assertTrue(manageFolder.verifyLabelTexts(), "Failed to verified Multiple Label Text");
            extentTest.log(LogStatus.PASS, "Successfully verified Multiple Label Text");
            logger.info("Successfully verified Multiple Label Text");

            libraryPage.clickOnElipsisIconForEdit();*/

            /*Assert.assertTrue(libraryPage.verifyEditButton(), "Failed to verified Edit Button");
            extentTest.log(LogStatus.PASS, "Successfully  verified Edit Button");
            logger.info("Successfully  verified Edit Button");

            Assert.assertTrue(libraryPage.verifyArchiveButton(), "Failed to verified Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Archive Button.");
            logger.info("Successfully verified Archive Button.");

            libraryPage.clickOnArchive();

            Assert.assertTrue(libraryPage.verifyOkArchiveButton(), "Failed to verified Ok Archive Button.");
            extentTest.log(LogStatus.PASS, "Successfully verified Ok Archive Button.");
            logger.info("Successfully verified Archive Ok Archive Button.");

            libraryPage.clickOnOK();

            Assert.assertTrue(courseBookCreateEditAssignDelete.verifyCreateNewDropDown(), "Failed to verified Create New DropDown.");
            extentTest.log(LogStatus.PASS, "Successfully verified Create New DropDown.");
            logger.info("Successfully verified Create New DropDown.");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 12, description = "Verify Functionality of 'Close Folder Filter' After Adding Folder")
    public void verifyFunctionalityOfCloseFolderFilter() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            manageFolder.scrollUpScreen();

            Assert.assertTrue(manageFolder.verifyCloseFilterIcon(), "Failed to verified Close Filter Icon");
            extentTest.log(LogStatus.PASS, "Successfully verified Close Filter Icon");
            logger.info("Successfully verified Close Filter Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 13, description = "Verify Functionality of 'Cancel Button' After Clicking On Close Folder Filter")
    public void verifyFunctionalityOfCancelCloseFolderFilter() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            manageFolder.getCountOfFolderFilterBefore();
            manageFolder.clickOnCloseFilterIcon();

            Assert.assertTrue(manageFolder.verifyCancelButton(), "Failed to verified Cancel Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Cancel Button");
            logger.info("Successfully verified Cancel Button");

            manageFolder.clickOnCancelButton();

            Assert.assertTrue(manageFolder.verifyCloseFilterIcon(), "Failed to verified Close Filter Icon");
            extentTest.log(LogStatus.PASS, "Successfully verified Close Filter Icon");
            logger.info("Successfully verified Close Filter Icon");

            manageFolder.getCountOfFolderFilterAfter();

            Assert.assertTrue(manageFolder.verifyNewFolderFilterAfterCancel(), "Failed to verified Folder Filter Icon");
            extentTest.log(LogStatus.PASS, "Successfully verified Folder Filter Icon");
            logger.info("Successfully verified Folder Filter Icon");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 14, description = "Verify Functionality of 'Remove Button' After Clicking On Close Folder Filter")
    public void verifyFunctionalityOfRemoveCloseFolderFilter() {
        boolean result = true;
        try {
            ManageFolder manageFolder = new ManageFolder(webDriver, extentTest, extentReports);

            manageFolder.getCountOfFolderFilterBefore();
            manageFolder.clickOnCloseFilterIcon();

            Assert.assertTrue(manageFolder.verifyRemoveButton(), "Failed to verified Remove Button");
            extentTest.log(LogStatus.PASS, "Successfully verified Remove Button");
            logger.info("Successfully verified Remove Button");

            manageFolder.clickOnRemoveButton();
            manageFolder.clickOnOkButton();
            manageFolder.getCountOfFolderFilterAfter();

            Assert.assertTrue(manageFolder.verifyFolderFilterAfterRemove(), "Failed to verified Folder Filter After Remove");
            extentTest.log(LogStatus.PASS, "Successfully verified Folder Filter After Remove");
            logger.info("Successfully verified Folder Filter After Remove");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}